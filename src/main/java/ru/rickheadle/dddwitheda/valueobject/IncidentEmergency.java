package ru.rickheadle.dddwitheda.valueobject;

import java.util.Arrays;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IncidentEmergency {

  /**
   * Обращение является пожеланием.
   */
  NONE ("Нет", 0),

  /**
   * Существуют неудобства при использовании услуги,
   * риск увеличения влияния на бизнес до существенного низкий.
   */
  LOW ("Низкая", 1),

  /**
   * Незначительное ухудшение качества услуги,
   * есть риск увеличения влияния на бизнес до существенного.
   */
  MEDIUM ("Средняя", 2),

  /**
   * Качество услуги сильно снижено,
   * высокий риск увеличения влияния на бизнес до существенного.
   */
  HIGH ("Высокая", 3),

  /**
   * Влияние на бизнес существенное.
   */
  EXTREME ("Очень высокая", 4);

  private final String name;
  private final int value;

  public Optional<IncidentEmergency> findByValue(int value) {
    return Arrays.stream(IncidentEmergency.values())
        .filter(incidentEmergency -> incidentEmergency.getValue() == value)
        .findFirst();
  }

}
