package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface IncidentService {

  Incident createIncident(
      String title,
      String description,
      IncidentInfluence incidentInfluence,
      IncidentEmergency incidentEmergency,
      TechSupportExpert techSupportExpert);

  void updateIncidentStatus(UUID incidentId, Status newStatus);

  void assignIncidentToTechSupportExpert(UUID incidentId, TechSupportExpert techSupportExpert);

  Optional<Incident> getIncidentById(UUID incidentId);

  List<Incident> getIncidentsByStatus(Status incidentStatus);

  List<Incident> getIncidentsByAssignedTechSupportExpert(TechSupportExpert techSupportExpert);
}
