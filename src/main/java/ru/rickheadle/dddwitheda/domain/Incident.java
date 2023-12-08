package ru.rickheadle.dddwitheda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
import ru.rickheadle.dddwitheda.valueobject.Status;

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
  private IncidentPriority priority;
  private Status status;

  @ManyToOne
  private Customer customer;

  @OneToOne
  private TechSupportExpert techSupportExpert;

  @NonNull
  private IncidentEmergency incidentEmergency;
  @NonNull
  private IncidentInfluence incidentInfluence;

}
