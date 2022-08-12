<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		Doctor doctor =new Doctor();
		Object obj = session.getAttribute(Data.DOCTOR);
		if (obj != null) {
			doctor = (Doctor) obj;
		}   
%>
 
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>在线医疗 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
</head>
<body>

<div id="ihealth-layout" class="theme-tradewind">
    
    <!-- sidebar -->
    <div class="sidebar px-4 py-4 py-md-5 me-0">
        <div class="d-flex flex-column h-100">
            <a href="" class="mb-0 brand-icon">
                <span class="logo-icon">
                    <i class="icofont-heart-beat fs-2"></i>
                </span>
                <span class="logo-text">菜单</span>
            </a>
            <!-- Menu: main ul -->

            <ul class="menu-list flex-grow-1 mt-3">
                <li class="collapsed">
                    <a class="m-link" data-bs-toggle="collapse" data-bs-target="#authorization" href="#" target="IFrameBox" >
                        <i class="icofont-stamp"></i> <span>在线问诊</span> <span
                            class="arrow icofont-rounded-down ms-auto text-end fs-5"></span></a>
                    <!-- 在线问诊 子菜单 -->
                    <ul class="sub-menu collapse" id="authorization">
                        <li><a class="ms-link" href="<%=Data.URL%>/Doctor/Registration.jsp" target="IFrameBox">预约问诊</a></li>
                       
                        <li><a class="ms-link" href="<%=Data.URL%>/Doctor/OpenRecipe.jsp" target="IFrameBox"> 开处方</a></li>
                    </ul>
                </li>
                <li class="collapsed">
                    <a class="m-link" data-bs-toggle="collapse" data-bs-target="#menu-Patient" href="#" target="IFrameBox">
                        <i class="icofont-crutch"></i> <span>患者信息</span> <span
                            class="arrow icofont-rounded-down ms-auto text-end fs-5"></span></a>
                    <!--患者 子菜单 -->
                    <ul class="sub-menu collapse" id="menu-Patient">
                        <li><a class="ms-link" href="Patient.jsp" target="IFrameBox">查看患者信息</a></li>
                    </ul>
                </li>
                <li class="collapsed">
                    <a class="m-link" data-bs-toggle="collapse" data-bs-target="#menu-Doctor" href="#" target="IFrameBox">
                        <i class="icofont-doctor"></i> <span>科普文章</span> <span
                            class="arrow icofont-rounded-down ms-auto text-end fs-5"></span></a>
                    <!--科普文章 子菜单 -->
                      <ul class="sub-menu collapse" id="menu-Doctor">
                        <li><a class="ms-link" href="<%=Data.URL%>/Doctor/Article.jsp" target="IFrameBox">查看科普文章</a></li>
                    </ul>
                </li>
                <li class="collapsed">
                    <a class="m-link" data-bs-toggle="collapse" data-bs-target="#schedule" href="#" target="IFrameBox">
                        <i class="icofont-ui-calendar"></i> <span>排班信息</span> <span
                            class="arrow icofont-rounded-down ms-auto text-end fs-5"></span></a>
                    <!--排班 子菜单 -->
                    <ul class="sub-menu collapse " id="schedule">
                        <li><a class="ms-link" href="<%=Data.URL%>/Doctor/Schedule.jsp" target="IFrameBox">查看排班信息</a></li>
                    </ul>
                </li>
            </ul>
            
            <!-- Menu: menu collepce btn -->
        </div>
    </div>
    <!-- main body area -->
    <div class="main px-lg-4 px-md-4">
        <!-- Body: Header -->
        <div class="header">
            <nav class="navbar py-4">
                <div class="container-xxl">
                    <!-- header rightbar icon -->
                    <div class="h-right d-flex align-items-center mr-5 mr-lg-0 order-1">
                        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover">
                            <div class="u-info me-2">
                                <p class="mb-0 text-end line-height-sm "><span class="font-weight-bold"><%=doctor.getName() %></span></p>
                                
                            </div>
                            <a class="nav-link dropdown-toggle pulse p-0" href="#" role="button" data-bs-toggle="dropdown" data-bs-display="static">
                                <img class="avatar lg rounded-circle img-thumbnail" src="<%=Data.URL %>/<%=doctor.getPic()%>" alt="profile">
                            </a>
                            <div class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0">
                                <div class="card border-0 w280">
                                    <div class="card-body pb-0">
                                        <div class="d-flex py-1">
                                            <img class="avatar rounded-circle" src="static/picture/profile_av.png" alt="profile">
                                            <div class="flex-fill ms-3">
                                                <p class="mb-0"><span class="font-weight-bold"><%=doctor.getName() %></span></p>
                                                <small class=""><%=doctor.getEmail()%></small>
                                            </div>
                                        </div>
                                        <div><hr class="dropdown-divider border-dark"></div>
                                    </div>
                                    <div class="list-group m-2 ">
                                        <a href="<%=Data.URL%>/Doctor/doctorss.jsp" target="IFrameBox" class="list-group-item list-group-item-action border-0 "><i class="icofont-ui-video-chat fs-5 me-3" ></i>个人信息修改</a>
                                        <a href="<%=Data.URL%>/Doctor/Login.jsp" class="list-group-item list-group-item-action border-0 "><i class="icofont-logout fs-6 me-3"></i>退出</a>
                                        <div><hr class="dropdown-divider border-dark"></div>
                                       
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="setting ms-2">
                            <a href="#" data-bs-toggle="modal" data-bs-target="#Settingmodal"><i class="icofont-gear-alt fs-5"></i></a>
                        </div>
                    </div>
                    <!-- main menu Search-->
                    <div class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
                        <div class="input-group flex-nowrap input-group-lg">
                            <input type="search" class="form-control" placeholder="Search" aria-label="search" aria-describedby="addon-wrapping">
                            <button type="button" class="input-group-text" id="addon-wrapping"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                </div>
            </nav>
        </div>  
        <!--中间内容显示-->   
        <div style="padding: 0px; width: 100%; height: 800px;">
            <iframe name="IFrameBox" src="<%=Data.URL%>/Doctor/Welcome.jsp" frameborder="1"
                width="100%" height="100%" scrolling="No" noresize="noresize"></iframe>
        </div>
       
    </div>
  
</div>

<!-- Jquery Core Js -->
<script src="static/js/libscripts.bundle.js"></script>

<!-- Plugin Js -->
<script src="static/js/apexcharts.bundle.js"></script>
<script src="static/js/jquery-ui.min.js"></script>
<script src="static/js/owl.carousel.js"></script>
<script src="static/js/dataTables.bundle.js"></script>      

<!-- Jquery Page Js -->
<script src="static/js/template.js"></script>
<script src="static/js/index.js"></script>
 <script>
      $('#myDataTable')
      .addClass( 'nowrap' )
      .dataTable( {
          responsive: true,
          columnDefs: [
              { targets: [-1, -3], className: 'dt-body-right' }
          ]
      });
 </script>
</body>
</html> 