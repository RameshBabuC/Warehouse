package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	public int saveItem(Item itm);
    public void updateItem(Item itm);
    public  void deleteItem(int itmId);
    public Item getOneItem(int itmId);
    public List<Item> getAllItems();

	}
