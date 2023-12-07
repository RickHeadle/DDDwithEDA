package ru.rickheadle.dddwitheda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import ru.rickheadle.dddwitheda.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.valueobject.IncidentPriority;
import ru.rickheadle.dddwitheda.valueobject.IncidentStatus;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requests")
public class IncidentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private java.util.UUID incidentId;

  private String title;
  private String description;
  private IncidentPriority priority;
  private IncidentStatus status;

  @ManyToOne
  private UserInfo userInfo;

  @NonNull
  private IncidentEmergency incidentEmergency;
  @NonNull
  private IncidentInfluence incidentInfluence;


  public IncidentPriority getPriority() {
    return IncidentPriority.findByValue(
        priorityMatrix
            [incidentEmergency.getValue()]
            [incidentInfluence.getValue()]
    ).orElseThrow();
  }

  /**
   * Матрица определения приоритета инцидента, основываясь на
   * оценки срочности и влияния. <br>
   * @link {@link description}/priorityMatrix.png
   */
  private static int[][] priorityMatrix = {
      {0, 0, 0, 1, 2},
      {0, 1, 1, 2, 3},
      {0, 1, 2, 2, 3},
      {1, 2, 2, 3, 4},
      {2, 3, 3, 4, 4}
  };

}
