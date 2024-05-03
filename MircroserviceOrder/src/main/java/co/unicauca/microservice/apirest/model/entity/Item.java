package co.unicauca.microservice.apirest.model.entity;

import co.unicauca.microservice.apirest.access.microservice.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
@Data
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private Long productId;
    private int amount;
}
