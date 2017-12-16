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
	private File image; // �ϴ����ļ�
	private String imageFileName; // �ļ�����
	private String imageContentType; // �ļ�����

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

	// ������Ӧʵ����ı���
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// ������Ӧservice�����
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	// ��������
	public String add() {
		String img = FileUpLoad.upload(image, imageContentType, "pic"); // �ϴ�
		student.setIcon(img);
		this.studentService.add(student);
		return "succ";
	}

	// ��ѯ����
	public void getBm() {
		// ��ȡ��Ϣ
		List list = this.studentService.getBm(student.getTermid() + "");
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

	public String login() {
		// ��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		Student u = this.studentService.login(student); // ͨ�������ĵ��ý�������
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

	// �˳���¼
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("student");
		return "succ";
	}

	public String getAllStus() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String keywords = request.getParameter("keywords");
		System.out.println(keywords + "11111111");
		// ��ȡ��Ϣ
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
