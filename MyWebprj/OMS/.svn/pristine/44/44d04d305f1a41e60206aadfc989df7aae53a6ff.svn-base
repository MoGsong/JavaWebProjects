<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.entity.Post"%>
<%@page import="com.gxnu.service.imp.PostService"%>
<%@page import="com.gxnu.service.IPostService"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<%
	String url = Data.URL;
%>
<%
	Object obj = request.getAttribute("DOCTOR");
	Doctor doctor = new Doctor();
	if (obj != null) {
		doctor = (Doctor) obj;
	}
%>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>:: 医生信息修改</title>

<!-- project css file  -->
<link rel="stylesheet"
	href="<%=Data.URL%>/Manage/static/css/ihealth.style.min.css">
</head>

<body>

	<div id="ihealth-layout" class="theme-tradewind">

		<!-- sidebar -->

		<!-- main body area -->
		<div class="main px-lg-4 px-md-4">

			<!-- Body: Header -->


			<!-- Body: Body -->
			<div class="body d-flex py-3">
				<div class="container-xxl">
					<div class="row align-items-center">
						<div class="border-0 mb-4">
							<div
								class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
								<h3 class="fw-bold mb-0">医生编辑</h3>
							</div>
						</div>
					</div>
					<!-- Row end  -->
					<div class="row mb-3">
						<div class="col-sm-12">
							<div class="card mb-3">
								<div
									class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
									<h6 class="mb-0 fw-bold ">医生基础信息</h6>
								</div>

								<div class="card-body">
									<form class="form-horizontal m-t"
										action="<%=url%>/doctor?OP=doupdate" method="post"
										enctype="multipart/form-data">
										<div class="row g-3 align-items-center">
											<div class="col-md-6">
												<label for="firstname" class="form-label">姓名</label> <input
													type="text" class="form-control" name="name" required=""
													value="<%=doctor.getName()%>">
											</div>

											<div class="col-md-6">
												<label for="phonenumber" class="form-label">电话号码</label> <input
													type="text" class="form-control" name="tel" required=""
													value="<%=doctor.getTel()%>">
											</div>
											<div class="col-md-6">
												<label for="emailaddress" class="form-label">邮箱</label> <input
													type="email" class="form-control" name="email" required=""
													value="<%=doctor.getEmail()%>">
											</div>
											<div class="col-md-6">
												<label for="admittime" class="form-label">年龄</label> <input
													type="text" class="form-control" name="age" required=""
													value="<%=doctor.getAge()%>">
											</div>
											<div class="col-md-6">
												<label for="admittime" class="form-label">账号</label> <input
													type="text" class="form-control" name="username"
													required="" value="<%=doctor.getUsername()%>">
											</div>
											<div class="col-md-6">
												<label for="admittime" class="form-label">密码</label> <input
													type="password" class="form-control" name="password"
													required="" value="<%=doctor.getPassword()%>">
											</div>
											<div class="col-md-6">
												<label for="admittime" class="form-label">科室</label>
												<div class="col-md-6">
													<select class="form-control" name="unit">
														<%
															IUnitService ius = new UnitService();
															List<Unit> units = ius.findAll();
															for (Unit unit : units) {
														%>
														<option value="<%=unit.getId()%>"
															<%if (doctor.getUnit().getId() == unit.getId())
					out.print("selected='selected'");%>><%=unit.getName()%>
														</option>
														<%
															}
														%>

													</select>
												</div>
											</div>
											<div class="col-md-6">
												<label for="admittime" class="form-label">职位</label>
												<div class="col-md-6">

													<select class="form-control" name="post">
														<%
															IPostService ips = new PostService();
															List<Post> posts = ips.find();
															for (Post post : posts) {
														%>
														<option value="<%=post.getId()%>"
															<%if (doctor.getPost().getId() == post.getId())
					out.print("selected='selected'");%>><%=post.getPost()%>
														</option>
														<%
															}
														%>

													</select>
												</div>
											</div>
											<div class="col-md-6">
												<label for="formFileMultiple" class="form-label"> 头像</label>
												<input class="form-control" type="file" name="pic"
													multiple="" required="">
											</div>
											<div class="col-md-6">
												<label class="form-label">性别</label>
												<div class="row">
													<div class="col-md-6">
														<div class="form-check">
															<input class="form-check-input" type="radio" name="sex"
																id="exampleRadios11" value="男" checked=""> <label
																class="form-check-label" for="exampleRadios11">
																男 </label>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-check">
															<input class="form-check-input" type="radio" name="sex"
																id="exampleRadios22" value="女"> <label
																class="form-check-label" for="exampleRadios22">
																女 </label>
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-12">
												<label for="addnote" class="form-label">备注</label>
												<textarea class="form-control" name="addnote" rows="3"></textarea>
											</div>
										</div>
										<!-- 隐藏作用域，用于不需要显示的数据随表单提交 -->
										<input type="hidden" name="id" value="<%=doctor.getId()%>" />
										<button type="submit" class="btn btn-primary mt-4">提交</button>
									</form>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>

			<!-- Modal Custom Settings-->

		</div>

	</div>

	<!-- Jquery Core Js -->
	<script src="<%=Data.URL%>/Manage/static/js/libscripts.bundle.js"></script>


	<!-- Jquery Page Js -->
	<script src="<%=Data.URL%>/Manage/static/js/template.js"></script>


</body>
</html>
