package ru.rickheadle.dddwitheda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rickheadle.dddwitheda.entity.IncidentEntity;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentEntity, Long> {

}
