package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.RequestAssignedToTechSupportExpertEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class RequestAssignedToTechSupportExpertEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = RequestAssignedToTechSupportExpertEvent.class
  )
  public void onApplicationEvent(RequestAssignedToTechSupportExpertEvent event) {
    log.info(String.format(
        "Запросу на обслуживание присвоен сотрудник технической поддержки: %1$s. "
            + "Время создания события: %2$s",
        event.getRequest(),
        event.getCreatedAt()
    ));
  }
}
