<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String url = Data.URL + "/ForgetPwdAction"; %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>邮箱验证找回密码</title>
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
 <style>
 body {
	background-size: cover;
	background-image: url("images/back1.jpg");
	background-repeat: no-repeat;
	background-position: right top;
	background-attachment: fixed;
}
 </style>
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div style="height:150px;"></div>
                <span style="font-family: 华文行楷;font-size: 36px">找回密码</span>
            </div>
            <form class="m-t" role="form" action=<%=url %> method="post">
                <div class="form-group">
                    <input type="text" name="USER" class="form-control" placeholder="请输入用户名" required="true">
                </div>
                <div class="form-group">
                    <input type="email" name="EMAIL" class="form-control" placeholder="请输入邮箱" required="true">
                </div>
                <!--此处点击跳转Servlet，验证用户身份 -->
                <button type="submit" class="btn btn-primary block full-width m-b">验 证</button>
            </form>
        </div>
    </div>
</body>
</html>
