package ru.rickheadle.dddwitheda.domain.create;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentInfluence;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidentCommand {

  private final String title;
  private final String description;
  private final IncidentInfluence incidentInfluence;
  private final IncidentEmergency incidentEmergency;
  private final UUID productUserId;
  private final UUID techSupportExpertId;
}
