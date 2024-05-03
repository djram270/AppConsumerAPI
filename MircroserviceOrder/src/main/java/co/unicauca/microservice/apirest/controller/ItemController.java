package co.unicauca.microservice.apirest.controller;

import co.unicauca.microservice.apirest.access.microservice.implementation.iMicroserviceProduct;
import co.unicauca.microservice.apirest.model.entity.Item;
import co.unicauca.microservice.apirest.model.service.iItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Items")
@RequiredArgsConstructor
public class ItemController {
    //inyectar un servicio (innecesario, ahora se gestinona con @wired)
    @Autowired
    private iItemService itemService;
    @Autowired
    private iMicroserviceProduct MicroserviceProduct;

    //@POST requiete una dependecia que no se tiene en el proyecto
    @PostMapping("/post")
    public ResponseEntity<String> posItem(@RequestBody Item item) {
//        item.setProduct(MicroserviceProduct.getProduct(String.valueOf(item.getProduct().getProductId())));
        if (MicroserviceProduct.getProduct(String.valueOf(item.getProductId())) == null)
        {
            return ResponseEntity.ok("fallas");
        }
        return ResponseEntity.ok(itemService.postItem(item));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Item>> getItems() {
        return ResponseEntity.ok(itemService.getItem());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> putItem(@RequestBody Item item, @PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.putItem(item, id));
    }
}
