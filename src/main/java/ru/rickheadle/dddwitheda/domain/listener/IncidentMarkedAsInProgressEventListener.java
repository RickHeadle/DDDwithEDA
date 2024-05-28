package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsInProgressEvent;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentMarkedAsInProgressEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentMarkedAsInProgressEvent.class)
  public void onApplicationEvent(IncidentMarkedAsInProgressEvent event) {
    log.info(String.format("Инциденту присвоен новый статус: %1$s. Время создания события: %2$s",
        Status.IN_PROGRESS.getStatusName(),
        event.getCreatedAt()));
  }
}
