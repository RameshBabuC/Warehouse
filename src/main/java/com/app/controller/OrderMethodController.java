package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
@Autowired
private IOrderMethodService service;
@Autowired
private OrderMethodValidator validator;
    //1. to display Register Page
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	// create model attribute object
	map.addAttribute("orderMethod", new OrderMethod());
	return "OrderMethodRegister";	
}
//2.on click submit button
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String saveData(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
	validator.validate(orderMethod, errors);
	if(!errors.hasErrors()) {
	Integer ordMethId=service.saveOrderMethod(orderMethod);
	String msg="OrderMethod'"+ordMethId+"' saved";
	map.addAttribute("message",msg);
	//clear the form data
	map.addAttribute("orderMethod", new OrderMethod());
	}
	return "OrderMethodRegister";
}
//3. get data from DB to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<OrderMethod> ordMeths=service.getAllOrdMeths();
	map.addAttribute("list",ordMeths);
	return "OrderMethodData";
}
//4.delete orderMethod by id
@RequestMapping("/delete")
public String deleteOrderMethod(@RequestParam("id") Integer ordMethId,ModelMap map) {
	String msg=null;
	try {
		if(service.isOrderMethodconnectedWithItem(ordMethId)) {
			msg="OrderMethod can't be deleted";
		}else {
			//call service layer delete
			service.deleteOrderMethod(ordMethId);
			// construct final message
			 msg="OrderMethod '"+ordMethId+"' Deleted Successfully";
		}
	}catch(HibernateOptimisticLockingFailureException e) {
		msg="OrderMethod '"+ordMethId+"' Not Found";
	}
	
	// get new data from DB
	List<OrderMethod> ordMeths=service.getAllOrdMeths();
	//send to UI
	map.addAttribute("message", msg);
	map.addAttribute("list", ordMeths);
	return "OrderMethodData";
}
//5.show edit page
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer ordMethId,ModelMap map) {
	OrderMethod orderMethod=service.getOneOrderMethod(ordMethId);
	map.addAttribute("orderMethod", orderMethod);
			return "OrderMethodEdit";	
}
//6.do update operation
@RequestMapping(value="/update",method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute OrderMethod orderMethod,ModelMap map) {
	service.updateOrderMethod(orderMethod);
	String msg="OrderMethod '"+orderMethod.getOrdMethId()+"' updated" ;
	List<OrderMethod> ordMeths=service.getAllOrdMeths();
			
	map.addAttribute("message",msg);
	map.addAttribute("list", ordMeths);
	return "OrderMethodData";
}
//7.Export data to Excel File
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<OrderMethod> orderMethods=service.getAllOrdMeths();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new OrderMethodExcelView());
//model details
	m.addObject("orderMethods", orderMethods);
	return m;
}
//8.Export data to PDF file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	//fetch data from DB
	List<OrderMethod> orderMethods=service.getAllOrdMeths();
	//create model and view
	ModelAndView m=new ModelAndView();
	//provide view class name
	m.setView(new OrderMethodPdfView());
	//provide data to it
	m.addObject("orderMethods", orderMethods);
	return m;
}



}

