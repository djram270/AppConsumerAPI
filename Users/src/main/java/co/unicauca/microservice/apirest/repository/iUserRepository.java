package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//Para usar el repositorio y las demas cosas necesarias para User. Esto se hace para cada objeto y hay que indicar el tipo de dato de la id con el adorno entity en el model

public interface iUserRepository extends JpaRepository <User, Long> {

}
