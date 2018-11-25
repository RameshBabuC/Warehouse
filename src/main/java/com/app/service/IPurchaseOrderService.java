package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderService {
	public int savePurchaseOrder(PurchaseOrder prchsOrd );
	public void updatePurchaseOrder(PurchaseOrder prchsOrd);
	public void deletePurchaseOrder(int prchsId);
	public PurchaseOrder getOnePurchaseOrder(int prchsId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
