package ru.rickheadle.dddwitheda.application.services.impl;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.rickheadle.dddwitheda.application.api.assign.AssignIncidentToTechSupportExpertCommand;
import ru.rickheadle.dddwitheda.application.api.close.MarkIncidentAsClosedCommand;
import ru.rickheadle.dddwitheda.application.api.complete.MarkIncidentAsCompletedCommand;
import ru.rickheadle.dddwitheda.application.api.create.CreateIncidentCommand;
import ru.rickheadle.dddwitheda.application.api.external.MarkIncidentAsOnExternalProcessingCommand;
import ru.rickheadle.dddwitheda.application.api.inProgress.MarkIncidentAsInProgressCommand;
import ru.rickheadle.dddwitheda.application.api.info.MarkIncidentAsInformationNeededCommand;
import ru.rickheadle.dddwitheda.application.api.reject.MarkIncidentAsRejectedCommand;
import ru.rickheadle.dddwitheda.domain.model.valueobject.IncidentEmergency;
import ru.rickheadle.dddwitheda.domain.model.valueobject.IncidentInfluence;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

@SpringBootTest
class IncidentServiceUnitTest {

  @Autowired
  private IncidentServiceImpl incidentService;

  @Autowired
  private TechSupportExpertServiceImpl techSupportExpertService;

  private static CreateIncidentCommand createIncidentCommand;
  private static MarkIncidentAsInProgressCommand markIncidentAsInProgressCommand;
  private static AssignIncidentToTechSupportExpertCommand assignIncidentToTechSupportExpertCommand;
  private static MarkIncidentAsCompletedCommand markIncidentAsCompletedCommand;
  private static MarkIncidentAsClosedCommand markIncidentAsClosedCommand;
  private static MarkIncidentAsRejectedCommand markIncidentAsRejectedCommand;
  private static MarkIncidentAsInformationNeededCommand markIncidentAsInformationNeededCommand;
  private static MarkIncidentAsOnExternalProcessingCommand markIncidentAsOnExternalProcessingCommand;

  @BeforeAll
  static void beforeAll() {
    createIncidentCommand = CreateIncidentCommand.builder()
        .title("Test title for Incident")
        .description("Description")
        .incidentInfluence(IncidentInfluence.LOW)
        .incidentEmergency(IncidentEmergency.HIGH)
        .productUserId(UUID.fromString("9f632f4b-e907-466e-bf70-e67518f0f741"))
        .techSupportExpertId(UUID.fromString("a5b4e2e7-a16c-46f9-b6c5-70d0665768eb"))
        .build();
    markIncidentAsInProgressCommand = MarkIncidentAsInProgressCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
    assignIncidentToTechSupportExpertCommand = AssignIncidentToTechSupportExpertCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .techSupportExpertId(UUID.fromString("a5b4e2e7-a16c-46f9-b6c5-70d0665768eb"))
        .build();
    markIncidentAsCompletedCommand = MarkIncidentAsCompletedCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
    markIncidentAsClosedCommand = MarkIncidentAsClosedCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
    markIncidentAsRejectedCommand = MarkIncidentAsRejectedCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
    markIncidentAsInformationNeededCommand = MarkIncidentAsInformationNeededCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
    markIncidentAsOnExternalProcessingCommand = MarkIncidentAsOnExternalProcessingCommand.builder()
        .incidentId(UUID.fromString("7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6"))
        .build();
  }

  @Test
  @DisplayName("Проверка на создание сущности Incident")
  void whenCreateIncidentMethodCalled_thenIncidentEntityCreated() {
    Assertions.assertDoesNotThrow(() -> incidentService.createIncident(createIncidentCommand));
    Assertions.assertNotEquals(0, incidentService.findAllIncidents().size());
  }

  @Test
  @DisplayName("Проверка на установку статуса IN_PROGRESS")
  void whenMarkIncidentAsInProgressMethodCalled_thenIncidentStatusIsInProgress() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsInProgress(markIncidentAsInProgressCommand));
    Assertions.assertEquals(Status.IN_PROGRESS, incidentService.findIncidentById(
        markIncidentAsInProgressCommand.getIncidentId()).getStatus());
  }

  @Test
  @DisplayName("Проверка назначения эксперта на инцидент")
  void whenIncidentAssignedToTechSupportExpert_thenIncidentTechSupportExpertChanged() {
    Assertions.assertDoesNotThrow(() ->
        incidentService.assignIncidentToTechSupportExpert(assignIncidentToTechSupportExpertCommand));
    Assertions.assertEquals(
        techSupportExpertService.findTechSupportExpertById(
            assignIncidentToTechSupportExpertCommand.getTechSupportExpertId()
        ).orElseThrow(),
        incidentService.findIncidentById(
            assignIncidentToTechSupportExpertCommand.getIncidentId()
        ).getTechSupportExpert());
  }

  @Test
  @DisplayName("Проверка на установку статуса COMPLETED")
  void whenMarkIncidentAsCompletedMethodCalled_thenIncidentStatusIsCompleted() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsCompleted(markIncidentAsCompletedCommand));
    Assertions.assertEquals(Status.COMPLETED, incidentService.findIncidentById(
        markIncidentAsInProgressCommand.getIncidentId()).getStatus());
  }

  @Test
  @DisplayName("Проверка на установку статуса CLOSED")
  void whenMarkIncidentAsClosedMethodCalled_thenIncidentStatusIsClosed() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsClosed(markIncidentAsClosedCommand));
    Assertions.assertEquals(Status.CLOSED, incidentService.findIncidentById(
        markIncidentAsClosedCommand.getIncidentId()).getStatus());
  }

  @Test
  @DisplayName("Проверка на установку статуса REJECTED_BY_USER")
  void whenMarkIncidentAsRejectedMethodCalled_thenIncidentStatusIsRejected() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsRejected(markIncidentAsRejectedCommand));
    Assertions.assertEquals(Status.REJECTED_BY_USER, incidentService.findIncidentById(
        markIncidentAsRejectedCommand.getIncidentId()).getStatus());
  }

  @Test
  @DisplayName("Проверка на установку статуса INFORMATION_NEEDED")
  void whenMarkIncidentAsInformationNeededMethodCalled_thenIncidentStatusIsInformationNeeded() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsInformationNeeded(markIncidentAsInformationNeededCommand));
    Assertions.assertEquals(Status.INFORMATION_NEEDED, incidentService.findIncidentById(
        markIncidentAsInformationNeededCommand.getIncidentId()).getStatus());
  }

  @Test
  @DisplayName("Проверка на установку статуса EXTERNAL_PROCESSING")
  void whenMarkIncidentAsOnExternalProcessingMethodCalled_thenIncidentStatusIsOnExternalProcessing() {
    Assertions.assertDoesNotThrow(
        () -> incidentService.markIncidentAsOnExternalProcessing(markIncidentAsOnExternalProcessingCommand));
    Assertions.assertEquals(Status.EXTERNAL_PROCESSING, incidentService.findIncidentById(
        markIncidentAsOnExternalProcessingCommand.getIncidentId()).getStatus());
  }

}