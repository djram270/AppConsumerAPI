package co.unicauca.microservice.apirest.model.service;

import co.unicauca.microservice.apirest.model.entity.Category;
import co.unicauca.microservice.apirest.model.entity.Product;

import java.util.List;

public interface iCategoryService {
    List<Category> getCategories();
    Category getCategory(Long id);
    Category getCategoryByName(String name);
    String deleteCategory(Long id);
    String postCategory(Category category);
    String putCategory(Category category, Long id);
    List<Category> categoriesExisting (List<Category> categories);
}
