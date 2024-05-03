package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iItemRepository extends JpaRepository<Item, Long> {
}
