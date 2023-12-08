package ru.rickheadle.dddwitheda.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.domain.Request;
import ru.rickheadle.dddwitheda.domain.TechSupportExpert;
import ru.rickheadle.dddwitheda.valueobject.Status;

@Repository
public interface RequestRepository extends JpaRepository<Request, UUID> {

  List<Request> findAllByStatus(Status status);

  List<Request> findAllByTechSupportExpert(TechSupportExpert techSupportExpert);
}
