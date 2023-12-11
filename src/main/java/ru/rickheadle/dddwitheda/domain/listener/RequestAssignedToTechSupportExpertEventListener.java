package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.RequestAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.publisher.RequestEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestAssignedToTechSupportExpertEventListener {

  @Autowired
  private RequestEventPublisher requestEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = RequestAssignedToTechSupportExpertEvent.class
  )
  public void onApplicationEvent(RequestAssignedToTechSupportExpertEvent event) {
    requestEventPublisher.publishRequestAssignedToTechSupportExpertEvent(event);
    log.info(String.format(
        "Запросу на обслуживание присвоен сотрудник технической поддержки: %1$s. "
            + "Время создания события: %2$s",
        event.getRequest(),
        event.getCreatedAt()
    ));
  }
}
