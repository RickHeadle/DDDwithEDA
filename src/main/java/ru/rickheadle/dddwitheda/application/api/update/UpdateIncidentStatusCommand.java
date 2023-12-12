package ru.rickheadle.dddwitheda.application.api.update;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Getter
@Builder
@AllArgsConstructor
public class UpdateIncidentStatusCommand {

  private final UUID incidentId;
  private final Status status;

}
