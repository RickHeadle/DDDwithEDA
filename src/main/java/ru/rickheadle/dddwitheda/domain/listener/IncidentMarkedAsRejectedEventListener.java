package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsRejectedEvent;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentMarkedAsRejectedEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentMarkedAsRejectedEvent.class)
  public void onApplicationEvent(IncidentMarkedAsRejectedEvent event) {
    log.info(String.format("Инциденту присвоен новый статус: %1$s. Время создания события: %2$s",
        Status.REJECTED_BY_USER.getStatusName(),
        event.getCreatedAt()));
  }

}
