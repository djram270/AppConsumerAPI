package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.model.entity.Order;
import co.unicauca.microservice.apirest.model.service.iOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private iOrderService orderService;

    @PostMapping("/post")
    public ResponseEntity<String> posOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.postOrder(order));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
    @GetMapping("/get/id/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.getOrder(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<String> putOrder(@RequestBody Order order, @PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.putOrder(order, id));
    }
    @GetMapping("/execute/NotSend/{id}")
    public ResponseEntity<String> executeNotSendInOrder(@PathVariable Long id)
    {
        if (!orderService.executeNotSendInOrder(id))
        {
            return ResponseEntity.ok("it was not possible to execute this action in that order");
        }
        return ResponseEntity.ok("it was possible to execute this action in that order");
    }
    @GetMapping("/execute/OnHold/{id}")
    public ResponseEntity<String> executeOnHoldInOrder(@PathVariable Long id)
    {
        if (!orderService.executeOnHoldInOrder(id))
        {
            return ResponseEntity.ok("it was not possible to execute this action in that order");
        }
        return ResponseEntity.ok("it was possible to execute this action in that order");
    }
    @GetMapping("/execute/Send/{id}")
    public ResponseEntity<String> executeSendInOrder(@PathVariable Long id)
    {
        if (!orderService.executeSendInOrder(id))
        {
            return ResponseEntity.ok("it was not possible to execute this action in that order");
        }
        return ResponseEntity.ok("it was possible to execute this action in that order");
    }
    @GetMapping("/execute/Cancel/{id}")
    public ResponseEntity<String> executeCancelInOrder(@PathVariable Long id)
    {
        if (!orderService.executeCancelInOrder(id))
        {
            return ResponseEntity.ok("it was not possible to execute this action in that order");
        }
        return ResponseEntity.ok("it was possible to execute this action in that order");
    }
}
