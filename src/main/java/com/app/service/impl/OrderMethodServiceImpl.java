package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
@Autowired
private IOrderMethodDao dao;
	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod ordMeth) {
		// TODO Auto-generated method stub
		return dao.saveOrderMethod(ordMeth);
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod ordMeth) {
		// TODO Auto-generated method stub
         dao.updateOrderMethod(ordMeth);
         
	}

	@Override
	@Transactional
	public void deleteOrderMethod(int ordMethId) {
		// TODO Auto-generated method stub
      dao.deleteOrderMethod(ordMethId);
      
	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethod(int ordMethId) {
		// TODO Auto-generated method stub
		return dao.getOneOrderMethod(ordMethId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrdMeths() {
		// TODO Auto-generated method stub
		return dao.getAllOrdMeths();
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodByMode(String ordMethMode) {
         return dao.getOrderMethodByMode(ordMethMode);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isOrdMethCodeExist(String ordMethCode) {
		// TODO Auto-generated method stub
		return dao.isOrdMethCodeExist(ordMethCode);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isOrderMethodconnectedWithItem(Integer ordMethId) {
		// TODO Auto-generated method stub
		return dao.isOrderMethodconnectedWithItem(ordMethId);
	}

}
