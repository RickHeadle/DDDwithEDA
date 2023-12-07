package ru.rickheadle.dddwitheda.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import ru.rickheadle.dddwitheda.DomainEvent;
import ru.rickheadle.dddwitheda.entity.IncidentEntity;

public class IncidentCreatedEvent implements DomainEvent<IncidentEntity> {

  @Getter
  private final IncidentEntity incident;
  private final ZonedDateTime createdAt;

  public IncidentCreatedEvent(IncidentEntity incident, ZonedDateTime createdAt) {
    this.incident = incident;
    this.createdAt = createdAt;
  }
}
