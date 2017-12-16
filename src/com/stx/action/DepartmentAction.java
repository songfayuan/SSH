package com.stx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stx.entity.Department;
import com.stx.entity.Term;
import com.stx.service.DepartmentService;
import com.stx.service.TermService;

public class DepartmentAction extends ActionSupport {
	// ������Ӧʵ����ı���
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// ������Ӧservice�����
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void getTerm() {
		List list = this.departmentService.getTerm();
		// ��ȡresponse
		HttpServletResponse response = ServletActionContext.getResponse();

		// ����װ�����ݵ�listװ����json��ʽ���ַ���
		JSONArray jsonArray = JSONArray.fromObject(list);
		// �����ݷ���ǰ̨ҳ��
		response.setCharacterEncoding("utf-8");
		// �����ݷ���ǰ̨
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void getDepartmentB() {
		List list = this.departmentService.getDepartment();
		// ��ȡresponse
		HttpServletResponse response = ServletActionContext.getResponse();

		// ����װ�����ݵ�listװ����json��ʽ���ַ���
		JSONArray jsonArray = JSONArray.fromObject(list);
		// �����ݷ���ǰ̨ҳ��
		response.setCharacterEncoding("utf-8");
		// �����ݷ���ǰ̨
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ��������
	public String add() {
		this.departmentService.add(department);
		return "succ";
	}

	// ��ѯ����
	public String select() {
		// ��ȡ��Ϣ
		List list=this.departmentService.select(department.getTermid()+"");
		HttpServletRequest request = ServletActionContext.getRequest (); 
		request.setAttribute("department", list);
		return "succ";

	}

}
