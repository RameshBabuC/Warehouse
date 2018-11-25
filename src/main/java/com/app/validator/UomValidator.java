package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
@Component
public class UomValidator implements Validator {
	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {

		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom uom=(Uom)target;
		if("".equals(uom.getUmType())||uom.getUmType()==null) {
			errors.rejectValue("umType", null, "Please enter Atleast One Type");
		}
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getUmModel()).matches()){
			errors.rejectValue("umModel", null, "Please enter Valid Model(4 to 10 Uppercase Only)");
		}else {
			if(service.isUomAlreadyExist(uom.getUmModel())) {
			errors.rejectValue("umModel", null, "Uom already exist,Please choose Other");
		}
		}
		if(!Pattern.compile("[A-Za-z0-9\\-\\s]{10,200}").matcher(uom.getUmDsc()).matches()) {
			errors.rejectValue("umDsc", null, "Please enter Description");
		}

	}
}
