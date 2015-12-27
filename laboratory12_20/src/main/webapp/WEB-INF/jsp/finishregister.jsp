<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>完成预约</title>
</head>
<body>
    ${error}
   <form action="Finishregister.do" method="post">
         xuehao:<input  type="text" name="student_num"><br>
         neima:<input type="text" name="carcode">
         <input value="提交" type="submit">
   </form>
</body>
</html>