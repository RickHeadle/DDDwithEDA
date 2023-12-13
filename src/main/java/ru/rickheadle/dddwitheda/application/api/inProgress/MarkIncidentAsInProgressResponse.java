package ru.rickheadle.dddwitheda.application.api.inProgress;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsInProgressResponse {

  private final UUID incidentId;
  private final String response;

}
