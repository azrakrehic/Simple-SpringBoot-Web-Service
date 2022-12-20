package com.azrakrehic.Web.Servis.service;

import com.azrakrehic.Web.Servis.dao.CustomerDAO;
import com.azrakrehic.Web.Servis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDAO.findAll();
    }

    public Customer getCustomer(Integer customerId) {
        return customerDAO.findById(customerId).get();
    }

    public Customer updateCustomer (Integer customerId, Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public Customer deleteCustomer(Integer customerId) {
        Customer deletedCustomer = customerDAO.findById(customerId).get();
        customerDAO.deleteById(customerId);
        return deletedCustomer;
    }
}
