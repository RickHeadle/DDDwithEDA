package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.IncidentService;
import ru.rickheadle.dddwitheda.domain.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.domain.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentStatusUpdatedEvent;
import ru.rickheadle.dddwitheda.domain.mapper.IncidentDataMapper;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;
import ru.rickheadle.dddwitheda.infrastructure.repository.IncidentRepository;

@Service
@Transactional
public class IncidentServiceImpl implements IncidentService {

  private final IncidentRepository incidentRepository;
  private final IncidentDataMapper incidentDataMapper;
  private final IncidentEventPublisher incidentEventPublisher;

  @Autowired
  public IncidentServiceImpl(IncidentRepository incidentRepository,
      IncidentDataMapper incidentDataMapper, IncidentEventPublisher incidentEventPublisher) {
    this.incidentRepository = incidentRepository;
    this.incidentDataMapper = incidentDataMapper;
    this.incidentEventPublisher = incidentEventPublisher;
  }

  @Override
  public CreateIncidentResponse createIncident(CreateIncidentCommand incidentCommand) {
    Incident incident = incidentDataMapper.createIncidentCommandToIncident(incidentCommand);
    incidentRepository.save(incident);
    incidentEventPublisher.publishIncidentCreatedEvent(
        new IncidentCreatedEvent(
            this,
            incident,
            ZonedDateTime.now()
        )
    );
    return incidentDataMapper.incidentToCreateIncidentResponse(incident,
        "Incident created successfully!");
  }

  @Override
  public void updateIncidentStatus(UUID incidentId, Status newStatus) {
    getIncidentById(incidentId)
        .ifPresent(incident -> {
          incident.setStatus(newStatus);
          incidentRepository.save(incident);
          incidentEventPublisher.publishIncidentStatusUpdatedEvent(
              new IncidentStatusUpdatedEvent(
                  this,
                  incident,
                  ZonedDateTime.now()
              )
          );
        });
  }

  @Override
  public void assignIncidentToTechSupportExpert(UUID incidentId,
      TechSupportExpert techSupportExpert) {
    getIncidentById(incidentId)
        .ifPresent(incident -> {
          incident.setTechSupportExpert(techSupportExpert);
          incidentRepository.save(incident);
          incidentEventPublisher.publishIncidentAssignedToTechSupportExpertEvent(
              new IncidentAssignedToTechSupportExpertEvent(
                  this,
                  incident,
                  ZonedDateTime.now()
              )
          );
        });
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
