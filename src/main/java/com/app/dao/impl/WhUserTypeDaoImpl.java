package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;


@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
@Autowired
private HibernateTemplate ht;

@Override
public Integer saveWhUserType(WhUserType whUsrTyp) {
	// TODO Auto-generated method stub
	return (Integer)ht.save(whUsrTyp);
}

@Override
public void updateWhUserType(WhUserType whUsrTyp) {
	// TODO Auto-generated method stub
	   ht.update(whUsrTyp);
}

@Override
public void deleteWhUserType(int whUsrTypId) {
	// TODO Auto-generated method stub
	WhUserType whUsrTyp=new WhUserType();
	whUsrTyp.setWhUsrTypId(whUsrTypId);
	ht.delete(whUsrTyp);
}

@Override
public WhUserType getOneWhUserType(int whUsrTypId) {
	// TODO Auto-generated method stub
	return ht.get(WhUserType.class, whUsrTypId);
}

@Override
public List<WhUserType> getAllWhUserTypes() {
	// TODO Auto-generated method stub
	return ht.loadAll(WhUserType.class);
}

@Override
public List<WhUserType> getWhUserTypeByType(String whUsrTypType) {
   String hql="from "+WhUserType.class.getName()+" where whUsrTypType=?";
   List<WhUserType> list=(List<WhUserType>)ht.find(hql, whUsrTypType);
	return list;
}

@Override
public boolean isWhUserTypeAlreadyExist(String whUsrTypCode) {
	// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<Long> rowsCount=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class)
			.setProjection(Projections.rowCount())
			.add(Restrictions.eq("whUsrTypCode", whUsrTypCode)));
	return rowsCount.get(0)!=0?true:false;
}

	}
