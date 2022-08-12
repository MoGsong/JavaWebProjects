<%@page import="com.gxnu.entity.Operator"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object obj = session.getAttribute(Data.OPERATOR);
      Operator op = new Operator();
        if(obj!=null){
    	op = (Operator)obj;
    }
    %>
    <div align="center" style="margin:230px auto;width:800px;height:300px;">
    <p><span style="font-size:45px;font-family: 华文行楷;">欢迎<%=op.getUsername()%>使用掌上唐山后台管理系统</span></p>
    </div>
</body>
</html>
