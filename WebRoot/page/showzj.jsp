<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String imgpath = request.getParameter("imgpath");
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
					阅读章节
					<a href="javascript:history.go(-1);">返回</a>
				</div>
				<div class="panel-body">
					<img src="<%=basePath%><%=imgpath %>" width="100%"/>
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
