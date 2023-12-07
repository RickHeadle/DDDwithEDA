package ru.rickheadle.dddwitheda.valueobject;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
@AllArgsConstructor
public enum IncidentPriority {

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

  public static Optional<IncidentPriority> findByValue(@NonNull int value) {
    return Arrays.stream(IncidentPriority.values())
        .filter(incidentPriority -> Objects.equals(incidentPriority.getValue(), value))
        .findFirst();
  }
}
