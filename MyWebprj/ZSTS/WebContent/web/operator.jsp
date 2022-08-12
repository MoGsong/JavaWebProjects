<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.OperatorService"%>
<%@page import="com.gxnu.service.IOperatorService"%>
<%@page import="com.gxnu.entity.Operator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>信息管理</title>
     <link href="css/style.css?v=2.2.0" rel="stylesheet">
     <script>
     function xxx(n){
  	   //重新跳转到operator.jsp，即“刷新operator.jsp”,且把要显示的号码以请求参数的方法进行传递，如 P=4
  	   window.location.href="http://192.168.1.196:8080/ZSTS/web/operator.jsp?P="+n;
     }
     
	
</script>

<style>
.STYLE1 {font-size: 12px}
</style>
     
</head>
<body style="background-color: white">
		<div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>信息管理</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="table_data_tables.html#">选项1</a>
                                        </li>
                                        <li><a href="table_data_tables.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content" >
                                <div class=""  >
                                    <a onclick="fnClickAddRow();" href="http://192.168.1.196:8080/ZSTS/web/addoperator.jsp" class="btn btn-primary ">添加行</a>
                                </div></br>
                                                    
                                
                                <table class="table table-striped table-bordered table-hover  dataTable" id="editable" aria-describedby="editable_info"  width="100%">
                                    <thead>
                                        <tr role="row">
                                          </thead>
                                    <tbody>
                                        	<tr style="text-align:center" class="gradeA even">
                                            <td class="sorting_1">编号</td>
                                            <td class=" ">用户名</td>
                                            <td class=" ">密码</td>
                                            <td class="center ">电话</td>
                                            <td class="center ">头像</td>
                                            <td class="center ">角色</td>
                                            <td class="center ">电子邮箱</td>
                                            <td class="center ">基本操作</td>
                                       </tr>
                                       <%
                                       IOperatorService OperatorService = new OperatorService();
	                       			   List<Operator> operators = OperatorService.find();
	                       			   int i=0;
											for (Operator operator : operators) {
												i++;
										%>
										
                                       </tbody>
                                    </thead>
                                    <tbody>
                                      
										<tr class="gradeA even">
                                            <td class="sorting_1"><%=i %></td>
                                            <td class=" ">    
                                        	     <div align="center" class="STYLE1">
	              									<div align="center">
	              							             <%=operator.getUsername()%>
									              	</div>
									            </div>
                                            </td>
                                            <td class=" ">
                                            <div align="center" class="STYLE1">
                                            <div align="center">
	              							             <%=operator.getPassword()%>
									              	</div>
									              	</td>
                                            <td class="center ">
                                            <div align="center" class="STYLE1">
                                            <div align="center">
	              							            <%=operator.getTel()%>
									              	</div>
									              	</td>
                                            <td class="center ">
                                            <div align="center" class="STYLE1" >
                                            <div align="center">
	              							             <%=operator.getPic()%>
									              	</div>
									              	</td>
                                             <td class="center ">
                                             <div align="center" class="STYLE1">
                                            <div align="center">
	              							            <%=operator.getRole()%>
									              	</div>
									              	</td>
                                              
                                               <td class="center ">
                                               <div align="center" class="STYLE1">
                                            <div align="center">
	              							             <%=operator.getEmail()%>
									              	</div>
									              	</td>
                                               
                                              <td class="center "><a href="http://192.168.1.196:8080/ZSTS/operator?op=toupdate&id=<%=operator.getId()%>">编辑</a> &nbsp;&nbsp;&nbsp;&nbsp;
                                              					  <a href="http://192.168.1.196:8080/ZSTS/operator?id=<%=operator.getId()%>">删除</a></td>
                                        </tr>
                                        <%
											}
                                        %>
                                      </tbody>
                                   
                                </table>
                                
                                
                               <table style="width:100%" border="0">
                                <tr><td class="dataTables_info" id="editable_info" role="alert" aria-live="polite" aria-relevant="all">显示 1 到 10 项，共 <%=i %> 项 </td>
                                <td ><div style="width:60%; margin:0 auto;align:right">
                               </div></td>
							</table>
                        
                    		</div>
</body>
</html>