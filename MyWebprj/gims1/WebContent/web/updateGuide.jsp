<%@page import="com.gxnu.entity.Guide"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>图片管理</title>
<style>
body {
	background-size: cover;
	background-color: #191e4537;
	background-repeat: no-repeat;
	background-position: right top;
	background-attachment: fixed;
}
</style>
<%
	Object obj = request.getAttribute("GUIDE");
	Guide guide = new Guide();
	if (obj != null) {
		guide = (Guide) obj;
	}
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
</head>
<body>
	<form id="frm"
		action="http://192.168.1.202:8080/GIMS/guide?OP=doupdate"
		method="post" enctype="multipart/form-data">
		<div
			style="width: 400px; height: 180px; margin: 0px auto; text-align: center;">
			<h1>编辑图片</h1>

			<table
				style="border-style: solid; width: 300px; height: 100px; background-color: white; margin: 0px auto;"
				border="1">
				<tr style="width: 40%;">
					<td><span>图片</span></td>
					<td><img
						src="http://192.168.1.202:8080/GIMS/web/images/<%=guide.getName()%>"
						style="width: 40px" /></td>
				</tr>
				<tr style="width: 40%;">
					<td><span>新图片</span></td>
					<td><input type="file" name="pic_name" style="border: none;"/></td>
					    <input type="hidden" name="uuu" value="<%=guide.getName()%>"/>
				</tr>
				<tr>
					<td><span>跳转链接</span></td>
					<td><input type="text" value="<%=guide.getURL()%>" name="url"
						style="border: none;" /></td>
				</tr>
			</table>
		</div>
		<br>
		<div style="text-align: center;">
			<!-- 隐藏作用域，用于不需要显示的数据随表单提交 -->
			<input type="hidden" name="id" value="<%=guide.getId()%>" /> <input
				type="submit" value="修改" />
		</div>
	</form>
</body>
</html>