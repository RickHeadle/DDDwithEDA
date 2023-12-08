package ru.rickheadle.dddwitheda.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.Incident;

@Getter
public class IncidentCreatedEvent extends ApplicationEvent {

  private final Incident incident;
  private final ZonedDateTime createdAt;

  public IncidentCreatedEvent(Object source, Incident incident, ZonedDateTime createdAt) {
    super(source);
    this.incident = incident;
    this.createdAt = createdAt;
  }
}
