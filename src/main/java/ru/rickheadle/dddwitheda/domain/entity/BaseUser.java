package ru.rickheadle.dddwitheda.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import lombok.Data;

@Data
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
