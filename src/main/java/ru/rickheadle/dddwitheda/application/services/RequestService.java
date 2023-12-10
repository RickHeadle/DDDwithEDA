package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.entity.Request;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface RequestService {

  void createRequest(String title, String description, TechSupportExpert techSupportExpert);

  void updateRequestStatus(UUID requestId, Status newStatus);

  void assignIncidentToTechSupportExpert(UUID requestId, TechSupportExpert techSupportExpert);

  Optional<Request> getRequestById(UUID requestId);

  List<Request> getRequestsByStatus(Status status);

  List<Request> getRequestsByTechSupportExpert(TechSupportExpert techSupportExpert);
}
