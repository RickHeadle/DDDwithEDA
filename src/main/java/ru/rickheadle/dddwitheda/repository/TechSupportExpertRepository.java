package ru.rickheadle.dddwitheda.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.SupportLevel;

@Repository
public interface TechSupportExpertRepository extends JpaRepository<TechSupportExpert, UUID> {

  TechSupportExpert findByEmailAddress(String emailAddress);

  List<TechSupportExpert> findAllBySupportLevel(SupportLevel supportLevel);
}
