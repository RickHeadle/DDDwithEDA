package ru.rickheadle.dddwitheda.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.rickheadle.dddwitheda.domain.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

  Customer findByLastNameAndFirstNameAndMiddleName(
      String firstName, String lastName, String middleName);

  Customer findByEmailAddress(String emailAddress);

}
