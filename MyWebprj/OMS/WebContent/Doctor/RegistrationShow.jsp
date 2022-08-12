<%@page import="com.gxnu.entity.Registration"%>
<%@page import="com.gxnu.service.imp.RegistrationService"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.service.IArticleService"%>
<%@page import="com.gxnu.entity.Article"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.ArticleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String url = Data.URL + "/article";
%>

<%
	
	HttpSession doctorSession = request.getSession();
	Object obj = doctorSession.getAttribute(Data.DOCTOR);
	Doctor doctor = new Doctor();
	if (obj != null) {
		doctor = (Doctor) obj;
	}
	System.out.println("这里是预约信息的医生："+ doctor.toString());
%>

<!Doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>查看预约信息</title>
<!-- Summernote css -->
<link href="static/css/summernote-bs4.css" rel="stylesheet"
	type="text/css">
<!-- plugin css file  -->
<link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
<link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
<!-- project css file  -->
<link rel="stylesheet" href="static/css/ihealth.style.min.css">
<!-- Bootstrap Css -->
<link href="static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- Icons Css -->
<link href="static/css/icons.min.css" rel="stylesheet" type="text/css">
<!-- App Css-->
<link href="static/css/app.min.css" rel="stylesheet" type="text/css">


</head>


<body>

	<div id="ihealth-layout" class="theme-tradewind">

		<!-- sidebar -->

		<!-- main body area -->
		<div class="main px-lg-4 px-md-4">

			<!-- Body: Header -->


			<!-- Body: Body -->
			<div class="body d-flex py-lg-3 py-md-2">
				<div class="container-xxl">
					<div class="row align-items-center">
						<div class="border-0 mb-4">
							<div
								class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
								<h3 class="fw-bold mb-0">预约信息</h3>
								<div class="col-auto d-flex w-sm-100">
									<button type="button"
										class="btn btn-primary btn-set-task w-sm-100"
										data-bs-toggle="modal" data-bs-target="#depadd">

										<i class="icofont-plus-circle me-2 fs-6"></i> 添加
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Row end  -->
					<div class="row clearfix g-3">
						<div class="col-sm-12">
							<div class="card mb-3">
								<div class="card-body">
									<table id="myProjectTable"
										class="table table-hover align-middle mb-0"
										style="width: 100%">
										<thead>
											<tr>
												<th scope="col">序号</th>
												<th scope="col">患者名字</th>
												<th scope="col">患者性别</th>
												<th scope="col">患者年龄</th>
												<th scope="col">患者联系方式</th>
												<th scope="col">预约时间</th>
												<th scope="col">预约编号</th>
											</tr>

										</thead>
										<%
											RegistrationService registrationService = new RegistrationService();
											List<Registration> registrations = registrationService.findByDoctorId(doctor.getId());
											System.out.println("测试：" + registrations.toString());
											int i = 1;
											for (Registration registration : registrations) {
												System.out.println("预约信息测试：" + registration.toString());
										%>
										<tbody>
											<tr>
												<td><span class="fw-bold"><%=i++%></span></td>
												<td><span class="fw-bold ms-1"><%=registration.getPatient().getName()%></span></td>
												<td><span class="fw-bold ms-1"><%=registration.getPatient().getSex()%></span></td>
												<td><span class="fw-bold ms-1"><%=registration.getPatient().getAge()%></span></td>
												<td><%=registration.getPatient().getTel()%></td>
												<td><%=registration.getReserve_time()%></td>
												<td><%=registration.getNumber()%></td>
											</tr>

											<%
												}
											%>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- Row End -->
				</div>
			</div>

			<!-- Modal Custom Settings-->

			


		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="static/js/libscripts.bundle.js"></script>
	<!-- JAVASCRIPT -->
	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.bundle.min.js"></script>
	<script src="static/js/metisMenu.min.js"></script>
	<script src="static/js/simplebar.min.js"></script>
	<script src="static/js/waves.min.js"></script>

	<script src="static/js/bundle.js"></script>

	<!-- Summernote js -->
	<script src="static/js/summernote-bs4.min.js"></script>

	<!-- init js -->
	<script src="static/js/summernote.init.js"></script>

	<script src="static/js/app.js"></script>

	<!-- Plugin Js-->
	<script src="static/js/dataTables.bundle.js"></script>

	<!-- Jquery Page Js -->
	<script src="static/js/template.js"></script>
	<script>
		function tj() {
			//根据id获取html页面中的表单，并提交
			window.document.getElementById("addfrm").submit();
		}

		//删除
		function remove(url) {
			window.location.href = url;
		}

		//编辑方法
		function edit(obj, id) {
			var $td = $(obj).parents('tr').children('td');

			var title = $td.eq(1).text().replace(/\s*/g, "");
			var content = $td.eq(2).text().replace(/\s*/g, "");
			var pic = $td.eq(3).text().replace(/\s*/g, "");
			var author = $td.eq(4).text().replace(/\s*/g, "");
			var time = $td.eq(5).text().replace(/\s*/g, "");
			//alert(tel);

			//var i= address.toString();

			$("#ID").val(id);
			//  $("#updateName").css('color','red').val("qqq"+tel);
			$("#updatetitle").val(title);
			$("#updatecontent").val(content);
			$("#updatepic").val(pic);
			//  $("#updateTel").css('color','red').css('text-align','left');
			$("#updateauthor").val(author);
			$("#updatetime").val(time);

		}
		// project data table
		$(document).ready(function() {
			$('#myProjectTable').addClass('nowrap').dataTable({
				responsive : true,
				columnDefs : [ {
					targets : [ -1, -3 ],
					className : 'dt-body-right'
				} ]
			});
			$('.deleterow').on('click', function() {
				var tablename = $(this).closest('table').DataTable();
				tablename.row($(this).parents('tr')).remove().draw();

			});
		});
	</script>
</body>

</html>