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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomService service;
	//1. get all records from DB
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<Uom> uoms=service.getAllUoms();
		if(uoms==null||uoms.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
		}
		return message;
	}
	//2. Get one object by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		Uom uom=service.getOneUom(id);
		if(uom==null) {//data not exist
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		}
		return message;
	}
	//3. delete object by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteUom(id);
			message=new ResponseEntity<String>("Uom deleted successfully",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<>("Uom id Not Found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	//4.save uom
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Uom uom){
		ResponseEntity<String> message=null;
		try{
			Integer id=service.saveUom(uom);
			message=new ResponseEntity<String>("saved with id:"+id,HttpStatus.OK);
		}catch(Exception e){
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return message;
	}
	//5.update data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Uom uom){
		ResponseEntity<String> message=null;
		try {
			service.updateUom(uom);
			message=new ResponseEntity<String>("Uom updated",HttpStatus.OK);
		}catch(Exception e) {
		message=new ResponseEntity<String>("Uom '"+uom.getUmId()+"' not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}	
}
