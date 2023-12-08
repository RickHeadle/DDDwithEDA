package ru.rickheadle.dddwitheda.domain.valueobject;

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
   * Инцидент не является приоритетным.
   * Он будет взят в работу только тогда, когда будут устранены более приоритетные инциденты.
   */
  NONE ("Нет", 0),

  /**
   * Инцидент имеет низкий приоритет.
   */
  LOW ("Низкий", 1),

  /**
   * Инцидент имеет средний приоритет.
   */
  MEDIUM ("Средний", 2),

  /**
   * Инцидент имеет высокий приоритет.
   */
  HIGH ("Высокий", 3),

  /**
   * Инцидент имеет максимальный приоритет, и будет обработан в первую очередь.
   */
  EXTREME ("Очень высокий", 4);

  private final String name;
  private final int value;

  public static Optional<IncidentPriority> findByValue(@NonNull int value) {
    return Arrays.stream(IncidentPriority.values())
        .filter(incidentPriority -> Objects.equals(incidentPriority.getValue(), value))
        .findFirst();
  }

  public static IncidentPriority getPriority(IncidentInfluence incidentInfluence,
      IncidentEmergency incidentEmergency) {
    return IncidentPriority.findByValue(
        PRIORITY_MATRIX
            [incidentEmergency.getValue()]
            [incidentInfluence.getValue()]
    ).orElseThrow();
  }

  /**
   * Матрица определения приоритета инцидента, основываясь на
   * оценки срочности и влияния. <br>
   * @link {@link description}/priorityMatrix.png
   */
  private static final int[][] PRIORITY_MATRIX = {
      {0, 0, 0, 1, 2},
      {0, 1, 1, 2, 3},
      {0, 1, 2, 2, 3},
      {1, 2, 2, 3, 4},
      {2, 3, 3, 4, 4}
  };
}
