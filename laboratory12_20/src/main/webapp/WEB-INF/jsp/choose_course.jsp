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
       <font color="#ff6633">成功添加${success}条记录！<br>  ${fail}条记录已经存在</font> 
       </c:if>
       <form method="post" action="choose-course.do" enctype="multipart/form-data">
          <input type="file" name="excelupload">
          <input type="submit" name="tijiao"> 
       </form>
</body>
</html>