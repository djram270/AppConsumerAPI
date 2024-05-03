package co.unicauca.microservice.apirest.model.entity.states;

import co.unicauca.microservice.apirest.model.entity.Order;

public class NotSend implements iStateOrder{
    @Override
    public void CancellOrder(Order order) {
        order.setState(new Cancel());
    }

    @Override
    public void SendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    @Override
    public void NotSendOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    @Override
    public void OnHoldOrder(Order order) {
        order.setState(new OnHold());
    }
}
