package co.unicauca.microservice.apirest.model.service.implementation;

import co.unicauca.microservice.apirest.model.entity.Order;
import co.unicauca.microservice.apirest.model.service.iOrderService;
import co.unicauca.microservice.apirest.repository.iOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService implements iOrderService {
    @Autowired
    private iOrderRepository orderRepository;
    @Override
    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    @Override
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Product was deleted successfull";
    }

    @Override
    public String postOrder(Order order) {
        orderRepository.save(order);
        return "Product was created successfull";
    }

    @Override
    public String putOrder(Order order, Long id) {
        Order o = orderRepository.findById(id).get();

        if (o == null)
        {
            return "Product was not updated, an error has occurred";
        }
        order.setOrderId(o.getOrderId());
        orderRepository.save(order);
        return "Product was updated successfull";
    }
}
