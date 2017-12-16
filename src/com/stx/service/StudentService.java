package com.stx.service;

import java.util.ArrayList;
import java.util.List;

import com.stx.dao.ObjectDao;
import com.stx.entity.Student;


public class StudentService {
	private ObjectDao objectDao;

	public ObjectDao getObjectDao() {
		return objectDao;
	}

	public void setObjectDao(ObjectDao objectDao) {
		this.objectDao = objectDao;
	}
	
	// 新增方法
	public void add(Student student) {
		String[] strs=student.getTerm().split(",");
		student.setTermid(Integer.parseInt(strs[0]));
		student.setTerm(strs[1]);
		String[] str=student.getDepartment().split(",");
		student.setDepartmentid(Integer.parseInt(str[0]));
		student.setDepartment(str[1]);
		this.objectDao.insertObjectForm(student);
	}

	// 查询方法
	public List getBm(String termid) {
		return this.objectDao.getObjectList("from Department department where department.termid="+termid);

	}
	
	//登陆操作
	public Student login(Student student){  //以对象的形式去实现
		String hql="from Student u " +
				"where u.name='"+student.getName()+"' " +
						"and u.password='"+student.getPassword()+"'";
		Student u=(Student)this.objectDao.getObjectForm(hql);
		return u;
	}
	
	public List getStus(String departmentid){
		return this.objectDao.getObjectList("from Student student where student.departmentid="+departmentid);
	}
	
	public List getAllStus(String hql){
		return this.objectDao.getObjectList(hql);	
	}

}
