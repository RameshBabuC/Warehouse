package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
@Autowired
private ICustomerDao dao;

@Override
@Transactional
public Integer saveCustomer(Customer cust) {
	// TODO Auto-generated method stub
	return dao.saveCustomer(cust);
}

@Override
@Transactional
public void updateCustomer(Customer cust) {
	// TODO Auto-generated method stub
	dao.updateCustomer(cust);
}

@Override
@Transactional
public void deleteCustomer(int custId) {
	// TODO Auto-generated method stub
	dao.deleteCustomer(custId);
}

@Override
@Transactional(readOnly=true)
public Customer getOneCustomer(int custId) {
	// TODO Auto-generated method stub
	return dao.getOneCustomer(custId);
}

@Override
@Transactional(readOnly=true)
public List<Customer> getAllCustomers() {
	// TODO Auto-generated method stub
	return dao.getAllCustomers();
}
	
}
