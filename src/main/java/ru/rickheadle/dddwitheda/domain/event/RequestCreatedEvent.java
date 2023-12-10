package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.entity.Request;

@Getter
public class RequestCreatedEvent extends ApplicationEvent {

  private final Request request;
  private final ZonedDateTime createdAt;

  public RequestCreatedEvent(Object source, Request request, ZonedDateTime createdAt) {
    super(source);
    this.request = request;
    this.createdAt = createdAt;
  }
}
