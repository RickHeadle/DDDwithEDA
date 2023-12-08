package ru.rickheadle.dddwitheda.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rickheadle.dddwitheda.domain.valueobject.SupportLevel;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tech_support_experts")
public class TechSupportExpert extends BaseUser {

  private SupportLevel supportLevel;
}
