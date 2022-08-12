<%@page import="com.gxnu.util.Data"%>
<%@page import="java.util.Date"%>
<%@page import="com.gxnu.entity.Operator"%>
<%@page import="com.gxnu.service.imp.OperatorService"%>
<%@page import="com.gxnu.service.IOperatorService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//获取参数
	IOperatorService ios = new OperatorService();
	String obj = request.getParameter("lating");
	long end = Long.parseLong(obj);
	String flag = request.getParameter("flag");
	String id = request.getParameter("operatorid");
	Operator op = ios.find(Integer.parseInt(id));
	String url = Data.URL + "/ResetPasswordAction?operatorId="+op.getId(); 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>重置用户密码</title>
    <link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=2.2.0" rel="stylesheet">
  <style>
 body {
	background-size: cover;
	background-image: url("images/back1.jpg");
	background-repeat: no-repeat;
	background-position: right top;
	background-attachment: fixed;
}
 </style>
</head>
<body >
    <div style="height:150px;"></div>
    <div id="title"><h1 style="font-family:华文行楷,serif;text-align:center;">修改密码</h1></div>
    <!-- 连接有效 -->
    <form class="form-horizontal m-t" action=<%=url %> id="signupForm" method="post">
        
        <div class="form-group" style="width: 400px;margin:0px auto;">
            <label class="col-sm-3 control-label">新密码</label>
            <div class="col-sm-8">
                <input id="password" name="password"  class="form-control" type="password">
            </div>
        </div>
        <div class="form-group" style="width: 400px;margin:10px auto;">
            <label class="col-sm-3 control-label">确认密码</label>
            <div class="col-sm-8">
                <input id="confirm_password" name="confirm_password"  class="form-control" type="password">
            </div>
        </div>
        <div class="form-group"style="width: 400px;margin:0px auto;">
            <div class="col-sm-8 col-sm-offset-3">
                <button type="submit" class="btn btn-primary block full-width m-b">提交</button>
            </div>
        </div>
    </form>
    
    <!-- 连接无效 -->
    <form class="form-horizontal m-t"  id="failureForm">
        <div class="form-group" style="width: 400px;margin:0px auto;">
         	<div><h1 style="font-family:华文行楷,serif;text-align:center;color:black;"><a href="web/ForgetPassword.jsp">
         		该链接已失效，请重新申请。
         	</a></h1></div>  
        </div>
        <div class="form-group"style="width: 400px;margin:0px auto;">
            <div class="col-sm-8 col-sm-offset-3">
            </div>
        </div>
    </form>
    
<script type="text/javascript">
//调用judge
window.onload = judge;
var myInterval;
function judge(){
	var  FLAG = <%=flag%>;
	myInterval = setInterval(function(){ 
		var time = new Date();
		var now = time.getTime();
		//alert(now);
		var end = <%=end %>;
		if((end-now)<=0){FLAG = "false";alert(FLAG);} 
		if(FLAG = "true" && (end - now) >= 0) {
				//alert(end-now);
				document.getElementById("signupForm").style.display = "block";
				document.getElementById("failureForm").style.display = "none";
			}else{
				//alert(end-now);
				document.getElementById("signupForm").style.display = "none";
				document.getElementById("title").style.display = "none";
				document.getElementById("failureForm").style.display = "block";
				stopInterval();
			}

		}, 200);

		}, 2000);

		}, 100);


	}
	
	function stopInterval() {
		clearInterval(myInterval);
	}


		//stopInterval();
	
</script>
	
    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.min.js"></script>
    <script src="js/bootstrap.min.js?v=3.4.0"></script>
    <script src="js/jquery.metisMenu.js"></script>
    <script src="js/jquery.slimscroll.min.js"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/messages_zh.min.js"></script>
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

</body>
</html>
