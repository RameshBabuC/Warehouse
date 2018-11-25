package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {
@Autowired
private IUomDao dao;
	@Override
	@Transactional
	public Integer saveUom(Uom um) {
		// TODO Auto-generated method stub
		return dao.saveUom(um);
	}

	@Override
	@Transactional
	public void updateUom(Uom um) {
		// TODO Auto-generated method stub
        dao.updateUom(um);
	}

	@Override
	@Transactional
	public void deleteUom(int umId) {
		// TODO Auto-generated method stub
          dao.deleteUom(umId);
	}

	@Override
	@Transactional(readOnly=true)
	public Uom getOneUom(int umId) {
		// TODO Auto-generated method stub
		return dao.getOneUom(umId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return dao.getAllUoms();
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomAlreadyExist(String umModel) {
		
		return dao.isUomAlreadyExist(umModel);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomConnectedWithItem(Integer umId) {
		// TODO Auto-generated method stub
		return dao.isUomConnectedWithItem(umId);
	}

}
