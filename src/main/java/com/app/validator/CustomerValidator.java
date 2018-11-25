package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;
@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
    Customer cust=(Customer)target;
   if("".equals(cust.getCustCode())) {
	   errors.rejectValue("custCode", null, "Please enter Code");
   }
   if("".equals(cust.getCustAddr())) {
	   errors.rejectValue("custAddr", null, "Please enter Address");
   }
   if(cust.getCustLocs().isEmpty()) {
	   errors.rejectValue("custLocs",null, "Please choose Locations");
   }
   if("".equals(cust.getCustEnabled())||cust.getCustEnabled()==null) {
	   errors.rejectValue("custEnabled", null, "Please  Enable Customer");
   }
   if("".equals(cust.getCustEmail())) {
	   errors.rejectValue("custEmail", null, "Please enter Email");
   }
   if("".equals(cust.getCustContact())) {
	   errors.rejectValue("custContact", null, "Please enter Contact");
   }
	}

}
