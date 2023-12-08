package ru.rickheadle.dddwitheda.application.services.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.RequestService;
import ru.rickheadle.dddwitheda.domain.Request;
import ru.rickheadle.dddwitheda.domain.TechSupportExpert;
import ru.rickheadle.dddwitheda.repository.RequestRepository;
import ru.rickheadle.dddwitheda.valueobject.Status;

@Service
public class RequestServiceImpl implements RequestService {

  private final RequestRepository requestRepository;

  @Autowired
  public RequestServiceImpl(RequestRepository requestRepository) {
    this.requestRepository = requestRepository;
  }

  @Override
  public Request createRequest(String title, String description,
      TechSupportExpert techSupportExpert) {
    Request request = Request.builder()
        .title(title)
        .description(description)
        .status(Status.REGISTERED)
        .techSupportExpert(techSupportExpert)
        .build();
    return requestRepository.save(request);
  }

  @Override
  public Request updateRequestStatus(UUID requestId, Status newStatus) {
    Request request = getRequestById(requestId);
    request.setStatus(newStatus);
    return requestRepository.save(request);
  }

  @Override
  public Request assignIncidentToTechSupportExpert(UUID requestId,
      TechSupportExpert techSupportExpert) {
    Request request = getRequestById(requestId);
    request.setTechSupportExpert(techSupportExpert);
    return requestRepository.save(request);
  }

  @Override
  public Request getRequestById(UUID requestId) {
    return requestRepository.findById(requestId).orElseThrow();
  }

  @Override
  public List<Request> getRequestsByStatus(Status status) {
    return requestRepository.findAllByStatus(status);
  }

  @Override
  public List<Request> getRequestsByTechSupportExpert(TechSupportExpert techSupportExpert) {
    return requestRepository.findAllByTechSupportExpert(techSupportExpert);
  }
}
