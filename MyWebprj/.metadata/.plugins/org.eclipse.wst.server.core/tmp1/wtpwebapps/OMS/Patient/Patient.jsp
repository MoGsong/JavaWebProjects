<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Patient"%>
<%@page import="com.gxnu.service.imp.PatientService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <%
    //PatientService patientDAO=new PatientService();//调用业务方法

    //Patient patient=patientDAO.find(2);
    
 Object obj = session.getAttribute(Data.PATIENT);
 Patient patient = new Patient();
 if(obj!=null){
     patient=(Patient)obj; 
 }
 System.out.println(patient+"88888888888888888888");
      %>	           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
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
			<script >
function tjj(){
	//获取html页面中的表单
	window.document.getElementById("jsjs").submit();
}
</script>
</head>
<body>
<!-- 
<body style="overflow:hidden">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
  <tr>
    <td width="171" id=frmTitle noWrap name="fmTitle" align="center" valign="top"><table width="171" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
      <tr>
        <td  bgcolor="#1873aa" style="width:6px;">&nbsp;</td>
        <td width="165"><iframe name="I1" height="100%" width="165" src="left.html" border="0" frameborder="0" scrolling="no"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
      </tr>
    </table>		</td>
    <td width="6"  style="width:6px;"valign="middle" bgcolor="1873aa" onclick=switchSysBar()><SPAN class=navPoint 
id=switchPoint title=关闭/打开左栏><img src="images/main_55.gif" name="img1" width=6 height=40 id=img1></SPAN></td>
    <td width="100%" align="center" valign="top"><iframe name="I2" height="100%" width="100%" border="0" frameborder="0" src="tab/tab.html"> 浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
  </tr>
</table> -->
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
							<h2>个人信息修改</h2>
							<ul class="bread-list">
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Breadcrumbs -->
				
		<!-- Shop Register -->
		<section class="register section">
			<div class="container">
				<div class="inner">
					<div class="row"> 
						<div class="col-lg-6">							
								<!-- Form -->
								<form class="form" id="jsjs" action="<%=Data.URL%>/patient?OP=exits" method="post" enctype="multipart/form-data">
								
									<div class="row">
										<div class="col-lg-12" >
											
											    <label class="form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
												&nbsp;<input type="text" name="name" placeholder="姓名" value="<%=patient.getName()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >								
											    <label class="form-label">姓&nbsp;&nbsp;&nbsp;&nbsp;别: </label>
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="sex" placeholder="性别"  value="<%=patient.getSex()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >											
											<label class="form-label">年&nbsp;&nbsp;&nbsp;&nbsp;龄: </label>
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="age" placeholder="年龄" value="<%=patient.getAge()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >
											<label class="form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码: </label>
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="password" placeholder="密码" value="<%=patient.getPassword()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >
											<label class="form-label">身&nbsp;份&nbsp;证: </label>
												&nbsp;&nbsp;<input type="text" name="idcard" placeholder="身份证" value="<%=patient.getIdcard()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >
										<label class="form-label">电&nbsp;&nbsp;&nbsp;&nbsp;话: </label>
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="tel" placeholder="电话" value="<%=patient.getTel()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12">
										<label class="form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;箱: </label>
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" placeholder="邮箱" value="<%=patient.getEmail()%>">
											</div>
										</div>
										
										<div class="row">
										<div class="col-lg-12" >
										<label class="form-label" >头&nbsp;&nbsp;&nbsp;&nbsp;象: </label>									
												<input type="file" name="pic"/>
											  <img src="http://localhost:8080/OMS/<%=patient.getPic()%>" style="width:40px;" />
											</div>
										</div>
										
											<div class="row">								
										    <div class="col-lg-12" >
										    
											<label class="form-label">预&nbsp;&nbsp;&nbsp;&nbsp;留: </label>	
												&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="yuliu" placeholder="预留" value="<%=patient.getYuliu()%>">
												
											</div>
										</div>
										
										<div class="col-12">
											<div class="form-group login-btn">
											<!-- 隐藏作用域，通过要把一个不需要的数据随同它一起使用表单进行提交 -->
                                                  <input type="hidden" name="id" value="<%=patient.getId()%>"/>
                                                  <input type="hidden" name="username" value="<%=patient.getUsername()%>"/>
											     <input type="button" onclick="tjj()" value="确定修改"/>   <a href="<%=Data.URL %>/Patient/main.jsp">返回主页</a>
											</div>
											
										</div>
									</div>
								</form>
								<!--/ End Form -->
							</div>
						</div>
					</div>
				</div>
		
		</section>
		<!--/ End Register -->
		<!-- 
		Footer Area
		<footer id="footer" class="footer ">
			Footer Top
			<div class="footer-top">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 col-md-6 col-12">
							<div class="single-footer">
								<h2>About Us</h2>
								<p>Lorem ipsum dolor sit am consectetur adipisicing elit do eiusmod tempor incididunt ut labore dolore magna.</p>
								Social
								<ul class="social">
									<li><a href="#"><i class="icofont-facebook"></i></a></li>
									<li><a href="#"><i class="icofont-google-plus"></i></a></li>
									<li><a href="#"><i class="icofont-twitter"></i></a></li>
									<li><a href="#"><i class="icofont-vimeo"></i></a></li>
									<li><a href="#"><i class="icofont-pinterest"></i></a></li>
								</ul>
								End Social
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
			/ End Footer Top
			Copyright
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
			/ End Copyright
		</footer>
		/ End Footer Area
		 -->
		
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