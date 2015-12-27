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

	<form action="user-course.do" method="post">
		课程：<input type="text" name="courseName" />
		老师：<input type="text" name="teacher" />
		电话：<input type="text" name="tphone" />
		教室：<input type="text" name="classroom" />
		课程号：<input type="text" name="identifier" />
		<input type="submit" value="submit" />
	</form>

</body>
</html>