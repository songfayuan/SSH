package com.stx.service;

import java.util.ArrayList;
import java.util.List;

import com.stx.dao.ObjectDao;
import com.stx.entity.Term;
import com.stx.entity.User;

public class TermService {
	private ObjectDao objectDao;

	public ObjectDao getObjectDao() {
		return objectDao;
	}

	public void setObjectDao(ObjectDao objectDao) {
		this.objectDao = objectDao;
	}
	
	//��������
	public void add(Term term){
		this.objectDao.insertObjectForm(term);
	}
	//��ѯ����
	public List selectTerm(String hql){
		return this.objectDao.getObjectList(hql);
		
	}

}
