package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentAssignedToTechSupportExpertEventListener {

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentAssignedToTechSupportExpertEvent.class)
  public void onApplicationEvent(IncidentAssignedToTechSupportExpertEvent event) {
    log.info(String.format(
        "Инциденту присвоен сотрудник технической поддержки: %1$s. Время создания события: %2$s",
        event.getTechSupportExpert(),
        event.getCreatedAt()));
  }
}
