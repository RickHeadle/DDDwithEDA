package ru.rickheadle.dddwitheda.domain.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsClosedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsCompletedEvent;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsInProgressEvent;

@Slf4j
@Component
public class IncidentEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  public IncidentEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishIncidentCreatedEvent(IncidentCreatedEvent incidentCreatedEvent) {
    log.info("Publishing the IncidentCreatedEvent: " + incidentCreatedEvent.toString());
    applicationEventPublisher.publishEvent(incidentCreatedEvent);
  }

  public void publishIncidentAssignedToTechSupportExpertEvent(
      IncidentAssignedToTechSupportExpertEvent event) {
    log.info("Publishing the IncidentAssignedToTechSupportExpertEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }

  public void publishIncidentMarkedAsInProgressEvent(IncidentMarkedAsInProgressEvent event) {
    log.info("Publishing the IncidentStatusUpdatedEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }

  public void publishIncidentMarkedAsCompleted(IncidentMarkedAsCompletedEvent event) {
    log.info("Publishing the IncidentMarkedAsCompletedEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }

  public void publishIncidentMarkedAsClosed(IncidentMarkedAsClosedEvent event) {
    log.info("Publishing the IncidentMarkedAsClosedEvent: " + event.toString());
    applicationEventPublisher.publishEvent(event);
  }
}
