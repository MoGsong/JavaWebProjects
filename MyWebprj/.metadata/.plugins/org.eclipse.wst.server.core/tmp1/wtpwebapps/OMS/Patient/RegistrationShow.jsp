<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.org.apache.regexp.internal.recompile"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="com.gxnu.service.imp.RegistrationService"%>
<%@page import="com.gxnu.entity.Registration"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Patient"%>
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
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color2.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color3.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color4.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color5.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color6.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color7.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color8.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color9.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color10.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color11.css">-->
		<!--<link rel="stylesheet" href="<%=tabPath %>css/color/color12.css">-->

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
		
		<%
		Object obj = request.getAttribute(Data.REGISTRATION);
		List<Registration> registrations = new ArrayList<>();
		if(obj!=null){
			registrations=(List<Registration>)obj; 
		}
		System.out.println(registrations.toString());
		%>
		
		<!-- Breadcrumbs -->
		<div class="breadcrumbs overlay">
			<div class="container">
				<div class="bread-inner">
					<div class="row">
						<div class="col-12">
							<h2>??????????????????</h2>
							<ul class="bread-list">
								<li><a href="index.html">??????</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">??????????????????</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		
		 <!-- Start Faq -->
        <section class="faq-area section">
            <div class="container">
                <div class="row faq-wrap">
                    <div class="col-lg-12">
                        <div class="faq-head">
                            <h2>????????????????????????</h2>
                        </div>
                        <div class="faq-item">
                            <ul class="accordion">
                            	<%
                            	if(registrations != null){
                            		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            		int i = 3;
                            		for(Registration registration : registrations){
                            		
                            	%>
                                <li class="wow fadeInUp" data-wow-delay=".3s">
                                    <a>???????????????<%=new DoctorService().find(registration.getDoctor().getId()).getName() %>&nbsp;&nbsp;??????????????????<%=df.format(registration.getReserve_time()) %></a>
                                    <p>????????????????????????<%=registration.getNumber() %>&nbsp;&nbsp;??????????????????<%=new DoctorService().find(registration.getDoctor().getId()).getPost().getPrice() %>
                                    &nbsp;&nbsp;????????????????????????<%=registration.getPay_time() %></p>
                                    
                                    &nbsp;&nbsp;<a target="IFrameBox" href="<%=Data.URL%>/login?registrationId=<%=registration.getId() %>&patientId=<%=registration.getPatient().getId() %>">???????????????</a>
                                    
                                </li>
                                <%
                            		}
                            	}else{
                                %>
                                <p>???????????????????????????</p>
                                <%} %>
                            </ul>
                        </div>
                    </div>
                </div>
                
                
            </div>
        </section>
        <!-- End Faq -->
		
		
		
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