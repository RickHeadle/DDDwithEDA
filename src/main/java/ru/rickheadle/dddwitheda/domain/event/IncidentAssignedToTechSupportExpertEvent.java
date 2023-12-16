package ru.rickheadle.dddwitheda.domain.event;

import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;

@Getter
public class IncidentAssignedToTechSupportExpertEvent extends ApplicationEvent {

  private final TechSupportExpert techSupportExpert;
  private final ZonedDateTime createdAt;

  public IncidentAssignedToTechSupportExpertEvent(Object source, TechSupportExpert techSupportExpert,
      ZonedDateTime createdAt) {
    super(source);
    this.techSupportExpert = techSupportExpert;
    this.createdAt = createdAt;
  }
}
