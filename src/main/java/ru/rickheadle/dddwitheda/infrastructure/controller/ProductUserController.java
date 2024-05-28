package ru.rickheadle.dddwitheda.infrastructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rickheadle.dddwitheda.application.services.impl.ProductUserServiceImpl;
import ru.rickheadle.dddwitheda.domain.model.ProductUser;

@RestController
@RequestMapping(value = "/productUsers")
public class ProductUserController {

  private final ProductUserServiceImpl productUserService;

  @Autowired
  public ProductUserController(ProductUserServiceImpl productUserService) {
    this.productUserService = productUserService;
  }

  @GetMapping
  public List<ProductUser> findAllProductUsers() {
    return productUserService.findAllProductUsers();
  }
}
