package ru.rickheadle.dddwitheda.service;

import javax.validation.Valid;
import ru.rickheadle.dddwitheda.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.create.CreateIncidentResponse;

public interface IncidentCreationService {

  CreateIncidentResponse createIncident(@Valid CreateIncidentCommand createIncidentCommand);
}
