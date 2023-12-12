package ru.rickheadle.dddwitheda.domain.assign;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AssignIncidentToTechSupportExpertCommand {

  private final UUID incidentId;
  private final UUID techSupportExpertId;

}
