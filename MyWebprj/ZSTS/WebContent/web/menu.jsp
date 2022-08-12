<%@page import="com.gxnu.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.MenuService"%>
<%@page import="com.gxnu.service.IMenuService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pageSize=5;			//每一页 上显示信息的最大条数
	int firstPage=1;		//首页的页码
	int previousPage=1;		//上一页的页码
	int nextPage=1;			//下一页的页码
	int lastPage=1;			//最后一页的页码
	int currentPage=1;		//当前的页码
	
	//获取请求参数P，该值为要显示的页码
	String cp = request.getParameter("P");
	if(cp!=null){
		currentPage = Integer.parseInt(cp);
	}

   //调用业务方法，检索所有菜单信息
   IMenuService menuService = new MenuService();
   List<Menu> menus = menuService.find();
   int total = menus.size(); //最记录条数
   //分页
   menus = menuService.find(currentPage,pageSize);
   
   //最后一页的页码
   if(total%pageSize==0){
	   lastPage = total/pageSize;
   }else{
	   lastPage = total/pageSize + 1;
   }
   
	//得到上一页的页号
   previousPage=currentPage-1;
   if(previousPage<=firstPage){
	previousPage=firstPage;
   }
	
   //得到下一页的页号
   nextPage=currentPage+1;
   if(nextPage>=lastPage){
	 nextPage=lastPage;
   }
   
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">
    <title>菜单</title>
     <link href="css/style.css?v=2.2.0" rel="stylesheet">
     </script>
<script>
   function xxx(n){
	   //重新跳转到menu.jsp，即“刷新tab.jsp”,且把要显示的号码以请求参数的方法进行传递，如 P=4
	   window.location.href="http://192.168.1.163:8080/ZSTS/web/menu.jsp?P="+n;
   }
</script>
</head>

<body style="background-color: white">
   <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>菜单管理</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                   
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                              <div class="ibox-content" >
                                <div class=""  >
                                    <a onclick="fnClickAddRow();" href="http://192.168.1.163:8080/ZSTS/web/addmenu.jsp" class="btn btn-primary ">添加行</a>
                                </div></br>
                                
                                <table border="0" style="width:85%"><tr>
                              <td>  <table border="0">
                                <tr>
                               <td style="align:right"> 每页</td>
                               <td style="width:40%"><select name="editable_length" aria-controls="editable" class="form-control input-sm"  style="width:100px;margin: 0 auto">
                             				   <option value="10"  >4</option><option value="25">10</option><option value="50">15</option></select></td> 
                               <td style="margin:60%;">条记录</br></td>
                               </tr></table></td>
                                
                               <td> <table border="0">
                                <tr>
                                <td id="editable_filter" class="dataTables_filter"> 查找：</td>
                                <td><input type="search" class="form-control input-sm" aria-controls="editable"  style="width:100px;margin: 0 auto"> </td>
                                </tr></table></td>
                                
                                </tr></td></table>
                                </br>
                               
                                <table class="table table-striped table-bordered table-hover  dataTable" id="editable" aria-describedby="editable_info" width="85%">
                                  
                                        <tr class="gradeA even">
                                            <td class="sorting_1">编号</td>
                                            <td class=" "> 名称</td>
                                            <td class=" ">父菜单</td>
                                            <td class="center ">URL</td>
                                            <td class="center ">预留</td>
                                              <td class="center ">基本操作</td>
                                        </tr>
                                        
			                                          <%
			            //循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
			            for(Menu menu : menus ) {
			          %>
                                 
                                        <tr class="gradeA even">
                                            <td class="sorting_1"><%=menus.indexOf(menu)+1%></td>
                                            <td class=" "><%=menu.getName() %></td>
                                            <td class="center "><%-- <%=menu.getParent() %> --%>
                                            <span> <!-- java中的条件表达式x?y:z   x为true，y为整个表达式的结果，否则z为整个表达式的结果 -->            
           									 <%=new MenuService().find(menu.getParent()).getName()==null?"自己":new MenuService().find(menu.getParent()).getName() %> </span></td>
                                            <td class="center "><%=menu.getURL() %></td>
                                             <td class=" "><%=menu.getYuliu() %> </td>
                                            <td class="center "  ><a href="http://192.168.1.163:8080/ZSTS/menu?OP=toupdate&id=<%=menu.getId()%>"  style="color: green;";">编辑</a>  &nbsp;&nbsp;&nbsp;&nbsp;
                                            <a href="http://192.168.1.163:8080/ZSTS/menu?id=<%=menu.getId()%>"  style="color: green;">删除</a></td>
                                        </tr> <%} %>
                                </table></div>
   
   							 	<table  border="0"  style="width:100%">
                                <tr><td class="dataTables_info" id="editable_info" role="alert" aria-live="polite" aria-relevant="all">&nbsp;&nbsp;共有 <%=total %> 条记录，当前第 <%=currentPage %>/<%=lastPage %> 页 </td>
                                <td ><div style="width:100%; align:center">
                                 <table border="0" class="t" id="editable" aria-describedby="editable_info"  >
                                <tr class="gradeA even">
                               		<td class="sorting_1"><input type="button" value="首页"  onclick="xxx(<%=firstPage%>)"/></td>
                                    <td class=" "> <input type="button" value="上一页"  onclick="xxx(<%=previousPage%>)"/></td>
                                    <td class=" "><input type="button" value="下一页"  onclick="xxx(<%=nextPage%>)"/></td>
                                    <td class="center "><input type="button" value="尾页"  onclick="xxx(<%=lastPage%>)"/></td>
                                     <td class="center " style="width:25%">转到第<input id="page" name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 页</td>
                                      <td class="center "><input type="button" value="转"  onclick="xxx(document.getElementById('page').value)"/></td>
                             	 </tr>
                               </table></div></td>
						</table>
                          
</body>

</html>
