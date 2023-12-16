package ru.rickheadle.dddwitheda.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import ru.rickheadle.dddwitheda.domain.model.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.domain.model.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.domain.model.valueobject.IncidentPriority;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incidents")
public class Incident extends BaseEntity {

  private String title;
  private String description;

  @Enumerated(EnumType.STRING)
  private IncidentPriority priority;
  private Status status;

  @ManyToOne
  private ProductUser productUser;

  @ManyToOne
  private TechSupportExpert techSupportExpert;

  @NonNull
  @Enumerated(EnumType.STRING)
  private IncidentEmergency incidentEmergency;

  @NonNull
  @Enumerated(EnumType.STRING)
  private IncidentInfluence incidentInfluence;

}
