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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/user")
public class WhUserTypeRestController {
	@Autowired
	private IWhUserTypeService service;
	//1. Get Records From DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<WhUserType> userTypes=	service.getAllWhUserTypes();
		if(userTypes==null||userTypes.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<WhUserType>>(userTypes,HttpStatus.OK);
		}
		return message;
	}
	//2.Get One Object by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		WhUserType userType=service.getOneWhUserType(id);
		if(userType==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<WhUserType>(userType,HttpStatus.OK);
		}
		return message;
	}
	//3.delete Object by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
	ResponseEntity<String>	message=null;
	try {
	service.deleteWhUserType(id);
	message=new ResponseEntity<String>("WhUserType deleted successfully",HttpStatus.OK);
	}catch(Exception e) {
		message=new ResponseEntity<String>("WhUserType id not found",HttpStatus.BAD_REQUEST);
	}
		return message;
	}
	//4.save Object by id
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody WhUserType whUserType ){
		ResponseEntity<String> message=null;
		try {
		Integer id=service.saveWhUserType(whUserType);
		message=new ResponseEntity<String>("WhUsrType saved with id:"+id,HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	//6.update data by id
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody WhUserType whUserType){
		ResponseEntity<String> message =null;
		try {
			service.updateWhUserType(whUserType);
			message=new ResponseEntity<String>("WhUserType updated",HttpStatus.OK);
			}catch(Exception e) {
				message=new ResponseEntity<String>("WhUserType id '"+whUserType.getWhUsrTypId()+"' not found",HttpStatus.BAD_REQUEST);
			}
		return message;
	}
}
