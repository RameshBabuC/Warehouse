package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;


@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
@Autowired
private HibernateTemplate ht;

@Override
public Integer saveShipmentType(ShipmentType shipTyp) {
	// TODO Auto-generated method stub
	return (Integer)ht.save(shipTyp);
}

@Override
public void updateShipmentType(ShipmentType shipTyp) {
	// TODO Auto-generated method stub
	            ht.update(shipTyp);
	            
}

@Override
public void deleteShipmentType(int shipTypId) {
	// TODO Auto-generated method stub
	ShipmentType shipTyp=new ShipmentType();
	shipTyp.setShipTypId(shipTypId);
	ht.delete(shipTyp);
}

@Override
public ShipmentType getOneShipmentType(int shipTypId) {
	// TODO Auto-generated method stub
	return ht.get(ShipmentType.class, shipTypId);
}

@Override
public List<ShipmentType> getAllShipTypes() {
	// TODO Auto-generated method stub
	return ht.loadAll(ShipmentType.class);
}

@Override
public List<ShipmentType> getAllShipmentsByCode(String shipTypEnabled) {
	String hql="from "+ShipmentType.class.getName()+" where shipTypEnabled=?0 ";
	List<ShipmentType> shipmentTypes=(List<ShipmentType>)ht.find(hql, shipTypEnabled);
	return shipmentTypes;
}

	}
