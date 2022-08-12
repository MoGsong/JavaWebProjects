<%@page import="com.gxnu.util.Data"%>
<%@page import="com.gxnu.entity.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//获取session对象中当前登录的用户数据
	Object obj = request.getAttribute("MENU");
	Menu menu = new Menu();
	if(obj!=null){
		menu = (Menu)obj;
	}
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">

<title>掌上唐山-菜单页面-修改菜单</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="http://192.168.1.163:8080/ZSTS/web/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="http://192.168.1.163:8080/ZSTS/web/css/font-awesome.css?v=4.3.0" rel="stylesheet">
<link href="http://192.168.1.163:8080/ZSTS/web/css/animate.css" rel="stylesheet">
<link href="http://192.168.1.163:8080/ZSTS/web/css/style.css?v=2.2.0" rel="stylesheet">

<%
String url =Data.URL+"/menu?OP=doupdate";
%>
</head>


<body>

	<div class="row wrapper border-bottom white-bg page-heading">
		<div class="col-lg-10">
			<h2>修改菜单</h2>
			<ol class="breadcrumb">
				<li><a>主页</a></li>
				<li><a>菜单管理</a></li>
				<li><strong>修改菜单</strong></li>
			</ol>
		</div>
		<div class="col-lg-2"></div>
	</div>


	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-lg-12">

				<div class="row">


					<div class="ibox float-e-margins">
						<div class="ibox-title">

							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> <a class="dropdown-toggle" data-toggle="dropdown"
									href="form_basic.html#"> <i class="fa fa-wrench"></i>
								</a> <a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="frm"  action=<%=url%>
								method="post">

								<div class="form-group">
									<label class="col-sm-3 control-label">名称：</label>
									<div class="col-sm-8">
										<input id="name" name="name" class="form-control" type="text"
											aria-required="true" aria-invalid="true" class="error"
											value="<%=menu.getName()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">父菜单：</label>
									<div class="col-sm-8">
										<input id="parent" name="parent" class="form-control"
											type="text"  value="<%=menu.getParent()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">URL：</label>
									<div class="col-sm-8">
										<input id="URL" name="URL" class="form-control" type="text" value="<%=menu.getURL()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">预留：</label>
									<div class="col-sm-8">
										<input id="yuliuyuliu" name="yuliu" class="form-control"
											type="text"  value="<%=menu.getYuliu()%>">
									</div>
								</div>


							   <div class="form-group">
                                        <div class="col-sm-8 col-sm-offset-3">
                                            <button class="btn btn-primary" type="submit" >提交</button>
                                        </div>
                                    </div>
                                    <!-- 隐藏作用域，通常用于把一个无需显示的数据随同其他一起使用表达提交 -->
                                    <input type="hidden" name="ID" value="<%=menu.getId()%>" />
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

         

    </script>

	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<!--统计代码，可删除-->

</body>

</html>
