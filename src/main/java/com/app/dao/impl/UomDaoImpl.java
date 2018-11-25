package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Item;
import com.app.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
@Autowired
private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom um) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(um);
	}

	@Override
	public void updateUom(Uom um) {
		// TODO Auto-generated method stub
          ht.update(um);
	}

	@Override
	public void deleteUom(int umId) {
		// TODO Auto-generated method stub
          Uom um=new Uom();
          um.setUmId(umId);
		ht.delete(um);
	}

	@Override
	public Uom getOneUom(int umId) {
		// TODO Auto-generated method stub
		
		return ht.get(Uom.class,umId) ;
	}

	@Override
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return ht.loadAll(Uom.class);
	}

	@Override
	public boolean isUomAlreadyExist(String umModel) {
@SuppressWarnings("unchecked")
List<Long> rowsCount=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(Uom.class)
		.setProjection(Projections.rowCount())
		.add(Restrictions.eq("umModel", umModel)));
		return rowsCount.get(0)!=0?true:false;
	}

	@Override
	public boolean isUomConnectedWithItem(Integer umId) {
		@SuppressWarnings("unchecked")
		List<Long> rowsCount=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(Item.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("uom.umId", umId)));
		return rowsCount.get(0)!=0?true:false;
	}
	

}
