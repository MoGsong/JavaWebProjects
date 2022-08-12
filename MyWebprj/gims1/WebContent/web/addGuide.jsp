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
<script>
	function tj() {
		//根据id获取html页面中的表单，并提交
		window.document.getElementById("frm").submit();
	}
	
</script>

</head>
<body>
	<form id="frm" action="http://192.168.1.202:8080/GIMS/guide?OP=add" method="post"  enctype="multipart/form-data">
		
		<div
			style="width: 400px; height: 180px; margin: 0px auto; text-align: center;">
			<h1>图片管理</h1>

			<table
				style="border-style: solid; width: 300px; height: 100px; background-color: white; margin: 0px auto;"
				border="1">
				<tr style="width: 40%;">
					<td><span>图片名</span></td>
					<td><input type="file"  name="pic_name"
						style="border: none;" /></td>
				</tr>
				<tr>
					<td><span>跳转链接</span></td>
					<td><input type="text"  name="url"
						style="border: none;" /></td>
				</tr>
			</table>
		</div>
		<br>
		<div style="text-align: center;">
			<input type="button" value="添加" onclick="tj()"/>
		</div>
</body>
</html>