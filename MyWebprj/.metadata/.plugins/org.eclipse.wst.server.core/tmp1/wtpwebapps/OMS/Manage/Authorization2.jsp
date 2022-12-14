<%@page import="java.util.ArrayList"%>
<%@page import="com.gxnu.entity.Authorization"%>
<%@page import="com.gxnu.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.gxnu.service.imp.MenuService"%>
<%@page import="com.gxnu.service.IMenuService"%>
<%@page import="com.gxnu.util.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>:: 权限管理</title>
    <!-- plugin css file  -->
    <link rel="stylesheet" href="static/css/responsive.dataTables.min.css">
    <link rel="stylesheet" href="static/css/dataTables.bootstrap5.min.css">
    <!-- project css file  -->
    <link rel="stylesheet" href="static/css/ihealth.style.min.css">
    <!-- Summernote css -->
    <link href="static/css/summernote-bs4.css" rel="stylesheet" type="text/css">
    <!-- Bootstrap Css -->
    <link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Icons Css -->
    <link href="static/css/icons.min.css" rel="stylesheet" type="text/css">
    <!-- App Css-->
    <link href="static/css/app.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="ihealth-layout" class="theme-tradewind">



        <!-- main body area -->
        <div class="main px-lg-4 px-md-4">

            <!-- Body: Header -->


            <!-- Body: Body -->
            <div class="body d-flex py-lg-3 py-md-2">
                <div class="container-xxl">
                    <div class="row align-items-center">
                        <div class="border-0 mb-4">
                            <div
                                class="card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap">
                                <h3 class="fw-bold mb-0">权限管理</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- Row end  -->
            
			<form action="<%=Data.URL %>/authorization?OP=update" method="post">
				<%
					Object obj = session.getAttribute(Data.AUTHORIZATION);
					List<Authorization> authorizations = new ArrayList<Authorization>();
					if(obj!=null){
						authorizations = (List<Authorization>)obj;
					}
				%>
				<%
					IMenuService ims = new MenuService();
					List<Menu> menus = ims.findByParent(0);
					for(Menu menu:menus){				
				%>
			        <input name="menus" value="<%=menu.getId() %>" type="checkbox" 
			        <%for(Authorization au:authorizations){ if(au.getMenu().getId()==menu.getId()){out.print("checked='checked'");break;}}%> /><%=menu.getName() %><br/>
					<%
						List<Menu> sons = ims.findByParent(menu.getId());
						for(Menu son:sons){
					%>
						 &nbsp;&nbsp;&nbsp;&nbsp;<input name="menus" value="<%=son.getId() %>" type="checkbox" 
						<%for(Authorization authorization:authorizations){if(son.getId()==authorization.getMenu().getId()){out.print("checked='checked'");break;}}%>/><%=son.getName() %><br/>
						<% 
						 	  } 	
						}
				%>
			<input type="hidden" name="roleid" value="<%=request.getParameter("roleid")%>"/>
			<button type="submit" class="btn btn-primary btn-set-task w-sm-100"
	                    data-bs-toggle="modal" ><i
	                        class="icofont-plus-circle me-2 fs-6"></i>确定</button>
            
  			</form>
        </div>
    </div>

    <!-- Modal Custom Settings-->
  

    <!-- Jquery Core Js -->
    <script src="static/js/libscripts.bundle.js"></script>
    <!-- JAVASCRIPT -->
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/bootstrap.bundle.min.js"></script>
    <script src="static/js/metisMenu.min.js"></script>
    <script src="static/js/simplebar.min.js"></script>
    <script src="static/js/waves.min.js"></script>

    <script src="static/js/bundle.js"></script>

    <!-- Summernote js -->
    <script src="static/js/summernote-bs4.min.js"></script>

    <!-- init js -->
    <script src="static/js/summernote.init.js"></script>

    <script src="static/js/app.js"></script>

    <!-- Plugin Js-->
    <script src="static/js/dataTables.bundle.js"></script>

    <!-- Jquery Page Js -->
    <script src="static/js/template.js"></script>
    <script>
        // project data table
        $(document).ready(function () {
            $('#myProjectTable')
                .addClass('nowrap')
                .dataTable({
                    responsive: true,
                    columnDefs: [
                        { targets: [-1, -3], className: 'dt-body-right' }
                    ]
                });
            $('.deleterow').on('click', function () {
                var tablename = $(this).closest('table').DataTable();
                tablename
                    .row($(this)
                        .parents('tr'))
                    .remove()
                    .draw();

            });
        });
    </script>
</body>

</html>