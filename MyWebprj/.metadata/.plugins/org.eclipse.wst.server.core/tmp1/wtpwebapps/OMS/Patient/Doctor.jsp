<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="com.gxnu.service.IDoctorService"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<!-- Meta Tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="keywords" content="Site keywords here">
<meta name="description" content="">
<meta name='copyright' content=''>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Title -->
<title>医生信息</title>
<!-- Favicon -->
<link rel="icon" href="img/favicon.png">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap"
	rel="stylesheet">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Nice Select CSS -->
<link rel="stylesheet" href="css/nice-select.css">
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- icofont CSS -->
<link rel="stylesheet" href="css/icofont.css">
<!-- Slicknav -->
<link rel="stylesheet" href="css/slicknav.min.css">
<!-- Owl Carousel CSS -->
<link rel="stylesheet" href="css/owl-carousel.css">
<!-- Datepicker CSS -->
<link rel="stylesheet" href="css/datepicker.css">
<!-- Animate CSS -->
<link rel="stylesheet" href="css/animate.min.css">
<!-- Magnific Popup CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Medipro CSS -->
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/responsive.css">

</head>
<body>

	<!-- Breadcrumbs -->
	<div class="breadcrumbs overlay">
		<div class="container">
			<div class="bread-inner">
				<div class="row">
					<div class="col-12">
						<h2>医生</h2>
						<ul class="bread-list">
							<li><a href="index.html">科室</a></li>
							<li><i class="icofont-simple-right"></i></li>
							<li class="active">医生信息</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumbs -->
	<%
		IDoctorService doctorService = new DoctorService();
		List<Doctor> doctors = doctorService.find();
		for (Doctor doctor : doctors) {
	%>
	<!-- Doctor Details -->
	<div class="doctor-details-area section">
		<div class="container">
			<div class="row">
				<!--修改图片 改变尺寸请修改col-lg-?语句-->
				<div class="col-lg-5">
					<div class="doctor-details-item doctor-details-left">
						<img src="<%=Data.URL%>/<%=doctor.getPic()%>" alt="#">
						<div class="doctor-details-contact">
							<h3>相关信息</h3>
							<ul class="basic-info">
								<li><i class="icofont-ui-call"></i> 电话 : <%=doctor.getTel() %></li>
								<li><i class="icofont-ui-message"></i> 邮箱：<%=doctor.getEmail() %></li>

							</ul>

							<div class="doctor-details-work">
								<h3>工作时间</h3>
								<ul class="time-sidual">
									<li class="day">星期一 - 星期五 <span>8.00-20.00</span></li>
									<li class="day">星期四 <span>9.00-18.30</span></li>
									<li class="day">星期一 - 星期四 <span>9.00-15.00</span></li>
									<li class="day">星期一 - 星期三 <span>8.00-20.00</span></li>
								</ul>
							</div>

						</div>
					</div>
				</div>
				<div class="col-lg-7">
					<div class="doctor-details-item">
						<div class="doctor-details-right">
							<div class="doctor-name">
								<h3 class="name">医生姓名：<%=doctor.getName() %></h3>
								<p class="deg">性别：<%=doctor.getSex() %></p>
								<p class="deg">年龄：<%=doctor.getAge() %></p>

							</div>
							<div class="doctor-details-biography">
								<h3>所在科室</h3>
								<p><%=doctor.getUnit().getName() %></p>
								<br>
								<p>儿科是全面研究小儿时期身心发育、保健以及疾病防治的综合医学科学。 凡涉及 儿童 和 青少年 时期的健康与卫生问题都属于儿科范围。 其医治的对象处于生长发育期。</p>
							</div>
							<div class="doctor-details-biography">
								<h3>职位</h3>
								<p><%=doctor.getPost().getPost() %></p>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Doctor Details -->
	<%
		}
	%>



	<!-- jquery Min JS -->
	<script src="js/jquery.min.js"></script>
	<!-- jquery Migrate JS -->
	<script src="js/jquery-migrate-3.0.0.js"></script>
	<!-- jquery Ui JS -->
	<script src="js/jquery-ui.min.js"></script>
	<!-- Easing JS -->
	<script src="js/easing.js"></script>
	<!-- Color JS -->
	<script src="js/colors.js"></script>
	<!-- Popper JS -->
	<script src="js/popper.min.js"></script>
	<!-- Bootstrap Datepicker JS -->
	<script src="js/bootstrap-datepicker.js"></script>
	<!-- Jquery Nav JS -->
	<script src="js/jquery.nav.js"></script>
	<!-- Slicknav JS -->
	<script src="js/slicknav.min.js"></script>
	<!-- ScrollUp JS -->
	<script src="js/jquery.scrollUp.min.js"></script>
	<!-- Niceselect JS -->
	<script src="js/niceselect.js"></script>
	<!-- Tilt Jquery JS -->
	<script src="js/tilt.jquery.min.js"></script>
	<!-- Owl Carousel JS -->
	<script src="js/owl-carousel.js"></script>
	<!-- counterup JS -->
	<script src="js/jquery.counterup.min.js"></script>
	<!-- Steller JS -->
	<script src="js/steller.js"></script>
	<!-- Wow JS -->
	<script src="js/wow.min.js"></script>
	<!-- Magnific Popup JS -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Counter Up CDN JS -->
	<script src="js/waypoints.min.js"></script>
	<!-- Bootstrap JS -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
</body>
</html>
