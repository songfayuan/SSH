<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    text-shadow: 0 1px 4px rgba(0,0,0,.2);
}
		</style>
	</head>
  
  <body style="background: url('images/bg.jpg');">
    <div class="container">&nbsp; 
    <br/> <br/> <br/>
    <center> <h1 style="color: white;">双体通讯录</h1></center><br/>
    <center> <h1 style="color: white;">学员登录</h1></center>
    <br/>
   
    	<form action="student/login.do" method="post">
			<input type="text" name="student.name" class="input  input-big" placeholder="请输入用户名！" style="background-color:transparent"/>
			<br/>
			<input type="password" name="student.password" class="input  input-big" placeholder="请输入密码！"  style="background-color:transparent"/>
			<br/>
			<button class='button  button-block  button-big  bg-yellow bg-inverse' type='submit'>
						提交
			</button>
			<a href="page/Student/add.jsp" style="color: white;">学员注册 | </a>
			<a href="page/login.jsp" style="color: white;">管理员登陆</a>
		</form>
    
    </div>
  </body>
</html>
