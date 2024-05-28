package ru.rickheadle.dddwitheda.domain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.model.Request;
import ru.rickheadle.dddwitheda.domain.model.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.model.valueobject.Status;

public interface RequestService {

  void createRequest(String title, String description, TechSupportExpert techSupportExpert);

  void updateRequestStatus(UUID requestId, Status newStatus);

  void assignRequestToTechSupportExpert(UUID requestId, TechSupportExpert techSupportExpert);

  Optional<Request> findRequestById(UUID requestId);

  List<Request> findRequestsByStatus(Status status);

  List<Request> findRequestsByTechSupportExpert(TechSupportExpert techSupportExpert);

  List<Request> findAllRequests();
}
