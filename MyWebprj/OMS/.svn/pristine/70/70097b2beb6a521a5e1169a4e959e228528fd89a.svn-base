<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.dao.ReserveCaseDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.entity.ReserveCase"%>
<%@page import="com.gxnu.service.imp.ReserveCaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
        ReserveCaseDAO reservecaseDAO = new ReserveCaseDAO();    
		List<ReserveCase> reservecases =reservecaseDAO.findAll();			
     
   %>
   
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 操作员管理 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/parsley.css">

    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    
    <script >
function tj(){
	//获取html页面中的表单
	window.document.getElementById("js").submit();
}
</script>
</head>
<body>
<div id="ihealth-layout" class="theme-tradewind">
   <!-- main body area -->
      <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">可预约情况信息查看</h3>
                        </div>
                    </div>
                </div> <!-- Row end  -->
                          <table
			                  		class="table table-striped table-bordered table-hover  dataTable"
										id="editable" aria-describedby="editable_info" width="130%">


										<tr align="center" class="gradeA even">
											<td class="sorting_1" >编号</td>
											<td class=" ">医生</td>
											<td class=" ">时间</td>
											<td class="center ">以预约人数</td>
											<td class="center ">预留</td>											
										</tr>
<%
											//循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
											for (ReserveCase reserveCase : reservecases) {
											
										%>
										
										  <tr align="center" class="gradeA even">
											<td class="sorting_1"><%=reserveCase.getId()%></td>
											<td class=" "><%=reserveCase.getDoctor().getName()%></td>
											<td class=" "><%=reserveCase.getTime()%></td>
											<td class="center "><%=reserveCase.getAl_reserve()%></td>	
											<td class="center "></td>																																																																								   
										</tr>
										<%
											}
										%>
										<a href="<%=Data.URL%>/Manage/index.jsp"> 返回页面</a>
									</table>
									</div>

									<table style="width: 100%" border="0">
										<tr>
                            </div>
                        </div>
                    </div>


</body>
</html> 