package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.RequestService;
import ru.rickheadle.dddwitheda.domain.entity.Request;
import ru.rickheadle.dddwitheda.domain.entity.TechSupportExpert;
import ru.rickheadle.dddwitheda.domain.event.RequestAssignedToTechSupportExpertEvent;
import ru.rickheadle.dddwitheda.domain.event.RequestCreatedEvent;
import ru.rickheadle.dddwitheda.domain.event.RequestStatusUpdatedEvent;
import ru.rickheadle.dddwitheda.domain.publisher.RequestEventPublisher;
import ru.rickheadle.dddwitheda.domain.valueobject.Status;
import ru.rickheadle.dddwitheda.repository.RequestRepository;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

  private final RequestRepository requestRepository;
  private final RequestEventPublisher requestEventPublisher;

  @Autowired
  public RequestServiceImpl(RequestRepository requestRepository,
      RequestEventPublisher requestEventPublisher) {
    this.requestRepository = requestRepository;
    this.requestEventPublisher = requestEventPublisher;
  }

  @Override
  public void createRequest(String title, String description,
      TechSupportExpert techSupportExpert) {
    Request request = Request.builder()
        .title(title)
        .description(description)
        .status(Status.REGISTERED)
        .techSupportExpert(techSupportExpert)
        .build();
    requestRepository.save(request);
    requestEventPublisher.publishRequestCreatedEvent(
        new RequestCreatedEvent(
            this,
            request,
            ZonedDateTime.now()
        )
    );
  }

  @Override
  public void updateRequestStatus(UUID requestId, Status newStatus) {
    getRequestById(requestId)
        .ifPresent(request -> {
          request.setStatus(newStatus);
          requestRepository.save(request);
          requestEventPublisher.publishRequestStatusUpdatedEvent(
              new RequestStatusUpdatedEvent(
                  this,
                  request,
                  ZonedDateTime.now()
              )
          );
        });
  }

  @Override
  public void assignIncidentToTechSupportExpert(UUID requestId,
      TechSupportExpert techSupportExpert) {
    getRequestById(requestId)
        .ifPresent(request -> {
          request.setTechSupportExpert(techSupportExpert);
          requestRepository.save(request);
          requestEventPublisher.publishRequestAssignedToTechSupportExpertEvent(
              new RequestAssignedToTechSupportExpertEvent(
                  this,
                  request,
                  ZonedDateTime.now()
              )
          );
        });
  }

  @Override
  public Optional<Request> getRequestById(UUID requestId) {
    return requestRepository.findById(requestId);
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
