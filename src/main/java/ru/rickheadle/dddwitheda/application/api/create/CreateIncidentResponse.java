package ru.rickheadle.dddwitheda.application.api.create;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidentResponse {

  private final UUID incidentId;
  private final String response;
}
