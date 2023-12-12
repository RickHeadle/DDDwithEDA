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
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusCommand;
import ru.rickheadle.dddwitheda.application.api.update.UpdateIncidentStatusResponse;
import ru.rickheadle.dddwitheda.application.services.impl.IncidentServiceImpl;
import ru.rickheadle.dddwitheda.domain.entity.Incident;

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

  @PostMapping(value = "/updateStatus", consumes = "application/json")
  public ResponseEntity<UpdateIncidentStatusResponse> updateIncidentStatus(
      @RequestBody UpdateIncidentStatusCommand command
  ) {
    UpdateIncidentStatusResponse response =
        incidentService.updateIncidentStatus(command);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public List<Incident> findAllIncidents() {
    return incidentService.findAllIncidents();
  }

}
