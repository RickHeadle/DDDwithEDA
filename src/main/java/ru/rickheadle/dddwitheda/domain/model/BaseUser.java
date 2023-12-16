package ru.rickheadle.dddwitheda.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class BaseUser extends BaseEntity {

  private String firstName;
  private String middleName;
  private String lastName;

  @Email
  @Column(name = "email")
  private String emailAddress;

  @Column(name = "phone")
  private String phoneNumber;
}
