package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService stService;
	@Autowired
	private IWhUserTypeService utService;
	//1.to display Register page
	@RequestMapping("/register")
	public String showRegPage(ModelMap map) {
		//create model attribute object
		//shipmenttype multiplicity
		List<ShipmentType> shipmentEnables=stService.getAllShipmentsByCode("YES");
		map.addAttribute("shipmentEnables", shipmentEnables);
		//whusertype multiplicity
		List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
		map.addAttribute("vendors",vendors);
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		return "PurchaseOrderRegister";
	}
	//2. on click submit button
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map) {
		Integer prchsId=service.savePurchaseOrder(purchaseOrder);
		String msg="PurchaseOrder '"+prchsId+"' saved";
		map.addAttribute("message", msg);
		//shipmenttype multiplicity
		List<ShipmentType> shipmentEnables=stService.getAllShipmentsByCode("YES");
		map.addAttribute("shipmentEnables", shipmentEnables);
		//whusertype multiplicity
		List<WhUserType> vendors=utService.getWhUserTypeByType("Vendor");
		map.addAttribute("vendors",vendors);
		// clear form data
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		return "PurchaseOrderRegister";
	}
	//3.Get data from DB to UI
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<PurchaseOrder> prchsOrders=service.getAllPurchaseOrders();
		map.addAttribute("list",prchsOrders);
		return "PurchaseOrderData";
	}
}
