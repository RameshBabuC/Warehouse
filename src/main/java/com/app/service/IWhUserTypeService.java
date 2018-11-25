package com.app.service;

import java.util.List;


import com.app.model.WhUserType;

public interface IWhUserTypeService {
	public Integer saveWhUserType(WhUserType whUsrTyp);
    public void updateWhUserType(WhUserType whUsrTyp);
    public void deleteWhUserType(int whUsrTypId);
    public WhUserType getOneWhUserType(int whUsrTypId);
    public List<WhUserType> getAllWhUserTypes();
    public List<WhUserType> getWhUserTypeByType(String whUsrTypType);
    public boolean isWhUserTypeAlreadyExist(String whUsrTypCode);
}