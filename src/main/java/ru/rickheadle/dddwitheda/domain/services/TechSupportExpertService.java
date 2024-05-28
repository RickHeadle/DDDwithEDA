package ru.rickheadle.dddwitheda.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.model.valueobject.SupportLevel;

public interface TechSupportExpertService {

  Optional<TechSupportExpert> findTechSupportExpertById(UUID techSupportExpertId);

  List<TechSupportExpert> findTechSupportExpertsBySupportLevel(SupportLevel supportLevel);

  List<TechSupportExpert> findAllTechSupportExperts();
}
