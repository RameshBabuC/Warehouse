package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {
@Autowired
private IShipmentTypeDao dao;

@Override
@Transactional
public Integer saveShipmentType(ShipmentType shipTyp) {
	// TODO Auto-generated method stub
	return dao.saveShipmentType(shipTyp);
}

@Override
@Transactional
public void updateShipmentType(ShipmentType shipTyp) {
	// TODO Auto-generated method stub
	     dao.updateShipmentType(shipTyp);
}

@Override
@Transactional
public void deleteShipmentType(int shipTypId) {
	// TODO Auto-generated method stub
	    dao.deleteShipmentType(shipTypId);
}

@Override
@Transactional(readOnly=true)
public ShipmentType getOneShipmentType(int shipTypId) {
	// TODO Auto-generated method stub
	return dao.getOneShipmentType(shipTypId);
}

@Override
public List<ShipmentType> getAllShipTypes() {
	// TODO Auto-generated method stub
	return dao.getAllShipTypes();
}

@Override
@Transactional(readOnly=true)
public List<ShipmentType> getAllShipmentsByCode(String shipTypEnabled) {
	// TODO Auto-generated method stub
	return dao.getAllShipmentsByCode(shipTypEnabled);
}
	}
