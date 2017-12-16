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
				  	期数信息主页面
				  </div>
				  <div class="panel-body">
				  	<table  class='table table-hover  table-condensed table-bordered' >
				  		<c:forEach items="${term}" var="q">
							<tr align="center">
								<td>
									${q.id }
								</td>
								<td>
									<a href="department/select.do?department.termid=${q.id}">${q.term }</a>									
								</td>
								<td>
									${q.remark }
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
