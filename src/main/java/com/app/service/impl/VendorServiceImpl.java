package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;
@Service
public class VendorServiceImpl implements IVendorService {
@Autowired
private IVendorDao dao;

@Override
@Transactional
public Integer saveVendor(Vendor ven) {
	// TODO Auto-generated method stub
	return dao.saveVendor(ven);
}

@Override
@Transactional
public void updateVendor(Vendor ven) {
	// TODO Auto-generated method stub
	   dao.updateVendor(ven);
}

@Override
@Transactional
public void deleteVendor(int venId) {
	// TODO Auto-generated method stub
	  dao.deleteVendor(venId);
}

@Override
@Transactional(readOnly=true)
public Vendor getOneVendor(int venId) {
	// TODO Auto-generated method stub
	return dao.getOneVendor(venId);
}

@Override
@Transactional(readOnly=true)
public List<Vendor> getAllVendors() {
	// TODO Auto-generated method stub
	return dao.getAllVendors();
}
	
}
