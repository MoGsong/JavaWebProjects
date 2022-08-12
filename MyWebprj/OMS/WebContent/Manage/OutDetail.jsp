<%@page import="com.gxnu.entity.OutDetail"%>
<%@page import="com.gxnu.service.imp.OutDetailService"%>
<%@page import="com.gxnu.service.IOutDetailService"%>
<%@page import="com.gxnu.entity.DrugInfo"%>
<%@page import="com.gxnu.service.imp.DrugInfoService"%>
<%@page import="com.gxnu.service.IDrugInfoService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.DrugInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>入库明细</title>
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
                                <h3 class="fw-bold mb-0">出库明细</h3>
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
                                                <th scope="col">药品名称</th>
                                                <th scope="col">出库价格</th>
                                                <th scope="col">数量</th>
                                                <th scope="col">单位</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <% 
                                           //获取会话中传过来的入库InStoreId，循环遍历，若入库明细的入库id等于InStoreId,则输出
                                             IOutDetailService ids = new OutDetailService();
                                             List<OutDetail> outDetails = ids.findAll();
                                             int i = 1;
                                             for(OutDetail outDetail : outDetails){ 
                                           %>
                                            <tr>
                                                <td>
                                                    <span class="fw-bold"><%=i++ %></span>
                                                </td>
                                                <td>
                                                    <!-- 药品名称 -->
                                                    <span class="fw-bold ms-1"><%=outDetail.getInventory().getDrugInfo().getName()%></span>
                                                </td>
                                                <td>
                                                    <!-- 出库价格 -->
                                                   <span><%=outDetail.getSprice()%></span>
                                                </td>
                                                <td>
                                                    <!-- 数量 -->
                                                    <span><%=outDetail.getNum()%></span>
                                                </td>
                                                <td>
                                                	<!-- 单位-->
                                                    <span><%=outDetail.getInventory().getMeasur().getName()%></span>
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