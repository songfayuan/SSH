<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
				<div class="navbar bg-yellow bg-inverse radius">
					<div class="navbar-head">
						<button class="button bg icon-navicon" data-target="#navbar-bg1"></button>
						双体通讯录平台
					</div>
					<div class="navbar-body nav-navicon" id="navbar-bg1">
						<ul class="nav nav-inline nav-menu">
							<c:if test="${!empty sessionScope.user}">
								<li>
									<a href="page/addTerm.jsp">新增期数</a>
								</li>
								<li>
									<a href="term/selectTerm.do">查看期数</a>
								</li>
								<li>
									<a href="page/Department/add.jsp">新增部门</a>
								</li>
								<li>
									<a href="student/getAllStus.do">人员信息</a>
								</li>
								<li>
									<a href="user/logout.do">退出登陆</a>
								</li>
								<li>
								<a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=Gml1dH18e2Nve3RafHVid3tzdjR5dXc" target="_">意见反馈</a>
								</li>
							</c:if>
							<c:if test="${!empty sessionScope.student}">						
								<li>
									<a href="term/selectTerm.do">查看期数</a>
								</li>
								<li>
									<a href="student/getAllStus.do">人员信息</a>
								</li>
								<li>
									<a href="student/logout.do">退出登陆</a>
								</li>
								<li>
								<a href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=Gml1dH18e2Nve3RafHVid3tzdjR5dXc" target="_">意见反馈</a>
								</li>
							</c:if>

						</ul>
					</div>
				</div>