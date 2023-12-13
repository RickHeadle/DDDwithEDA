package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertCommand;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertResponse;
import ru.rickheadle.dddwitheda.application.api.close.MarkIncidentAsClosedCommand;
import ru.rickheadle.dddwitheda.application.api.close.MarkIncidentAsClosedResponse;
import ru.rickheadle.dddwitheda.application.api.complete.MarkIncidentAsCompletedCommand;
import ru.rickheadle.dddwitheda.application.api.complete.MarkIncidentAsCompletedResponse;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.application.api.inProgress.MarkIncidentAsInProgressCommand;
import ru.rickheadle.dddwitheda.application.api.inProgress.MarkIncidentAsInProgressResponse;
import ru.rickheadle.dddwitheda.application.mapper.IncidentDataMapper;
import ru.rickheadle.dddwitheda.application.services.IncidentService;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsClosedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsCompletedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsInProgressEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;
import ru.rickheadle.dddwitheda.domain.repository.IncidentRepository;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {

  private final IncidentRepository incidentRepository;
  private final IncidentDataMapper incidentDataMapper;
  private final IncidentEventPublisher incidentEventPublisher;
  private final TechSupportExpertServiceImpl techSupportExpertService;

  @Autowired
  public IncidentServiceImpl(IncidentRepository incidentRepository,
      IncidentDataMapper incidentDataMapper, IncidentEventPublisher incidentEventPublisher,
      TechSupportExpertServiceImpl techSupportExpertService) {
    this.incidentRepository = incidentRepository;
    this.incidentDataMapper = incidentDataMapper;
    this.incidentEventPublisher = incidentEventPublisher;
    this.techSupportExpertService = techSupportExpertService;
  }

  @Override
  public CreateIncidentResponse createIncident(CreateIncidentCommand incidentCommand) {
    Incident incident = incidentDataMapper.createIncidentCommandToIncident(incidentCommand);
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentCreatedEvent(
        new IncidentCreatedEvent(
            this,
            incident.getTitle(),
            ZonedDateTime.now()
        )
    );
    return incidentDataMapper.incidentToCreateIncidentResponse(incident,
        "Incident created successfully!");
  }

  @Override
  public MarkIncidentAsInProgressResponse markIncidentAsInProgress(
      MarkIncidentAsInProgressCommand command) {
    Incident incident = findIncidentById(command.getIncidentId());
    incident.setStatus(Status.IN_PROGRESS);
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentMarkedAsInProgressEvent(
        new IncidentMarkedAsInProgressEvent(
            this,
            Status.IN_PROGRESS,
            ZonedDateTime.now()
        )
    );
    return MarkIncidentAsInProgressResponse.builder()
        .incidentId(incident.getId())
        .response("Incident got a new Status: " + Status.IN_PROGRESS.getStatusName())
        .build();
  }

  @Override
  public AssignIncidentToTechSupportExpertResponse assignIncidentToTechSupportExpert(
      AssignIncidentToTechSupportExpertCommand command) {
    Incident incident = findIncidentById(command.getIncidentId());
    incident.setTechSupportExpert(
        techSupportExpertService.findTechSupportExpertById(command.getTechSupportExpertId())
            .orElseThrow());
    //TODO: add publishEvent for setting Assign Status
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentAssignedToTechSupportExpertEvent(
        new IncidentAssignedToTechSupportExpertEvent(
            this,
            incident.getTechSupportExpert(),
            ZonedDateTime.now()
        )
    );
    return AssignIncidentToTechSupportExpertResponse.builder()
        .incidentId(incident.getId())
        .newTechSupportExpertId(incident.getTechSupportExpert().getId())
        .response("A new TechSupportExpert has been assigned to resolve the incident!")
        .build();
  }

  @Override
  public MarkIncidentAsCompletedResponse markIncidentAsCompleted(
      MarkIncidentAsCompletedCommand command) {
    Incident incident = findIncidentById(command.getIncidentId());
    incident.setStatus(Status.COMPLETED);
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentMarkedAsCompleted(
        new IncidentMarkedAsCompletedEvent(
            this,
            Status.COMPLETED,
            ZonedDateTime.now()
        )
    );
    return MarkIncidentAsCompletedResponse.builder()
        .incidentId(incident.getId())
        .response("Incident got a new Status: " + Status.COMPLETED.getStatusName())
        .build();
  }

  @Override
  public MarkIncidentAsClosedResponse markIncidentAsClosed(MarkIncidentAsClosedCommand command) {
    Incident incident = findIncidentById(command.getIncidentId());
    incident.setStatus(Status.CLOSED);
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentMarkedAsClosed(
        new IncidentMarkedAsClosedEvent(
            this,
            Status.CLOSED,
            ZonedDateTime.now()
        )
    );
    return MarkIncidentAsClosedResponse.builder()
        .incidentId(incident.getId())
        .response("Incident got a new Status: " + Status.CLOSED.getStatusName())
        .build();
  }

  @Override
  public Incident findIncidentById(UUID incidentId) {
    return incidentRepository.findById(incidentId).orElseThrow();
  }

  @Override
  public List<Incident> findIncidentsByStatus(Status incidentStatus) {
    return incidentRepository.findAllByStatus(incidentStatus);
  }

  @Override
  public List<Incident> findIncidentsByAssignedTechSupportExpert(
      TechSupportExpert techSupportExpert) {
    return incidentRepository.findAllByTechSupportExpert(techSupportExpert);
  }

  @Override
  public List<Incident> findAllIncidents() {
    return incidentRepository.findAll();
  }
}
