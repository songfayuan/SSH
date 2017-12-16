package com.stx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity(name="Department")
@Table(name="department",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Department {
	private int id;
	private int termid;
	private String termname;
	private String departmentname;
	private String remark;
	
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
	
	@Column(name="termname")
	public String getTermname() {
		return termname;
	}
	public void setTermname(String termname) {
		this.termname = termname;
	}
	
	@Column(name="departmentname")
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
