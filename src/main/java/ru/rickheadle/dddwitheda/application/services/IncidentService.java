package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertCommand;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertResponse;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusCommand;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusResponse;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface IncidentService {

  CreateIncidentResponse createIncident(CreateIncidentCommand incidentCommand);

  UpdateIncidentStatusResponse updateIncidentStatus(UpdateIncidentStatusCommand command);

  AssignIncidentToTechSupportExpertResponse assignIncidentToTechSupportExpert(
      AssignIncidentToTechSupportExpertCommand command);

  Optional<Incident> getIncidentById(UUID incidentId);

  List<Incident> findIncidentsByStatus(Status incidentStatus);

  List<Incident> findIncidentsByAssignedTechSupportExpert(TechSupportExpert techSupportExpert);

  List<Incident> findAllIncidents();
}
