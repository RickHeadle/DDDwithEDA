package ru.rickheadle.dddwitheda.application.api.close;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsClosedCommand {

  private final UUID incidentId;

}
