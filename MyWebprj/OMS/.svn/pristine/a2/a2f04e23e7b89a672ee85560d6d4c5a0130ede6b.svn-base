
<%@page import="java.util.Calendar"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.service.IDoctorService"%>
<%@page import="com.gxnu.entity.Patient"%>
<%@page import="com.gxnu.service.imp.PatientService"%>
<%@page import="com.gxnu.service.IPatientService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 填写病例表::  添加病例 </title>
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
</head>
    <!-- 医生信息从登录信息获取，患者信息从预约情况获取 -->
<%
	IPatientService patientService = new PatientService();
	int patientId = Integer.parseInt(request.getParameter("patientId"));
	Patient patient = patientService.find(patientId);
	
	IDoctorService doctorService = new DoctorService();
	int doctorId = Integer.parseInt(request.getParameter("doctorId"));
	Doctor doctor = doctorService.find(doctorId);
    
    Calendar calendar= Calendar.getInstance();
    SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(dateFormat.format(calendar.getTime()));
    %>
<script >
	function tj(){
		window.document.getElementById("frm").submit();
		}

</script>
<body>
<div id="ihealth-layout" class="theme-tradewind">
  <div class="main px-lg-4 px-md-4">
      <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">填写病例</h3>
                        </div>
                    </div>
                </div> <!-- Row end  -->
                <div class="row mb-3">
                    <div class="col-sm-12">
                        <div class="card mb-3">
                            <div class="card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0">
                                <h6 class="mb-0 fw-bold ">填写病例</h6>
                            </div>
                            <div class="card-body">
                                <form id="frm" action="<%=Data.URL%>/record?OP=add" method="post">
                                <div class="col-md-6">
                                            <label for="firstname" class="mb-0 fw-bold ">患者信息</label>
                                 </div>
                                    <div class="row g-3 align-items-center">          
                                        <div class="col-md-6">
                                            <label for="firstname" class="form-label">姓名：<%=patient.getName()%></label>
                                        </div>
                                        <div class="col-md-6">
                                            <label class="form-label">性别：<%=patient.getSex() %></label>                                            
                                        </div>
                                                   
                                        <div class="col-md-6">
                                            <label for="admitdate" class="form-label">年龄：<%=patient.getAge()%>></label>
                                        </div>
                                    </div>
                                    
                                    <div class="row g-3 align-items-center">                                     
                                        <div class="col-md-6">
                                            <label for="phonenumber" class="mb-0 fw-bold ">症状描述</label>                    
                                        </div>
                                   		<textarea  name="disease" rows="10"required=""></textarea>
                                    </div>
                                         <div class="row g-3 align-items-center">   
                                        <div class="col-md-6">
                                            <label for="emailaddress" class="mb-0 fw-bold ">诊断结果</label>
                                        </div>
                                         <textarea  name="result" rows="10"required=""></textarea>
                                        </div>
                                       <div class="row g-3 align-items-center">  
                                        <div class="col-md-6">
                                            <label for="admittime" class="form-label">主治医生：<%=doctor.getName() %></label>
                                        </div>
                                        </div>
                                         <div class="row g-3 align-items-center">   
                                        <div class="col-md-6">
                                     <input type="hidden" name="patientid" value="<%=patient.getId() %>"/> 
                                       <input type="hidden" name="doctorid" value="<%=doctor.getId()%>"/>
                                       <input type="hidden" name="time" value="<%=dateFormat.format(calendar.getTime())%>"/>
                                    <button type="button" onclick="tj()" class="btn btn-primary mt-4">提交</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        
      
        <!-- Modal Custom Settings-->
       <div class="modal fade right" id="Settingmodal" tabindex="-1" aria-hidden="true">
            <div class="modal-dialog  modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Custom Settings</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body custom_setting">
                        <!-- Settings: Color -->
                        <div class="setting-theme pb-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-color-bucket fs-4 me-2 text-primary"></i>Template Color Settings</h6>
                            <ul class="list-unstyled row row-cols-3 g-2 choose-skin mb-2 mt-2">
                                <li data-theme="indigo"><div class="indigo"></div></li>
                                <li data-theme="tradewind" class="active"><div class="tradewind"></div></li>
                                <li data-theme="monalisa"><div class="monalisa"></div></li>
                                <li data-theme="blue"><div class="blue"></div></li>
                                <li data-theme="cyan"><div class="cyan"></div></li>
                                <li data-theme="green"><div class="green"></div></li>
                                <li data-theme="orange"><div class="orange"></div></li>
                                <li data-theme="blush"><div class="blush"></div></li>
                                <li data-theme="red"><div class="red"></div></li>
                            </ul>
                        </div>
                        <div class="sidebar-gradient py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-paint fs-4 me-2 text-primary"></i>Sidebar Gradient</h6>
                            <div class="form-check form-switch gradient-switch pt-2 mb-2">
                                <input class="form-check-input" type="checkbox" id="CheckGradient">
                                <label class="form-check-label" for="CheckGradient">Enable Gradient! ( Sidebar )</label>
                            </div>
                        </div>
                        <!-- Settings: Template dynamics -->
                        <div class="dynamic-block py-3">
                            <ul class="list-unstyled choose-skin mb-2 mt-1">
                                <li data-theme="dynamic"><div class="dynamic"><i class="icofont-paint me-2"></i> Click to Dyanmic Setting</div></li>
                            </ul>
                            <div class="dt-setting">
                                <ul class="list-group list-unstyled mt-1">
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label>Primary Color</label>
                                        <button id="primaryColorPicker" class="btn bg-primary avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label>Secondary Color</label>
                                        <button id="secondaryColorPicker" class="btn bg-secondary avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 1</label>
                                        <button id="chartColorPicker1" class="btn chart-color1 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 2</label>
                                        <button id="chartColorPicker2" class="btn chart-color2 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 3</label>
                                        <button id="chartColorPicker3" class="btn chart-color3 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 4</label>
                                        <button id="chartColorPicker4" class="btn chart-color4 avatar xs border-0 rounded-0"></button>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center py-1 px-2">
                                        <label class="text-muted">Chart Color 5</label>
                                        <button id="chartColorPicker5" class="btn chart-color5 avatar xs border-0 rounded-0"></button>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- Settings: Font -->
                        <div class="setting-font py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-font fs-4 me-2 text-primary"></i> Font Settings</h6>
                            <ul class="list-group font_setting mt-1">
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-poppins" value="font-poppins">
                                        <label class="form-check-label" for="font-poppins">
                                            Poppins Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-opensans" value="font-opensans" checked="">
                                        <label class="form-check-label" for="font-opensans">
                                            Open Sans Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-montserrat" value="font-montserrat">
                                        <label class="form-check-label" for="font-montserrat">
                                            Montserrat Google Font
                                        </label>
                                    </div>
                                </li>
                                <li class="list-group-item py-1 px-2">
                                    <div class="form-check mb-0">
                                        <input class="form-check-input" type="radio" name="font" id="font-mukta" value="font-mukta">
                                        <label class="form-check-label" for="font-mukta">
                                            Mukta Google Font
                                        </label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <!-- Settings: Light/dark -->
                        <div class="setting-mode py-3">
                            <h6 class="card-title mb-2 fs-6 d-flex align-items-center"><i class="icofont-layout fs-4 me-2 text-primary"></i>Contrast Layout</h6>
                            <ul class="list-group list-unstyled mb-0 mt-1">
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-switch mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-switch">
                                        <label class="form-check-label" for="theme-switch">Enable Dark Mode!</label>
                                    </div>
                                </li>
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-high-contrast mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-high-contrast">
                                        <label class="form-check-label" for="theme-high-contrast">Enable High Contrast</label>
                                    </div>
                                </li>
                                <li class="list-group-item d-flex align-items-center py-1 px-2">
                                    <div class="form-check form-switch theme-rtl mb-0">
                                        <input class="form-check-input" type="checkbox" id="theme-rtl">
                                        <label class="form-check-label" for="theme-rtl">Enable RTL Mode!</label>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="modal-footer justify-content-start">
                        <button type="button" class="btn btn-white border lift" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary lift">Save Changes</button>
                    </div>
                </div>
            </div>
        </div> 

    </div>
  </div>
</div>       

<!-- Jquery Core Js -->
<script src="static/js/libscripts.bundle.js"></script>


<!-- Jquery Page Js -->
<script src="static/js/template.js"></script>


</body>
</html> 