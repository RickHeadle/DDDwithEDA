package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class IncidentMarkedAsCompletedEvent extends ApplicationEvent {

  private final ZonedDateTime createdAt;

  public IncidentMarkedAsCompletedEvent(Object source, ZonedDateTime createdAt) {
    super(source);
    this.createdAt = createdAt;
  }

}
