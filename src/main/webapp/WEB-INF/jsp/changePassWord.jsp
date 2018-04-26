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
<link href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<form action="updateUserPassWord" method="post" style="width:70%;padding:50px;" id="submit_form">
  <div class="form-group">
    <label for="exampleInputEmail1">用户名</label>
    <input type="text" class="form-control" name="userName" placeholder="请输入用户名" value="${sessionScope.user.userName}" readonly="readonly">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">原密码</label>
    <input type="password" class="form-control" name="password" placeholder="请输入原密码">
    <c:if test="${!empty requestScope.error}">
    	    <span style="color:red;font-size:80%">${requestScope.error}</span>
    </c:if>
 	<c:if test="${!empty requestScope.success}">
    	    <span style="color:green;font-size:80%">${requestScope.success}</span>
    </c:if>
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">新密码</label>
    <input type="password" class="form-control" name="newPassword" placeholder="请输入新密码">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">确认密码</label>
    <input type="password" class="form-control" name="reNewPassword" placeholder="请确认新密码">
  </div>
  <button type="submit" class="btn btn-default">确定修改</button>
</form>
</body>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script type="text/javascript">
$(function () {
$('#submit_form').bootstrapValidator({
	message: 'This value is not valid',
	feedbackIcons:{
		valid:'glyphicon glyphicon-ok',
		invalid: 'glyphicon glyphicon-remove',
		validating: 'glyphicon glyphicon-refresh'
	},
    fields: {
    	password: {
            message: "<span style='color:red'>原密码验证失败</span>",
            validators: {
                notEmpty: {
                    message: "<span style='color:red'>*原密码不能为空</span>"
                }
            }
        },
        newPassword: {
            message: "<span style='color:red'>新密码验证失败</span>",
            validators: {
                notEmpty: {
                    message: "<span style='color:red'>*新密码不能为空</span>"
                }
            }
        },
        reNewPassword: {
            message: '确认密码验证失败',
            validators: {
                notEmpty: {
                    message: "<span style='color:red'>*确认密码不能为空</span>"
                },
                identical: {
                	field: 'newPassword',
                	message: "<span style='color:red'>*两次输入密码不一致</span>"
                }
            }
        }
    }
})
})
</script>
</html>