package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.UUID;
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
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface IncidentService {

  CreateIncidentResponse createIncident(CreateIncidentCommand incidentCommand);

  MarkIncidentAsInProgressResponse markIncidentAsInProgress(MarkIncidentAsInProgressCommand command);

  AssignIncidentToTechSupportExpertResponse assignIncidentToTechSupportExpert(
      AssignIncidentToTechSupportExpertCommand command);

  MarkIncidentAsCompletedResponse markIncidentAsCompleted(MarkIncidentAsCompletedCommand command);

  MarkIncidentAsClosedResponse markIncidentAsClosed(MarkIncidentAsClosedCommand command);

  Incident findIncidentById(UUID incidentId);

  List<Incident> findIncidentsByStatus(Status incidentStatus);

  List<Incident> findIncidentsByAssignedTechSupportExpert(TechSupportExpert techSupportExpert);

  List<Incident> findAllIncidents();
}
