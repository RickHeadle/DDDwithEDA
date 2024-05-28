package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class IncidentMarkedAsOnExternalProcessingEvent extends ApplicationEvent {

  private final ZonedDateTime createdAt;
  public IncidentMarkedAsOnExternalProcessingEvent(Object source, ZonedDateTime createdAt) {
    super(source);
    this.createdAt = createdAt;
  }
}
