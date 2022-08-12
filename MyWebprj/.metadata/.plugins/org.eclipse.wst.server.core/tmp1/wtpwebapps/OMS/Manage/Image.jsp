<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Image"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.IImageService"%>
<%@page import="com.gxnu.service.imp.ImageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: I-Health::  Patient List </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
</head>
<!-- 图片信息管理 -->

<%
	IImageService imageService=new ImageService();
	List<Image> images=imageService.find();
%>


<body>

<div id="ihealth-layout" class="theme-tradewind">

   <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
         
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">图片管理</h3>
                                           
                             <div class="col-auto d-flex w-sm-100">
                                    <button type="button"  class="btn btn-primary btn-set-task w-sm-100"
                                        data-bs-toggle="modal" data-bs-target="#depadd">
                                        <i class="icofont-plus-circle me-2 fs-6"></i>添加</button>
                                </div>
                        </div>
                    </div>
                </div> <!-- Row end  -->
               
                <div class="row mb-3">
                    <div class="card">
                     <form id="delete" action="<%=Data.URL%>/image?OP=delete" method="post">
                        <div class="card-body">
                            <table id="patient-table" class="table table-hover align-middle mb-0" style="width: 100%;">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>图片</th>
                                        <th>图片名</th>
                                        <th>跳转链接</th>
                                        <th>基本操作</th>
                                                                            
                                    </tr>
                                </thead>
                               
                                <tbody>
                                                   
                                    <%
                                       //循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中<td></td>,把静态数据改成数据库表中的记
                                          for(Image image:images){
                                     %>   
                                                        <tr>
                                                            <th><%=image.getId() %></th>
                                                            <td>
                                                            <div align="center">
                                                            <!-- 图片放在根目录下是HTML，在文件夹里面是FILE类型 -->
                                                            <img src="<%=Data.URL %>/<%=image.getName()%>" style="width: 60px" /> 
                                                            </div>
                                                            </td>
                                                            <td><%=image.getName() %></td>
                                                            <td><%=image.getUrl() %></td>
                                                             <td>
                                                             
                                                             <div class="btn-group" role="group" aria-label="Basic outlined example">            
                                                             <button type="button" onclick="update(this,<%=image.getId()%>)" class="btn btn-outline-secondary"data-bs-toggle="modal" data-bs-target="#depedit">
                                                             <i class="icofont-edit text-success"></i></button>
                                                                                                      
                                                             
                                                             <button type="button" class="btn btn-outline-secondary" onclick="Delete()"><i class="icofont-ui-delete text-danger"></i></button>
                                                             <input type="hidden" name="id" value="<%=image.getId()%>"/>
                                                            
                                                             
                                                             </div>
                                                                                                                         
                                                             </td>                                                     
                                                        </tr>                                                 
                                                 
                                                 <%} %>   
                                   
                                </tbody>
                                
                            </table>
                        </div>
                        </form>
                    </div>
                </div>
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

   <!-- 添加图片信息-->
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">图片添加</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form id="addImage" action="<%=Data.URL%>/image?OP=add"  enctype ="multipart/form-data"  method="post" >
                                    <div class="col-sm-6">
                                          <label for="formFileMultiple" class="form-label"> 图片</label>
												<input class="form-control" type="file" name="addName"  required="">
                                    </div>
                                    
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">图片链接</label>
                                        <input type="text" class="form-control" name="addURL">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="button" onclick="add()"class="btn btn-primary">添加</button>
                        </div>
                    </div>
                </div>
            </div>
         
          <!-- 编辑图片信息-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 图片修改</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form id="updateImage" action="<%=Data.URL%>/image?OP=doupdate" enctype ="multipart/form-data" method="post">                                   
                                    <div class="col-sm-6">
                                        <label for="formFileMultiple" class="form-label"> 图片</label>
										<input class="form-control" type="file"  name="updatename" id="updateName" required="">
                                    </div>
                                   
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">图片链接</label>
                                        <input type="text" class="form-control" name="updateurl" id="updateURL">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="hidden" class="form-control" name="updateid" id="updateId">
                                    </div>

                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <button type="button" onclick="Update()"class="btn btn-primary">保存</button>
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

       
     function update(obj,id){
         //父标签th下的子标签td，分别对应0~4
         var $td = $(obj).parents('tr').children('td');
         //获取字段的值,.replace(/\s*/g,"");为js格式化删除空格
         var url = $td.eq(2).text().replace(/\s*/g,"");
         //根据input标签的id属性，设置input默认的value值
         $("#updateId").val(id);
         $("#updateURL").val(url);
         }

     function Delete(){
    	 	window.document.getElementById("delete").submit();
         }

     function add(){
 	 	window.document.getElementById("addImage").submit();
      }

     function Update(){
    	 window.document.getElementById("updateImage").submit();
         }
     
</script>


</body>
</html> 