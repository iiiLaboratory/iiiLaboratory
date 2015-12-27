<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改</title>
</head>
<body>
       <c:if  test="${not empty error}">
       <font color="#ff6633">${error}</font> 
       </c:if>
       <c:if test="${not empty success }">
       <font color="#ff6633">${email} ${phone} ${success}</font> 
       </c:if>
       <form action="update.do" method="post">
		学    号：<input type="text" name="student_num"/></br>
		邮    箱：<input type="text" name="email" /></br>
		手    机：<input type="text" name="phone" /></br>
		<input type="submit" value="update" />
	</form>
</body>
</html>