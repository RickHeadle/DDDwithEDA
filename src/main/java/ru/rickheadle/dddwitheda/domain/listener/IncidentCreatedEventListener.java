package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentCreatedEventListener {

  @Autowired
  private IncidentEventPublisher incidentEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentCreatedEvent.class)
  public void onApplicationEvent(IncidentCreatedEvent event) {
    incidentEventPublisher.publishIncidentCreatedEvent(event);
    log.info(String.format("Создан новый инцидент: %1$s. Время создания: %2$s",
        event.getIncident(),
        event.getCreatedAt()));
  }

}
