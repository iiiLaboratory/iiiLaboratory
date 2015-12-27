<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户预注册</title>
</head>
<body>
 	   <c:if  test="${not empty error}">
       <font color="#ff6633">${error}</font> 
       </c:if>
       <c:if test="${not empty success }">
       <font color="#ff6633">${success}</font> 
       </c:if>

	<form action="user-register.do" method="post">
		学号：<input type="text" name="student_num" /></br>
		姓名：<input type="text" name="user_name" /></br>
		密码：<input type="password" name="password" /></br>
		<!-- 一卡通：<input type="text" name="cardcode" /> -->
		邮箱：<input type="text" name="email" /> </br>
		手机：<input type="text" name="phone" /></br>
		<input type="submit" value="submit" />
	</form>

</body>
</html>