package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.entity.Request;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;

public interface RequestService {

  Request createRequest(String title, String description, TechSupportExpert techSupportExpert);

  Request updateRequestStatus(UUID requestId, Status newStatus);

  Request assignIncidentToTechSupportExpert(UUID requestId, TechSupportExpert techSupportExpert);

  Request getRequestById(UUID requestId);

  List<Request> getRequestsByStatus(Status status);

  List<Request> getRequestsByTechSupportExpert(TechSupportExpert techSupportExpert);
}
