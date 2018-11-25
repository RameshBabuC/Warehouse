package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.Item;
import com.app.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveOrderMethod(OrderMethod ordMeth) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(ordMeth);
	}

	@Override
	public void updateOrderMethod(OrderMethod ordMeth) {
		// TODO Auto-generated method stub
       ht.update(ordMeth);
	}

	@Override
	public void deleteOrderMethod(int ordMethId) {
		// TODO Auto-generated method stub
           OrderMethod ordMeth=new  OrderMethod();
           ordMeth.setOrdMethId(ordMethId);
           ht.delete(ordMeth);
	}

	@Override
	public OrderMethod getOneOrderMethod(int ordMethId) {
		// TODO Auto-generated method stub
		return ht.get(OrderMethod.class, ordMethId);
	}

	@Override
	public List<OrderMethod> getAllOrdMeths() {
		// TODO Auto-generated method stub
		return ht.loadAll(OrderMethod.class);
	}

	@Override
	public List<OrderMethod> getOrderMethodByMode(String ordMethMode) {
       String hql= " from "+OrderMethod.class.getName()+" where ordMethMode=?";
       List<OrderMethod> oms=(List<OrderMethod>)ht.find(hql, ordMethMode);
		return oms;
	}

	@Override
	public boolean isOrdMethCodeExist(String ordMethCode) {
		@SuppressWarnings("unchecked")
		List<Long> rowsCount=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("ordMethCode", ordMethCode)));
		return rowsCount.get(0)!=0?true:false;
	}

	@Override
	public boolean isOrderMethodconnectedWithItem(Integer ordMethId) {
		@SuppressWarnings("unchecked")
		List<Long> rowsCount=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.or(Restrictions.eq("omSale.ordMethId",ordMethId),
						             Restrictions.eq("omPurchase.ordMethId", ordMethId))));
		return rowsCount.get(0)!=0?true:false;
	}

	
}
