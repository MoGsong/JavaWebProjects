<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>    
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Unit"%>
<%@page import="com.gxnu.service.imp.UnitService"%>
<%@page import="com.gxnu.service.IUnitService"%>
<% String url = Data.URL+"/unit"; %>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>科室管理</title>
    <!-- Summernote css -->
    <link href="../static/css/summernote-bs4.css" rel="stylesheet" type="text/css">
    <!-- plugin css file  -->
    <link rel="stylesheet" href="../static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="../static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="../static/css/ihealth.style.min.css">
    <!-- Bootstrap Css -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Icons Css -->
    <link href="../static/css/icons.min.css" rel="stylesheet" type="text/css">
    <!-- App Css-->
    <link href="../static/css/app.min.css" rel="stylesheet" type="text/css">
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
                                <h3 class="fw-bold mb-0">科室管理</h3>
                                <div class="col-auto d-flex w-sm-100">
                                <!-- 添加按钮 data-bs-target="#depadd"跳转-->
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
                                                <th scope="col">科室名称</th>
                                                <th scope="col">科室地点</th>
                                                <th scope="col">负责人</th>
                                                <th scope="col">负责人联系电话</th>
                                                <th scope="col">基本操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
											<%
										
										    //直接获取数据库信息，显示出界面
										    IUnitService ius = new UnitService();
											List<Unit> units = new ArrayList<Unit>();
											units = ius.findAll();
											int i = 1;
											for(Unit unit:units){
													
											%>                                      	
                                            <tr><!-- 按钮所在的tr -->
                                                <td><!-- 按钮所在的tr的孩子td 然后用eq选择器，索引是从0开始，可以取对应list列表的值-->
                                                    <span class="fw-bold"><%=i %></span>
                                                </td>
                                                <td>
                                                    <%=unit.getName() %>
                                                </td>
                                                
                                                
                                                <td>

                                                   <%=unit.getAddress() %>
                                                </td>
                                                <td>
                                                   <%=unit.getPrincipal() %>
                                                </td>
                                                <td>
                                                   <%=unit.getTel() %>
                                                </td>
                                                <td>
                                                    <div class="btn-group" role="group"  aria-label="Basic outlined example">
                                                    
                                                    <!-- 编辑按钮——>数据回显 -->
                                                     <!-- 第一种
															data-toggle: 以什么事件触发，如modal,popover,tooltips等；
															data-target: 事件的目标；
															1、Bootstrap 模态框带参数传值实例: https://blog.csdn.net/linhaiyun_ytdx/article/details/77417702 
															2、onclick点击事件实现向其传值
															onclick="Values(<%=unit.getId() %>)" 
															
														-->
														<!--第二种
															先给按钮绑定一个onclick事件，然后点击按钮触发edit(this)事件。
															 this是当前button标签 找他的父标签tr的孩子标签th。然后用eq选择器，索引是从0开始，可以取对应list列表的值。
															 然后用JQuery，把数据渲染到对应的ID里。
															 https://blog.csdn.net/zlq0527/article/details/114804760
															 -->
                                                        <button type="button" class="btn btn-outline-secondary"
                                                            data-bs-toggle="modal" data-bs-target="#depedit" 
                                                            onclick="edit(this,<%=unit.getId() %>)">
                                                            <i class="icofont-edit text-success"></i>
                                                         </button>
                                                            
                                                            <!--  onclick="window.location.href='https://www.bilibili.com/'" > -->
                                                     <%String removeUrl = Data.URL+"/unit?id=" +unit.getId();%>       
                                                     <!-- 删除按钮 -->
                                                        <button type="button"  class="btn btn-outline-secondary "
                                                         onclick="remove('<%=removeUrl %>')" >
                                                        	<i class="icofont-ui-delete text-danger"></i>
                                                        </button>
                                                    </div>
                                                </td>
                                                
                                            </tr>
                                            <%i++;} %>
                                          
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row End -->
                </div>
            </div>

            <!-- Modal Custom Settings-->

<%
String addUrl=url+ "?OP=add";
%>
            <!-- 添加科室信息-->
          
            <div class="modal fade" id="depadd" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                  
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depaddLabel">添加科室信息</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                              <form id="addForm" method="post" action=<%=addUrl %>>
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">科室名称</label>
                                        <input type="text" class="form-control" id="addName" name="addName">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">科室地点</label>
                                        <input type="text" class="form-control" id="addAddress" name="addAddress">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">负责人</label>
                                        <input type="text" class="form-control" id="addPrincipal" name="addPrincipal">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">负责人联系电话</label>
                                        <input type="text" class="form-control" id="addTel" name="addTel">
                                    </div>
                                    
                                    <!-- end row -->
                                    <!-- end row -->
                                    <!-- end container-fluid -->
                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <input type="button" class="btn btn-primary" onclick="tjAdd()" value="添加"/>
                        </div>
                    </div>
                </div>
            </div>
            
<%
String updateUrl = url +"?OP=add";
%>
            <!-- 编辑科室信息-->
            <div class="modal fade" id="depedit" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title  fw-bold" id="depeditLabel"> 编辑科室信息</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <div class="deadline-form">
                                <form id="updateForm" method="post" action=<%=updateUrl %>>
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">科室名称</label>
                                        <input type="text" class="form-control" id="updateName" name="updateName" value="">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="depone" class="form-label">科室地点</label>
                                        <input type="text" class="form-control" id="updateAddress" name="updateAddress" value="">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">负责人</label>
                                        <input type="text" class="form-control" id="updatePrincipal" name="updatePrincipal" value="">
                                    </div>
                                    <div class="col-sm-6">
                                        <label for="deptwo" class="form-label">负责人联系电话</label>
                                        <input type="text" class="form-control" id="updateTel"  name="updateTel" value="" >
                                    </div>
                                    
                                    <div class="col-sm-6">
									<input type="text" class="form-control" id="updateId" name="updateId" value="">
									</div>
                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                            <input type="button" class="btn btn-primary"  onclick="tjUpdate()" value="保存">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="../static/js/libscripts.bundle.js"></script>
    <!-- JAVASCRIPT -->
    <script src="../static/js/jquery.min.js"></script>
    <script src="../static/js/bootstrap.bundle.min.js"></script>
    <script src="../static/js/metisMenu.min.js"></script>
    <script src="../static/js/simplebar.min.js"></script>
    <script src="../static/js/waves.min.js"></script>

    <script src="../static/js/bundle.js"></script>

    <!-- Summernote js -->
    <script src="../static/js/summernote-bs4.min.js"></script>

    <!-- init js -->
    <script src="../static/js/summernote.init.js"></script>

    <script src="../static/js/app.js"></script>

    <!-- Plugin Js-->
    <script src="../static/js/dataTables.bundle.js"></script>

    <!-- Jquery Page Js -->
    <script src="../static/js/template.js"></script>
    <script>
        // project data table
       // $("#depedit").modal("hide");
       //第一种 无用
        function Values(ID){//在按钮中定义的点击事件函数Values,传入ID
          //  alert(ID);
			$("#id").val(ID); //接收传入的ID值,发送给id为id的标签
			
            }
		//第二种
        function edit(obj,id){
            var $td= $(obj).parents('tr').children('td');
           
            var name = $td.eq(1).text();
            var address = $td.eq(2).text();
            var principal = $td.eq(3).text();
            var tel = $td.eq(4).text();
            

			var i= address.toString();
           
            $("#updateId").val(id); 
            $("#updateName").val("qqq");
            $("#updateAddress").val(i);
            $("#updatePrincipal").val(principal);
            $("#updateTel").val(tel);

            //控制台输出测试
            console.log(id);
            console.log(name);
            console.log(address);
            console.log(principal);
            console.log(tel);
        }
        
        
        function remove(url){//在按钮中定义的点击事件函数remove
        	console.log(url);
          	window.location.href=url;
  			
              }

    	function tjAdd() {
    		//根据id获取html页面中的表单，并提交
    		window.document.getElementById("addForm").submit();
    	}

    	function tjUpdate() {
    		//根据id获取html页面中的表单，并提交
    		window.document.getElementById("updateForm").submit();
    	}
    	
        
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