<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.service.ITypical_caseService"%>
<%@page import="com.gxnu.entity.Typical_case"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.Typical_caseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	 String path = request.getContextPath();
	 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 	 String url = Data.URL+"/typical_caseshow";
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
		
		<!-- Color CSS -->
		<link rel="stylesheet" href="css/color/color1.css">
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
		<script>
		 function tj(){
		    	//根据id获取html页面中的表单，并提交
		    	window.document.getElementById("frm").submit();
		    }
		</script>
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
							<h2>经典病例</h2>
							<ul class="bread-list">
								<li><a href="index.html">首页</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">经典病例</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		
		<!-- <div class="col-lg-12 col-12">
			<div class="main-sidebar"> -->
				<!-- Single Widget -->
				<!-- <div class="single-widget search">
					<div class="form">
						<input type="email" placeholder="Search Here...">
						<a class="button" href="#"><i class="fa fa-search"></i></a>
					</div>
				</div> -->
				
		<!-- Single News -->
		<section class="blog grid section">
			<div class="container">
				<div class="row">
					<div class="col-lg-12 col-12">
						<div class="row">
							 <%
							       ITypical_caseService typical_caseService = new Typical_caseService();
							     
							       List<Typical_case> typical_cases = typical_caseService.find();
							       
							       int i =1;
							       for(Typical_case typical_case:typical_cases){
							   %>
							<div class="col-lg-6 col-md-6 col-12">
								<!-- Single Blog -->
								<div class="single-news">
									<div class="news-head">
										<img src="<%=Data.URL%>/Patient/img/<%=typical_case.getPic()%>" alt="#">
									</div>
									<div class="news-body">
										<div class="news-content">
											<div class="date"><%=typical_case.getTitle() %></div>
											<h2><a href="<%=Data.URL %>/typical_caseShow?OP=show&TypicalCaseID=<%=typical_case.getId() %>" onclick="tj()"><%=typical_case.getTitle() %></a></h2>
											
										</div>
									</div>
								</div>
								<!-- End Single Blog -->
							</div>

							<%i++;} %>
								<!--/ End Pagination -->
							</div>
						</div>
					</div>
				</div>
		</section>
		<!--/ End Single News -->
		
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