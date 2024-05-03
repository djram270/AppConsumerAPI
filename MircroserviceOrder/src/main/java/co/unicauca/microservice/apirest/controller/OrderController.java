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
    public ResponseEntity<String> posItem(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.postOrder(order));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Order>> getItems() {
        return ResponseEntity.ok(orderService.getOrder());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.deleteOrder(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putItem(@RequestBody Order order, @PathVariable Long id)
    {
        return ResponseEntity.ok(orderService.putOrder(order, id));
    }
}
