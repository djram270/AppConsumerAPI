package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.Item;

import java.util.List;

public interface iItemService {
    List<Item> getItem();
    String deleteItem(Long id);
    String postItem(Item item);
    String putItem(Item item, Long id);
}
