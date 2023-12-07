package ru.rickheadle.dddwitheda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<ID> implements Serializable {

  @Column(name = "id", updatable = false, nullable = false)
  private ID id;

}
