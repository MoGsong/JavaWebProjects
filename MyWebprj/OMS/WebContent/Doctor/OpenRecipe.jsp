<%@page import="com.gxnu.entity.Patient"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>:: 开电子处方</title>

<!-- project css file  -->
<link rel="stylesheet" href="static/css/ihealth.style.min.css">

<%
	Object obj1 = session.getAttribute(Data.DOCTOR);
	Doctor doctor = new Doctor();
	if (obj1 != null) {
		doctor = (Doctor) obj1;
	}

	Object obj2 = session.getAttribute(Data.PATIENT);
	Patient patient = new Patient();
	if (obj2 != null) {
		patient = (Patient) obj2;
	}
%>

<script>
	function tj() {
		//根据id获取html页面中的表单，并提交
		window.document.getElementById("frm").submit();
	}
</script>
</head>
<body>
	<form class="form-horizontal m-t" id="frm"
		action="<%=Data.URL%>/recipe?OP=new" method="post">
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
									class="card-header no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
									<h3 class="fw-bold mb-0 py-3 pb-2">开电子处方</h3>
								</div>
							</div>
						</div>
						<input type="hidden" name="doctorid" value="<%=doctor.getId()%>" />
						<input type="hidden" name="patientid"
							value="<%=patient.getId()%>" />
						<!-- Row end  -->
						<button type="button"
							class="btn btn-primary btn-set-task w-sm-100" onclick="tj()">
							<i class="icofont-plus-circle me-2 fs-6"></i>前往开处方
						</button>

					</div>
				</div>

			</div>
		</div>

		<!-- Jquery Core Js -->
		<script src="static/js/libscripts.bundle.js"></script>

		<!-- Jquery Page Js -->
		<script src="static/js/template.js"></script>
	</form>
</body>
</html>