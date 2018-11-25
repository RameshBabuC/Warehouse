package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {
@Autowired
private HibernateTemplate ht;

@Override
public Integer saveVendor(Vendor ven) {
	// TODO Auto-generated method stub
	return (Integer)ht.save(ven);
}

@Override
public void updateVendor(Vendor ven) {
	// TODO Auto-generated method stub
	     ht.update(ven);
}

@Override
public void deleteVendor(int venId) {
	// TODO Auto-generated method stub
	Vendor ven=new Vendor();
	ven.setVenId(venId);
	   ht.delete(ven);
}

@Override
public Vendor getOneVendor(int venId) {
	// TODO Auto-generated method stub
	return ht.get(Vendor.class, venId);
}

@Override
public List<Vendor> getAllVendors() {
	// TODO Auto-generated method stub
	return ht.loadAll(Vendor.class);
}


	
}
