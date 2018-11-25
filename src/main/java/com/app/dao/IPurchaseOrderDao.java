package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {
	public int savePurchaseOrder(PurchaseOrder prchsOrd );
	public void updatePurchaseOrder(PurchaseOrder prchsOrd);
	public void deletePurchaseOrder(int prchsId);
	public PurchaseOrder getOnePurchaseOrder(int prchsId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
