package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertCommand;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertResponse;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusCommand;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusResponse;
import ru.rickheadle.dddwitheda.application.mapper.IncidentDataMapper;
import ru.rickheadle.dddwitheda.application.services.IncidentService;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentStatusUpdatedEvent;
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
  public UpdateIncidentStatusResponse updateIncidentStatus(UpdateIncidentStatusCommand command) {
    Incident incident = getIncidentById(command.getIncidentId()).orElseThrow();
    incident.setStatus(command.getStatus());
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentStatusUpdatedEvent(
        new IncidentStatusUpdatedEvent(
            this,
            incident,
            ZonedDateTime.now()
        )
    );
    return UpdateIncidentStatusResponse.builder()
        .incidentId(incident.getId())
        .response("Incident got a new Status")
        .build();
  }

  @Override
  public AssignIncidentToTechSupportExpertResponse assignIncidentToTechSupportExpert(
      AssignIncidentToTechSupportExpertCommand command) {
    Incident incident = getIncidentById(command.getIncidentId()).orElseThrow();
    incident.setTechSupportExpert(
        techSupportExpertService.findTechSupportExpertById(command.getTechSupportExpertId())
            .orElseThrow());
    updateIncidentStatus(UpdateIncidentStatusCommand.builder()
        .incidentId(command.getIncidentId())
        .status(Status.ASSIGNED)
        .build());
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentAssignedToTechSupportExpertEvent(
        new IncidentAssignedToTechSupportExpertEvent(
            this,
            incident,
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
  public Optional<Incident> getIncidentById(UUID incidentId) {
    return incidentRepository.findById(incidentId);
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
