package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
@Autowired
private IPurchaseOrderDao dao;
	@Override
	@Transactional
	public int savePurchaseOrder(PurchaseOrder prchsOrd) {
		// TODO Auto-generated method stub
		return dao.savePurchaseOrder(prchsOrd);
	}

	@Override
	@Transactional
	public void updatePurchaseOrder(PurchaseOrder prchsOrd) {
		// TODO Auto-generated method stub
        dao.updatePurchaseOrder(prchsOrd);
	}

	@Override
	@Transactional
	public void deletePurchaseOrder(int prchsId) {
		// TODO Auto-generated method stub
             dao.deletePurchaseOrder(prchsId);
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrder(int prchsId) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrder(prchsId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseOrders();
	}

}
