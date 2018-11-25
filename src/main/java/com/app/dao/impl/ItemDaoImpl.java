package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {
@Autowired
private HibernateTemplate ht;

@Override
public int saveItem(Item itm) {
	// TODO Auto-generated method stub
	return (Integer)ht.save(itm);
}

@Override
public void updateItem(Item itm) {
	// TODO Auto-generated method stub
	     ht.update(itm);
}

@Override
public void deleteItem(int itmId) {
	// TODO Auto-generated method stub
	Item itm=new Item();
	itm.setItmId(itmId);
	ht.delete(itm);
}

@Override
public Item getOneItem(int itmId) {
	// TODO Auto-generated method stub
	return ht.get(Item.class, itmId);
}

@Override
public List<Item> getAllItems() {
	// TODO Auto-generated method stub
	return ht.loadAll(Item.class);
}
	
}
