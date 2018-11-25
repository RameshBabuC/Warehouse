package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipmentType(ShipmentType shipTyp);
    public void updateShipmentType(ShipmentType shipTyp);
    public void deleteShipmentType(int shipTypId);
    public ShipmentType getOneShipmentType(int shipTypId);
    public List<ShipmentType> getAllShipTypes();	
    public List<ShipmentType> getAllShipmentsByCode(String shipTypEnabled);

}