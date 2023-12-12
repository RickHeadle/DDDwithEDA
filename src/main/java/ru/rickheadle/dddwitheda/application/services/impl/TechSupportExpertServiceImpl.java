package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.TechSupportExpertService;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.repository.TechSupportExpertRepository;
import ru.rickheadle.dddwitheda.domain.valueobject.SupportLevel;

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
