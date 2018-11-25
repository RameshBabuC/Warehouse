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

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService service;
	@Autowired
	private IUomService uomService;
	@Autowired
	private IOrderMethodService omService;
	@Autowired
	private IWhUserTypeService utService;
	@Autowired
	private ItemValidator validator;
	//1. to display Register Page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		// uom multiplicity
		List<Uom> uoms=uomService.getAllUoms();
		map.addAttribute("uoms",uoms);
		//ordermethod multiplicity
		List<OrderMethod> sales=omService.getOrderMethodByMode("Sale");
		map.addAttribute("sales",sales);
		List<OrderMethod> purchases=omService.getOrderMethodByMode("Purchase");
		map.addAttribute("purchases",purchases);
		//whusertype multiplicity
		List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
		map.addAttribute("vendors",vendors);
		List<WhUserType> customers=utService.getWhUserTypeByType("Customer");
		map.addAttribute("customers",customers);
		// create model attribute object
		map.addAttribute("item", new Item());
		return "ItemRegister";	
	}
	//2.on click submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Item item,Errors errors,ModelMap map) {
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			Integer itmId=service.saveItem(item);
			String msg="Item'"+itmId+"' saved";
			map.addAttribute("message",msg);
			map.addAttribute("item", new Item());
		}
			// uom multiplicity
			List<Uom> uoms=uomService.getAllUoms();
			map.addAttribute("uoms",uoms);
			//ordermethod multiplicity
			List<OrderMethod> sales=omService.getOrderMethodByMode("Sale");
			map.addAttribute("sales",sales);
			List<OrderMethod> purchases=omService.getOrderMethodByMode("Purchase");
			map.addAttribute("purchases",purchases);
			//whusertype multiplicity
			List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
			map.addAttribute("vendors",vendors);
			List<WhUserType> customers=utService.getWhUserTypeByType("Customer");
			map.addAttribute("customers",customers);
			//clear the form data
	
		return "ItemRegister";
	}
	//3. get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Item> items=service.getAllItems();
		map.addAttribute("list",items);
		return "ItemData";
	}
	//4.delete item by id
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id") Integer itmId,ModelMap map) {
		//call service layer delete
		service.deleteItem(itmId);
		// construct final message
		String msg="Item '"+itmId+"' Deleted";
		// get new data from DB
		List<Item> items=service.getAllItems();
		//send to UI
		map.addAttribute("message", msg);
		map.addAttribute("list", items);
		return "ItemData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer itmId,ModelMap map) {
		Item item=service.getOneItem(itmId);
		//uom multiplicity
		List<Uom> uoms=uomService.getAllUoms();
		map.addAttribute("uoms",uoms);
		//ordermethod multiplicity
		List<OrderMethod> sales=omService.getOrderMethodByMode("Sale");
		map.addAttribute("sales",sales);
		List<OrderMethod> purchases=omService.getOrderMethodByMode("Purchase");
		map.addAttribute("purchases",purchases);
		//whusertype multiplicity
		List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
		map.addAttribute("vendors",vendors);
		List<WhUserType> customers=utService.getWhUserTypeByType("Customer");
		map.addAttribute("customers",customers);
		//Item item=service.getOneItem(itmId);
		map.addAttribute("item", item);
		return "ItemEdit";
	}
	//6.do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute Item item,Errors errors,ModelMap map) {
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			service.updateItem(item);
			String msg="Item '"+item.getItmId()+"' updated" ;
			List<Item> items=service.getAllItems();
			map.addAttribute("message",msg);
			map.addAttribute("list", items);
			return "ItemData";
		}else {
			List<Uom> uoms=uomService.getAllUoms();
			map.addAttribute("uoms",uoms);
			//ordermethod multiplicity
			List<OrderMethod> sales=omService.getOrderMethodByMode("Sale");
			map.addAttribute("sales",sales);
			List<OrderMethod> purchases=omService.getOrderMethodByMode("Purchase");
			map.addAttribute("purchases",purchases);
			//whusertype multiplicity
			List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
			map.addAttribute("vendors",vendors);
			List<WhUserType> customers=utService.getWhUserTypeByType("Customer");
			map.addAttribute("customers",customers);
			//Item item=service.getOneItem(itmId);
			return "ItemEdit";
		}
	}

}

