package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item=(Item)target;	
		if(!Pattern.compile("[A-Za-z]{3,7}").matcher(item.getItmCode()).matches()) {
			errors.rejectValue("itmCode", null, "Please enter code(3 to 7 characters only)");
		}
		if(item.getItmWidth()<=0.0||item.getItmLength()<=0.0||item.getItmHeight()<=0.0) {
			errors.rejectValue("itmLength",null,"Please enter Valid Dimensions");
		}
		if(item.getItmCost()<=0.0){
			errors.rejectValue("itmCost",null,"Please enter Valid Cost");

		}
		if("".equals(item.getItmCurrency())||item.getItmCurrency()==null) {
			errors.rejectValue("itmCurrency", null,"Please choose one Base Currency");
		}
		if(item.getUom()==null||item.getUom().getUmId()==null) {
			errors.rejectValue("uom", null, "Please choose one Uom" ); 
		}
		if(item.getOmSale()==null||item.getOmSale().getOrdMethId()==null) {
			errors.rejectValue("omSale", null, "Please choose one Sale Type" );
		}
		if(item.getOmPurchase()==null||item.getOmPurchase().getOrdMethId()==null){
			errors.rejectValue("omPurchase", null, "Please choose one Purchase Type" );
		}
		if(item.getVenUsers()==null||item.getVenUsers().isEmpty()) {
			errors.rejectValue("venUsers", null, "Please choose atleast one Vendor" );
		}
		if(item.getCustUsers()==null||item.getCustUsers().isEmpty()) {
			errors.rejectValue("custUsers", null, "Please choose atleast one Customer" );
		}
	}
}
