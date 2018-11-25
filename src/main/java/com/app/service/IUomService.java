package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {



	public Integer saveUom(Uom um);
	public void updateUom(Uom um);
	public void deleteUom(int umId);
	public Uom getOneUom(int umId);
	public List<Uom> getAllUoms();
	public boolean isUomAlreadyExist(String umModel);
	public boolean isUomConnectedWithItem(Integer umId);


}
