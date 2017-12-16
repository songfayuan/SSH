<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href='<%=basePath%>'>
<meta name='viewport'
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no' />
<link rel='stylesheet' href='<%=basePath%>css/pintuer.css'>
<script src='<%=basePath%>js/jquery.js'></script>
<script src='<%=basePath%>js/pintuer.js'></script>
<script src='<%=basePath%>js/respond.js'></script>
<style type="text/css">
h1 {
	font-size: 30px;
	font-weight: 700;
	text-shadow: 0 1px 4px rgba(0, 0, 0, .2);
}
</style>
</head>

<body onload="getTerm()" style="background: url('images/bg.jpg');">
	<div class="container">
		&nbsp; <br />
		<br />
		<br />
		<center>
			<h1 style="color: white;">双体通讯录注册页</h1>
		</center>
		<br />
		<br />

		<form action="student/add.do" method="post"
			enctype='multipart/form-data'>
			<select id="term" name="student.term"
				onchange="getDepartmentByTerm()" class="input  input-big"
				style="background-color:transparent">
			</select><br /> <select id="department" name="student.department"
				class="input  input-big" style="background-color:transparent">
			</select><br /> <input type="text" name="student.name" onblur="checkUser()"
				class="input  input-big" placeholder="请输入姓名"
				style="background-color:transparent" /> <br /> <input
				type="password" name="student.password" class="input  input-big"
				placeholder="请输入密码" style="background-color:transparent" /> <br />
			<input type="text" name="student.phone" class="input  input-big"
				placeholder="请输入电话" style="background-color:transparent" /> <br />
			<input type="text" name="student.qq" class="input  input-big"
				placeholder="请输入QQ" style="background-color:transparent" /> <br />
			<input type="text" name="student.email" class="input  input-big"
				placeholder="请输入邮箱" style="background-color:transparent" /> <br />
			<input type="file" name="image" class="input  input-big"
				placeholder="添加图片" style="background-color:transparent" /> <br />
			<button
				class='button  button-block  button-big  bg-yellow bg-inverse'
				type='submit'>提交</button>
			<a href="page/Student/login.jsp" style="color: white;">已有账号，登陆？</a>
		</form>

	</div>
</body>
</html>

<script type="text/javascript">
	function getTerm() {
		$.post('department/getTerm.do', function(data) {
			var json = eval("(" + data + ")");
			$("#term").append("<option value='0'>请选择期数");
			$.each(json, function(index, item) {
				$("#term").append(
						"<option value='"+item.id+","+item.term+"'>"
								+ item.term);
			});
		});
	}

	function getDepartmentByTerm() {
		var dep = document.getElementById("term").value;
		var temp = dep.split(',');

		$.post('student/getBm.do?student.Termid=' + temp[0], function(data) {
			var json = eval("(" + data + ")");
			$("#department").html("");
			$("#department").append("<option value='0'>请选择所在部门");
			$.each(json, function(index, item) {
				$("#department").append(
						"<option value='"+item.id+","+item.departmentname+"'>"
								+ item.departmentname);
			});
		});
	}
</script>