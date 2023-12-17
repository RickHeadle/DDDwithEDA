package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsOnExternalProcessingEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentMarkedAsOnExternalProcessingEventListener {

  @Autowired
  private IncidentEventPublisher incidentEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentMarkedAsOnExternalProcessingEvent.class
  )
  public void onApplicationEvent(IncidentMarkedAsOnExternalProcessingEvent event) {
    incidentEventPublisher.publishIncidentMarkedAsOnExternalProcessing(event);
    log.info(String.format(
        "Изменение статуса инцидента: %1$s -> %2$s. Время создания события: %3$s",
        event.getOldStatus().getStatusName(),
        event.getNewStatus().getStatusName(),
        event.getCreatedAt()));
  }

}
