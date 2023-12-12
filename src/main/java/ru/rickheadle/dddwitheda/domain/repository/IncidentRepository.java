package ru.rickheadle.dddwitheda.domain.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, UUID> {

  List<Incident> findAllByStatus(Status status);

  List<Incident> findAllByTechSupportExpert(TechSupportExpert techSupportExpert);
}
