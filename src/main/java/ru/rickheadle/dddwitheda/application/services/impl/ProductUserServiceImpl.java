package ru.rickheadle.dddwitheda.application.services.impl;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rickheadle.dddwitheda.application.services.ProductUserService;
import ru.rickheadle.dddwitheda.domain.model.ProductUser;
import ru.rickheadle.dddwitheda.infrastructure.repository.ProductUserRepository;

@Service
@Transactional
public class ProductUserServiceImpl implements ProductUserService {

  private final ProductUserRepository productUserRepository;

  @Autowired
  public ProductUserServiceImpl(ProductUserRepository productUserRepository) {
    this.productUserRepository = productUserRepository;
  }

  @Override
  public Optional<ProductUser> findProductUserById(UUID productUserId) {
    return productUserRepository.findById(productUserId);
  }

  @Override
  public List<ProductUser> findAllProductUsers() {
    return productUserRepository.findAll();
  }
}
