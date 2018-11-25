package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;
import com.app.view.CustomerExcelView;
import com.app.view.CustomerPdfView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
@Autowired
private ICustomerService service;
@Autowired
private CustomerValidator validator;
    //1. to display Register Page
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	// create model attribute object
	map.addAttribute("customer", new Customer());
	return "CustomerRegister";	
}
//2.on click submit button
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String saveData(@ModelAttribute Customer customer,Errors errors,ModelMap map) {
	validator.validate(customer, errors);
	if(!errors.hasErrors()) {
	Integer custId=service.saveCustomer(customer);
	String msg="Customer'"+custId+"' saved";
	map.addAttribute("message",msg);
	//clear the form data
	map.addAttribute("customer", new Customer());
	}
	return "CustomerRegister";
}
//3. get data from DB to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<Customer> customers=service.getAllCustomers();
	map.addAttribute("list",customers);
	return "CustomerData";
}
//4.delete customer by id
@RequestMapping("/delete")
public String deleteCustomer(@RequestParam("id") Integer custId,ModelMap map) {
	//call service layer delete
	service.deleteCustomer(custId);
	// construct final message
	String msg="Customer '"+custId+"' Deleted";
	// get new data from DB
	List<Customer> customers=service.getAllCustomers();
	//send to UI
	map.addAttribute("message", msg);
	map.addAttribute("list", customers);
	return "CustomerData";
}
//5.show edit page
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer custId,ModelMap map) {
	Customer customer=service.getOneCustomer(custId);
	map.addAttribute("customer", customer);
			return "CustomerEdit";	
}
//6.do update operation
@RequestMapping(value="/update",method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute Customer customer,ModelMap map) {
	service.updateCustomer(customer);
	String msg="Customer '"+customer.getCustId()+"' updated" ;
	List<Customer> customers=service.getAllCustomers();
	map.addAttribute("message",msg);
	map.addAttribute("list", customers);
	return "CustomerData";
}
//7.Export data to Excel File
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<Customer> customers=service.getAllCustomers();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new CustomerExcelView());
//model details
	m.addObject("customers", customers);
	return m;
}
//8.Export data to PDF file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	//fetch data from DB
	List<Customer> customers=service.getAllCustomers();
	//create model and view
	ModelAndView m=new ModelAndView();
	//provide view class name
	m.setView(new CustomerPdfView());
	//provide data to it
	m.addObject("customers",customers);
	return m;
}

}

