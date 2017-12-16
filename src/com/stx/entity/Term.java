package com.stx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity(name="Term")
@Table(name="term",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Term {
	private int id;
	private String term;
	private String remark;

	
	
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
	
	@Column(name="term")
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
