<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path%>/static/css/bootstrap.css">
</head>
<body>
<table class="table table-striped">
 	<thead>
 		<tr>
 			<td>用户ID</td>
 			<td>用户名</td>
 			<td>手机号</td>
 			<td>生日</td>
 			<td>性别</td>
 			<td>邮箱</td>
 			<td>操作</td>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach var="user" items="${userList}" varStatus="index">
	 		<tr>
	 			<td>${index.count+1}</td>
	 			<td>${user.userName}</td>
	 			<td>${user.phoneNum}</td>
	 			<td>${user.birthday}</td>
	 			<td>${user.sex}</td>
	 			<td>${user.email}</td>
	 			<td><a href="#">编辑</a>|<a href="#" onclick="del('${user.userId}')">删除</a></td>
	 		</tr>
 		</c:forEach>
 	</tbody>
</table>
</body>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script>
function del(userId) { 
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
	  window.location.href="deleteUser?userId="+userId;
	  return true; 
	 }else{ 
	  return false; 
	 } 
	} 
</script>
</html>