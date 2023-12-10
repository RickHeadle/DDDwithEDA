package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.entity.Incident;

@Getter
public class IncidentStatusUpdatedEvent extends ApplicationEvent {

  private final Incident incident;
  private final ZonedDateTime createdAt;

  public IncidentStatusUpdatedEvent(Object source, Incident incident, ZonedDateTime createdAt) {
    super(source);
    this.incident = incident;
    this.createdAt = createdAt;
  }
}
