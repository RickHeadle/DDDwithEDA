package ru.rickheadle.dddwitheda.mapper;

import org.springframework.stereotype.Component;
import ru.rickheadle.dddwitheda.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.domain.entity.Incident;

@Component
public class IncidentDataMapper {

  public Incident createIncidentCommandToIncident(CreateIncidentCommand createIncidentCommand) {
/*    return new Incident(
        new IncidentId(UUID.randomUUID()),

    );*/
    return null;
  }

}
