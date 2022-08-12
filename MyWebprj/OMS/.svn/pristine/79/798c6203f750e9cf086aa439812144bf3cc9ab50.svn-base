<%@page import="com.gxnu.entity.Patient"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.IPatientService"%>
<%@page import="com.gxnu.service.imp.PatientService"%>
<%@page import="com.gxnu.service.IPatienService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>患者信息查看 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
</head>
<body>
<div id="ihealth-layout" class="theme-tradewind">
   <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">患者信息管理</h3>
                        </div>
                    </div>
                </div> <!-- Row end  -->
                <div class="row mb-3">
                    <div class="card">
                        <div class="card-body">
                            <table id="patient-table" class="table table-hover align-middle mb-0" style="width: 100%;">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>年龄</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                     IPatientService patientService = new PatientService();
                                     List<Patient> patients = patientService.find();
                                     int i = 0;
                                     for(Patient patient : patients){
                                %>
                                    <tr>
                                        <td><%=++i %></td>
                                        <td><img src="static/picture/avatar3.jpg" class="avatar  rounded-circle me-2" alt="profile-image"><span><%=patient.getName() %> </span></td>
                                        <td><%=patient.getSex() %></td>
                                        <td><%=patient.getAge() %></td>
                                        
                                    </tr>
                                   <%} %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>
</div>

<!-- Jquery Core Js -->
<script src="static/js/libscripts.bundle.js"></script>

<!-- Plugin Js-->
<script src="static/js/dataTables.bundle.js"></script>

<!-- Jquery Page Js -->
<script src="static/js/template.js"></script>
<script>
     $(document).ready(function() {
        $('#patient-table')
        .addClass( 'nowrap' )
        .dataTable( {
            responsive: true,
            columnDefs: [
                { targets: [-1, -3], className: 'dt-body-right' }
            ]
        });
    });

</script>
 
</body>
</html> 