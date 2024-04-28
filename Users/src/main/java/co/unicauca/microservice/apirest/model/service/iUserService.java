package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.User;

import java.util.List;

public interface iUserService {
    List<User> getUsers();

    String deleteUser(Long id);

    String postUser(User user);

    String putUser(User user, Long id);
}
