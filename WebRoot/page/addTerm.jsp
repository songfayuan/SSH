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
					添加期数
				</div>
				<div class="panel-body">
					<form action="term/add.do" method="post">
						<input name="term.term" type="text" class="input  input-big" placeholder="请输入期数"
							style="background-color: transparent" /><br/>
						<textarea  rows="15" class="input input-big" placeholder="请输入备注"
							name="term.remark" cols="100"></textarea><br/>
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
