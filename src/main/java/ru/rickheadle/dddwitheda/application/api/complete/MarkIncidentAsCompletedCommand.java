package ru.rickheadle.dddwitheda.application.api.complete;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MarkIncidentAsCompletedCommand {

  private final UUID incidentId;

}
