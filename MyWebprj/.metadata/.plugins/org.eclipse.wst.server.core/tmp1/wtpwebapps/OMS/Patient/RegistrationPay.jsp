<%@page import="java.text.DateFormat"%>
<%@page import="com.gxnu.entity.Registration"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.ScheduleService"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String tabPath = basePath + "Patient/";
%>
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <!-- Meta Tags -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="keywords" content="Site keywords here">
		<meta name="description" content="">
		<meta name='copyright' content=''>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Title -->
        <title></title>
		
		<!-- Favicon -->
        <link rel="icon" href="img/favicon.png">
		
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=tabPath %>css/bootstrap.min.css">
		<!-- Nice Select CSS -->
		<link rel="stylesheet" href="<%=tabPath %>css/nice-select.css">
		<!-- Improve CSS -->
		<link rel="stylesheet" href="<%=tabPath %>css/improve.css">
		<!-- Font Awesome CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/font-awesome.min.css">
		<!-- icofont CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/icofont.css">
		<!-- Slicknav -->
		<link rel="stylesheet" href="<%=tabPath %>css/slicknav.min.css">
		<!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/owl-carousel.css">
		<!-- Datepicker CSS -->
		<link rel="stylesheet" href="<%=tabPath %>css/datepicker.css">
		<!-- Animate CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/animate.min.css">
		<!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/magnific-popup.css">
		
		<!-- Medipro CSS -->
        <link rel="stylesheet" href="<%=tabPath %>css/normalize.css">
        <link rel="stylesheet" href="<%=tabPath %>style.css">
        <link rel="stylesheet" href="<%=tabPath %>css/responsive.css">
		
		<!-- Color CSS -->
		<link rel="stylesheet" href="<%=tabPath %>css/color/color1.css">

		<link rel="stylesheet" href="#" id="colors">
		
    </head>
    <body>
	
		<!-- Preloader -->
        <div class="preloader">
            <div class="loader">
                <div class="loader-outter"></div>
                <div class="loader-inner"></div>

                <div class="indicator"> 
                    <svg width="16px" height="12px">
                        <polyline id="back" points="1 6 4 6 6 11 10 1 12 6 15 6"></polyline>
                        <polyline id="front" points="1 6 4 6 6 11 10 1 12 6 15 6"></polyline>
                    </svg>
                </div>
            </div>
        </div>
        <!-- End Preloader -->
		
		
		<!-- Breadcrumbs -->
		<div class="breadcrumbs overlay">
			<div class="container">
				<div class="bread-inner">
					<div class="row">
						<div class="col-12">
							<h2>预约挂号</h2>
							<ul class="bread-list">
								<li><a href="index.html">支付预约费</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">支付成功</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		<%
		//获取session对象，获取之前存储的Registration信息
		HttpSession registrationSession = request.getSession();
		Registration registration = (Registration)registrationSession.getAttribute("REGISTRATION");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		%>
		<!-- Start Appointment -->
		<section class="appointment single-page">
				<div class="container">
					<div class="row">
						<div class=" col-md-12 col-12">
							<div class="appointment-inner">
								<div class="title">
									<h3>预约成功</h3>
									<p>亲爱的患者朋友您好，恭喜你预约成功！</p>
									<p>您的预约的时间是：<%=format.format(registration.getReserve_time())%>。请您及时登录系统进行线上问诊哦</p>
								</div>
								
                                 <div class="row">
									<div class="col-12">
										<div class="form-group">
											<div class="button">
												<button onclick="window.top.location.href='main.jsp'" class="btn">返回首页</button>
											</div>
										</div>
									</div>
								</div>	
							</div>
						</div>
					</div>
				</div>
				
		</section>
		<!--/End Appointment -->
		
		
			<!-- Copyright -->
			<div class="copyright">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-12">
							<div class="copyright-content">
								<p>Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/ End Copyright -->
		</footer>
		<!--/ End Footer Area -->
		
		<!-- jquery Min JS -->
        <script src="<%=tabPath %>js/jquery.min.js"></script>
		<!-- jquery Migrate JS -->
		<script src="<%=tabPath %>js/jquery-migrate-3.0.0.js"></script>
		<!-- jquery Ui JS -->
		<script src="<%=tabPath %>js/jquery-ui.min.js"></script>
		<!-- Easing JS -->
        <script src="<%=tabPath %>js/easing.js"></script>
		<!-- Color JS -->
		<script src="<%=tabPath %>js/colors.js"></script>
		<!-- Popper JS -->
		<script src="<%=tabPath %>js/popper.min.js"></script>
		<!-- Bootstrap Datepicker JS -->
		<script src="<%=tabPath %>js/bootstrap-datepicker.js"></script>
		<!-- Jquery Nav JS -->
        <script src="<%=tabPath %>js/jquery.nav.js"></script>
		<!-- Slicknav JS -->
		<script src="<%=tabPath %>js/slicknav.min.js"></script>
		<!-- ScrollUp JS -->
        <script src="<%=tabPath %>js/jquery.scrollUp.min.js"></script>
		<!-- Niceselect JS -->
		<script src="<%=tabPath %>js/niceselect.js"></script>
		<!-- Tilt Jquery JS -->
		<script src="<%=tabPath %>js/tilt.jquery.min.js"></script>
		<!-- Owl Carousel JS -->
        <script src="<%=tabPath %>js/owl-carousel.js"></script>
		<!-- counterup JS -->
		<script src="<%=tabPath %>js/jquery.counterup.min.js"></script>
		<!-- Steller JS -->
		<script src="<%=tabPath %>js/steller.js"></script>
		<!-- Wow JS -->
		<script src="<%=tabPath %>js/wow.min.js"></script>
		<!-- Magnific Popup JS -->
		<script src="<%=tabPath %>js/jquery.magnific-popup.min.js"></script>
		<!-- Counter Up CDN JS -->
		<script src="<%=tabPath %>js/waypoints.min.js"></script>
		<!-- Bootstrap JS -->
		<script src="<%=tabPath %>js/bootstrap.min.js"></script>
		<!-- Main JS -->
		<script src="<%=tabPath %>js/main.js"></script>
    </body>
</html>