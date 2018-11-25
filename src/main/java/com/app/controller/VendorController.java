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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.validator.VendorValidator;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
@Autowired
private IVendorService service;
@Autowired
private VendorValidator  validator;
    //1. to display Register Page
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	// create model attribute object
	map.addAttribute("vendor", new Vendor());
	return "VendorRegister";	
}
//2.on click submit button
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String saveData(@ModelAttribute Vendor vendor,Errors errors,ModelMap map) {
	validator.validate(vendor, errors);
	if(!errors.hasErrors()) {
	Integer venId=service.saveVendor(vendor);
	String msg="Vendor'"+venId+"' saved";
	map.addAttribute("message",msg);
	//clear the form data
	map.addAttribute("vendor", new Vendor());
	}
	return "VendorRegister";
}
//3. get data from DB to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<Vendor> vendors=service.getAllVendors();
	map.addAttribute("list",vendors);
	return "VendorData";
}
//4.delete vendor by id
@RequestMapping("/delete")
public String deleteUom(@RequestParam("id") Integer venId,ModelMap map) {
	//call service layer delete
	service.deleteVendor(venId);;
	// construct final message
	String msg="Vendor '"+venId+"' Deleted";
	// get new data from DB
	List<Vendor> vendors=service.getAllVendors();
	//send to UI
	map.addAttribute("message", msg);
	map.addAttribute("list", vendors);
	return "VendorData";
}
//5.show edit page
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer venId,ModelMap map) {
	Vendor vendor=service.getOneVendor(venId);
	map.addAttribute("vendor", vendor);
			return "VendorEdit";	
}
//6.do update operation
@RequestMapping(value="/update",method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute Vendor vendor,Errors errors,ModelMap map) {
	validator.validate(vendor, errors);
	if(!errors.hasErrors()) {
	service.updateVendor(vendor);
	String msg="Vendor '"+vendor.getVenId()+"' updated" ;
	List<Vendor> vendors=service.getAllVendors();
	map.addAttribute("message",msg);
	map.addAttribute("list", vendors);
	return "VendorData";
	}
	return "VendorEdit";
}
//7.Export data to Excel File
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<Vendor> vendors=service.getAllVendors();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new VendorExcelView());
//model details
	m.addObject("vendor", vendors);
	return m;
}
//8.Export data to PDF file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	//fetch data from DB
	List<Vendor> vendors=service.getAllVendors();
	//create model and view
	ModelAndView m=new ModelAndView();
	//provide view class name
	m.setView(new VendorPdfView());
	//provide data to it
	m.addObject("vendors", vendors);
	return m;
}

}

