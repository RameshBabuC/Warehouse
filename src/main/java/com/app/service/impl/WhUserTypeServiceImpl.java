package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
@Autowired
private IWhUserTypeDao dao;

@Override
@Transactional
public Integer saveWhUserType(WhUserType whUsrTyp) {
	// TODO Auto-generated method stub
	return dao.saveWhUserType(whUsrTyp);
}

@Override
@Transactional
public void updateWhUserType(WhUserType whUsrTyp) {
	// TODO Auto-generated method stub
	dao.updateWhUserType(whUsrTyp);
}

@Override
@Transactional
public void deleteWhUserType(int whUsrTypId) {
	// TODO Auto-generated method stub
	dao.deleteWhUserType(whUsrTypId);
}

@Override
@Transactional(readOnly=true)
public WhUserType getOneWhUserType(int whUsrTypId) {
	// TODO Auto-generated method stub
	return dao.getOneWhUserType(whUsrTypId);
}

@Override
@Transactional(readOnly=true)
public List<WhUserType> getAllWhUserTypes() {
	// TODO Auto-generated method stub
	return dao.getAllWhUserTypes();
}

@Override
@Transactional(readOnly=true)
  public List<WhUserType> getWhUserTypeByType(String whUsrTypType) {     
	return dao.getWhUserTypeByType(whUsrTypType);
}

@Override
@Transactional(readOnly=true)
public boolean isWhUserTypeAlreadyExist(String whUsrTypCode) {
	// TODO Auto-generated method stub
	return dao.isWhUserTypeAlreadyExist(whUsrTypCode);
}
	}
