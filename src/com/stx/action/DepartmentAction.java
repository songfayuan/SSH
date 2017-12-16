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
	// 创建对应实体类的变量
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// 创建对应service类变量
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void getTerm() {
		List list = this.departmentService.getTerm();
		// 获取response
		HttpServletResponse response = ServletActionContext.getResponse();

		// 将封装了数据的list装换成json格式的字符串
		JSONArray jsonArray = JSONArray.fromObject(list);
		// 将数据返回前台页面
		response.setCharacterEncoding("utf-8");
		// 将数据返回前台
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void getDepartmentB() {
		List list = this.departmentService.getDepartment();
		// 获取response
		HttpServletResponse response = ServletActionContext.getResponse();

		// 将封装了数据的list装换成json格式的字符串
		JSONArray jsonArray = JSONArray.fromObject(list);
		// 将数据返回前台页面
		response.setCharacterEncoding("utf-8");
		// 将数据返回前台
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 新增方法
	public String add() {
		this.departmentService.add(department);
		return "succ";
	}

	// 查询方法
	public String select() {
		// 获取信息
		List list=this.departmentService.select(department.getTermid()+"");
		HttpServletRequest request = ServletActionContext.getRequest (); 
		request.setAttribute("department", list);
		return "succ";

	}

}
