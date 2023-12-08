package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.Incident;
import ru.rickheadle.dddwitheda.domain.TechSupportExpert;
import ru.rickheadle.dddwitheda.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.valueobject.Status;

public interface IncidentService {

  Incident createIncident(
      String title,
      String description,
      IncidentInfluence incidentInfluence,
      IncidentEmergency incidentEmergency,
      TechSupportExpert techSupportExpert);

  Incident updateIncidentStatus(UUID incidentId, Status newStatus);

  Incident assignIncidentToTechSupportExpert(UUID incidentId, TechSupportExpert techSupportExpert);

  Incident getIncidentById(UUID incidentId);

  List<Incident> getIncidentsByStatus(Status incidentStatus);

  List<Incident> getIncidentsByAssignedTechSupportExpert(TechSupportExpert techSupportExpert);
}
