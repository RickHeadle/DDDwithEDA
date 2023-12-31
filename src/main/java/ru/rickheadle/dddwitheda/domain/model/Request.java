package ru.rickheadle.dddwitheda.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requests")
public class Request extends BaseEntity {

  private String title;
  private String description;
  private Status status;

  @ManyToOne
  private ProductUser productUser;

  @OneToOne
  private TechSupportExpert techSupportExpert;

}
