package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {
   @Autowired
   private HibernateTemplate ht;
	@Override
	public int savePurchaseOrder(PurchaseOrder prchsOrd) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(prchsOrd);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder prchsOrd) {
		// TODO Auto-generated method stub
		ht.update(prchsOrd);
	}

	@Override
	public void deletePurchaseOrder(int prchsId) {
		// TODO Auto-generated method stub
		PurchaseOrder prchsOrd=new PurchaseOrder();
		prchsOrd.setPrchsId(prchsId);
		ht.delete(prchsOrd);
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(int prchsId) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class, prchsId);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
