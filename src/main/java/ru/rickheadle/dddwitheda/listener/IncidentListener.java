package ru.rickheadle.dddwitheda.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.rickheadle.dddwitheda.event.IncidentCreatedEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentListener {

  @EventListener(IncidentCreatedEvent.class)
  public void handle(IncidentCreatedEvent event) {
    log.info(String.format("Создан новый инцидент: %1$s. Время создания: %2$s",
        event.getIncident().toString(),
        event.getCreatedAt().toString()));
  }

}
