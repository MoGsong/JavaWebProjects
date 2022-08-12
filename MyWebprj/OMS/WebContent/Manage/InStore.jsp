<%@page import="com.gxnu.entity.Measure"%>
<%@page import="com.gxnu.service.imp.MeasureService"%>
<%@page import="com.gxnu.service.IMeasureService"%>
<%@page import="com.gxnu.entity.Inventory"%>
<%@page import="com.gxnu.service.imp.InventoryService"%>
<%@page import="com.gxnu.service.IInventoryService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.InDetail"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.InDetailService"%>
<%@page import="com.gxnu.service.IInDetailService"%>
<%@page import="com.gxnu.service.IInStoreService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 入库明细</title>
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
                                <h3 class="fw-bold mb-0">入库记录</h3>
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
                                                <th scope="col">药品名称</th>
                                                <th scope="col">进货价格</th>
                                                <th scope="col">数量</th>
                                                <th scope="col">单位</th>
                                                <th scope="col">基本操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <% 
                                           //获取会话中传过来的入库InStoreId，循环遍历，若入库明细的入库id等于InStoreId,则输出
                                             Object instoreId = session.getAttribute("InStoreId");
                                             int inStoreId = 0;
                                             if(instoreId!=null){inStoreId = Integer.parseInt(String.valueOf(instoreId));}
                                             IInDetailService ids = new InDetailService();
                                             List<InDetail> inDetails = ids.findAll();
                                             int i = 1;
                                             for(InDetail inDetail : inDetails){
                                            	 if(inDetail.getInStore().getId()==inStoreId){
                                           %>
                                            <tr>
                                                <td>
                                                    <span class="fw-bold"><%=i++ %></span>
                                                </td>
                                                <td>
                                                    <!-- 药品名称 -->
                                                    <span class="fw-bold ms-1"><%=inDetail.getInventory().getDrugInfo().getName()%></span>
                                                </td>
                                                <td>
                                                    <!-- 进货价格 -->
                                                   <span><%=inDetail.getPrice()%></span>
                                                </td>
                                                <td>
                                                    <!-- 数量 -->
                                                    <span><%=inDetail.getNum()%></span>
                                                </td>
                                                <td>
                                                	<!-- 单位-->
                                                    <span><%=inDetail.getInventory().getMeasur().getName()%></span>
                                                </td>
                                                <td>
                                                    <div class="btn-group" role="group"
                                                        aria-label="Basic outlined example">
                                                        
                                                        <button type="button" class="btn btn-outline-secondary"
                                                            data-bs-toggle="modal" data-bs-target="#depedit" onclick="edit(this,<%=inDetail.getId()%>,<%=inDetail.getInventory().getId()%>)"><i
                                                                class="icofont-edit text-success"></i></button>
                                                                
                                                        <button type="button"
                                                            onclick="window.location.href='<%=Data.URL%>/indetail?OP=delete&ID=<%=inDetail.getId()%>'"><i
                                                                class="icofont-ui-delete text-danger"></i></button>
                                                    </div>
                                                </td>
                                            </tr>
                                            <%}} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row End -->
                </div>
                <div style="margin-left:90%" class="col-auto d-flex w-sm-100">
                    <button type="button" class="btn btn-primary btn-set-task w-sm-100"
                        data-bs-toggle="modal" onclick="window.location.href='<%=Data.URL%>/Manage/Drug.jsp'">完成入库</button>
                </div>
            </div>

            <!-- Modal Custom Settings-->


            <!-- 添加入库明细-->
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">添加入库明细</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/indetail?OP=add" method="post">
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">药品名称</label>
                                        <select name="INVENTORY">
								            <option value="1" selected="selected">--请选择药品--</option>
								            <%
								            IInventoryService irs = new InventoryService();
								            List<Inventory> inventories = irs.find();
								            for(Inventory inventory : inventories){          
								            %>
								            <option value="<%=inventory.getId()%>">--<%=inventory.getDrugInfo().getName()%>--</option>
								            <%}%>           
								        </select>
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">进货价格</label>
                                        <input type="text" class="form-control" id="deptwo" name="PRICE">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depthree" class="form-label">数量</label>
                                        <input type="text" class="form-control" id="depthree" name="NUM">
                                        <!-- <input type="hidden" class="form-control" name="INSTOREID" value="<%=inStoreId%>">  -->
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


            <!-- 编辑入库明细-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 编辑药品</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form action="<%=Data.URL%>/indetail?OP=update" method="post">
                                    <div class="mb-3">
                                        <input type="hidden" class="form-control" id="updateInventory" name="INVENTORY">
                                        <input type="hidden" class="form-control" id="updateId" name="ID">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">进货价格</label>
                                        <input type="text" class="form-control" id="updatePrice" name="PRICE">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">数量</label>
                                        <input type="text" class="form-control" id="updateNum" name="NUM">
                                    </div>
                                    <div class="modal-footer">
			                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
			                            <button type="submit" class="btn btn-primary">保存</button>
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
	    function edit(obj,id,inventoryId){
	        var $td= $(obj).parents('tr').children('td');
	       
	        var price = $td.eq(2).text().replace(/\s*/g,"");
	        var num = $td.eq(3).text().replace(/\s*/g,"");
	        //alert(tel);
	
			//var i= address.toString();
	       
	       $("#updateInventory").val(inventoryId); 
	      //  $("#updateName").css('color','red').val("qqq"+tel);
	      $("#updatePrice").val(price);
	        $("#updateNum").val(num);
	        $("#updateId").val(id);
	      //  $("#updateTel").css('color','red').css('text-align','left');
  
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