<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.AboutService"%>
<%@page import="com.gxnu.service.IAboutService"%>
<%@page import="com.gxnu.entity.About"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//获取session对象中当前登录的用户数据
	Object obj = request.getAttribute("ABOUT");
	About about = new About();
	if(obj!=null){
		about = (About)obj;
		//System.out.println(about);
	}
	
%>
      
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 后台管理--关于医院</title>
    <!-- Summernote css -->
    <link href="static/css/summernote-bs4.css" rel="stylesheet" type="text/css">
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    <!-- Bootstrap Css -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Icons Css -->
    <link href="static/css/icons.min.css" rel="stylesheet" type="text/css">
    <!-- App Css-->
    <link href="static/css/app.min.css" rel="stylesheet" type="text/css">
</head>
<script>
function tjUpdate(){
	//根据id获取html页面中的表单，并提交
	window.document.getElementById("frm").submit();
}
</script>
<body>

    <div id="ihealth-layout" class="theme-tradewind">

        <!-- sidebar -->
        <!-- main body area -->
        <div class="main px-lg-4 px-md-4">

            <!-- Body: Header -->
           
            <!-- Body: Body -->
            <div class="body d-flex py-lg-3 py-md-2"> 
                <div class="container-xxl">
                <!-- enctype="multipart/form-data"用于支持文本数据的提交 -->
                <form class="container-xxl"  id="frm"  action="<%=Data.URL%>/about?OP=doupdate" method="post" enctype="multipart/form-data">
                    <div class="row align-items-center">
                        <div class="border-0 mb-4">
                            <div
                                class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                                <h3 class="fw-bold mb-0">关于医院</h3>
                                <div class="col-auto d-flex w-sm-100">
                                <style>
								    button{background-color:green}
								</style>
                                    <button type="submit" class="btn btn-primary btn-set-task w-sm-100"
                                        data-bs-toggle="modal" data-bs-target="#" onclick="tjUpdate()" >
                                        <font color="white">确认修改</font></button>
                                </div>
                            </div>
                        </div>
                    </div> <!-- Row end  -->
                    <!--body:body-->
                    
                    <table>
                        <tr>
                            <td style="width: 700px;">
                                <div>
                                    <label  class="form-label"><font color="green">医院名</font></label></br>
                                    <input type="text" name="name" class="form-control" style="width: 400px;" value="<%=about.getName() %>">
                                </div>
                            </td>
                            <td></br>
                                <div>
                                    <label  class="form-label"><font color="green">医院地址</font></label></br>
                                    <input type="text" name="address" class="form-control" style="width: 400px;" value="<%=about.getAddress() %>">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td></br>
                                <div>
                                    <label  class="form-label"><font color="green">联系方式</font></label></br>
                                    <input type="text" name="tel" class="form-control" style="width: 400px;" value="<%=about.getTel() %>">
                                </div>
                            </td>
                            <td></br>
                                <div>
                                    <label  class="form-label"><font color="green">邮编</font></label></br>
                                    <input type="text" name="postcode" class="form-control" style="width: 400px;" value="<%=about.getPostcode() %>">
                                </div>
                            </td>
                        </tr>
						
						<tr>
                      <td></br>
                          <div>
                              <label  class="form-label"><font color="green">图片</font></label></br>
                              <img src="<%=Data.URL %>/Manage/static/picture/<%=about.getPic()%>"  class="form-control"  style="width:250px; height:200px "/> 
                          </div>
                      </td>

                      <td></br>
                          <div>
                              <label  class="form-label"><font color="green">选择图片</font></label></br>
                             <%--  <img src="<%=Data.URL %>/Manage/static/picture/<%=about.getPic()%>"  class="form-control" name="pic"  style="width:250px; height:200px "/> --%>
                              <input type="file" name="pic" class="form-control" style="width: 400px;">
                          </div>
                      </td>
                  </tr></br>
                       <!-- 医院简介start -->
                        <tr>
                            <div>
                                <label  class="form-label"><font color="green">简介</font></label></br>
                                 <textarea type="text" class="form-control" rows="3" name="synopsis" style="width:100%;height: 150px">
                                 <%=about.getSynopsis() %>
                                 </textarea>
                                <script>
							        document.getElementById("text").value="{{synopsis}}"
							    </script>
                            </div>
                        </tr></br>
                         <!-- 医院简介end -->
                    </table>
                    <!-- 隐藏作用域，通常用于把一个无需显示的数据随同其他一起使用表达提交 -->
                            <input type="hidden" name="id" value="<%=about.getId()%>" />
                     <!--  </form> -->
                    <!-- Jquery Core Js -->
                    <script src="static/js/libscripts.bundle.js"></script>
                    <!-- JAVASCRIPT -->
                    <script src="static/js/jquery.min.js"></script>
                    <script src="static/js/bootstrap.bundle.min.js"></script>
                    <script src="static/js/metisMenu.min.js"></script>
                    <script src="static/js/simplebar.min.js"></script>
                    <script src="static/js/waves.min.js"></script>

                    <script src="static/js/bundle.js"></script>

                    <!-- Summernote js -->
                    <script src="static/js/summernote-bs4.min.js"></script>

                    <!-- init js -->
                    <script src="static/js/summernote.init.js"></script>

                    <script src="static/js/app.js"></script>

                    <!-- Plugin Js-->
                    <script src="static/js/dataTables.bundle.js"></script>

                    <!-- Jquery Page Js -->
                    <script src="static/js/template.js"></script>
                    <script>
                        // project data table
                        $(document).ready(function () {
                            $('#myProjectTable')
                                .addClass('nowrap')
                                .dataTable({
                                    responsive: true,
                                    columnDefs: [
                                        { targets: [-1, -3], className: 'dt-body-right' }
                                    ]
                                });
                            $('.deleterow').on('click', function () {
                                var tablename = $(this).closest('table').DataTable();
                                tablename
                                    .row($(this)
                                        .parents('tr'))
                                    .remove()
                                    .draw();

                            });
                        });
                    </script>
</body>

</html>