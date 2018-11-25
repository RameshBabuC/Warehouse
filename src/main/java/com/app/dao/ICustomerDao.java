package com.app.dao;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerDao {
          public Integer saveCustomer(Customer cust);
          public void updateCustomer(Customer cust);
          public void deleteCustomer(int custId);
          public Customer getOneCustomer(int custId);
          public List<Customer> getAllCustomers();

}
