package com.stx.service;

import java.util.ArrayList;
import java.util.List;

import com.stx.dao.ObjectDao;
import com.stx.entity.Department;
import com.stx.entity.Term;
import com.stx.entity.User;

public class DepartmentService {
	private ObjectDao objectDao;

	public ObjectDao getObjectDao() {
		return objectDao;
	}

	public void setObjectDao(ObjectDao objectDao) {
		this.objectDao = objectDao;
	}
	
	public List getTerm(){
		String hql="from Term";
		return this.objectDao.getObjectList(hql);
		
	}
	
	public List getDepartment(){
		String hql="from Department";
		return this.objectDao.getObjectList(hql);
		
	}
	
	//新增方法
	public void add(Department department){
		String[] strs=department.getTermname().split(",");
		department.setTermid(Integer.parseInt(strs[0]));
		department.setTermname(strs[1]);
		this.objectDao.insertObjectForm(department);
	}
	//查询方法
	public List select(String termid){
		List list=this.objectDao.getObjectList("from Department b where b.termid="+termid);
		return list;
	}

}
