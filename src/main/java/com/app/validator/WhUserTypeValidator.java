package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}
	@Autowired
    private IWhUserTypeService service;
	@Override
	public void validate(Object target, Errors errors) {
        WhUserType ut=(WhUserType)target;
        if("".equals(ut.getWhUsrTypType())||ut.getWhUsrTypType()==null) {
        	errors.rejectValue("whUsrTypType", null, "Please choose atleast one Type");
        }
        if(!Pattern.compile("[A-Z\\-]{4,10}").matcher(ut.getWhUsrTypCode()).matches()) {
        	errors.rejectValue("whUsrTypCode", null, "Please enter Code(4 to 10 Uppercase Only)");
        }else if(service.isWhUserTypeAlreadyExist(ut.getWhUsrTypCode())) {
        	errors.rejectValue("whUsrTypCode", null, "WhUserType Code Already Exist, Please choose Another" );
        }
        if("".equals(ut.getWhUrsTypForType())||ut.getWhUrsTypForType()==null) {
        	errors.rejectValue("whUrsTypForType", null, "Please choose one For Type");
        }
        if(!Pattern.compile("[\\w]+\\@[a-z]+\\.[a-z]+").matcher(ut.getWhUsrTypEmail()).matches()) {
        	errors.rejectValue("whUsrTypEmail", null, "Please enter valid Email");
        }
        if(!Pattern.compile("[0-9]{10}").matcher(ut.getWhUsrTypContact()).matches()) {
        	errors.rejectValue("whUsrTypContact", null, "Please enter Contact(10 digits only)");
        }
        if("".equals(ut.getWhUsrTypIdType())) {
        	errors.rejectValue("whUsrTypIdType", null, "Please choose one IdType");
        }
        if(!Pattern.compile("[A-Za-z0-9\\_]{8,12}").matcher(ut.getWhUsrTypIdNum()).matches()) {
        	errors.rejectValue("whUsrTypIdNum", null, "Please enter valid Id Number");
        }
	}

}
