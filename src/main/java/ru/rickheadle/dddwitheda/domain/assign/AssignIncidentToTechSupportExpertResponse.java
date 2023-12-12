package ru.rickheadle.dddwitheda.domain.assign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.rickheadle.dddwitheda.domain.entity.Incident;

@Getter
@Builder
@AllArgsConstructor
public class AssignIncidentToTechSupportExpertResponse {

  private final Incident incident;
  private final String response;
}
