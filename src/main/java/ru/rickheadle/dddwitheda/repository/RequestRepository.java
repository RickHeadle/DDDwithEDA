package ru.rickheadle.dddwitheda.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.entity.Request;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Repository
public interface RequestRepository extends JpaRepository<Request, UUID> {

  List<Request> findAllByStatus(Status status);

  List<Request> findAllByTechSupportExpert(TechSupportExpert techSupportExpert);
}
