<%@page import="com.gxnu.entity.Menu"%>
<%@page import="com.gxnu.service.imp.MenuService"%>
<%@page import="com.gxnu.service.IMenuService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 菜单管理</title>
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

        

        <!-- main body area -->
        <div class="main px-lg-4 px-md-4">
                       

            <!-- Body: Body -->
            <div class="body d-flex py-lg-3 py-md-2">
                <div class="container-xxl">
                    <div class="row align-items-center">
                        <div class="border-0 mb-4">
                            <div
                                class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                                <h3 class="fw-bold mb-0">菜单管理</h3>
                                <div class="col-auto d-flex w-sm-100">
                                    <button type="button" class="btn btn-primary btn-set-task w-sm-100"
                                        data-bs-toggle="modal" data-bs-target="#depadd"><i
                                            class="icofont-plus-circle me-2 fs-6"></i>添加</button>
                                </div>
                            </div>
                        </div>
                    </div> <!-- Row end  -->
                    <div class="row clearfix g-3">
                        <div class="col-sm-12">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <table id="myProjectTable" class="table table-hover align-middle mb-0"
                                        style="width:100%">
                                        <thead>
                                            <tr>
	                                            <th>序号</th>
	                                            <th>名称</th> 
	                                            <th>父菜单</th> 
	                                            <th>URL</th>   
	                                            <th>基本操作</th> 
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <!-- 此处调用业务层方法,返回一个Menu对象集合，循环遍历 -->
                                        <% IMenuService ims = new MenuService();
                                           List<Menu> menus = ims.find();
                                           int i = 1;
                                           for(Menu menu : menus){
                                        	  
                                        %>
                                            <tr>
                                                <td>
                                                    <span class="fw-bold"><%=i++ %></span>
                                                </td>
                                                <td>
                                                    <!-- 菜单名称 -->
                                                    <span class="fw-bold ms-1"><%=menu.getName()%></span>
                                                </td>
                                                <td>
                                                    <!-- 父菜单-->
                                                   <span><%=new MenuService().find(menu.getParent()).getName()==null?"无":new MenuService().find(menu.getParent()).getName() %></span>
                                                </td>
                                                <td>
                                                    <!-- URL -->
                                                    <span><%=menu.getUrl()%></span>
                                                </td>
                                               <%--  <td>
                                                	<!-- 预留-->
                                                    <span><%=menu.getYuliu() %></span>
                                                </td> --%>
                                                <td>
                                                    <div class="btn-group" role="group"
                                                        aria-label="Basic outlined example">
                                                        
                                                        <button type="button" class="btn btn-outline-secondary"
                                                            data-bs-toggle="modal" data-bs-target="#depedit" onclick="edit(this,<%=menu.getId()%>)"><i
                                                                class="icofont-edit text-success"></i></button>
                                                             
                                                        <button type="button"
                                                            onclick="window.location.href='<%=Data.URL%>/menu?OP=delete&ID=<%=menu.getId()%>'"><i
                                                                class="icofont-ui-delete text-danger"></i></button>
                                                    </div>
                                                </td>
                                            </tr>
                                           <%} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row End -->
                </div>
            </div>

            <!-- Modal Custom Settings-->


            <!-- 添加菜单-->
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">添加菜单</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/menu?OP=add" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">菜单名称</label>
                                        <input type="text" class="form-control" id="depone" name="NAME">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">父菜单</label>
                                        <input type="text" class="form-control" id="deptwo" name="PARENT">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depthree" class="form-label">url</label>
                                        <input type="text" class="form-control" id="depthree" name="URL">
                                    </div>
                                    <div class="col-sm-6">
                                    <label for="depfour" class="form-label">预留</label>
                                    <input type="text" class="form-control" id="depfour" name="YULIU">
                                    </div>
                                    <div class="summernote"></div>
                                    <!-- end row -->
                                    <!-- end row -->
                                    <!-- end container-fluid -->
                                    <div class="modal-footer">
			                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
			                            <button type="submit" class="btn btn-primary">添加</button>
			                        </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 编辑菜单-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 编辑菜单</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/menu?OP=update" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">菜单名称</label>
                                        <input type="text" class="form-control" id="updateone" name="NAME">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">父菜单</label>
                                        <input type="text" class="form-control" id="updatetwo" name="PARENT">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depthree" class="form-label">url</label>
                                        <input type="text" class="form-control" id="updatethree" name="URL">
                                    </div>
                                    <div class="col-sm-6">
                                    <label for="depfour" class="form-label">预留</label>
                                    <input type="text" class="form-control" id="updatefour" name="YULIU">
                                    <input type="hidden" class="form-control" id="updatefive" name="ID">
                                    </div>
                                    <div class="summernote"></div>
                                    <!-- end row -->
                                    <!-- end row -->
                                    <!-- end container-fluid -->
                                    <div class="modal-footer">
			                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
			                            <button type="submit" class="btn btn-primary">修改</button>
			                            
			                        </div>
                                </form>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>

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
	    function edit(obj,id){
	        var $td= $(obj).parents('tr').children('td');
	       
	        var name = $td.eq(1).text().replace(/\s*/g,"");
	        var parent = $td.eq(2).text().replace(/\s*/g,"");
	        var url = $td.eq(3).text().replace(/\s*/g,"");
	        var yuliu = $td.eq(4).text().replace(/\s*/g,"");
	        //alert(tel);
	
			//var i= address.toString();
	       
	       $("#updateone").val(name); 
	      //  $("#updateName").css('color','red').val("qqq"+tel);
	      $("#updatetwo").val(parent);
	        $("#updatethree").val(url);
	        $("#updatefour").val(yuliu);
	      //  $("#updateTel").css('color','red').css('text-align','left');
	        $("#updatefive").val(id);
		
	        //控制台输出测试
	        //console.log(id);
	        //console.log(name);
	        //console.log(address);
	        //console.log(principal);
	        //console.log(tel);
	      
	    }    
    </script>
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