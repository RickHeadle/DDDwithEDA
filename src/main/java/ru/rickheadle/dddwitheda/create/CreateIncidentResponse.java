package ru.rickheadle.dddwitheda.create;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
public record CreateIncidentResponse(@NotNull UUID messageId, @NotNull String message) {

}
