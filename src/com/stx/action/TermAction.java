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
	// 创建对应实体类的变量
	Term term;

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	// 创建对应service类变量
	TermService termService;

	public TermService getTermService() {
		return termService;
	}

	public void setTermService(TermService termService) {
		this.termService = termService;
	}

	// 新增方法
	public String add() {
		this.termService.add(term);
		return "succ";
	}

	// 查询方法
	public String selectTerm() {
		// 获取信息
		List list = this.termService.selectTerm("from Term");
		// 将数据封装到request
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("term", list);
		return "succ";
	}

}
