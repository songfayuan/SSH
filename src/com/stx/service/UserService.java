package com.stx.service;

import java.util.ArrayList;
import java.util.List;

import com.stx.dao.ObjectDao;
import com.stx.entity.User;

public class UserService {
	private ObjectDao objectDao;

	public ObjectDao getObjectDao() {
		return objectDao;
	}

	public void setObjectDao(ObjectDao objectDao) {
		this.objectDao = objectDao;
	}
	
	public void addUser(User user){
		this.objectDao.insertObjectForm(user);
	}
	
	public User login(User user){  //以对象的形式去实现
		String hql="from User u " +
				"where u.username='"+user.getUsername()+"' " +
						"and u.password='"+user.getPassword()+"'";
		User u=(User)this.objectDao.getObjectForm(hql);
		return u;
	}

}
