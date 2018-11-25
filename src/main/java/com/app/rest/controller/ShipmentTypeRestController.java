package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {
	@Autowired
	private IShipmentTypeService service;
	//1. Get Records from DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<ShipmentType> shipmentTypes= service.getAllShipTypes();
		if(shipmentTypes==null||shipmentTypes.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<ShipmentType>>(shipmentTypes,HttpStatus.OK);
		}
		return message;
	}
	//2.Get Object by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		ShipmentType shipmentType=service.getOneShipmentType(id);
		if(shipmentType==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<ShipmentType>(shipmentType,HttpStatus.OK);
		}
		return message;
	}
	//3.delete Object by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteShipmentType(id);
			message=new ResponseEntity<String>("ShipmentType deleted successfully",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("ShipmentType id not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	//4.save ShipmentType
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveShipmentType(shipmentType);
			message=new ResponseEntity<String>("ShipmentType saved with id:"+id,HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	//5.update data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> message=null;
		try {
			service.updateShipmentType(shipmentType);
			message=new ResponseEntity<String>("ShipmentType updated",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("ShipmentType id '"+shipmentType.getShipTypId()+"' not found ",HttpStatus.BAD_REQUEST);	
		}
		return message;
	}
}
