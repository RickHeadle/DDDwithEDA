package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Getter
public class IncidentMarkedAsCompletedEvent extends ApplicationEvent {

  private final Status status;
  private final ZonedDateTime createdAt;

  public IncidentMarkedAsCompletedEvent(Object source, Status status, ZonedDateTime createdAt) {
    super(source);
    this.status = status;
    this.createdAt = createdAt;
  }

}
