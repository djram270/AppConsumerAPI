package co.unicauca.microservice.apirest.model.entity.states;

import co.unicauca.microservice.apirest.model.entity.Order;

public class OnHold implements iStateOrder{

    @Override
    public void CancelOrder(Order order) {
        System.out.println("This transition does not exist");
    }

    @Override
    public void SendOrder(Order order) {
        System.out.println("The product was send");
        order.setState(new Send());
    }

    @Override
    public void NotSendOrder(Order order) {
        order.setState(new NotSend());
    }

    @Override
    public void OnHoldOrder(Order order) {
        System.out.println("This transition does not exist");
    }
}
