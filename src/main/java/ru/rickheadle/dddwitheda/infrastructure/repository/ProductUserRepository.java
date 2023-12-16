package ru.rickheadle.dddwitheda.infrastructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.model.ProductUser;

@Repository
public interface ProductUserRepository extends JpaRepository<ProductUser, UUID> {

  ProductUser findByLastNameAndFirstNameAndMiddleName(
      String firstName, String lastName, String middleName);

  ProductUser findByEmailAddress(String emailAddress);

}
