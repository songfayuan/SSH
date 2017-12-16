package com.stx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity(name="User")
@Table(name="user",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class User {
	private int id;
	private String username;
	private String password;
	private String nickname;
	
	
	
	//����Ψһ��ʾ
	@Id
	//�ֶ���
	@Column(name="id")
	//������ʽ--�Զ�����
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	//�ֹ�ָ��
//	@GeneratedValue(generator="_assigned")
//	@GenericGenerator(name="_assigned",strategy="assigned")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
