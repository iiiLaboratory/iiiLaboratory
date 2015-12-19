<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String username = (String) session.getAttribute("name");
	String password = (String) session.getAttribute("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/div.css" type="text/css"
	media="screen" />
<link
	href="${ pageContext.request.contextPath }/css/bootstrap-combined.min.css"
	rel="stylesheet">
</head>
<body>
用户：[< % = username %>]<br/>
密码：[< % = password %>]<br/>
</body>

<body>

	<div class="control-group">
		<div class="controls">
			<p style="color: red;">
				<c:if test="${ not empty wrong }">用户名或密码错误</c:if>
			</p>
		</div>
	</div>
	<div class="span4"></div>
</body>
</html>