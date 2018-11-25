package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Component
public class OrderMethodValidator implements Validator {
	@Autowired
    private IOrderMethodService  service;
	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
       OrderMethod om=(OrderMethod)target;	
       if("".equals(om.getOrdMethMode())||om.getOrdMethMode()==null) {
    	   errors.rejectValue("ordMethMode", null, "Please choose one Mode");
       }
       if(!Pattern.compile("[A-Z]{3,7}").matcher(om.getOrdMethCode()).matches()) {
    	   errors.rejectValue("ordMethCode", null, "Please enter Valid Code(3 to 7 Uppercase Only)");
       }else if(service.isOrdMethCodeExist(om.getOrdMethCode())) {
    	   errors.rejectValue("ordMethCode", null, "OrderMethod Code already exist,Please choose other");
       }
       if("".equals(om.getOrdMethMethod())) {
    	   errors.rejectValue("ordMethMethod", null, "Please choose atleast one Method");
       }
       if(om.getOrdMethAccept()==null||om.getOrdMethAccept().isEmpty()) {
    	   errors.rejectValue("ordMethAccept", null, "Please choose atleast one option");
       }
       if(!Pattern.compile("[A-Za-z0-9\\s]{10,200}").matcher(om.getOrdMethDsc()).matches()) {
    	   errors.rejectValue("ordMethDsc", null, "Please enter Description");
       }
         
	}

}
