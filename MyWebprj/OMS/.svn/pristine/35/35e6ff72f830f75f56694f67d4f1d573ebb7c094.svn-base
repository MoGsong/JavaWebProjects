<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>    
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Schedule"%>
<%@page import="com.gxnu.service.imp.ScheduleService"%>
<%@page import="com.gxnu.service.IScheduleService"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="com.gxnu.service.IDoctorService"%>


<% String url = Data.URL+"/schedule?OP=getId"; %>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>值班管理 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/main.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">


</head>
<body>

<div id="ihealth-layout" class="theme-tradewind">
    <!-- main body area -->
    <div class="main px-lg-4 px-md-4">

        <!-- Body: Body -->
        <div class="body d-flex py-lg-3 py-md-2">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                    <form method="post" class="form-horizontal" action=<%=url %>>
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom">
                            <h3 class="fw-bold mb-0">值班管理</h3>
                            
                              <div class="col-auto d-flex">
                               <span style="padding-top: 5px;font-size: 18px;color:green">科室选择-->&nbsp;&nbsp;</span>
								<select class="form-control" name="unitId" style="width: 200px;">
								<%
								IUnitService ius = new UnitService();
								List<Unit> units = ius.findAll();
								for(Unit unit : units){
								%>
									<option value="<%=unit.getId() %>"><%=unit.getName() %></option>
								<%}%>
								</select>
								&nbsp;&nbsp;<input type="submit" class="btn btn-primary"  value="确定">
							</div>
                                                    
                            <div class="col-auto d-flex">
                            </div>


                        </div>
                        </form>
                    </div>
                </div> <!-- Row end  -->
                

<!-- Jquery Core Js -->
<script src="static/js/libscripts.bundle.js"></script>

<!-- Plugin Js-->
<script src="static/js/main.min.js"></script>

<!-- Jquery Page Js -->
<script src="static/js/template.js"></script>



</body>
</html>