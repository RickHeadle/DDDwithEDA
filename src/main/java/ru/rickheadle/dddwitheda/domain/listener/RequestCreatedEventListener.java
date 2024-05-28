package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.RequestCreatedEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestCreatedEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = RequestCreatedEvent.class)
  public void onApplicationEvent(RequestCreatedEvent event) {
    log.info(String.format(
        "Создан новый запрос на обслуживание: %1$s. Время создания события: %2$s",
        event.getRequest(),
        event.getCreatedAt()));
  }

}
