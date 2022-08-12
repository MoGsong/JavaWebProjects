<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.entity.Operator"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
body {
	background-size: 1300px 800px;
	background-image: url("static/picture/welcome1.jpg");
	background-repeat: no-repeat;
	background-position: right top;
	background-attachment: fixed;
}
</style>
</head>
<body>
<%
    Object obj = session.getAttribute(Data.OPERATOR);
      Operator op = new Operator();
        if(obj!=null){
        	op  = (Operator)obj;
    }
        System.out.print(op);
    %>
    <div align="center" style="margin:230px auto;width:800px;height:300px;">
    <p><span style="font-size:45px;font-family: 华文行楷;">欢迎<%=op.getRole().getName()%>使用在线医疗后台管理系统</span></p>
    </div>
</body>
</html>
