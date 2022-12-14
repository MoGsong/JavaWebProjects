<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Article"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.ArticleService"%>
<%@page import="com.gxnu.service.IArticleService"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String artPath = basePath + "Patient/";
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
        <title></title>
		
		<!-- Favicon -->
        <link rel="icon" href="img/favicon.png">
		
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=artPath%>css/bootstrap.min.css">
		<!-- Nice Select CSS -->
		<link rel="stylesheet" href="<%=artPath%>css/nice-select.css">
		<!-- Improve CSS -->
		<link rel="stylesheet" href="<%=artPath%>css/improve.css">
		<!-- Font Awesome CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/font-awesome.min.css">
		<!-- icofont CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/icofont.css">
		<!-- Slicknav -->
		<link rel="stylesheet" href="<%=artPath%>css/slicknav.min.css">
		<!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/owl-carousel.css">
		<!-- Datepicker CSS -->
		<link rel="stylesheet" href="<%=artPath%>css/datepicker.css">
		<!-- Animate CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/animate.min.css">
		<!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/magnific-popup.css">
		
		<!-- Medipro CSS -->
        <link rel="stylesheet" href="<%=artPath%>css/normalize.css">
        <link rel="stylesheet" href="<%=artPath%>style.css">
        <link rel="stylesheet" href="<%=artPath%>css/responsive.css">
		
		<!-- Color CSS -->
		<link rel="stylesheet" href="<%=artPath%>css/color/color1.css">
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color2.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color3.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color4.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color5.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color6.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color7.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color8.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color9.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color10.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color11.css">-->
		<!--<link rel="stylesheet" href="<%=artPath%>css/color/color12.css">-->

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
							<h2>??????????????????</h2>
							<ul class="bread-list">
								<li><a href="index.html">????????????</a></li>
								<li><i class="icofont-simple-right"></i></li>
								<li class="active">??????</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
				
		<!-- Service Details -->
		
		<!-- get???Servlet???????????????  ?????????String 
			?????????ArticleService ??????findByid??????
		-->
		<% 
		Object obj = request.getAttribute("ARTICLE");
		int articleid = Integer.parseInt((String)obj);
	    Article article = new ArticleService().find(articleid);
  		%> 
  		
        <div class="service-details-area section">
            <div class="container">
            
                
                    <h2><%=article.getTitle() %></h2>
                  	
					<div class="date_color2"></div>
					<p><%=article.getTime() %></p>
                    
                    <img src="<%=Data.URL%>/Doctor/static/picture/<%=article.getPic()%>" >
                    
                    
                    <p><%=article.getContent() %></p>
                    
                </div>
                
             
                <!-- <div class="row">
                    <div class="col-lg-5">
                        <div class="service-details-inner-left">
                            <img src="img/signup-bg.jpg" alt="#">
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="service-details-inner">
                            <h2>We always take care <br> our patient</h2>
                            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Architecto blanditiis obcaecati veritatis magnam pariatur molestiae in maxime. Animi quae vitae in inventore. Totam mollitia aspernatur provident veniam aperiam placeat impedit! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe rem natus nobis, dolorum nam excepturi iure autem nemo ducimus temporibus facere, est eum voluptatem, culpa optio fugit assumenda quod? Praesentium.</p>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Id, laudantium ullam, iure distinctio officia libero voluptatem obcaecati vero deleniti minima nemo itaque alias nisi eveniet soluta architecto quae laboriosam unde.</p>
                        </div>
                    </div>
                </div> -->
            </div>
        </div>
        <!-- End Service Details -->
		
		<!-- Footer Area -->
		<footer id="footer" class="footer ">
			<!-- Footer Top -->
			<div class="footer-top">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-12">
							<div class="single-footer">
								<h2>About Us</h2>
								<p>Lorem ipsum dolor sit am consectetur adipisicing elit do eiusmod tempor incididunt ut labore dolore magna.</p>
								<!-- Social -->
								<ul class="social">
									<li><a href="#"><i class="icofont-facebook"></i></a></li>
									<li><a href="#"><i class="icofont-google-plus"></i></a></li>
									<li><a href="#"><i class="icofont-twitter"></i></a></li>
									<li><a href="#"><i class="icofont-vimeo"></i></a></li>
									<li><a href="#"><i class="icofont-pinterest"></i></a></li>
								</ul>
								<!-- End Social -->
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-12">
							<div class="single-footer f-link">
								<h2>Quick Links</h2>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-12">
										<ul>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Home</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>About Us</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Services</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Our Cases</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Other Links</a></li>	
										</ul>
									</div>
									<div class="col-lg-6 col-md-6 col-12">
										<ul>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Consuling</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Finance</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Testimonials</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>FAQ</a></li>
											<li><a href="#"><i class="fa fa-caret-right" aria-hidden="true"></i>Contact Us</a></li>	
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-12">
							<div class="single-footer">
								<h2>Open Hours</h2>
								<p>Lorem ipsum dolor sit ame consectetur adipisicing elit do eiusmod tempor incididunt.</p>
								<ul class="time-sidual">
									<li class="day">Monday - Fridayp <span>8.00-20.00</span></li>
									<li class="day">Saturday <span>9.00-18.30</span></li>
									<li class="day">Monday - Thusday <span>9.00-15.00</span></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-3 col-md-6 col-12">
							<div class="single-footer">
								<h2>Newsletter</h2>
								<p>subscribe to our newsletter to get allour news in your inbox.. Lorem ipsum dolor sit amet, consectetur adipisicing elit,</p>
								<form action="mail/mail.php" method="get" target="_blank" class="newsletter-inner">
									<input name="email" placeholder="Email Address" class="common-input" onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Your email address'" required="" type="email">
									<button class="button"><i class="icofont icofont-paper-plane"></i></button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--/ End Footer Top -->
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
        <script src="<%=artPath%>js/jquery.min.js"></script>
		<!-- jquery Migrate JS -->
		<script src="<%=artPath%>js/jquery-migrate-3.0.0.js"></script>
		<!-- jquery Ui JS -->
		<script src="<%=artPath%>js/jquery-ui.min.js"></script>
		<!-- Easing JS -->
        <script src="<%=artPath%>js/easing.js"></script>
		<!-- Color JS -->
		<script src="<%=artPath%>js/colors.js"></script>
		<!-- Popper JS -->
		<script src="<%=artPath%>js/popper.min.js"></script>
		<!-- Bootstrap Datepicker JS -->
		<script src="<%=artPath%>js/bootstrap-datepicker.js"></script>
		<!-- Jquery Nav JS -->
        <script src="<%=artPath%>js/jquery.nav.js"></script>
		<!-- Slicknav JS -->
		<script src="<%=artPath%>js/slicknav.min.js"></script>
		<!-- ScrollUp JS -->
        <script src="<%=artPath%>js/jquery.scrollUp.min.js"></script>
		<!-- Niceselect JS -->
		<script src="<%=artPath%>js/niceselect.js"></script>
		<!-- Tilt Jquery JS -->
		<script src="<%=artPath%>js/tilt.jquery.min.js"></script>
		<!-- Owl Carousel JS -->
        <script src="<%=artPath%>js/owl-carousel.js"></script>
		<!-- counterup JS -->
		<script src="<%=artPath%>js/jquery.counterup.min.js"></script>
		<!-- Steller JS -->
		<script src="<%=artPath%>js/steller.js"></script>
		<!-- Wow JS -->
		<script src="<%=artPath%>js/wow.min.js"></script>
		<!-- Magnific Popup JS -->
		<script src="<%=artPath%>js/jquery.magnific-popup.min.js"></script>
		<!-- Counter Up CDN JS -->
		<script src="<%=artPath%>js/waypoints.min.js"></script>
		<!-- Bootstrap JS -->
		<script src="<%=artPath%>js/bootstrap.min.js"></script>
		<!-- Main JS -->
		<script src="<%=artPath%>js/main.js"></script>
    </body>
</html>