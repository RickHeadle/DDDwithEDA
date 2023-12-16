package ru.rickheadle.dddwitheda.application.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rickheadle.dddwitheda.application.services.impl.TechSupportExpertServiceImpl;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;

@RestController
@RequestMapping(value = "/techSupportExperts")
public class TechSupportExpertController {

  private final TechSupportExpertServiceImpl techSupportExpertService;

  public TechSupportExpertController(TechSupportExpertServiceImpl techSupportExpertService) {
    this.techSupportExpertService = techSupportExpertService;
  }

  @GetMapping
  public List<TechSupportExpert> findAllTechSupportExperts() {
    return techSupportExpertService.findAllTechSupportExperts();
  }
}
