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
 			<td>文件类型ID</td>
 			<td>文件类型</td>
 			<td>文件简介</td>
 			<td>排序</td>
 			<td>操作</td>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach var="fileType" items="${fileTypeList}" varStatus="index">
	 		<tr>
	 			<td>${index.count+1}</td>
	 			<td>${fileType.fileTypeName}</td>
	 			<td>${fileType.description}</td>
	 			<td>${fileType.sort}</td>
	 			<td><a href="#">编辑</a>|<a href="#" onclick="del('${fileType.fileTypeId}')">删除</a></td>
	 		</tr>
 		</c:forEach>
 	</tbody>
</table>
</body>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script>
function del(fileTypeId) { 
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
		 alert(fileTypeId);
	   window.location.href="deleteFileType?fileTypeId="+fileTypeId;
	   return true; 
	 }else{ 
	  return false; 
	 } 
	} 
</script>
</html>