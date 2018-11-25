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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {
	@Autowired
    private IOrderMethodService service;
	//1. Get all records from DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<OrderMethod> orderMethods=service.getAllOrdMeths();
		if(orderMethods==null||orderMethods.isEmpty()) { //data not exist
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<OrderMethod>>(orderMethods,HttpStatus.OK);
		}
		return message;
	}
	//2.Get one Object by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		OrderMethod orderMethod=service.getOneOrderMethod(id);
		if(orderMethod==null) {
			message=new ResponseEntity<OrderMethod>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<OrderMethod>(orderMethod,HttpStatus.OK);
		}
		return message;
	}
	// delete record by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String> message=null;
	try {
		service.deleteOrderMethod(id);
		message=new ResponseEntity<String>("OrderMethod deleted successfully",HttpStatus.OK);
	}catch(Exception e) {
		message=new ResponseEntity<String>("OrderMethod id Not Found",HttpStatus.BAD_REQUEST);
	}
	return message;
	}
	//4.save data by id
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> message=null;
		try {
		Integer id= service.saveOrderMethod(orderMethod);
		message=new ResponseEntity<String>("OrderMethod saved with id:"+id,HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	//5.update data by id
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> message=null;
		try {
			service.updateOrderMethod(orderMethod);
			message=new ResponseEntity<String>("OrderMethod updated",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("OrderMetod '"+orderMethod.getOrdMethId()+"' not found",HttpStatus.BAD_REQUEST);
			
		}
		return message;
	}
}
