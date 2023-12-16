package ru.rickheadle.dddwitheda.application.api.info;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsInformationNeededResponse {

  private final UUID incidentId;
  private final String response;

}
