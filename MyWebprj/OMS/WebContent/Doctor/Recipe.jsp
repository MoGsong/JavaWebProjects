<%@page import="com.gxnu.entity.Patient"%>
<%@page import="java.util.Collections"%>
<%@page import="com.gxnu.entity.OutStore"%>
<%@page import="com.gxnu.service.imp.OutStoreService"%>
<%@page import="com.gxnu.service.IOutStoreService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.OutDetail"%>
<%@page import="com.gxnu.entity.Inventory"%>
<%@page import="com.gxnu.service.imp.InventoryService"%>
<%@page import="com.gxnu.service.IInventoryService"%>
<%@page import="com.gxnu.entity.Measure"%>
<%@page import="com.gxnu.service.imp.MeasureService"%>
<%@page import="com.gxnu.service.IMeasureService"%>
<%@page import="com.gxnu.entity.DrugInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.DrugInfoService"%>
<%@page import="com.gxnu.service.IDrugInfoService"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<%
//获取请求转发信息
	Object obj = request.getAttribute("OUTDETAIL");
	List<OutDetail> outDetails = new ArrayList<OutDetail>();
	if (obj != null) {
		outDetails = (List<OutDetail>) obj;
	}

%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
//获取病人登录信息
	Object obj2 = session.getAttribute(Data.PATIENT);
	Patient patient = new Patient();
	if (obj2 != null) {
		patient = (Patient) obj2;
	}
	
%>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>:: --电子处方</title>
<!-- Summernote css -->
<link href="<%=Data.URL%>/Doctor/static/css/summernote-bs4.css" rel="stylesheet"
	type="text/css">
<!-- plugin css file  -->
<link rel="stylesheet" href="<%=Data.URL%>/Doctor/static/css/responsive.dataTables.min.css">
<link rel="stylesheet" href="<%=Data.URL%>/Doctor/static/css/dataTables.bootstrap5.min.css">
<!-- project css file  -->
<link rel="stylesheet" href="<%=Data.URL%>/Doctor/static/css/ihealth.style.min.css">
<!-- Bootstrap Css -->
<link href="<%=Data.URL%>/Doctor/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<!-- Icons Css -->
<link href="<%=Data.URL%>/Doctor/static/css/icons.min.css" rel="stylesheet" type="text/css">
<!-- App Css-->
<link href="<%=Data.URL%>/Doctor/static/css/app.min.css" rel="stylesheet" type="text/css">
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
								<h3 class="fw-bold mb-0">电子处方</h3>
								<div class="col-auto d-flex w-sm-100">
									<button type="button"
										class="btn btn-primary btn-set-task w-sm-100"
										data-bs-toggle="modal" data-bs-target="#depadd">
										<i class="icofont-plus-circle me-2 fs-6"></i>添加
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
												<th scope="col">药品名称</th>
												<th scope="col">数量</th>
												<th scope="col">单位</th>
												<th scope="col">用法</th>
												<th scope="col">价格</th>
												<th scope="col">基本操作</th>
											</tr>
										</thead>
										<tbody>
											<%int i=0;
											IOutStoreService outStoreService =new OutStoreService();
											List<OutStore> outStores = outStoreService.findAll();
											List<Integer> nums = new ArrayList<Integer>();
											for(OutStore outStore : outStores) {
												nums.add(outStore.getId());
											}
											int maxId = Collections.max(nums);//获取出库表最大id
												for (OutDetail outDetail : outDetails) {
													++i;
													if(outDetail.getOutStore().getId()==maxId){
														int tprice = outDetail.getSprice()*outDetail.getNum();
											%>
											<tr>
												<td><span class="fw-bold"><%=i%></span></td>
												<td><span class="fw-bold ms-1"><%=outDetail.getInventory().getDrugInfo().getName() %></span></td>
												<td><span class="fw-bold"><%=outDetail.getNum()%></span></td>
												<td><span class="fw-bold"><%=outDetail.getInventory().getMeasur().getName()%></span></td>
												<td><span class="fw-bold"><%=outDetail.getTusage()%></span></td>
												<td><span class="fw-bold"><%=tprice%></span></td>
												<td>
													<div class="btn-group" role="group"
														aria-label="Basic outlined example">
														
														<button type="button"
															class="btn btn-outline-secondary ">
															<a h><i class="icofont-ui-delete text-danger"></i></a>
														</button>
													</div>
												</td>
											</tr>
											<%
													}}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- Row End -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">取消</button>
					<a href="<%=Data.URL%>/recipe?OP=send&tel=<%=patient.getTel()%>&id=<%=patient.getId()%>"><button type="button" class="btn btn-primary">保存</button></a>
				</div>
			</div>

			<!-- Modal Custom Settings-->


			<!-- 添加药品-->
			<div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
				<div
					class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title  fw-bold" id="depaddLabel">添加药品</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="deadline-form">
								<form action="<%=Data.URL%>/recipe?OP=adddrug" method="post"
									id="addfrm">
									<div class="mb-3">
										<label for="exampleFormControlInput1111" class="form-label">药品名</label>
										<div class="col-md-6">
											<select name="druginfo" class="form-control" id="druginfo"
												onchange="xxx()">
												<option value="0" selected="selected">--请选择药品--</option>
												<%
													//查询所有药品  获取动态权限，添加下拉框
													IDrugInfoService drugInfoService = new DrugInfoService();
													List<DrugInfo> drugInfos = drugInfoService.findAll();
													//查询库存表，获取药品数量
													IInventoryService inventoryService = new InventoryService();
													List<Inventory> inventorys = inventoryService.find();
													for (DrugInfo drugInfo : drugInfos) {
												%>
												<option value="<%=drugInfo.getId()%>"><%=drugInfo.getName()%>
												</option>
												<%
													}
												%>
											</select>&nbsp;&nbsp;
										</div>
										<div class="col-sm-6">
											<label for="depone" class="form-label">库存数量</label> <input
												type="text" class="form-control" id="have" readonly="ture"
												name="have">
										</div>
									</div>

									<div class="col-sm-6">
										<label for="depone" class="form-label">数量</label> <input
											type="text" class="form-control" name="num">
									</div>
									<div class="col-sm-6">
										<label for="deptwo" class="form-label">单位</label>
										<div class="col-md-6">
											<select name="measure" class="form-control">

												<%
													//查询所有单位  获取动态权限，添加下拉框
													IMeasureService measureService = new MeasureService();
													List<Measure> measures = measureService.find();
													for (Measure measure : measures) {
												%>
												<option value="<%=measure.getId()%>"><%=measure.getName()%>
												</option>
												<%
													}
												%>
											</select>&nbsp;&nbsp;
										</div>
									</div>

									<label for="depthree" class="form-label">用法</label>
									<textarea class="form-control" rows="3"
										style="width: 300px; height: 150px" name="use"></textarea>
									<div class="col-sm-6">
										<label for="deptwo" class="form-label">单价</label> <input
											type="text" class="form-control" id="price" name="price" readonly="ture">
									</div>
									<!-- end row -->
									<!-- end row -->
									<!-- end container-fluid -->
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">取消</button>
							<input type="button" class="btn btn-primary" value="添加"
								onclick="tj()" />
						</div>
					</div>
				</div>
			</div>

			<!-- 编辑-->
			
		</div>
	</div>

	<!-- Jquery Core Js -->
	<script src="<%=Data.URL%>/Doctor/static/js/libscripts.bundle.js"></script>
	<!-- JAVASCRIPT -->
	<script src="<%=Data.URL%>/Doctor/static/js/jquery.min.js"></script>
	<script src="<%=Data.URL%>/Doctor/static/js/bootstrap.bundle.min.js"></script>
	<script src="<%=Data.URL%>/Doctor/static/js/metisMenu.min.js"></script>
	<script src="<%=Data.URL%>/Doctor/static/js/simplebar.min.js"></script>
	<script src="<%=Data.URL%>/Doctor/static/js/waves.min.js"></script>

	<script src="<%=Data.URL%>/Doctor/static/js/bundle.js"></script>

	<!-- Summernote js -->
	<script src="<%=Data.URL%>/Doctor/static/js/summernote-bs4.min.js"></script>

	<!-- init js -->
	<script src="<%=Data.URL%>/Doctor/static/js/summernote.init.js"></script>

	<script src="<%=Data.URL%>/Doctor/static/js/app.js"></script>

	<!-- Plugin Js-->
	<script src="<%=Data.URL%>/Doctor/static/js/dataTables.bundle.js"></script>

	<!-- Jquery Page Js -->
	<script src="<%=Data.URL%>/Doctor/static/js/template.js"></script>
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
	<script>
		function xxx(){
			alert("成功喽");
			 var myselect=document.getElementById("druginfo");
			 var index = myselect.selectedIndex;  // selectedIndex是所选中的项的index
			$.ajax({
				async:	false,			//默认为true，即请求为异步请求
				timeout:5000,			//设置请求超时时间（毫秒）
				dataType:"json",		//返回的数据类型
				type:	"post",			//设置请求方式
				url:	"<%=basePath%>/ajax", //设置请求URL
				data : "option=" + myselect.options[index].value, //设置传递的参数值
				success : function(msg) { //设置响应成功之后执行的回调函数

					$("#have").val(msg.num);
					$("#price").val(msg.xprice);

				},
				error : function() { //设置响应失败之后执行的回调函数
					alert("失败喽");
				}
			});
		}
	</script>
	<script>
		function tj() {
			//根据id获取html页面中的表单，并提交
			window.document.getElementById("addfrm").submit();
		}
	</script>
</body>

</html>