package ru.rickheadle.dddwitheda.service;

import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.create.CreateIncidentResponse;

@Service
public class IncidentCreationServiceImpl implements IncidentCreationService {

  @Override
  public CreateIncidentResponse createIncident(CreateIncidentCommand createIncidentCommand) {
    return null;
  }
}
