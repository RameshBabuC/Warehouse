package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;


@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
@Autowired
private IShipmentTypeService service;
    //1. to display Register Page
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	// create model attribute object
	map.addAttribute("shipmentType", new ShipmentType());
	return "ShipmentTypeRegister";	
}
//2.on click submit button
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String saveData(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
	Integer shipTypId=service.saveShipmentType(shipmentType);
	String msg="ShipmentType'"+shipTypId+"' saved";
	map.addAttribute("message",msg);
	//clear the form data
	map.addAttribute("shipmentType", new ShipmentType());
	return "ShipmentTypeRegister";
}
//3. get data from DB to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<ShipmentType> shipmentTypes=service.getAllShipTypes();
	map.addAttribute("list",shipmentTypes);
	return "ShipmentTypeData";
}
//4.delete shipmentType by id
@RequestMapping("/delete")
public String deleteShipmentType(@RequestParam("id") Integer shipTypId,ModelMap map) {
	//call service layer delete
	service.deleteShipmentType(shipTypId);
	// construct final message
	String msg="shipmentType '"+shipTypId+"' Deleted";
	// get new data from DB
	List<ShipmentType> shipmentTypes=service.getAllShipTypes();
	//send to UI
	map.addAttribute("message", msg);
	map.addAttribute("list", shipmentTypes);
	return "ShipmentTypeData";
}
//5.show edit page
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer shipTypId,ModelMap map) {
	ShipmentType shipmentType=service.getOneShipmentType(shipTypId);
	map.addAttribute("shipmentType", shipmentType);
			return "ShipmentTypeEdit";	
}
//6.do update operation
@RequestMapping(value="/update",method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
	service.updateShipmentType(shipmentType);
	String msg="ShipmentType '"+shipmentType.getShipTypId()+"' updated" ;
	List<ShipmentType> shipmentTypes=service.getAllShipTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list", shipmentTypes);
	return "ShipmentTypeData";
}
//7.Export data to Excel File
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<ShipmentType> shipmentTypes=service.getAllShipTypes();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new ShipmentTypeExcelView());
//model details
	m.addObject("shipmentTypes", shipmentTypes);
	return m;
}
//8.Export data to PDF file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	//fetch data from DB
	List<ShipmentType> shipmentTypes=service.getAllShipTypes();
	//create model and view
	ModelAndView m=new ModelAndView();
	//provide view class name
	m.setView(new ShipmentTypePdfView());
	//provide data to it
	m.addObject("shipmentTypes", shipmentTypes);
	return m;
}



}

