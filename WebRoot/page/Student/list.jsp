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
				<jsp:include page="../top.jsp"></jsp:include>
				<div class="panel">
				  <div class="panel-head">
				  	学生信息
				  	<a href="JavaScript:history.go(-1);">| 返回上一页</a>
				  </div>
				  <div class="panel-body">
				  	<table  class='table table-hover  table-condensed table-bordered' >
				  			<tr align="center">
				  				<th>
									照片
								</th>
								<th>
									姓名
								</th>
								<th>
									联系电话
								</th>
								<th>
									联系QQ
								</th>
								<th>
									联系邮箱
								</th>
							</tr>
				  		<c:forEach items="${student}" var="q">
							<tr align="center">
								<td>
									<img src="${q.icon }" width="20" />
								</td>
								<td>
									${q.name }
								</td>
								<td>
									<a href="tel:${q.phone }">${q.phone }</a>
								</td>
								<td>
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${q.qq }&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:${q.qq }:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
								</td>
								<td>
									${q.email }
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
