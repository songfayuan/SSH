package com.stx.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class ObjectDao extends HibernateDaoSupport {

	// 得到一个对象
	public Object getObjectForm(String condition) {
		List list = null;
		Object object = null;
		try {
			list = getHibernateTemplate().find(condition);   //getHibernateTemplate得到一个Hibernate的对象，用来操纵数据库
			if (list.size() == 1) {
				object = (Object) list.get(0);
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return object;
	}

	//得到一组对象
	public List getObjectList(String condition) {
		List list = null;
		try {
			list = getHibernateTemplate().find(condition);		
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	// 更新操作
	public boolean updateObjectForm(Object object) {
		boolean flag = false;
		try {
			getHibernateTemplate().update(object);
			flag = true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	// 插入操作
	public void insertObjectForm(Object object) {
		try {
		
			getHibernateTemplate().save(object);	
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();

		}
		
	}

	//删除操作
	public boolean deleteObjectForm(Object object) {
		try {
			getHibernateTemplate().delete(object);
			return true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	//得到数量的操作
	public int getCount(String hql){
		int count=((Long) getHibernateTemplate().getSessionFactory().getCurrentSession().iterate(hql).next()).intValue();
		return count;
	}
	
}
