<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String id = request.getParameter("id");
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
	</head>

	<body>

		<div class="container">
			<jsp:include page="top.jsp"></jsp:include>
			<div class="panel">
				<div class="panel-head">
					添加章节
				</div>
				<div class="panel-body">
					<form action="AddZjServlet?bookid=<%=id %>" method="post">
						<input name="title" type="text" class="input  input-big" placeholder="请输入章节标题"
							style="background-color: transparent" />
						<textarea  rows="15" class="input input-big" placeholder="请输入内容"
							name="content" cols="100"></textarea>
						<input
							class='button  button-block  button-big  bg-yellow bg-inverse'
							type="submit" value="提交">

					</form>
				</div>
			</div>
			<div class="container-layout">

				<div class="border-top padding-top">
					<div class="text-center height-big">
						版权所有 © 双体系，技术支持：双体系
					</div>
				</div>

			</div>


		</div>
	</body>
</html>
