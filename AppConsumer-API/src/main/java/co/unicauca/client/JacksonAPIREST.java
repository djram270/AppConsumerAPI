/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.client;

import co.unicauca.client.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
/**
 *
 * @author dizu8
 */
public class JacksonAPIREST {
    private final String urlBase; 
    private final HttpClient client;
    private final ObjectMapper mapper;
    
    public JacksonAPIREST ()
    {
        urlBase = "http://localhost:8080/Products";
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        mapper = new ObjectMapper();
    }
    
    public List<Product> getProducts ()
    {
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(urlBase + "/get")).build();
        List<Product> products = null;
        try 
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            products = getData(response.body(), new TypeReference<List<Product>>() {});
            //System.out.println(products.toString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
        }
        return products;
    }
    
    
    public String postProduct (Product p)
    {
        try {
            String jsonProduct = mapper.writeValueAsString(p.hashMap());
            HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(jsonProduct))
                .uri(URI.create(urlBase + "/post"))
                .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.toString());
            return e.toString();
        }
    }
    
    public String deleteProduct (String strId)
    {
        try
        {
            HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(urlBase + "/delete/" + strId)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }
    
    public String putProduct (Product p, String strId)
    {
        try
        {
            String jsonProduct = mapper.writeValueAsString(p);
            System.out.println(jsonProduct);
            HttpRequest request = HttpRequest.newBuilder()
                .PUT(HttpRequest.BodyPublishers.ofString(jsonProduct))
                .uri(URI.create(urlBase + "/put/" + strId))
                .header("Content-Type", "application/json")  // Especifica el tipo de contenido como JSON
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e)
        {
            return e.toString();
        }
    }
    
    private <T> T getData (String json, TypeReference<T> reference)
    {
        try
        {
            return mapper.readValue(json, reference);
        }catch (JsonProcessingException e)
        {
            System.out.println(e.toString());
        }
        return null;
    }
}
