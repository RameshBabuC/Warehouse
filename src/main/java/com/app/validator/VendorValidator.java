package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Vendor;
@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Vendor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
    		Vendor ven=(Vendor)target;
		if("".equals(ven.getVenName())) {
			errors.rejectValue("venName", null, "Please enter Name");
		}
		if("".equals(ven.getVenCode())) {
			errors.rejectValue("venCode", null, "Please enter Code");
		}
		if("".equals(ven.getVenDesg())||ven.getVenDesg()==null) {
			errors.rejectValue("venDesg", null, "Please enter Designation");
		}
		
		
	}

}
