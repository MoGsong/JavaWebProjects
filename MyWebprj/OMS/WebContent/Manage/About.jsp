<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.AboutService"%>
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
<html class="no-js" lang="en" dir="ltr">
   <script>
   function Index(n){
	   //重新跳转到首页
	   window.location.href="<%=Data.URL+"/Manage/index.html"%>";
   }
</script>
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

<body>

    <div id="ihealth-layout" class="theme-tradewind">

        <!-- sidebar -->
        <!-- main body area -->
        <div class="main px-lg-4 px-md-4">

            <!-- Body: Header -->
           
            <!-- Body: Body -->
            <div class="body d-flex py-lg-3 py-md-2">
                <div class="container-xxl">
                    <div class="row align-items-center">
                        <div class="border-0 mb-4">
                            <div
                                class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                                <h3 class="fw-bold mb-0">关于医院</h3>
                                 <%
			            //循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
			            for(About about : abouts ) {
			          %>
					<script>
					   function Update(n){
						   //重新跳转到menu.jsp，即“刷新tab.jsp”,且把要显示的号码以请求参数的方法进行传递，如 P=4
						   window.location.href="<%=Data.URL%>/about?OP=toupdate&id=<%=about.getId()%>";
					  	 }
					   </script>
                                <div class="col-auto d-flex w-sm-100">
                                         <input type="button" class="btn btn-primary" onclick="Update()" value="选择修改"/>
                                    &nbsp;&nbsp;<input type="button" class="btn btn-primary" onclick="Index()" value="返回首页"/>
                                   </div>
                            </div>
                        </div>
                    </div> <!-- Row end  -->
                    <!--body:body-->
                    
                       
                    <table style="width:100; align-content: center;">
                    <!-- 医院名称、地址start -->
                        <tr>
                            <td style="width: 700px;">
                                <div>
                                    <label  class="form-label">医院名</label>
                                    <input type="text" name="name" class="form-control" style="width: 400px;" value="<%=about.getName() %>">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <label  class="form-label">医院地址</label>
                                    <input type="text" name="address" class="form-control" style="width: 400px;" value="<%=about.getAddress() %>">
                                </div>
                            </td>
                        </tr>
                         <!-- 医院名称、地址end -->
                            
                            <!-- 医院联系方式、邮编start -->
                        <tr>
                            <td>
                                <div>
                                    <label  class="form-label">联系方式</label>
                                    <input type="text" name="tel" class="form-control" style="width: 400px;" value="<%=about.getTel() %>">
                                </div>
                            </td>
                            <td>
                                <div>
                                    <label  class="form-label">邮编</label>
                                    <input type="text" name="postcode" class="form-control" style="width: 400px;" value="<%=about.getPostcode() %>">
                                </div>
                            </td>
                        </tr>
                         <!-- 医院联系方式、邮编end -->
                            
                            <!-- 医院图片start -->
                        <tr>
                            <td>
                                <div>
                                    <label  class="form-label">图片</label>
                                    <input type="text" class="form-control" value="<%=about.getPic()%>" name="pic" style="width: 400px;" /></br>
                                    <img src="<%=Data.URL %>/Manage/static/picture/<%=about.getPic()%>"  class="form-control" style="width:250px; height:200px "/>
                                </div>
                            </td>
                        </tr>
                         <!-- 医院图片end -->
                         
                          <!-- 医院简介start -->
                        <tr>
                            <div>
                                <label  class="form-label">简介</label>
                                 <textarea id="synopsis" type="text" class="form-control" rows="3" name="synopsis" style="width:100%;height: 150px" placeholder="<%=about.getSynopsis() %>"></textarea>
                                <script>
							        document.getElementById("text").value="{{synopsis}}"
							    </script>
                            </div>
                        </tr><%} %></br>
                         <!-- 医院简介end -->
                    </table>
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