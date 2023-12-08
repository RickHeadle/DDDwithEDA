package ru.rickheadle.dddwitheda.domain.valueobject;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IncidentInfluence {

  /**
   * Пользователи или системы не затронуты.
   */
  NONE ("Нет", 0),

  /**
   * Затронут один пользователь или одна система.
   */
  LOW ("Низкое", 1),

  /**
   * Затронута небольшая группа пользователей или систем.
   */
  MEDIUM ("Среднее", 2),

  /**
   * затронута большая группа пользователей или систем.
   */
  HIGH ("Высокое", 3),

  /**
   * Затронуты все пользователи или системы.
   */
  EXTREME ("Очень высокое", 4);

  private final String name;
  private final int value;

  public Optional<IncidentInfluence> findByValue(int value) {
    return Arrays.stream(IncidentInfluence.values())
        .filter(incidentEmergencyEnum -> incidentEmergencyEnum.getValue() == value)
        .findFirst();
  }
}
