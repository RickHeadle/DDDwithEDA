package ru.rickheadle.dddwitheda.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ru.rickheadle.dddwitheda.entity.UserInfo;

@Builder
public record CreateIncidentCommand(String message, UserInfo userInfo) {

}
