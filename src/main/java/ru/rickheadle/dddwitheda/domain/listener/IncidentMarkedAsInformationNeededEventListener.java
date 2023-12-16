package ru.rickheadle.dddwitheda.domain.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import ru.rickheadle.dddwitheda.domain.event.IncidentMarkedAsInformationNeededEvent;
import ru.rickheadle.dddwitheda.domain.publisher.IncidentEventPublisher;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentMarkedAsInformationNeededEventListener {

  @Autowired
  private IncidentEventPublisher incidentEventPublisher;

  @TransactionalEventListener(
      phase = TransactionPhase.AFTER_COMMIT,
      classes = IncidentMarkedAsInformationNeededEvent.class)
  public void onApplicationEvent(IncidentMarkedAsInformationNeededEvent event) {
    incidentEventPublisher.publishIncidentMarkedAsInformationNeeded(event);
    log.info(String.format("Инциденту присвоен новый статус: %1$s. Время создания события: %2$s",
        event.getStatus().getStatusName(),
        event.getCreatedAt()));
  }

}
