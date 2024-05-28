package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class IncidentMarkedAsRejectedEvent extends ApplicationEvent {

  private final ZonedDateTime createdAt;

  public IncidentMarkedAsRejectedEvent(Object source, ZonedDateTime createdAt) {
    super(source);
    this.createdAt = createdAt;
  }
}
