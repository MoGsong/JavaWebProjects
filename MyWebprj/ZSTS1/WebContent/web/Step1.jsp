<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.Date"%>
<%@page import="com.gxnu.entity.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.Roleservice"%>
<%@page import="com.gxnu.service.IRoleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Step1</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">
<link href="css/style.css?v=2.2.0" rel="stylesheet">

<style type="text/css">
body {
	background-color: white
}
</style>

<%
String url = Data.URL+"/authorization?OP=toupdate";
%>
</head>
<body>
	<div id="wrapper">
		<form method="post" class="form-horizontal"
			action=<%=url %>>

			<div class="ibox-content">
				<div class="form-group">
					<label class="col-sm-2 control-label">角色选择</label>
					<div class="col-sm-10">
						<select class="form-control m-b" name="roleid"
							style="width: 200px;">
							<%
								IRoleService irs = new Roleservice();
								List<Role> roles = irs.find();
								for (Role role : roles) {
							%>
							<option value="<%=role.getId()%>"><%=role.getName()%>
							</option>
							<%
								}
							%>

						</select>
					</div>
				</div>

				<!-- 横线 -->
				<div class="hr-line-dashed"></div>
				<div style="margin-left: 170px">
					<div class="col-sm-8">
						<input type="submit" class="btn btn-primary" value="确定" />
					</div>
				</div>
		</form>
	</div>





	<!-- Mainly scripts -->
	<script src="js/jquery-2.1.1.min.js"></script>



	<!-- iCheck -->
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>

</body>
</html>