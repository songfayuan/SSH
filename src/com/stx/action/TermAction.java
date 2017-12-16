package com.stx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stx.entity.Term;

import com.stx.service.TermService;

public class TermAction extends ActionSupport {
	// ������Ӧʵ����ı���
	Term term;

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	// ������Ӧservice�����
	TermService termService;

	public TermService getTermService() {
		return termService;
	}

	public void setTermService(TermService termService) {
		this.termService = termService;
	}

	// ��������
	public String add() {
		this.termService.add(term);
		return "succ";
	}

	// ��ѯ����
	public String selectTerm() {
		// ��ȡ��Ϣ
		List list = this.termService.selectTerm("from Term");
		// �����ݷ�װ��request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("term", list);
		return "succ";
	}

}
