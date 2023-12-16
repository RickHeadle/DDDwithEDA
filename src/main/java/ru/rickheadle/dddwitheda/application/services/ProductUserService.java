package ru.rickheadle.dddwitheda.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ru.rickheadle.dddwitheda.domain.model.ProductUser;

public interface ProductUserService {

  Optional<ProductUser> findProductUserById(UUID productUserId);

  List<ProductUser> findAllProductUsers();

}
