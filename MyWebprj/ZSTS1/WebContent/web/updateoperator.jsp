<%@page import="com.gxnu.service.Roleservice"%>
<%@page import="com.gxnu.entity.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.IRoleService"%>
<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Operator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = Data.URL+"/operator?op=doupdate";

String url1 = Data.URL + "/ZSTS/web/css/bootstrap.min.css?v=3.4.0";
String url2 = Data.URL + "/web/css/font-awesome.css?v=4.3.0";
String url3 = Data.URL + "/web/css/animate.css";
String url4 = Data.URL + "/web/css/style.css?v=2.2.0";


%>
<%
	
	Object obj = request.getAttribute("OPERATOR");
	Operator operator = new Operator();
	if(obj!=null){
		operator = (Operator)obj;
	}
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><meta name="renderer" content="webkit">

    <title>掌上唐山-操作员管理-添加用户</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="<%=url1 %>" rel="stylesheet">
    <link href="<%=url2 %>" rel="stylesheet">
    <link href="<%=url3 %>" rel="stylesheet">
    <link href="<%=url4 %>" rel="stylesheet">
	
<style type="text/css">
body {
	background-color: white
}
</style>	
	
</head>

<body style="background-color:#FFFFF">
			
            <div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>修改用户</h2>
                    <table>
                    <tr>
                    	<td>
                    		主页-
                    	</td>
                    	<td>
                    		操作员管理-
                    	</td>
                    	<td>
							修改用户                    	
                    	</td>
                    </tr>
                    </table>
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
                                <h5>用户修改表单</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                        <i class="fa fa-wrench"></i>
                                    </a>
                                   
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <form class="form-horizontal m-t" id="signupForm"
                                 id="frm" action="<%=url%>" method="post" enctype="multipart/form-data">
	                             <div class="form-group">
	                                        <label class="col-sm-3 control-label">用户名：</label>
	                                        <div class="col-sm-8">
	                                            <input id="username" name="username" class="form-control" type="text" value="<%=operator.getUsername()%>"
	                                            aria-required="true" aria-invalid="true" class="error" style="width: 1300px">
	                                        </div>
	                               </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">密码：</label>
                                        <div class="col-sm-8">
                                            <input id="password" name="password" class="form-control" type="password" value="<%=operator.getPassword()%>" 
                                            style="width: 1300px">
                                        </div>
                                    </div>
                                    
                                  <div class="form-group">
                                        <label class="col-sm-3 control-label">电话：</label>
                                        <div class="col-sm-8">
                                            <input id="tel" name="tel" class="form-control" type="tel" value="<%=operator.getTel()%>" style="width: 1300px">
                                        </div>
                                    </div>
                                    
                                    <!--   <div class="form-group">
                                        <label class="col-sm-3 control-label">头像：</label>
                                        <div class="col-sm-8">
                                            <input id="pic" name="pic" class="form-control" type="pic" value="<%=operator.getPic()%>" style="width: 1300px">
                                        </div>
                                    </div>--> 
                                    
                                      <div class="form-group">
                                        <label class="col-sm-3 control-label">角色：</label>
                                        <div class="col-sm-8">
                                            <select class="form-control m-b" name="role"
									style="width: 200px;">
									<option value="0" selected="selected">--请选择角色--</option>
									<%
										IRoleService irs = new Roleservice();
										List<Role> roles = irs.find();
										for (Role role : roles) {
									%>
									<option value="<%=role.getId()%>"><%=role.getName()%>
									</option>
									<%
										}
									%>
		
								</select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">E-mail：</label>
                                        <div class="col-sm-8">
                                            <input id="email" name="email" class="form-control" type="email" value="<%=operator.getEmail()%>" style="width: 1300px">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-8 col-sm-offset-3">
                                            <button class="btn btn-primary" type="submit">提交</button>
                                            <input type="hidden" name="ID" value="<%=operator.getId() %>">
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

</html>
