package ru.rickheadle.dddwitheda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private java.util.UUID id;

  @UUID
  private java.util.UUID userInfoId;

  private String firstName;
  private String middleName;
  private String lastName;

  @Email
  @Column(name = "email")
  private String emailAddress;

  @Column(name = "phone")
  private String phoneNumber;

  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "creation_date")
  private LocalDateTime creationDate;

}
