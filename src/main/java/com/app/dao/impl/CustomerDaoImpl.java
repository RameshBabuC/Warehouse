package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
@Autowired
private HibernateTemplate ht;

@Override
public Integer saveCustomer(Customer cust) {
	// TODO Auto-generated method stub
	return (Integer)ht.save(cust);
}

@Override
public void updateCustomer(Customer cust) {
	// TODO Auto-generated method stub
	  ht.update(cust);
}

@Override
public void deleteCustomer(int custId) {
	// TODO Auto-generated method stub
	Customer cust=new Customer();
	cust.setCustId(custId);
	ht.delete(cust);
}

@Override
public Customer getOneCustomer(int custId) {
	// TODO Auto-generated method stub
	return ht.get(Customer.class, custId);
}

@Override
public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return ht.loadAll(Customer.class);
}

}
