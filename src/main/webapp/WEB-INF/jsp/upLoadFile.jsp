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
<link rel="stylesheet" href="<%=path%>/static/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<form style="width:70%;padding:50px;" action="uploadFile" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="exampleInputEmail1">文件名</label>
		    <input type="text" class="form-control" name="fileName" placeholder="请输入文件名">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputEmail1">文件描述</label> 
		    <input type="text" class="form-control" name="description" placeholder="请输入文件描述">
		  </div>
		  
		  <div class="form-group">
		 		<label for="exampleInputEmail1">文件文件类型</label> 
				<select class="form-control" name="fileTypeId">
					<c:forEach var="fileType" items="${fileTypeList}">
						<option value="${fileType.fileTypeId}">${fileType.fileTypeName}</option> 
					</c:forEach>
				</select>
		  </div>
		  
		   <div class="form-group">
			    <label for="exampleInputFile">文件上传</label>
			    <input type="file" name="uploadfile">
			    <p class="help-block">请选择文件</p>
		   </div>
		  
		  <button type="submit" class="btn btn-default">确定上传</button>
	</form>
</body>
</html>