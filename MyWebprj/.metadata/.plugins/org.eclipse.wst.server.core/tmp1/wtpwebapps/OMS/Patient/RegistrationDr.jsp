<%@page import="com.gxnu.service.imp.PatientService"%>
<%@page import="com.gxnu.entity.Patient"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.entity.Schedule"%>
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
							<h2>????????????</h2>
							<ul class="bread-list">
								<li><a href="index.html">????????????</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">??????????????????</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		
		<%
		Patient patient = new PatientService().find(2);
		HttpSession loginses = request.getSession();
		loginses.setAttribute("PATIENT", patient);
		%>
		
		<!-- Start Appointment -->
		<section class="appointment single-page">
			<form class="form" action="<%=Data.URL %>/RegistrationPatient?OP=pay" method="post">
				<div class="container">
					<div class="row">
						<div class=" col-md-12 col-12">
							<div class="appointment-inner">
								<div class="title">
									<h3>????????????</h3>
									<p>?????????????????????????????????????????????????????????????????????????????????</p>
								</div>
								<%
								//??????session??????unitId??????????????????????????????????????????
								HttpSession getUnitId = request.getSession();
								Object obj = getUnitId.getAttribute("UNITID");
								int flag = 0;
							 	if(obj!= null){
							 		int unitId = (int)obj;
							 		System.out.println("??????Dr???unitId???"+ unitId);
							 		//?????????????????????????????????
							 		int i = 0;
							 		//??????unitId??????????????????????????????
							 		List<Doctor> doctors = new DoctorService().findByUnit(unitId);
							 		//????????????doctors
							 		for (Doctor doctor : doctors) {
							 			System.out.printf("?????????????????????"+ doctor.toString());
							 			//???????????????id??????????????????????????????
							 			List<Schedule> schedules = new ScheduleService().findByDoctorId(doctor.getId());
							 			if(schedules != null){
							 				//????????????schedules
								 			for (Schedule schedule : schedules) {
								 				System.out.println("?????????????????????"+ schedule.getId());
								 				//?????????????????????
								 				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
								 				//???Timestamp?????????Date???????????????
								 				Date dateNew = new Date(timestamp.getTime());
								 				Date dateSchu = new Date(schedule.getDay().getTime());
								 				System.out.println("?????????????????????????????????"+ dateSchu);
								 				//????????????????????????long?????????????????????????????????
								 				double lag = dateSchu.getTime() - dateNew.getTime();
								 				System.out.println("???????????????"+ (lag/86400000) +"???");
								 				//?????????????????????????????????
								 				if((lag/86400000) >= 0 && (lag/86400000) <= 3){
								 					System.out.println("???????????????????????????"+ schedule.getPeriod());
								 					SimpleDateFormat ft = new SimpleDateFormat ("MM-dd");
								 					flag++;
								 				%>
													<div class="box">
												        <input type="radio"  id="radio<%=++i %>"  name="scheduleId"  checked="checked" value="<%=schedule.getId() %>"/>
												        <label for="radio<%=i %>"><%=i %>&nbsp;&nbsp;<%=doctor.getName() %> &nbsp;&nbsp;<%=ft.format(dateSchu) %>&nbsp;&nbsp;<%=schedule.getPeriod() %>&nbsp;&nbsp;<%=doctor.getPost().getPrice() %></label>
												    </div>
								<%				}
								 			}
							 			}
							 		}
							 		if(flag == 0){%>
							 			<div class="title">
							 			<h3>&nbsp;</h3>
										<h3 align="center">??????????????????????????????????????????????????????</h3>
										</div>
										<div class="row">
										<div class="col-12">
												<div class="form-group">
													<div class="button">
														<button onclick="window.location.href='RegistrationUnit.jsp'" class="btn">??????????????????</button>
													</div>
												</div>
											</div>
										</div>	
							 		<%}else{%>
							 			<div class="form-group">
		                                     <span class="form-timename">???????????????????????????????????????9???00-12???00????????????15???00-17???00</span>
		                                     <div class="">
		                                         <input name="selectTime" class="form-control" type="time" max="17:00" min="09:00" value="09:00:00" id="example-time-input">
		                                     </div>
		                                 </div>
		                                 <div class="row">
										<div class="col-12">
												<div class="form-group">
													<div class="button">
														<button type="submit" class="btn">????????????</button>
													</div>
												</div>
											</div>
										</div>	
							 		<%}
							 	}
								
								%>
                                 
							</div>
						</div>
					</div>
				</div>
				
			</form>
		</section>
		<!--/End Appointment -->
		
		
		
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