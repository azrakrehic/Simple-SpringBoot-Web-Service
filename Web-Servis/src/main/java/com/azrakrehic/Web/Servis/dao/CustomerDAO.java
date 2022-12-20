package com.azrakrehic.Web.Servis.dao;

import com.azrakrehic.Web.Servis.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {

    @Override
    List<Customer> findAll();
}
