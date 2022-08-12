<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.service.imp.AboutService"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.IAboutService"%>
<%@page import="com.gxnu.entity.About"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
   //调用业务方法，检索所有菜单信息
   IAboutService aboutService = new AboutService();
   List<About> abouts = aboutService.find();
 
   %>
<!doctype html>
<html>
<head>
        <!-- Meta Tags -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="keywords" content="Site keywords here">
		<meta name="description" content="">
		<meta name='copyright' content=''>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Title -->
        <title>用户：关于医院</title>
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
</head>
<body>
	
	<!-- Breadcrumbs -->
		<div class="breadcrumbs overlay">
			<div class="container">
				<div class="bread-inner">
					<div class="row">
						<div class="col-12">
							<h2>关于医院</h2>
							<ul class="bread-list">
								<li><a href="main.html">首页</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">关于医院</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
		

	<section class="about-area section">
            <div class="container-fluid p-0">
                <div class="row m-0">
                    <div class="col-lg-13 col-md-12 p-0">
                        <div class="about-image">
                            <img src="assets/img/about-img1.jpg" alt="image">
                        </div>
                    </div>

					 <%
			            //循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
			            for(About about : abouts ) {
			          %>
                    <div class="col-lg-13 col-md-12 p-0">
                        <div class="about-content">
                            <span>关于医院</span>
                            <h2><%=about.getName() %></h2>
                            <p>——简介——</p>

                            <ul>
                                <li><textarea id="synopsis" type="text" class="form-control" rows="3" name="synopsis" style="width:100%;height: 550px" placeholder="<%=about.getSynopsis() %>"></textarea>
                                <script>
							        document.getElementById("text").value="{{synopsis}}"
							    </script></li>
                                  <li><img src="./img/department.jpg"  name="pic"  style="width:100%; height:380px "/></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End About Area -->

        <!-- Start Our Vision Area -->
        <section class="our-vision-area ptb-100 pt-0">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="single-vision-box">
                            <div class="icon">
                                <i class="icofont-tick-mark"></i>
                            </div>
                            <h3>医院发展历史：</h3>
                            <p>不要晒你的钱，在医院那就是纸；不要晒你的工作，倒下了，无数人会比你做得更出色；不要晒你的房，你走了，那就是别人的窝；不要晒你的车，你离开了，车钥匙就握在别人手里了。你唯一可以炫耀的是你的健康：当别人都走了，你还可以晒着太阳，喝着茶，享受着健康的生活。请善待自己，因为零件不好配，价格贵还没货。</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="single-vision-box">
                            <div class="icon">
                                <i class="icofont-tick-mark"></i>
                            </div>
                            <h3>规模等级：</h3>
                            <p>去医院体检，前面有个目测170多斤的妹子拿了报告说血脂厚。妹子说：难怪我180斤，原来是血重。我....</p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="single-vision-box">
                            <div class="icon">
                                <i class="icofont-tick-mark"></i>
                            </div>
                            <h3>师资力量：</h3>
                            <p>今天去医院已被确诊为抑郁症，情绪进入低谷状态，变的腼腆自闭，焦虑不安，希望朋友们可以请我出去吃吃饭，看看电影，喝喝咖啡，吃吃烤串，旅旅游，爬爬山，开导开导我。</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Our Vision Area -->

        <!-- Start Our Mission Area -->
        <div class="contact-info">
			<div class="row">
				<!-- single-info -->
				<div class="col-lg-4 col-12 ">
					<div class="single-info">
						<i class="icofont icofont-ui-call"></i>
						<div class="content">
							<h3><%=about.getTel() %></h3>
							<p>info@company.com</p>
						</div>
					</div>
				</div>
				<!--/End single-info -->
				<!-- single-info -->
				<div class="col-lg-4 col-12 ">
					<div class="single-info">
						<i class="icofont-google-map"></i>
						<div class="content">
							<h3><%=about.getAddress() %></h3>
							<p>Chittagonj, Lakshmipur</p>
						</div>
					</div>
				</div>
				<!--/End single-info -->
				<!-- single-info -->
				<div class="col-lg-4 col-12 ">
					<div class="single-info">
						<i class="icofont icofont-wall-clock"></i>
						<div class="content">
							<h3><%=about.getPostcode() %></h3>
							<p>Sunday Closed</p>
						</div>
					</div>
				</div>
				<!--/End single-info -->
			</div>
		</div><%} %>
        <!-- End Our Mission Area -->

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
    