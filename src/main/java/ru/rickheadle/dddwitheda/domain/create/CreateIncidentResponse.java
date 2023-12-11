package ru.rickheadle.dddwitheda.domain.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.rickheadle.dddwitheda.domain.entity.Incident;

@Getter
@Builder
@AllArgsConstructor
public class CreateIncidentResponse {

  private final Incident incident;
  private final String response;
}
