package co.unicauca.microservice.apirest.model.entity.states;

import co.unicauca.microservice.apirest.model.entity.Order;

public interface iStateOrder {
    void CancellOrder(Order order);
    void SendOrder(Order order);
    void NotSendOrder(Order order);
    void OnHoldOrder(Order order);
}
