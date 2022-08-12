<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Doctor"%>
<%@page import="com.gxnu.service.imp.DoctorService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
     <%
     Object obj = session.getAttribute(Data.DOCTOR);
     Doctor doctor = new Doctor();
     if(obj!=null){
         doctor=(Doctor)obj; 
     }
     System.out.println(doctor+"daotordoctordoctor.....");
        %>
    
<!doctype html>
<html class="no-js" lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 医生信息管理 </title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/parsley.css">

    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    
    <script >
function tja(){
	//获取html页面中的表单
	window.document.getElementById("jsa").submit();
}
</script>
</head>
<body>
<div id="ihealth-layout" class="theme-tradewind">
   <!-- main body area -->
      <div class="main px-lg-4 px-md-4">
        <!-- Body: Body -->
        <div class="body d-flex py-3">
            <div class="container-xxl">
                <div class="row align-items-center">
                    <div class="border-0 mb-4">
                        <div class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                            <h3 class="fw-bold mb-0">医生个人信息</h3>
                        </div>
                    </div>
                     </div>
                    </div>
                </div> <!-- Row end  -->

                <div class="row align-item-center">
                    <div class="col-md-10">
                      
                            <div class="card-body">
                               
                                <form  id="jsa" action="<%=Data.URL%>/doctors?OP=doupdate" method="post" enctype="multipart/form-data">
                                    <div class="row g-3 align-items-center">
                                        <!--名称-->
                                        
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">姓名</label>
                                                <input type="text" name="n1" class="form-control" value="<%=doctor.getName()%>">
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">性别</label>
                                                <input type="text" name="n2" class="form-control"  value="<%=doctor.getSex()%>">
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">年龄</label>
                                                <input type="text" name="n3" class="form-control" value="<%=doctor.getAge()%>">
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">密码</label>
                                                <input type="text" name="n4" class="form-control" value="<%=doctor.getPassword()%>">
                                            </div>
                                        </div>
                                             <!--父菜单-->
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">电话</label>
                                                <input type="text" name="n5" class="form-control"  value="<%=doctor.getTel()%>">
                                            </div>
                                        </div>
                                         <div class="col-md-8">
                                            <div class="form-group">
                                                <label class="form-label">邮箱</label>
                                                <input type="text" name="n6" class="form-control" value="<%=doctor.getEmail()%>">
                                            </div>
                                        </div>  
                                                                           
                                         <div class="col-md-8">
                                            <div class="form-group">
                                                <label>头像</label>
                                              <input type="file" name="pic" />
											    <img src="http://localhost:8080/OMS/<%=doctor.getPic()%>" style="width:80px;"/>
                                            </div>
                                        </div>
     
                                                 <div class="col-md-10">   
                                                 <!-- 隐藏作用域，通过要把一个不需要的数据随同它一起使用表单进行提交 -->
                                                 <input type="hidden" name="id" value="<%=doctor.getId()%>"/>                                             
                                                 <input type="hidden" name="unitid" value="<%=doctor.getUnit().getId()%>"/>
                                                 <input type="hidden" name="postid" value="<%=doctor.getPost().getId()%>"/>                                            
                                                 <input type="hidden" name="username" value="<%=doctor.getUsername()%>"/>
                                                  <input type="hidden" name="yuliu" value="<%=doctor.getYuliu()%>"/>                                      
                                        <button  class="btn btn-primary" onclick="tja()">确定修改</button>  <a href="<%=Data.URL %>/Doctor/main.jsp">返回主页</a>
                                    </div>
                                   </div>
                                </form>
                            </div>
                        </div>                         
                            </div>
                        </div>
                    </div>
</body>
</html> 