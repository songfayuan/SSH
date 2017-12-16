<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.stx.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	</head>

	<body>
	
			<div class="container">
				<jsp:include page="top.jsp"></jsp:include>
				<div class="panel">
				  <div class="panel-head">
				  	欢迎主页面
				  </div>
				  <div class="panel-body">
				  	<table  class='table table-hover  table-condensed table-bordered' >
				  		<c:forEach items="${books}" var="b">
							<tr align="center">
								<td>
									<a href="GetZjServlet?bookid=${b.id }">${b.bookname }</a>
								</td>
								<td>
									<a href="page/addzj.jsp?id=${b.id }">增加章节</a>
								</td>
							</tr>
						</c:forEach>
				  	</table>
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
