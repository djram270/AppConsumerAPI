/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.unicauca.client;

import co.unicauca.client.gui.GUIClient;
import co.unicauca.client.model.Product;
import java.util.List;

/**
 *
 * @author dizu8
 */


public class AppConsumerAPI {

    public static void main(String[] args) {

        JacksonAPIREST jackson = new JacksonAPIREST();
        
        Product p;
        p = new Product(0L, "nombre1", 10.0);
        //jackson.postProduct(p);
        p = new Product(0L, "nombre2", 20.0);
        //jackson.postProduct(p);
        p = new Product(0L, "nombre3", 30.0);
        //jackson.postProduct(p);
        
        jackson.putProduct(p, "2");
        
        List<Product> products = jackson.getProducts();
        
        System.out.println(products.toString());
        /*
        GUIClient guiClient = new GUIClient(Products);
        
        guiClient.setSize(500, 500);
        guiClient.setVisible(true);*/
    }
}
