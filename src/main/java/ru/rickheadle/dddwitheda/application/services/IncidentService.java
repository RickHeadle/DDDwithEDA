package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.assign.AssignIncidentToTechSupportExpertCommand;
import ru.rickheadle.dddwitheda.domain.assign.AssignIncidentToTechSupportExpertResponse;
import ru.rickheadle.dddwitheda.domain.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.domain.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface IncidentService {

  CreateIncidentResponse createIncident(CreateIncidentCommand incidentCommand);

  void updateIncidentStatus(UUID incidentId, Status newStatus);

  AssignIncidentToTechSupportExpertResponse assignIncidentToTechSupportExpert(
      AssignIncidentToTechSupportExpertCommand command);

  Optional<Incident> getIncidentById(UUID incidentId);

  List<Incident> findIncidentsByStatus(Status incidentStatus);

  List<Incident> findIncidentsByAssignedTechSupportExpert(TechSupportExpert techSupportExpert);

  List<Incident> findAllIncidents();
}
