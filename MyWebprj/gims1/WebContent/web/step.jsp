<%@page import="com.gxnu.service.IRoleService"%>
<%@page import="com.gxnu.service.imp.RoleService"%>
<%@page import="com.gxnu.entity.Role"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>step</title>
</head>

<body>
<br/>
    <span style="color:rgb(22, 20, 20);font-size: 20px;">权限管理</span>
	<form action="http://localhost:8080/GIMS/jurisdiction?OP=toupdate" method="post">
        <select name="roleid">
            <option value="0" selected="selected">--请选择角色--</option>
            <%
            //查询所有角色  获取动态权限，添加下拉框
            IRoleService irs=new RoleService();
            List<Role> roles=irs.find();
            for(Role role:roles){          
            %>
            <option value="<%=role.getId()%>">--<%=role.getName()%>--</option>
            <%
            }
            %>           
        </select>&nbsp;&nbsp;
        <!-- submit自带提交按钮 -->
        <input type="submit" value="确定"/>
    </form>
</body>
</html>
