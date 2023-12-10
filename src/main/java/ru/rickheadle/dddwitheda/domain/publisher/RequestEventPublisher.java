package ru.rickheadle.dddwitheda.domain.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.rickheadle.dddwitheda.domain.event.RequestAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.RequestCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.RequestStatusUpdatedEvent;

@Slf4j
@Component
public class RequestEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  public RequestEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishRequestCreatedEvent(RequestCreatedEvent event) {
    log.info("Publishing the RequestCreatedEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }

  public void publishRequestAssignedToTechSupportExpertEvent(
      RequestAssignedToTechSupportExpertEvent event) {
    log.info("Publishing the RequestAssignedToTechSupportExpertEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }

  public void publishRequestStatusUpdatedEvent(RequestStatusUpdatedEvent event) {
    log.info("Publishing the RequestStatusUpdatedEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }
}
