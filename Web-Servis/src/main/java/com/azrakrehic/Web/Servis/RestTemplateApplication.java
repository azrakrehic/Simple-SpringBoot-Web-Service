package com.azrakrehic.Web.Servis;

import com.azrakrehic.Web.Servis.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.*;

@SpringBootApplication

public class RestTemplateApplication {
    static org.springframework.web.client.RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
    static String baseURL = "http://localhost:8080/customers";

    public static void main(String[] args) {
        useExchangeMethodsOfRestTemplate();
    }
    private static void useExchangeMethodsOfRestTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Customer> postRequestEntity = new HttpEntity<>(new Customer("azra", "krehic", "akrehic"),headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(baseURL , HttpMethod.POST, postRequestEntity, String.class);
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        System.out.println("Status code is " + statusCode);
        String customer = responseEntity.getBody();
        System.out.println("Response body " + customer);
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        System.out.println("Response headers" + responseHeaders);
        HttpEntity<Object> getRequestEntity = new HttpEntity<>(headers);
        responseEntity = restTemplate.exchange(baseURL  , HttpMethod.GET, getRequestEntity, String.class);
        statusCode = responseEntity.getStatusCode();
        System.out.println("Status code is " + statusCode);
        customer = responseEntity.getBody();
        System.out.println("Response body " + customer);
        responseHeaders = responseEntity.getHeaders();
        System.out.println("Response headers" + responseHeaders);
    }
}
