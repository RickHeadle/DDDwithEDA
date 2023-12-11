package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.RequestStatusUpdatedEvent;
import ru.rickheadle.dddwitheda.domain.publisher.RequestEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestStatusUpdatedEventListener {

  @Autowired
  private RequestEventPublisher requestEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = RequestStatusUpdatedEvent.class
  )
  public void onApplicationEvent(RequestStatusUpdatedEvent event) {
    requestEventPublisher.publishRequestStatusUpdatedEvent(event);
    log.info(String.format(
        "Запросу на обслуживание присвоен новый статус: %1$s. Время создания события: %2$s",
        event.getRequest(),
        event.getCreatedAt()
    ));
  }
}
