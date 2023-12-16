package ru.rickheadle.dddwitheda.infrastructure.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.model.valueobject.SupportLevel;

@Repository
public interface TechSupportExpertRepository extends JpaRepository<TechSupportExpert, UUID> {

  List<TechSupportExpert> findAllBySupportLevel(SupportLevel supportLevel);
}
