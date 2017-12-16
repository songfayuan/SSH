package com.stx.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.stx.entity.Department;
import com.stx.entity.Student;
import com.stx.entity.Term;
import com.stx.entity.User;
import com.stx.service.DepartmentService;
import com.stx.service.StudentService;
import com.stx.service.TermService;
import com.stx.util.FileUpLoad;

public class StudentAction extends ActionSupport {
	private File image; // 上传的文件
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	// 创建对应实体类的变量
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// 创建对应service类变量
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	// 新增方法
	public String add() {
		String img = FileUpLoad.upload(image, imageContentType, "pic"); // 上传
		student.setIcon(img);
		this.studentService.add(student);
		return "succ";
	}

	// 查询方法
	public void getBm() {
		// 获取信息
		List list = this.studentService.getBm(student.getTermid() + "");
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

	public String login() {
		// 获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		Student u = this.studentService.login(student); // 通过方法的调用建立连接
		if (u != null) {
			request.getSession().setAttribute("student", u);
			return "succ";
		} else {
			return "fail";
		}
	}

	public String getStus() {
		List list = this.studentService.getStus(student.getDepartmentid() + "");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("student", list);
		return "succ";
	}

	// 退出登录
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("student");
		return "succ";
	}

	public String getAllStus() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String keywords = request.getParameter("keywords");
		System.out.println(keywords + "11111111");
		// 获取信息
		List list = null;
		if (keywords != null) {
			list = this.studentService.getAllStus("from Student s where s.name like'%"+keywords+"%'");
		} else {
			list = this.studentService.getAllStus("from Student s");
		}
		request.setAttribute("stus", list);
		return "succ";
	}
}
