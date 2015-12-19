<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ username }
	${ role } 
	<%=session.getAttribute("userphone")%>
	<form action="user-manage.do" method="post">
		学号：<input type="text" name="student_num" />
		密码：<input type="password" name="password"/> 
		<input type="submit" value="submit" />
	</form>
</body>
</html>