package com.azrakrehic.Web.Servis.api;

import com.azrakrehic.Web.Servis.model.Customer;
import com.azrakrehic.Web.Servis.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;


@RestController
@RequestMapping(value = "/customers", produces = {"application/json", "application/xml"})
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer , @RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.addCustomer(customer));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(@RequestHeader HttpHeaders headers) {

        return ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.getCustomerList());
    }

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") int customerId, @RequestHeader HttpHeaders headers) {
        return  ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.getCustomer(customerId));
    }

    @PutMapping(value = "{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer, @RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.updateCustomer(customerId, customer));
    }

    @DeleteMapping(value = "{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int customerId, @RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.deleteCustomer(customerId));
    }
    @GetMapping("/specific")
    public ResponseEntity<Customer>  getCustomerQueryParam(@RequestParam(name = "customerId") int customerId, @RequestHeader HttpHeaders headers) {
        return ResponseEntity.ok().contentType(headers.getContentType()).body(customerService.getCustomer(customerId));
}
}
