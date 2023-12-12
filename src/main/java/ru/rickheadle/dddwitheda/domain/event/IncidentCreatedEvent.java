package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class IncidentCreatedEvent extends ApplicationEvent {

  private final String incidentTitle;
  private final ZonedDateTime createdAt;

  public IncidentCreatedEvent(Object source, String incidentTitle, ZonedDateTime createdAt) {
    super(source);
    this.incidentTitle = incidentTitle;
    this.createdAt = createdAt;
  }
}
