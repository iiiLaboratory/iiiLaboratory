<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选课</title>
</head>
<body>
       <c:if  test="${not empty  error}">
       <font color="#ff6633">${error}</font> 
       </c:if>
       <c:if test="${not empty success }">
       <font color="#ff6633">${success}</font> 
       </c:if>
       <form action="select-course.do" method="post">
		课程名：<input type="text" name="courseName" />
		学    号：<input type="text" name="student_num"/>
		<input type="submit" value="submit" />
	</form>
</body>
</html>