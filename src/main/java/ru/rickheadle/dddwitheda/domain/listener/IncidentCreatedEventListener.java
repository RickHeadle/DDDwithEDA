package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentCreatedEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentCreatedEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentCreatedEvent.class)
  public void onApplicationEvent(IncidentCreatedEvent event) {
    log.info(String.format("Создан новый инцидент: %1$s. Время создания события: %2$s",
        event.getIncidentTitle(),
        event.getCreatedAt()));
  }

}
