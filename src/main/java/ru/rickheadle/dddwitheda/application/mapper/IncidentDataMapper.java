package ru.rickheadle.dddwitheda.application.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentResponse;
import ru.rickheadle.dddwitheda.application.services.impl.ProductUserServiceImpl;
import ru.rickheadle.dddwitheda.application.services.impl.TechSupportExpertServiceImpl;
import ru.rickheadle.dddwitheda.domain.entity.Incident;
import ru.rickheadle.dddwitheda.domain.valueobject.IncidentPriority;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

@Component
public class IncidentDataMapper {

  private final ProductUserServiceImpl productUserService;
  private final TechSupportExpertServiceImpl techSupportService;

  @Autowired
  public IncidentDataMapper(ProductUserServiceImpl productUserService,
      TechSupportExpertServiceImpl techSupportService) {
    this.productUserService = productUserService;
    this.techSupportService = techSupportService;
  }

  public Incident createIncidentCommandToIncident(CreateIncidentCommand incidentCommand) {
    return Incident.builder()
        .title(incidentCommand.getTitle())
        .description(incidentCommand.getDescription())
        .incidentInfluence(incidentCommand.getIncidentInfluence())
        .incidentEmergency(incidentCommand.getIncidentEmergency())
        .priority(IncidentPriority.getPriority(
            incidentCommand.getIncidentInfluence(),
            incidentCommand.getIncidentEmergency()
        ))
        .status(Status.REGISTERED)
        .productUser(productUserService.findProductUserById(
            incidentCommand.getProductUserId()).orElse(null))
        .techSupportExpert(techSupportService.findTechSupportExpertById(
            incidentCommand.getTechSupportExpertId()).orElse(null))
        .build();
  }

  public CreateIncidentResponse incidentToCreateIncidentResponse(Incident incident, String response) {
    return CreateIncidentResponse.builder()
        .incidentId(incident.getId())
        .response(response)
        .build();
  }

}
