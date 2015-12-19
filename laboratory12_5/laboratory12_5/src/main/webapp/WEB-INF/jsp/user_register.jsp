<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实验注册</title>
<link rel="stylesheet" href="css/register.css">
<!-- <link rel="stylesheet" href="css/bootstrap.css"> -->
</head>
<body>
	<header id="header">
		<div class="top">
			<ul>
				<li class="active"><a><span data-hover="注册">注册</span></a></li>
				<li>|</li>
				<li><a href="login_in.html"><span data-hover="登录">登陆</span></a></li>
				<li>|</li>
				<li><a href="##"><span data-hover="联系我们">联系我们</span></a></li>
			</ul>
		</div>
	</header>

	<hr>

	<section id="center">
		<div class="top">
			<img src="./img/logo.png" style="margin-top: 10px;height: 56px">
			<h1 class="logo" style="display:inline">实验中心</h1>
		</div>
		<div class="center">
			<h2 class="subject">电子信息与通信工程学科</h2>
		</div>

		<hr>

		
		<div class="login">
		  <form class="registerform" action="user-register.do" method="post"> 
			<div class="row input-group" id="login_in">
				<label>学号:</label>
				<input type="text" name="student_num" id="group" placeholder="学号" onfocus="if(placeholder=='学号'){
				this.style.color='black';placeholder=''}" onblur="if(placeholder==''){
				this.style.color='gray';placeholder='学号'}">
			</div>
			<div class="row input-group" id="login_in">
				<label>姓名:</label>
				<input type="text"   name="user_name" id="group" placeholder="姓名" onfocus="if(placeholder=='邮箱'){
				this.style.color='black';placeholder=''}" onblur="if(placeholder==''){
				this.style.color='gray';placeholder='姓名'}">
			</div>
			<div class="row input-group" id="login_in">
				<label>卡号:</label>
				<input type="text"  name="cardcode"  id="group" placeholder="一卡通号" onfocus="if(placeholder=='一卡通号'){
				this.style.color='black';placeholder=''}" onblur="if(placeholder==''){
				this.style.color='gray';placeholder='一卡通号'}">
			</div>
			<div class="row input-group" id="login_in">
				<label>密码:</label>
				<input type="password" name="password" id="group" placeholder="密码" onfocus="if(placeholder=='密码'){
				this.style.color='black';placeholder=''}" onblur="if(placeholder==''){
				this.style.color='gray';placeholder='密码'}">
			</div>
			<div class="row input-group" id="login_in">
				<label>邮箱:</label>
				<input type="email" name="email"  id="group" placeholder="邮箱" onfocus="if(placeholder=='邮箱'){
				this.style.color='black';placeholder=''}" onblur="if(placeholder==''){
				this.style.color='gray';placeholder='邮箱'}">
			</div>
			<div class="row input-group" id="login_in">
				<label>电话:</label>
				<input type="phone" name="phone" class="phone" id="group" placeholder="电话">
			</div>
			<button class="btn" type="submit"><a href="##"><strong>注册</strong></a></button>
            </form>		
		</div>
	</section>
	<br>
	<hr>

	<footer id="footer">
		<div class="top">
			<div>
				<ul class="right">
					<li><a href="##">友情链接</a></li>
					<li><a href="##">联系我们</a></li>
				</ul>
			</div>
		</div>

		<div class="bottom">
			<div class="footer_bottom">
				<ul>
					<li>电子信息与通信工程专业实验教学中心 版权所有</li>
					<li>Copyright @2013 陕ICP备02184(05016169)</li>
				</ul>
			</div>
		</div>
	</footer>

</body>
</html>