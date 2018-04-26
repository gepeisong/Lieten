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
 			<td>文件ID</td>
 			<td>文件名</td>
 			<td>文件地址</td>
 			<td>文件类型</td>
 			<td>创建日期</td>
 			<td>上传者</td>
 			<td>操作</td>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach var="file" items="${fileList}" varStatus="index">
	 		<tr>
	 			<td>${index.count+1}</td>
	 			<td>${file.fileName}</td>
	 			<td>${file.fileUrl}</td>
	 			<td>${file.fileType}</td>
	 			<td>${file.createDate}</td>
	 			<td>${file.operator}</td>
	 			<td><a href="#">编辑</a>|<a href="#" onclick="del('${file.fileId}')">删除</a>|<a href="<%=path%>/${file.fileUrl}" download="${file.fileName}">下载</a></td>
	 		</tr>
 		</c:forEach>
 	</tbody>
</table>
</body>
<script type="text/javascript" src="<%=path%>/static/js/jquery-1.11.3.min.js"></script>
<script>
function del(fileId) { 
	 var msg = "您真的确定要删除吗？\n\n请确认！"; 
	 if (confirm(msg)==true){ 
		 
		// alert(fileId);
		 window.location.href="deleteFile?fileId="+fileId; 
	  	return true; 
	 }else{ 
	  return false; 
	 } 
	} 
</script>
</html>