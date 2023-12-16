package ru.rickheadle.dddwitheda.application.api.reject;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsRejectedResponse {

  private final UUID incidentId;
  private final String response;

}
