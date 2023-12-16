package ru.rickheadle.dddwitheda.application.api.reject;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarkIncidentAsRejectedCommand {

  private UUID incidentId;

}
