package com.stx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity(name="Student")
@Table(name="student",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Student {
	private int id;
	private int termid;
	private String term;
	private int departmentid;
	private String department;
	private String name;
	private String password;
	private String phone;
	private String qq;
	private String email;
	private String icon;
	
	//主键唯一标示
	@Id
	//字段名
	@Column(name="id")
	//增长方式--自动序列
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	//手工指定
//	@GeneratedValue(generator="_assigned")
//	@GenericGenerator(name="_assigned",strategy="assigned")

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="termid")
	public int getTermid() {
		return termid;
	}
	public void setTermid(int termid) {
		this.termid = termid;
	}
	
	@Column(name="departmentid")
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	
	@Column(name="term")
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Column(name="department")
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="qq")
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="icon")
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

	
}
