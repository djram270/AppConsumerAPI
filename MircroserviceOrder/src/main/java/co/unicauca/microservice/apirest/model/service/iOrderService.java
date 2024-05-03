package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.Order;

import java.util.List;

public interface iOrderService {
    List<Order> getOrder();
    String deleteOrder(Long id);
    String postOrder(Order order);
    String putOrder(Order order, Long id);
}
