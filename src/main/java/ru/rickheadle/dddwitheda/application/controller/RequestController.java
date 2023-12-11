package ru.rickheadle.dddwitheda.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rickheadle.dddwitheda.application.services.impl.RequestServiceImpl;
import ru.rickheadle.dddwitheda.domain.entity.Request;

@RestController
@RequestMapping(value = "/requests")
public class RequestController {

  private final RequestServiceImpl requestService;

  @Autowired
  public RequestController(RequestServiceImpl requestService) {
    this.requestService = requestService;
  }

  @GetMapping
  public List<Request> findAllRequests() {
    return requestService.findAllRequests();
  }
}
