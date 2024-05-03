package co.unicauca.microservice.apirest;

import co.unicauca.microservice.apirest.access.microservice.implementation.MicroserviceProduct;
import co.unicauca.microservice.apirest.access.microservice.implementation.iMicroserviceProduct;
import co.unicauca.microservice.apirest.access.microservice.model.Product;
import co.unicauca.microservice.apirest.model.entity.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProductsApplication.class, args);
		Order order = new Order();

		order.onHold();
		order.notSendOrder();
		order.cancelOrder();

//		iMicroserviceProduct jackson = new MicroserviceProduct();
//
//
//
////        p = new Product(0L, "nombre1", 10.0);
////        jackson.postProduct(p);
////        p = new Product(0L, "nombre2", 20.0);
////        jackson.postProduct(p);
////        p = new Product(0L, "nombre4", 40.0);
////        jackson.postProduct(p);
//
//		//jackson.putProduct(p, "2");
//
//		List<Product> products = jackson.getProducts();
//		Product p = jackson.getProduct("2");
//
//		System.out.println(products.toString());
//		System.out.println(p.toString());

//		Order pedido = new Order();
//
//		// Prueba del flujo del pedido
//		//pedido.recibirPedido();  // Se recibe el pedido
//		//pedido.procesarPedido(); // No se puede procesar porque no ha sido enviado aún
//		pedido.OnHoldOrder(); // Se procesa el pedido
//		pedido.sentOrder();   // Se envía el pedido
//		pedido.cancelledOrder();  // Se recibe el pedido

	}

}
