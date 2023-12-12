package ru.rickheadle.dddwitheda.application.api.update;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateIncidentStatusResponse {

  private final UUID incidentId;
  private final String response;

}
