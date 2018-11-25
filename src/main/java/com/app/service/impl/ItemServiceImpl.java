package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {
@Autowired
private IItemDao dao;

@Override
@Transactional
public int saveItem(Item itm) {
	// TODO Auto-generated method stub
	return dao.saveItem(itm);
}

@Override
@Transactional
public void updateItem(Item itm) {
	// TODO Auto-generated method stub
	dao.updateItem(itm);
}

@Override
@Transactional
public void deleteItem(int itmId) {
	// TODO Auto-generated method stub
	dao.deleteItem(itmId);
}

@Override
@Transactional(readOnly=true)
public Item getOneItem(int itmId) {
	// TODO Auto-generated method stub
	return dao.getOneItem(itmId);
}

@Override
@Transactional(readOnly=true)
public List<Item> getAllItems() {
	// TODO Auto-generated method stub
	return dao.getAllItems();
}

	
	}