package ru.rickheadle.dddwitheda.application.api.external;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsOnExternalProcessingResponse {

  private final UUID incidentId;
  private final String response;

}
