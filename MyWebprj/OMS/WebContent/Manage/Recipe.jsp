<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Recipe"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.RecipeService"%>
<%@page import="com.gxnu.service.IRecipeService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js" lang="en" dir="ltr">



<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>:: 处方信息</title>
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
<%
	String url = Data.URL;
%>
<body>
	<form class="form-horizontal m-t" id="frm"
		action="<%=url%>/recipes?OP=delete" method="post">
		<div id="ihealth-layout" class="theme-tradewind">

			<!-- sidebar -->


			<!-- main body area -->
			<div class="main px-lg-4 px-md-4">



				<!-- Body: Body -->
				<div class="body d-flex py-lg-3 py-md-2">
					<div class="container-xxl">
						<div class="row align-items-center">
							<div class="border-0 mb-4">
								<div
									class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
									<h3 class="fw-bold mb-0">处方信息</h3>
									<div class="col-auto d-flex w-sm-100"></div>
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
													<th scope="col">处方日期</th>
													<th scope="col">取药码</th>
													<th scope="col">患者</th>
													<th scope="col">诊断医师</th>
													<th scope="col">基本操作</th>
												</tr>
											</thead>
											<tbody>
												<%
													int i = 0;
													IRecipeService recipeService = new RecipeService();
													List<Recipe> recipes = recipeService.find();
													for (Recipe recipe : recipes) {
														i++;
												%>
												<tr>
													<td><span scope="col"><%=i%></span></td>
													<td><span scope="col"><%=recipe.getTime()%></span></td>
													<td><span scope="col"><%=recipe.getProof()%></span></td>
													<td><span scope="col"><%=recipe.getPatient().getName()%></span>
													</td>
													<td><span scope="col"><%=recipe.getDoctor().getName()%></span>
													</td>

													<td>
														<div class="btn-group" role="group"
															aria-label="Basic outlined example">
															<!-- 隐藏作用域 -->
															<input type="hidden" name="id"
																value="<%=recipe.getId()%>" />
															<button type="submit" class="btn btn-outline-secondary ">
																<i class="icofont-ui-delete text-danger"></i>
																</button>
														</div>
													</td>
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


				<!-- 添加处方-->


				<!-- 编辑处方-->

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
	</form>
</body>

</html>