<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
        * {margin: 0;padding: 0;}
        .container {
            width: 220px;
            margin-right: 35px;
            background: #ebf2fa;
            border: 1px solid #d4d4d4;
            border-bottom-color: #AAA;
            border-top: 0;
            box-shadow: 0 1px 1px #CCC;/*阴影*/
            margin:1 1 0 0;
              }
        .login-form {padding: 20px 15px 15px;}
        .login-form dl {line-height: 24px;}
        .login-form dl.pwd {margin: 15px 0 0;}
        .bottom {margin-top: 15px;}
        .top dd,.pwd dd{
     width: 186px;
    background: #FFF ;
    border: 1px solid #adb6c9;
     border-radius: 3px;
     height: 32px;
    box-shadow: 0 0 1px #FFF;
      padding: 1px;
     }
     .login-form .input-text {
     background: transparent;/*背景透明*/
     font-size: 14px;
     height: 32px;
    line-height: 32px;
     padding: 0;
     margin: 0 0 0 30px;
     width: 155px;
     border: 0;
      }
     .login-btn {
     width: 190px;
     height: 38px;
     border: 0;
     background: url(http://img.mukewang.com/539a972b00013e9102280177.jpg) no-repeat;
     cursor: pointer;/*鼠标变手*/
     }
     .regnow {
       margin: 0 15px;
       padding: 17px 0 15px;
       }
      .regnow input{
      background-position: 0 -38px;
       border: 0;
      padding: 0 0 3px 0;
      }
      .rbkw dd{
        font-size: 13px;
       padding-top:15px;
     }
     .rbkw dd a{
      float:right;
     text-decoration:none;
     }
     hr{
     width: 190px;
      margin:auto;
      }
 </style>
        <body>
      <div class="container">
        <form method="post" class="login-form" action="user-manage.do">
      <dl class="top clearfix">
         <dd>
             <input type="text" name="student_num" class="input-text" >
         </dd>
      </dl>
     <dl class="pwd clearfix">
            <dd>
               <input type="password" name="password" class="input-text">
       </dl>
       <dl class="rbkw">
          <dd>
             <input type="checkbox" value="1"  name="kw" /> 下次自动登录     <a href="#">忘记密码？</a>
         </dd>
                </dl>
        <dl class="bottom">
                        <input type="submit" class="input-submit login-btn" value="">
                </dl>
                </form>
                <hr/>
                <div class="regnow">
                        <input type="button" class="input-button login-btn" value="" >
                </div>
            </div>
            ${user.role } 
            ${user.userName }
            </body>
</html>