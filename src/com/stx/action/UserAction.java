package com.stx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stx.entity.User;
import com.stx.service.UserService;

public class UserAction extends ActionSupport {
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String add(){
		this.userService.addUser(user);
		return "succ";
	}
	
	public String login(){
		//��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest (); 
		User u=this.userService.login(user);    //ͨ�������ĵ��ý�������
		if(u!=null){
			request.getSession().setAttribute("user", u);
			return "succ";
		}else{
			return "fail";
		}
		
	}
	//�˳���¼
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest (); 
		request.getSession().removeAttribute("user");
		return "succ";
	}
}
