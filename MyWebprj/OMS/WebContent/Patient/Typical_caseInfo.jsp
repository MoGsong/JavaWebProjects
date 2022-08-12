<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.service.ITypical_caseService"%>
<%@page import="com.gxnu.entity.Typical_case"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.Typical_caseService"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String tyPath = basePath + "Patient/";
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
		<link rel="stylesheet" href="<%=tyPath%>css/bootstrap.min.css">
		<!-- Nice Select CSS -->
		<link rel="stylesheet" href="<%=tyPath%>css/nice-select.css">
		<!-- Font Awesome CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/font-awesome.min.css">
		<!-- icofont CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/icofont.css">
		<!-- Slicknav -->
		<link rel="stylesheet" href="<%=tyPath%>css/slicknav.min.css">
		<!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/owl-carousel.css">
		<!-- Datepicker CSS -->
		<link rel="stylesheet" href="<%=tyPath%>css/datepicker.css">
		<!-- Animate CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/animate.min.css">
		<!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/magnific-popup.css">
		
		<!-- Medipro CSS -->
        <link rel="stylesheet" href="<%=tyPath%>css/normalize.css">
        <link rel="stylesheet" href="<%=tyPath%>style.css">
        <link rel="stylesheet" href="<%=tyPath%>css/responsive.css">
		
		<!-- Color CSS -->
		<link rel="stylesheet" href="<%=tyPath%>css/color/color1.css">
		<!--<link rel="stylesheet" href="css/color/color2.css">-->
		<!--<link rel="stylesheet" href="css/color/color3.css">-->
		<!--<link rel="stylesheet" href="css/color/color4.css">-->
		<!--<link rel="stylesheet" href="css/color/color5.css">-->
		<!--<link rel="stylesheet" href="css/color/color6.css">-->
		<!--<link rel="stylesheet" href="css/color/color7.css">-->
		<!--<link rel="stylesheet" href="css/color/color8.css">-->
		<!--<link rel="stylesheet" href="css/color/color9.css">-->
		<!--<link rel="stylesheet" href="css/color/color10.css">-->
		<!--<link rel="stylesheet" href="css/color/color11.css">-->
		<!--<link rel="stylesheet" href="css/color/color12.css">-->

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
							<h2>案例信息</h2>
							<ul class="bread-list">
								<li><a href="index.html">首页</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">案例详情</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		
<% 
	Object obj = request.getAttribute("TypicalCase");

	int typical_caseid = Integer.parseInt((String)obj);
	Typical_case typical_case = new Typical_caseService().find(typical_caseid);
%> 
		<!-- Single News -->
		<section class="news-single section">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-12">
						<div class="row">
							<div class="col-12">
								<div class="single-main">
									
									
									<!-- News Title -->
									<h1 class="news-title"><%=typical_case.getTitle() %></a></h1>
									<!-- Meta -->
									<div class="meta">
										<div class="meta-left">
											
											<span class="date"><i class="fa fa-clock-o"></i>（<%=typical_case.getDate() %>）</span>
										</div>
										
									</div>
									<!-- News Text -->
									<div class="news-text">
									 <textarea id="content" type="text" class="form-control" rows="3" name="content" 
									  placeholder="<%=typical_case.getContent()%>" style="width: 1000px;height: 1500px"></textarea>
									 <script>
								        document.getElementById("text").value="{{content}}"
								     </script>
									
										
												
						
									<div class="single-image">
										<img src="<%=Data.URL%>/Patient/img/<%=typical_case.getPic()%>" >
									</div>
								
										
										</div>
									
								</div>
							</div>
							
		<!-- jquery Min JS -->
        <script src="<%=tyPath%>js/jquery.min.js"></script>
		<!-- jquery Migrate JS -->
		<script src="<%=tyPath%>js/jquery-migrate-3.0.0.js"></script>
		<!-- jquery Ui JS -->
		<script src="<%=tyPath%>js/jquery-ui.min.js"></script>
		<!-- Easing JS -->
        <script src="<%=tyPath%>js/easing.js"></script>
		<!-- Color JS -->
		<script src="<%=tyPath%>js/colors.js"></script>
		<!-- Popper JS -->
		<script src="<%=tyPath%>js/popper.min.js"></script>
		<!-- Bootstrap Datepicker JS -->
		<script src="<%=tyPath%>js/bootstrap-datepicker.js"></script>
		<!-- Jquery Nav JS -->
        <script src="<%=tyPath%>js/jquery.nav.js"></script>
		<!-- Slicknav JS -->
		<script src="<%=tyPath%>js/slicknav.min.js"></script>
		<!-- ScrollUp JS -->
        <script src="<%=tyPath%>js/jquery.scrollUp.min.js"></script>
		<!-- Niceselect JS -->
		<script src="<%=tyPath%>js/niceselect.js"></script>
		<!-- Tilt Jquery JS -->
		<script src="<%=tyPath%>js/tilt.jquery.min.js"></script>
		<!-- Owl Carousel JS -->
        <script src="<%=tyPath%>js/owl-carousel.js"></script>
		<!-- counterup JS -->
		<script src="<%=tyPath%>js/jquery.counterup.min.js"></script>
		<!-- Steller JS -->
		<script src="<%=tyPath%>js/steller.js"></script>
		<!-- Wow JS -->
		<script src="<%=tyPath%>js/wow.min.js"></script>
		<!-- Magnific Popup JS -->
		<script src="<%=tyPath%>js/jquery.magnific-popup.min.js"></script>
		<!-- Counter Up CDN JS -->
		<script src="<%=tyPath%>js/waypoints.min.js"></script>
		<!-- Bootstrap JS -->
		<script src="<%=tyPath%>js/bootstrap.min.js"></script>
		<!-- Main JS -->
		<script src="<%=tyPath%>js/main.js"></script>
    </body>
</html>