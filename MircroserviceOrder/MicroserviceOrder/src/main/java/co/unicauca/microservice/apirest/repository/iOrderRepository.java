package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iOrderRepository extends JpaRepository<Order, Long> {
}

