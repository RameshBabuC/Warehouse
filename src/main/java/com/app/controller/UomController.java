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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private UomValidator validator;
	//1. to display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		// create model attribute object
		map.addAttribute("uom", new Uom());
		return "UomRegister";	
	}
	//2.on click submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		validator.validate(uom, errors);
		if(!errors.hasErrors()) {
			Integer umId=service.saveUom(uom);
			String msg="Uom '"+umId+"' saved";
			map.addAttribute("message",msg);
			//clear the form data
			map.addAttribute("uom", new Uom());
		}
		return "UomRegister";

	}
	//3. get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Uom> uoms=service.getAllUoms();
		map.addAttribute("list",uoms);
		return "UomData";
	}
	//4.delete uom by id
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer umId,ModelMap map) {
		//call service layer delete
		String msg=null;
		try{
			if(service.isUomConnectedWithItem(umId)) {
				msg="Uom can't be deleted";
			}else {
				service.deleteUom(umId);
				// construct final message
				msg="Uom '"+umId+"' Deleted Successfully";
			}
		}catch(HibernateOptimisticLockingFailureException e) {
			msg="Uom '"+umId+"' Not Found";
		}
		// get new data from DB
		List<Uom> uoms=service.getAllUoms();
		//send to UI
		map.addAttribute("message", msg);
		map.addAttribute("list", uoms);
		return "UomData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer umId,ModelMap map) {
		Uom uom=service.getOneUom(umId);
		map.addAttribute("uom", uom);
		return "UomEdit";	
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		validator.validate(uom, errors);
		if(errors.hasErrors()) {
			service.updateUom(uom);
			String msg="Uom '"+uom.getUmId()+"' updated" ;
			List<Uom> uoms=service.getAllUoms();
			map.addAttribute("message",msg);
			map.addAttribute("list", uoms);
			return "UomData";
		}
		return "UomEdit"; 
	}
	//7.Export data to Excel File
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> uoms=service.getAllUoms();
		ModelAndView m=new ModelAndView();
		//view details
		m.setView(new UomExcelView());
		//model details
		m.addObject("uoms", uoms);
		return m;
	}
	//8.Export data to PDF file
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		//fetch data from DB
		List<Uom> uoms=service.getAllUoms();
		//create model and view
		ModelAndView m=new ModelAndView();
		//provide view class name
		m.setView(new UomPdfView());
		//provide data to it
		m.addObject("uoms", uoms);
		return m;
	}

}

