package ru.rickheadle.dddwitheda.application.services.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.IncidentService;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentPriority;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;
import ru.rickheadle.dddwitheda.repository.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService {

  private final IncidentRepository incidentRepository;

  @Autowired
  public IncidentServiceImpl(IncidentRepository incidentRepository) {
    this.incidentRepository = incidentRepository;
  }

  @Override
  public Incident createIncident(String title, String description,
      IncidentInfluence incidentInfluence, IncidentEmergency incidentEmergency,
      TechSupportExpert techSupportExpert) {
    Incident incident = Incident.builder()
        .title(title)
        .description(description)
        .incidentInfluence(incidentInfluence)
        .incidentEmergency(incidentEmergency)
        .priority(IncidentPriority.getPriority(incidentInfluence, incidentEmergency))
        .status(Status.REGISTERED)
        .techSupportExpert(techSupportExpert)
        .build();
    return incidentRepository.save(incident);
  }

  @Override
  public Incident updateIncidentStatus(UUID incidentId, Status newStatus) {
    Incident incident = getIncidentById(incidentId);
    incident.setStatus(newStatus);
    return incidentRepository.save(incident);
  }

  @Override
  public Incident assignIncidentToTechSupportExpert(UUID incidentId,
      TechSupportExpert techSupportExpert) {
    Incident incident = getIncidentById(incidentId);
    incident.setTechSupportExpert(techSupportExpert);
    return incidentRepository.save(incident);
  }

  @Override
  public Incident getIncidentById(UUID incidentId) {
    return incidentRepository.findById(incidentId).orElseThrow();
  }

  @Override
  public List<Incident> getIncidentsByStatus(Status incidentStatus) {
    return incidentRepository.findAllByStatus(incidentStatus);
  }

  @Override
  public List<Incident> getIncidentsByAssignedTechSupportExpert(
      TechSupportExpert techSupportExpert) {
    return incidentRepository.findAllByTechSupportExpert(techSupportExpert);
  }
}
