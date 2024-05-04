package co.unicauca.hyunseda.client.access.microservice;

/**
 *
 * @author dizu8
 */

import co.unicauca.hyunseda.client.access.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface iMicroserviceProduct {
    List<Product> getProducts ();
    Product getProduct (String strId);
    Product getProductName (String strId);
    Product getProductCategory (String strId);
    String postProduct (Product p);
    String deleteProduct (String strId);
    String putProduct (Product p, String strId);
    <T> T getData (String json, TypeReference<T> reference);
}

