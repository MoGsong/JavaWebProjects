<%@page import="com.gxnu.entity.lnformation"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //因为时请求过来 所以带有数据，直接获取到传过去的数据
Object obj=request.getAttribute("INFORMATION");  //传递过去的信息
    lnformation information=new lnformation();
if(obj!=null){
	information=(lnformation)obj;
}
  %>  
  
<!DOCTYPE html>

<%
String url=Data.URL+"/web";
%>
<html>
<script >
function tj(){
	//获取html页面中的表单
	window.document.getElementById("js").submit();
}
</script>

<head>    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>掌上唐山-民俗信息显示页面-添加更新</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="<%=url%>/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="<%=url%>/css/font-awesome.css?v=4.3.0" rel="stylesheet">
    <link href="<%=url%>/css/animate.css" rel="stylesheet">
    <link href="<%=url%>/css/style.css?v=2.2.0" rel="stylesheet">
    
  <style type="text/css">
body {
	background-color: white
}
</style>

</head>

<body>

            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>添加更新</h2>
                    <ol class="breadcrumb">
                        <li>
                            <a href="index.html">主页</a>
                        </li>
                        <li>
                            <a>民俗信息</a>
                        </li>
                        <li>
                            <strong>添加更新</strong>
                        </li>
                    </ol>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <div class="col-lg-12">

                <div class="row">
           
                   
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>民俗信息显示 </h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-user">
                                        <li><a href="form_basic.html#">选项1</a>
                                        </li>
                                        <li><a href="form_basic.html#">选项2</a>
                                        </li>
                                    </ul>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal m-t" id="signupForm" id="js" action="http://localhost:8080/ZSTS/xxx?OP=doupdate" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">类型</label>
                                        <div class="col-sm-8">
                                            <input id="firstname" name="types" class="form-control" type="text" value="<%=information.getTypes()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">内容</label>
                                        <div class="col-sm-8">
                                            <input id="lastname" name="content" class="form-control" type="text" 
                                            aria-required="true" aria-invalid="false" class="valid" value="<%=information.getContent()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">图片</label>
                                        <div class="col-sm-8">
                                            <input id="username" name="picture" class="form-control" type="text" aria-required="true" 
                                            aria-invalid="true" class="error" value="<%=information.getPicture()%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">更新时间</label>
                                        <div class="col-sm-8">
                                            <input id="password" name="time" class="form-control" type="text" value="<%=information.getTime()%>">
                                        </div>
                                    </div>
                                   
                                  
                                    <div class="form-group">
                                        <div class="col-sm-8 col-sm-offset-3">
                                        <!-- 隐藏id  隐藏作用域，通常把用于无需要的数据进行提交 -->
                                        <input type="hidden" name="id" value="<%=information.getId()%>"/>
                                            <button class="btn btn-primary" type="submit">确定</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>

 <!-- Mainly scripts -->
    <!--  -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/hplus.js?v=2.2.0"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="js/plugins/validate/jquery.validate.min.js"></script>
    <script src="js/plugins/validate/messages_zh.min.js"></script>
    <script>
        //以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
        $.validator.setDefaults({
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function (element) {
                element.closest('.form-group').removeClass('has-error').addClass('has-success');
            },
            errorElement: "span",
            errorClass: "help-block m-b-none",
            validClass: "help-block m-b-none"


        });

         //以下为官方示例
        $().ready(function () {
            // validate the comment form when it is submitted
            $("#commentForm").validate();

            // validate signup form on keyup and submit
            $("#signupForm").validate({
                rules: {
                    firstname: "required",
                    lastname: "required",
                    username: {
                        required: true,
                        minlength: 2
                    },
                    password: {
                        required: true,
                        minlength: 5
                    },
                    confirm_password: {
                        required: true,
                        minlength: 5,
                        equalTo: "#password"
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    topic: {
                        required: "#newsletter:checked",
                        minlength: 2
                    },
                    agree: "required"
                },
                messages: {
                    firstname: "请输入你的姓",
                    lastname: "请输入您的名字",
                    username: {
                        required: "请输入您的用户名",
                        minlength: "用户名必须两个字符以上"
                    },
                    password: {
                        required: "请输入您的密码",
                        minlength: "密码必须5个字符以上"
                    },
                    confirm_password: {
                        required: "请再次输入密码",
                        minlength: "密码必须5个字符以上",
                        equalTo: "两次输入的密码不一致"
                    },
                    email: "请输入您的E-mail",
                    agree: "必须同意协议后才能注册"
                }
            });

            // propose username by combining first- and lastname
            $("#username").focus(function () {
                var firstname = $("#firstname").val();
                var lastname = $("#lastname").val();
                if (firstname && lastname && !this.value) {
                    this.value = firstname + "." + lastname;
                }
            });
        });
    </script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script><!--统计代码，可删除-->

</body>
</form>
</html>
