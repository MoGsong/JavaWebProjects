<%@page import="java.util.stream.Collectors"%>
<%@page import="com.mchange.v1.util.CollectionUtils"%>
<%@page import="com.gxnu.entity.DrugInfo"%>
<%@page import="com.gxnu.service.imp.DrugInfoService"%>
<%@page import="com.gxnu.service.IDrugInfoService"%>
<%@page import="com.gxnu.entity.Measure"%>
<%@page import="com.gxnu.service.imp.MeasureService"%>
<%@page import="com.gxnu.service.IMeasureService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.Inventory"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.InventoryService"%>
<%@page import="com.gxnu.service.IInventoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>库存信息</title>
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
                                <h3 class="fw-bold mb-0">库存信息</h3>
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
                                                <th scope="col">平均进价</th>
                                                <th scope="col">数量</th>
                                                <th scope="col">单位</th>
                                                <th scope="col">基本操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <!-- 此处调用业务层方法,返回一个Inventory对象集合，循环遍历 -->
                                        <% IInventoryService iis = new InventoryService();
                                           List<Inventory> inventories = iis.find();
                                           int i = 1;
                                           for(Inventory inventory : inventories){
                                        %>
                                            <tr>
                                                <td>
                                                    <span class="fw-bold"><%=i++ %></span>
                                                </td>
                                                <td>
                                                    <!-- 库存药品名称 -->
                                                    <span class="fw-bold ms-1"><%=inventory.getDrugInfo().getName() %></span>
                                                </td>
                                                <td>
                                                    <!-- 平均进价 -->
                                                   <span><%=inventory.getXprice() %></span>
                                                </td>
                                                <td>
                                                    <!-- 库存数量 -->
                                                    <span><%=inventory.getNum() %></span>
                                                </td>
                                                <td>
                                                	<!-- 药品单位 -->
                                                    <span><%=inventory.getMeasur().getName() %></span>
                                                </td>
                                                <td>
                                                    <div class="btn-group" role="group"
                                                        aria-label="Basic outlined example">
                                                        
                                                        <button type="button" class="btn btn-outline-secondary"
                                                            data-bs-toggle="modal" data-bs-target="#depedit" onclick="edit(this,<%=inventory.getId()%>,<%=inventory.getDrugInfo().getId()%>)"><i
                                                                class="icofont-edit text-success"></i></button>
                                                                
                                                        <button type="button"
                                                            onclick="window.location.href='<%=Data.URL%>/inventory?OP=delete&ID=<%=inventory.getId()%>'"><i
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


            <!-- 添加库存药品-->
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">添加库存药品</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/inventory?OP=add" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">药品名称</label>
                                        <select class="form-control" name="DRUGINFO" style="width: 200px;">	                                      
	                                       
	                                       <%IDrugInfoService ids = new DrugInfoService(); 
	                                         List<DrugInfo> drugInfos = ids.findAll(); //所有的药品
	                                         List<DrugInfo> drugInfos2 = new ArrayList<>();//库存中已有的药品
	                                         for(Inventory inventory2 : inventories){
	                                        	 drugInfos2.add(inventory2.getDrugInfo());
	                                         }
	                                         //lambda表达式取两集合的差集，避免药品信息重复
	                                         List<DrugInfo> drugInfos3 = drugInfos.stream()
	                                                 .filter(notComment -> !drugInfos2.stream().map(all -> all.getId()).collect(Collectors.toList()).contains(notComment.getId()))
	                                                 .collect(Collectors.toList());
	                                         for(DrugInfo drugInfo : drugInfos3){
	                                       %>
	                                         <option value="<%=drugInfo.getId()%>">--<%=drugInfo.getName()%>--</option>
	                                       <%} %>
	                                       
	                                    </select>
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">平均进价</label>
                                        <input type="text" class="form-control" id="deptwo" name="XPRICE">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depthree" class="form-label">库存数量</label>
                                        <input type="text" class="form-control" id="depthree" name="NUM">
                                    </div>
                                    <div class="col-sm-6">
                                    <label for="depfour" class="form-label">药品单位</label>
                                    <select class="form-control" name="MEASURE" style="width: 200px;">
	                                      <option value="1"  id="depfour" selected="selected">--请选择单位--</option>
	                                       <%IMeasureService ims = new MeasureService();
	                                         List<Measure> measures = ims.find();
	                                         for(Measure measure : measures){	                                        	         
	                                       %>
	                                         <option value="<%=measure.getId()%>">--<%=measure.getName()%>--</option>
	                                       <%} %>
	                                    </select>
                                    <!-- <input type="text" class="form-control" id="depfour" name="MEASURE"> -->
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

            <!-- 编辑库存药品-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 编辑库存药品</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/inventory?OP=update" method="post">
                                    <div class="col-sm-6"  style="max-width: 80% ;">
                                       <div style="margin-left:60px;">
	                                        <input type="hidden" class="form-control" id="updateone" name="DRUGINFO" value="">
                                        </div>
                                    </div>
                                    <div class="col-sm-6" style="max-width: 80%">
                                       <div style="margin-left:60px;">
                                        <label for="deptwo" class="form-label">平均进价</label>
                                        <input type="text" class="form-control" id="updatetwo" name="XPRICE" value="">
                                       </div>
                                    </div>
                                    <div class="col-sm-6" style="max-width: 80%">
                                       <div style="margin-left:60px;">
                                        <label for="depthree" class="form-label">库存数量</label>
                                        <input type="text" class="form-control" id="updatethree" name="NUM" value="">
                                       </div>
                                    </div>
                                    <div class="col-sm-6" style="max-width: 80%">
                                      <div style="margin-left:60px;">
	                                    <label for="depfour" class="form-label">药品单位</label>
	                                    <select class="form-control" name="MEASURE" style="width: 200px;">
	                                      <option value="1"  id="updatefour" selected="selected">--请选择单位--</option>
	                                       <%IMeasureService iss = new MeasureService();
	                                         List<Measure> umeasures = iss.find();
	                                         for(Measure measure : umeasures){	                                        	         
	                                       %>
	                                         <option value="<%=measure.getId()%>">--<%=measure.getName()%>--</option>
	                                       <%} %>
	                                    </select>
	                                    <!--
	                                    <input type="text" class="form-control" id="updatefour" name="MEASURE" value="">
	                                    -->	                                    
	                                    <input type="hidden" class="form-control" id="updatefive" name="ID" value="">
	                                  </div>
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
	    function edit(obj,id,drugInfoId){
	        var $td= $(obj).parents('tr').children('td');
	       
	        //var drugInfo = $td.eq(1).text().replace(/\s*/g,"");
	        var xprice = $td.eq(2).text().replace(/\s*/g,"");
	        var num = $td.eq(3).text().replace(/\s*/g,"");
	        var measure = $td.eq(4).text().replace(/\s*/g,"");
	        //alert(tel);
	
			//var i= address.toString();
	       
	        $("#updateone").val(drugInfoId); 
	      //  $("#updateName").css('color','red').val("qqq"+tel);
	      $("#updatetwo").val(xprice);
	        $("#updatethree").val(num);
	        $("#updatefour").val(measure);
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