<%@ page language="java" contentType="text/html; charset=UTF-8"
   isELIgnored="false" pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网页队伍注册</title>
<script type="text/javascript" language="javascript">
		var i = 2;
		function addUser(){
			var voteP = document.getElementById("userNumList");
			var inputText = document.createTextNode("队员" + (i++) +"学号:");
			voteP.appendChild(inputText);
			var inputP = document.createElement("input");
			inputP.type="text";
			inputP.name="userID";
			voteP.appendChild(inputP);
			var brP = document.createElement("<br>");
			voteP.appendChild(brP);
		}
	</script>
</head>
<body>
<c:if  test="${not empty error }">
 <font color="#ff6633">${error }</font> 
</c:if>
    <form action="Teamregisteronpage.do" method="post">
                           实验号:<select name="courseID">
	  			<option value="1">信息对抗</option>
	  			<option value="2">单兵电台</option>	  			
	  		</select><br/>
                      
        <div id="userNumList">
                          同学1学号:<input type="text" name="userID"><br>
         </div><br>
          <input type="button" value="增加学生" onclick="addUser()"/> <br><br>               
         <input value="提交" type="submit">
   </form>

</body>
</html>