<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.MenuService"%>
<%@page import="com.gxnu.service.IMenuService"%>
<%@ page import="com.gxnu.entity.Menu" %><%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2022/7/19
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>修改菜单信息</title>
    <style type="text/css">
        <!--
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
        }
        .STYLE1 {font-size: 12px}
        .STYLE3 {font-size: 12px; font-weight: bold; }
        .STYLE4 {
            color: #03515d;
            font-size: 12px;
        }
        -->
    </style>
    <script>
        function a() {
            window.document.getElementById("sbm").submit();
        }
    </script>
    <script language="javascript" type="text/javascript" src="<%=basePath%>tab/My97DatePicker/WdatePicker.js"></script>
</head>

<% Object m = request.getAttribute("MENU");
    Menu ei = new Menu();
if(m!=null){
       ei = (Menu)m;
   }
%>
<body>
<form id="sbm" action="http://192.168.1.169:8080/GIMS/menu?op=doUpdate" method="post">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="30" background="<%=basePath%>web/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="12" height="30"><img src="<%=basePath%>web/images/tab_03.gif" width="12" height="30" /></td>
                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="5%"><div align="center"><img src="<%=basePath%>web/images/tb.gif" width="16" height="16" /></div></td>
                                    <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[业务中心]-[修改邮件]</td>
                                </tr>
                            </table></td>
                            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
                                <tr>
                                    
                                </tr>
                            </table></td>
                        </tr>
                    </table></td>
                    <td width="16"><img src="<%=basePath%>web/images/tab_07.gif" width="16" height="30" /></td>
                </tr>
            </table></td>
        </tr>
        <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="8" background="<%=basePath%>web/images/tab_12.gif">&nbsp;</td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
                         <tr>
            <td height="20" width="30%" bgcolor="#FFFFFF"><div align="center">
              菜单名
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input name="name" type="text" value="<%=ei.getName()%>"></div>
            </div></td>
          </tr>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
             父菜单
            </div></td>
            <td height="20" bgcolor="#FFFFFF">
              <div align="center">
              <% 
                 IMenuService ims = new MenuService();
                List<Menu> menus = ims.findByParent(0);
              %>
              <select name="parent">
              <option value="0">请选择父菜单</option>
              <% for(Menu menu:menus) {%>
              <option  value="<%=menu.getId() %>" <% if(menu.getId()==ei.getParent()) out.print("select='select'"); %> ><%=menu.getName() %></option>
              <%} %>
              </select>
              </div>
            </td>
          </tr>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              URL
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input value="<%=ei.getUrl() %>" name="URL" type="text"></div>
            </div></td>
          </tr>
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
             菜单图片
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input name="img" type="text"></div>
            </div></td>
          </tr>
            </table></td>
        </tr>
        <tr>
            <td height="35" background="<%=basePath%>web/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="12" height="35"><img src="<%=basePath%>web/images/tab_18.gif" width="12" height="35" /></td>
                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <input type="button" value="修改" onclick="a()">
                        <input type="hidden" name="id" value="<%=ei.getId()%>">
                    </table></td>
                    <td width="30%" height="35"></td>
                </tr>
            </table></td>
        </tr>
    </table></form>
</body>
</html>

