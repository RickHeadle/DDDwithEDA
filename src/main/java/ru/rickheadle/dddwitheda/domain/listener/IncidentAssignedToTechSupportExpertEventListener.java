package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentAssignedToTechSupportExpertEventListener {

  @Autowired
  private IncidentEventPublisher incidentEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentAssignedToTechSupportExpertEvent.class)
  public void onApplicationEvent(IncidentAssignedToTechSupportExpertEvent event) {
    incidentEventPublisher.publishIncidentAssignedToTechSupportExpertEvent(event);
    log.info(String.format(
        "Инциденту присвоен сотрудник технической поддержки: %1$s. Время создания: %2$s",
        event.getIncident(),
        event.getCreatedAt()));
  }
}
