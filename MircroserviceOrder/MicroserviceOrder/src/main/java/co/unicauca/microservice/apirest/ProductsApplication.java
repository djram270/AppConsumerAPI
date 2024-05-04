package co.unicauca.microservice.apirest;

import co.unicauca.microservice.apirest.access.microservice.iMicroserviceProduct;
import co.unicauca.microservice.apirest.model.entity.Order;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProductsApplication.class, args);
		Order order = new Order();

		order.onHold();
		order.notSendOrder();
		order.cancelOrder();

	}

}
