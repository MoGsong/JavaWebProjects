<%@ page import="com.gxnu.entity.AboutUs"  %>
<%@ page import="com.gxnu.service.IAboutUsService"  %>
<%@ page import="com.gxnu.service.imp.AboutUsService"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//request.getScheme()--当前页面使用的协议,比如"http”
//request.getServerName()--当前服务器的名字,比如“localhost"
//request.getServerPort()-当前服务器使用的端口
//request.getContextPath()—当前应用的名字,就是工程的名字。

String path = request.getContextPath();
String basePath = request.getScheme()+ "://"+request.getServerName()+":"+request.getServerPort()+path+"/web/";
//System.out.println(basePath);

%>
<%
//获取上一个资源（servlet）转发过来的数据
IAboutUsService eis = new AboutUsService();
AboutUs aboutUs = eis.find(1);

//request.setAttribute("aboutUs",aboutUs);

/*
Object obj = request.getAttribute("aboutUs");
AboutUs aboutUs =new AboutUs(); 
if(obj!=null){
	aboutUs = (AboutUs)obj;
	
}*/

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>关于我们</title>
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

.STYLE_input {width: 400px}

-->
</style>



<!-- 提交表单后的动作 -->
<script>
function tj(){
	//根据id获取html页面中的表单，并提交
	window.document.getElementById("frm").submit();
}
</script>

</head>

<body>
<!--通过OP来确定进行add操作  -->
<form id="frm" action="http://192.168.1.131:8080/GIMS/aboutUsAction?OP=doUpdate" method="post">

<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td height="30" background="<%=basePath %>images/tab_05.gif">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="12" height="30"><img src="<%=basePath %>images/tab_03.gif" width="12" height="30" /></td>
	        <td>
	        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td width="46%" valign="middle">
		            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		              		<tr>
				                <td width="5%"><div align="center"><img src="<%=basePath %>images/tb.gif" width="16" height="16" /></div></td>
				                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[关于我们]-[修改信息]</td>
		           			</tr>
		            	</table>
		      		</td>
		      		<td width="54%"></td>
		   		</tr>
		      </table>
	         </td>
	        </tr>
	     </table>
    </td>
    <td width="16"><img src="<%=basePath %>images/tab_07.gif" width="16" height="30" /></td>
    </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath %>images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="15%" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">"关于我们"</span></div></td>
            <td width="85%" height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">详细内容</span></div></td>
          </tr>
          <tr>
           <td height="300" bgcolor="#FFFFFF"><div align="center" class="STYLE1"  style="padding-bottom: 60px;padding-top: 60px">
              <div align="center">系统简介</div>
            </div></td>
            <td height="300" bgcolor="#FFFFFF">
	            <div align="center" class="STYLE1">
	              <div align="center">
	              	<textarea type="text" name="c_synopsis" cols="110" style="border: none;"><%=aboutUs.getSynopsis()%>
	              	</textarea>
	              	</div>
	            </div>
            </td>
          </tr>
          
          <tr>
           <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1" style="padding-bottom: 20px;padding-top: 20px">
              <div align="center">公司名称</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF">
	            <div align="center" class="STYLE1">
	              <div align="center">
	              	<input type="text" name="c_name" value="<%=aboutUs.getName()%>"  class="STYLE_input" style="border: none;"/>
	              	</div>
	            </div>
            </td>
          </tr>
         
          <tr>
             <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1" style="padding-bottom: 20px;padding-top: 20px">
              <div align="center">公司电话</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF">
	            <div align="center" class="STYLE1">
	              <div align="center">
	              	<input type="text" name="c_tel" value="<%=aboutUs.getTel() %>"   class="STYLE_input" style="border: none;"/>
	              	</div>
	            </div>
            </td>
           </tr>
           
            <tr>
             <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1" style="padding-bottom: 20px;padding-top: 20px">
              <div align="center">公司地址</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF">
	            <div align="center" class="STYLE1">
	              <div align="center">
	              	<input type="text" name="c_address" value="<%=aboutUs.getAddress()%>"  class="STYLE_input" style="border: none;"/>
	              	</div>
	            </div>
            </td>
           </tr>
           
            <tr>
             <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1" >
              <div align="center"></div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF" style="padding-bottom: 20px;padding-top: 20px">
            	<div align="center" class="STYLE1">
            	<!--隐藏作用域，通常用于把一个无需显示的数据随其它一起使用表单进行提交  -->
            	<input type="hidden" name="id" value="<%=aboutUs.getId()%>"></input>
              	<div align="center"><input type="button" value="确定" onclick="tj()"/></div>
            	</div>
            </td>
           </tr>
           
        </table></td>
        <td width="8" background="<%=basePath %>images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=basePath %>images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath %>images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4"></td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"></td>
                  <td width="45"></td>
                  <td width="45"></td>
                  <td width="40"></td>
                  <td width="100"><div align="center"></div></td>
                  <td width="40"></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath %>images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
