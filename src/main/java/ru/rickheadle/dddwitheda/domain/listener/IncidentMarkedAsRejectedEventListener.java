package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsRejectedEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentMarkedAsRejectedEventListener {

  @Autowired
  private IncidentEventPublisher incidentEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentMarkedAsRejectedEvent.class)
  public void onApplicationEvent(IncidentMarkedAsRejectedEvent event) {
    incidentEventPublisher.publishIncidentMarkedAsRejected(event);
    log.info(String.format("Инциденту присвоен новый статус: %1$s. Время создания события: %2$s",
        event.getStatus().getStatusName(),
        event.getCreatedAt()));
  }

}
