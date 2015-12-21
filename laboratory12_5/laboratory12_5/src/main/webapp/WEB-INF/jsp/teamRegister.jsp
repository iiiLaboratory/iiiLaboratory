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
     <c:if test="${not empty inputstyle_error}" > 
      <font color="#ff6633">ge shi you wu</font> 
      </c:if>
      <c:if test="${not empty error}" > 
      <font color="#ff6633">${error }</font> 
      </c:if> 
      <c:if test="${not empty successteam}" > 
      <font color="#ff6633">成功注册${successteam }个队伍</font> 
      </c:if> 
       <c:if test="${not empty successteaming}" > 
      <font color="#ff6633">成功注册${successteaming }个teaming,${failteaming }个teaming失败！</font> 
      </c:if> 
      
     <form method="post" action="TeamRegister.do" enctype="multipart/form-data">
          <input type="file" name="excelupload">
          <input type="submit" name="tijiao"> 
     </form>
</body>
</html>