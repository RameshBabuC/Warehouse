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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
@Autowired
private IWhUserTypeService service;
@Autowired
private WhUserTypeValidator validator;
    //1. to display Register Page
@RequestMapping("/register")
public String showRegPage(ModelMap map) {
	// create model attribute object
	map.addAttribute("whUserType", new WhUserType());
	return "WhUserTypeRegister";	
}
//2.on click submit button
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String saveData(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
	validator.validate(whUserType, errors);
	if(!errors.hasErrors()) {
	Integer whUsrTypId=service.saveWhUserType(whUserType);
	String msg="WhUserType'"+whUsrTypId+"' saved";
	map.addAttribute("message",msg);
	//clear the form data
	map.addAttribute("whUserType", new WhUserType());
	}
	return "WhUserTypeRegister";
}
//3. get data from DB to UI
@RequestMapping("/all")
public String showData(ModelMap map) {
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	map.addAttribute("list",whUserTypes);
	return "WhUserTypeData";
}
//4.delete whUserType by id
@RequestMapping("/delete")
public String deleteUser(@RequestParam("id")Integer whUsrTypId,ModelMap map) {
	//call service layer delete
	service.deleteWhUserType(whUsrTypId);;
	// construct final message
	String msg="WhUserType '"+whUsrTypId+"' Deleted";
	// get new data from DB
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	//send to UI
	map.addAttribute("message", msg);
	map.addAttribute("list", whUserTypes);
	return "WhUserTypeData";
}
//5.show edit page
@RequestMapping("/edit")
public String showEdit(@RequestParam("id")Integer whUsrTypId,ModelMap map) {
	WhUserType whUserType=service.getOneWhUserType(whUsrTypId);
	map.addAttribute("whUserType", whUserType);
			return "WhUserTypeEdit";	
}
//6.do update operation
@RequestMapping(value="/update",method=RequestMethod.POST)
public String doUpdateData(@ModelAttribute WhUserType whUserType,ModelMap map) {
	service.updateWhUserType(whUserType);
	String msg="WhUserType '"+whUserType.getWhUsrTypId()+"' updated" ;
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	map.addAttribute("message",msg);
	map.addAttribute("list", whUserTypes);
	return "WhUserTypeData";
}
//7.Export data to Excel File
@RequestMapping("/excel")
public ModelAndView showExcel() {
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	ModelAndView m=new ModelAndView();
	//view details
	m.setView(new WhUserTypeExcelView());
//model details
	m.addObject("whUserTypes", whUserTypes);
	return m;
}
//8.Export data to PDF file
@RequestMapping("/pdf")
public ModelAndView showPdf() {
	//fetch data from DB
	List<WhUserType> whUserTypes=service.getAllWhUserTypes();
	//create model and view
	ModelAndView m=new ModelAndView();
	//provide view class name
	m.setView(new WhUserTypePdfView());
	//provide data to it
	m.addObject("whUserTypes", whUserTypes);
	return m;
}


}

