package co.unicauca.microservice.apirest.repository;

import co.unicauca.microservice.apirest.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iCategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
