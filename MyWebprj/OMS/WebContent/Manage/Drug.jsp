<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>药品后台管理</title>
    
    <!-- Bootstrap Css -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    
    
<script>
   function rk(){
        window.location.href="<%=Data.URL%>/instore";
	   }
</script>
</head>

<body>
   <div style="text-align:center;font-family: 华文行楷;font-size:50px;margin:20px auto">药品后台管理</div>
   <table border="0px" align="center" style="margin:30px auto">
     <tr>
        <td>  
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100" onclick="window.location.href='DrugInfo.jsp'">
	     <span style="text-align:center;font-size:20px;" >    
	         药品信息</span></button>
	    </td>
	    <td>
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100"  onclick="window.location.href='Inventory.jsp'">
	         <span style="text-align:center;font-size:20px;" >
	         库存管理</span></button>
	    </td>
	    <td>
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100" onclick="window.location.href='Measure.jsp'">
	    <span style="text-align:center;font-size:20px;" >    
	         药品单位</span></button>
	    </td>
     </tr>
     <tr>
        <td>
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100" onclick="rk()">
	     <span style="text-align:center;font-size:20px;" >    
	         开始入库</span></button>
	    </td>
	    <td>
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100" onclick="window.location.href='InDetail.jsp'">
	     <span style="text-align:center;font-size:20px;" >    
	         入库明细</span></button>
	    </td>
	    <td>
	         <button type="button" style="background-color: #6AAB9C;width:180px;height:70px" class="btn btn-primary btn-set-task w-sm-100" onclick="window.location.href='OutDetail.jsp'">
	     <span style="text-align:center;font-size:20px;" >    
	         出库明细</span></button>
	    </td>
     </tr>
   </table>



    <!-- Jquery Core Js -->
    <script src="static/js/libscripts.bundle.js"></script>
    <!-- JAVASCRIPT -->
    <script src="static/js/jquery.min.js"></script>
  
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