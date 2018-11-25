package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodService {
	 public Integer saveOrderMethod(OrderMethod ordMeth);
     public void updateOrderMethod(OrderMethod ordMeth);
     public void deleteOrderMethod(int ordMethId);
     public OrderMethod getOneOrderMethod(int ordMethId);
     public List<OrderMethod> getAllOrdMeths();
     public List<OrderMethod> getOrderMethodByMode(String ordMethMode);
     public boolean isOrdMethCodeExist(String ordMethCode);
     public boolean isOrderMethodconnectedWithItem(Integer ordMethId);


}
