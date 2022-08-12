<%@page import="com.gxnu.entity.Config"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<%
	Object obj = request.getAttribute("CONFIG");
	Config conf = new Config();
	if(obj!=null){
		conf =(Config)obj;
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>服务器信息修改</title>
<meta charset="UTF-8">
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
//window.flag =  function updateValue(e) {};
function tj(){
	//alert(window.document.getElementById("frm").action);
	//根据id获取html页面中的表单，并提交
	window.document.getElementById("frm").submit();
} 
//setTimeout(tj(), 500);
/* var flag = function updateValue(e){
	
}  */
</script>

</head>

<body>
<form id="frm" action="http://192.168.1.167:8080/GIMS/config?OP=update&id=<%=conf.getId() %>&flag=<script>window.document.getElementById('flag').value</script>" method="post">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="tab/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="tab/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="http://192.168.1.167:8080/GIMS/web/images/WebServer.png" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[服务器信息管理管理]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                     
                    </div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath %>/tab/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="<%=basePath %>/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center">
            
            </div></td>
            <td width="3%" height="22" background="<%=basePath %>/tab/images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"></span></div></td>
          </tr>
          <tr>
           <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">服务器版本：</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input type="text" name="textfield1" value="<%=conf.getVersion()%>"/></div> 
            </div></td>
          </tr>
       
          <tr>
           <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">IP地址：</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">
             	 <input type="text" id="ip" placeholder="Enter IP"  name="textfield2" value="<%=conf.getIp()%>"/>
             	 <label id="tip"style="color:red;" ></label>
             	 <input id="flag" type="hidden">
             	 <!-- <input type="button" id="btn" value="验证" /> -->
             	 <script>
             		var flag = window.document.getElementById('flag');
             		var input = window.document.getElementById('ip');
             		var Tip = document.getElementById("tip");
             		//input.addEventListener('input', updateValue);
             		input.addEventListener('change', updateValue);
					 function updateValue(e) {
						var pattern = /^((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})(\.((2(5[0-5]|[0-4]\d))|[0-1]?\d{1,2})){3}$/;
					    var str = window.document.getElementById("ip").value;
					    if(pattern.test(str)){
					    	Tip.innerHTML="";
					    	flag.value = "true";
					    	//alert(flag);
					    	window.document.getElementById("frm").action = 'http://192.168.1.167:8080/GIMS/config?OP=update&flag=true&id=<%=conf.getId() %>';
					    	return flag
					    }else{
							Tip.innerHTML="IP有误";
							flag.value =  "false";
							//alert(flag);
							window.document.getElementById("frm").action = 'http://192.168.1.167:8080/GIMS/config?OP=update&flag=false&id=<%=conf.getId() %>';
					    	return flag
					    }
					}	
				  </script>
           </div> 
            </div></td>
          </tr>
          
          <tr>
           <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
             <div align="center">端口号：</div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input type="text" name="textfield3" value="<%=conf.getPort()%>"/></div> 
            </div></td>
          </tr>
          
           <tr>
             <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"></div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><input type="button" value="修改" onclick="tj()"/></div>
            </div></td>
           </tr>
           
        </table></td>
        <td width="8" background="tab/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="tab/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="tab/images/tab_18.gif" width="12" height="35" /></td>
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
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</head>
</html>

