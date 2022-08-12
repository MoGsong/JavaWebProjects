<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Operator"%>
<%@page import="com.gxnu.service.imp.OperatorService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
    Object obj = session.getAttribute(Data.OPERATOR);
    Operator operator = new Operator();
    if(obj!=null){
    	operator=(Operator)obj; 
    }
   // System.out.println(operator+"opopopopoopopop");  
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
<form  id="js" action="http://localhost:8080/OMS/Operaor?OP=toupdate" method="post" enctype="multipart/form-data">
<div id="ihealth-layout" class="theme-tradewind">
   <!-- main body area -->
      <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">操作员信息</h3>
                        </div>
                    </div>
                </div> <!-- Row end  -->

                <div class="row align-item-center">
                    <div class="col-md-10">
                      
                            <div class="card-body">
                                <form id="basic-form" method="post" novalidate="">
                                    <div class="row g-3 align-items-center">
                                        <!--名称-->
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">密码</label>
                                                <input type="text" name="name1" class="form-control" value="<%=operator.getPassword()%>">
                                            </div>
                                        </div>
                                             <!--父菜单-->
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">电话</label>
                                                <input type="text" name="name2" class="form-control" value="<%=operator.getTel()%>">
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>头像</label>
                                               <input type="file" name="pic" />
											 <img src="http://localhost:8080/OMS/<%=operator.getPic()%>" style="width:40px;"/>
                                            </div>
                                        </div>
                                                                                                                  
                                        
                                        <p> <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">邮箱</label>
                                                <input type="text" name="name4" class="form-control" value="<%=operator.getEmail()%>">
                                            </div>
                                        </div>
                                        </p>
                                        <div class="col-md-10">
                                        <!-- 隐藏作用域，通过要把一个不需要的数据随同它一起使用表单进行提交 -->
                                               <input type="hidden" name="id" value="<%=operator.getId()%>"/>
                                                <input type="hidden" name="roleid" value="<%=operator.getRole().getId()%>"/>
                                                <input type="hidden" name="username" value="<%=operator.getUsername()%>"/>
                                        <button type="submit" class="btn btn-primary" onclick="tj()">确定修改</button>  <a href="<%=Data.URL %>/Manage/index.jsp">返回主页</a>
                                    </div>
                                   </div>
                                </form>
                            </div>
                        </div>
                          
                            </div>
                        </div>
                    </div>


</body>
</form>
</html> 