package ru.rickheadle.dddwitheda.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
import ru.rickheadle.dddwitheda.application.api.info.MarkIncidentAsInformationNeededCommand;
import ru.rickheadle.dddwitheda.application.api.info.MarkIncidentAsInformationNeededResponse;
import ru.rickheadle.dddwitheda.application.services.impl.IncidentServiceImpl;
import ru.rickheadle.dddwitheda.domain.model.Incident;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentController {

  private final IncidentServiceImpl incidentService;

  @Autowired
  public IncidentController(IncidentServiceImpl incidentService) {
    this.incidentService = incidentService;
  }

  @PostMapping(value = "/create", consumes = "application/json")
  public ResponseEntity<CreateIncidentResponse> createIncident(
      @RequestBody CreateIncidentCommand createIncidentCommand) {
    CreateIncidentResponse response = incidentService.createIncident(createIncidentCommand);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/assign", consumes = "application/json")
  public ResponseEntity<AssignIncidentToTechSupportExpertResponse> assignIncident(
      @RequestBody AssignIncidentToTechSupportExpertCommand command
  ) {
    AssignIncidentToTechSupportExpertResponse response =
        incidentService.assignIncidentToTechSupportExpert(command);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/markAsInProgress", consumes = "application/json")
  public ResponseEntity<MarkIncidentAsInProgressResponse> markIncidentAsInProgress(
      @RequestBody MarkIncidentAsInProgressCommand command
  ) {
    MarkIncidentAsInProgressResponse response =
        incidentService.markIncidentAsInProgress(command);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/markAsCompleted", consumes = "application/json")
  public ResponseEntity<MarkIncidentAsCompletedResponse> markIncidentAsCompleted(
      @RequestBody MarkIncidentAsCompletedCommand command
  ) {
    MarkIncidentAsCompletedResponse response =
        incidentService.markIncidentAsCompleted(command);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/markAsClosed", consumes = "application/json")
  public ResponseEntity<MarkIncidentAsClosedResponse> markIncidentAsClosed(
      @RequestBody MarkIncidentAsClosedCommand command
  ) {
    MarkIncidentAsClosedResponse response =
        incidentService.markIncidentAsClosed(command);
    return ResponseEntity.ok(response);
  }

  @PostMapping(value = "/markAsInfoNeeded", consumes = "application/json")
  public ResponseEntity<MarkIncidentAsInformationNeededResponse> markIncidentAsInformationNeeded(
    @RequestBody MarkIncidentAsInformationNeededCommand command
  ) {
    MarkIncidentAsInformationNeededResponse response =
        incidentService.markIncidentAsInformationNeeded(command);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public List<Incident> findAllIncidents() {
    return incidentService.findAllIncidents();
  }

}
