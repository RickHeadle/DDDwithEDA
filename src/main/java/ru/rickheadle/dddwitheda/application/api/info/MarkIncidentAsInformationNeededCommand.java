package ru.rickheadle.dddwitheda.application.api.info;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkIncidentAsInformationNeededCommand {

  private UUID incidentId;
}
