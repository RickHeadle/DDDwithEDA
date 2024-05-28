package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.model.valueobject.SupportLevel;
import ru.rickheadle.dddwitheda.domain.services.TechSupportExpertService;
import ru.rickheadle.dddwitheda.infrastructure.repository.TechSupportExpertRepository;

@Service
@Transactional
public class TechSupportExpertServiceImpl implements TechSupportExpertService {

  private final TechSupportExpertRepository techSupportExpertRepository;

  @Autowired
  public TechSupportExpertServiceImpl(TechSupportExpertRepository techSupportExpertRepository) {
    this.techSupportExpertRepository = techSupportExpertRepository;
  }

  @Override
  public Optional<TechSupportExpert> findTechSupportExpertById(UUID techSupportExpertId) {
    return techSupportExpertRepository.findById(techSupportExpertId);
  }

  @Override
  public List<TechSupportExpert> findTechSupportExpertsBySupportLevel(SupportLevel supportLevel) {
    return techSupportExpertRepository.findAllBySupportLevel(supportLevel);
  }

  @Override
  public List<TechSupportExpert> findAllTechSupportExperts() {
    return techSupportExpertRepository.findAll();
  }
}
