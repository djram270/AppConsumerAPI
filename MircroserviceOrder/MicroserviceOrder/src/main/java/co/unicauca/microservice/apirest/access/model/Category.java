package co.unicauca.microservice.apirest.access.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Category {
    private Long categoryId;
    private String name;
}