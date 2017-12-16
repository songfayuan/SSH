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

	// �õ�һ������
	public Object getObjectForm(String condition) {
		List list = null;
		Object object = null;
		try {
			list = getHibernateTemplate().find(condition);   //getHibernateTemplate�õ�һ��Hibernate�Ķ��������������ݿ�
			if (list.size() == 1) {
				object = (Object) list.get(0);
			}
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return object;
	}

	//�õ�һ�����
	public List getObjectList(String condition) {
		List list = null;
		try {
			list = getHibernateTemplate().find(condition);		
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	// ���²���
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

	// �������
	public void insertObjectForm(Object object) {
		try {
		
			getHibernateTemplate().save(object);	
			
		} catch (DataAccessException ex) {
			ex.printStackTrace();

		}
		
	}

	//ɾ������
	public boolean deleteObjectForm(Object object) {
		try {
			getHibernateTemplate().delete(object);
			return true;
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	//�õ������Ĳ���
	public int getCount(String hql){
		int count=((Long) getHibernateTemplate().getSessionFactory().getCurrentSession().iterate(hql).next()).intValue();
		return count;
	}
	
}
