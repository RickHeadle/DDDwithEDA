package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.SupportLevel;

public interface TechSupportExpertService {

  Optional<TechSupportExpert> findTechSupportExpertById(UUID techSupportExpertId);

  List<TechSupportExpert> findTechSupportExpertsBySupportLevel(SupportLevel supportLevel);

  List<TechSupportExpert> findAllTechSupportExperts();
}
