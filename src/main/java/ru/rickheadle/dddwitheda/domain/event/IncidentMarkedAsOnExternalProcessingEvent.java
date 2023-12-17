package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@Getter
public class IncidentMarkedAsOnExternalProcessingEvent extends ApplicationEvent {

  private final Status oldStatus;
  private final Status newStatus;
  private final ZonedDateTime createdAt;
  public IncidentMarkedAsOnExternalProcessingEvent(Object source, Status oldStatus,
      Status newStatus, ZonedDateTime createdAt) {
    super(source);
    this.oldStatus = oldStatus;
    this.newStatus = newStatus;
    this.createdAt = createdAt;
  }
}
