<%@page import="com.gxnu.entity.Measure"%>
<%@page import="com.gxnu.service.imp.MeasureService"%>
<%@page import="com.gxnu.service.IMeasureService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.Measure"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>药品单位</title>
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
                                <h3 class="fw-bold mb-0">药品单位</h3>
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
                                                <th scope="col">id</th>
                                                <th scope="col">名称</th>
                                                <th scope="col">基本操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <!-- 此处调用业务层方法,返回一个Measure对象集合，循环遍历 -->
                                        <% IMeasureService ims = new MeasureService();
                                           List<Measure> measures = ims.find();
                                           int i = 1;
                                           for(Measure measure : measures){
                                        %>
                                            <tr>
                                                <td>
                                                    <span class="fw-bold"><%=i++ %></span>
                                                </td>
                                                <td>
                                                    <!-- 药品名称 -->
                                                    <span class="fw-bold ms-1"><%=measure.getName()%></span>
                                                </td>
                                                <td>
                                                    <div class="btn-group" role="group"
                                                        aria-label="Basic outlined example">
                                                        
                                                        <button type="button" class="btn btn-outline-secondary"
                                                            data-bs-toggle="modal" data-bs-target="#depedit" onclick="edit(this,<%=measure.getId()%>)"><i
                                                                class="icofont-edit text-success"></i></button>
                                                                
                                                        <button type="button"
                                                            onclick="window.location.href='<%=Data.URL%>/measure?OP=delete&ID=<%=measure.getId()%>'"><i
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
                <div style="margin-left:90%" class="col-auto d-flex w-sm-100">
                    <button type="button" class="btn btn-primary btn-set-task w-sm-100"
                        data-bs-toggle="modal" onclick="window.location.href='<%=Data.URL%>/Manage/Drug.jsp'">回到首页</button>
                </div>
            </div>

            <!-- Modal Custom Settings-->


            <!-- 添加药品-->
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">添加单位</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/measure?OP=add" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">单位名称</label>
                                        <input type="text" class="form-control" id="depone" name="NAME">
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

            <!-- 编辑药品-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 编辑单位</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/measure?OP=update" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">单位名称</label>
                                        <input type="text" class="form-control" id="updateone" name="NAME">
                                        <input type="hidden" class="form-control" id="updatetwo" name="ID">
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
	
			//var i= address.toString();
	       
	       $("#updateone").val(name); 
	        $("#updatetwo").val(id);
		
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