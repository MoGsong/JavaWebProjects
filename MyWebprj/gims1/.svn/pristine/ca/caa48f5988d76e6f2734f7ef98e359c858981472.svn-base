<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.Authorization"%>
<%@page import="com.gxnu.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.MenuService"%>
<%@page import="com.gxnu.service.IMenuService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //获取上一个资源（servlet）转发过来的数据（当前角色已经拥有的权限）
   Object obj =  request.getAttribute("JURISDICTIONS");
   List<Authorization> authorizations = new ArrayList<Authorization>();
   if(obj!=null){
	   authorizations = (List<Authorization>)obj;//{(2,22),(2,23),(2,24)}
   }
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>step2</title>
</head>

<body>
	<form action="http://localhost:8080/GIMS/jurisdiction?OP=doupdate" method="post">
	    <%
        // 先把所有父菜单显示，然后再把某个父菜单下的所有子菜单显示出来
   		IMenuService ims = new MenuService();
   		List<Menu> fathers = ims.findByParent(0); // {id=1，id=2}
   		for (int i = 0; i < fathers.size(); i++) {
       %>
        <input name="menus" value="<%=fathers.get(i).getId() %>" type="checkbox"  <%for(Authorization au:authorizations){ if(au.getMenu().getId()==fathers.get(i).getId()){ out.print("checked='checked'");break;}} %> /><%=fathers.get(i).getName() %><br/>
        
                 <%   List<Menu> sons = ims.findByParent(fathers.get(i).getId());
					  for (Menu son : sons) {
				 %>
				         &nbsp;&nbsp;&nbsp;&nbsp;  
				         <input name="menus" value="<%=son.getId() %>" type="checkbox" <%for(Authorization au:authorizations){ if(au.getMenu().getId()==son.getId()){ out.print("checked='checked'");break;}} %> /><%=son.getName() %><br/>
				 
				<%} %>	        
        <%
   		  }
        %>
      
        <!-- 隐藏作用域，通常用于把一个无需显示的数据随同其它一起使用表单进行提交 -->
        <input type="hidden" name="roleid" value="<%=request.getParameter("roleid")%>"/>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>