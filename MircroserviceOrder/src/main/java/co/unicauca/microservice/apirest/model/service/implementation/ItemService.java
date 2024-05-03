package co.unicauca.microservice.apirest.model.service.implementation;

import co.unicauca.microservice.apirest.model.entity.Item;
import co.unicauca.microservice.apirest.model.service.iItemService;
import co.unicauca.microservice.apirest.repository.iItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements iItemService {
    @Autowired
    private iItemRepository itemRepository;
    @Override
    public List<Item> getItem() {
        return itemRepository.findAll();
    }

    @Override
    public String deleteItem(Long id) {
        itemRepository.deleteById(id);
        return "Item was deleted successfull";
    }

    @Override
    public String postItem(Item item) {
        itemRepository.save(item);
        return "Item was created successfull";
    }

    @Override
    public String putItem(Item item, Long id) {
        Item i = itemRepository.findById(id).get();

        if (i == null)
        {
            return "Item was not updated, an error has occurred";
        }
        item.setItemId(i.getItemId());
        itemRepository.save(item);
        return "Item was updated successfull";

//        Product p = productRepository.findById(id).orElse(null);
//
//        if (p == null) {
//            return "Product was not updated, an error has occurred";
//        }
//
//        // Recorrer las categorías enviadas con el producto
//        for (Category category : product.getCategories()) {
//            // Verificar si la categoría existe en la base de datos por su nombre
//            Category existingCategory = categoryRepository.findByName(category.getName());
//
//            // Si la categoría existe, asignarla al producto
//            if (existingCategory != null) {
//                p.getCategories().add(existingCategory);
//            } else {
//                // Si la categoría no existe, crearla y asignarla al producto
//                Category newCategory = new Category(category.getName());
//                p.getCategories().add(newCategory);
//            }
//        }
//
//        // Actualizar el producto con las categorías encontradas o creadas
//        productRepository.save(p);
//
//        return "Product was updated successfully";
    }
}
