/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2022-08-10 03:34:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gxnu.entity.Menu;
import com.gxnu.service.imp.MenuService;
import com.gxnu.service.IMenuService;
import com.gxnu.util.Data;
import java.util.ArrayList;
import com.gxnu.entity.Menu;
import java.util.List;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.gxnu.service.imp.MenuService");
    _jspx_imports_classes.add("com.gxnu.service.IMenuService");
    _jspx_imports_classes.add("com.gxnu.util.Data");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.gxnu.entity.Menu");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html class=\"no-js\" lang=\"en\" dir=\"ltr\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <title>:: 菜单管理</title>\r\n");
      out.write("    <!-- Summernote css -->\r\n");
      out.write("    <link href=\"static/css/summernote-bs4.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <!-- plugin css file  -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/responsive.dataTables.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/dataTables.bootstrap5.min.css\">\r\n");
      out.write("    <!-- project css file  -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/ihealth.style.min.css\">\r\n");
      out.write("    <!-- Bootstrap Css -->\r\n");
      out.write("    <link href=\"static/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <!-- Icons Css -->\r\n");
      out.write("    <link href=\"static/css/icons.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <!-- App Css-->\r\n");
      out.write("    <link href=\"static/css/app.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"ihealth-layout\" class=\"theme-tradewind\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <!-- main body area -->\r\n");
      out.write("        <div class=\"main px-lg-4 px-md-4\">\r\n");
      out.write("                       \r\n");
      out.write("\r\n");
      out.write("            <!-- Body: Body -->\r\n");
      out.write("            <div class=\"body d-flex py-lg-3 py-md-2\">\r\n");
      out.write("                <div class=\"container-xxl\">\r\n");
      out.write("                    <div class=\"row align-items-center\">\r\n");
      out.write("                        <div class=\"border-0 mb-4\">\r\n");
      out.write("                            <div\r\n");
      out.write("                                class=\"card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">\r\n");
      out.write("                                <h3 class=\"fw-bold mb-0\">菜单管理</h3>\r\n");
      out.write("                                <div class=\"col-auto d-flex w-sm-100\">\r\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-primary btn-set-task w-sm-100\"\r\n");
      out.write("                                        data-bs-toggle=\"modal\" data-bs-target=\"#depadd\"><i\r\n");
      out.write("                                            class=\"icofont-plus-circle me-2 fs-6\"></i>添加</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div> <!-- Row end  -->\r\n");
      out.write("                    <div class=\"row clearfix g-3\">\r\n");
      out.write("                        <div class=\"col-sm-12\">\r\n");
      out.write("                            <div class=\"card mb-3\">\r\n");
      out.write("                                <div class=\"card-body\">\r\n");
      out.write("                                    <table id=\"myProjectTable\" class=\"table table-hover align-middle mb-0\"\r\n");
      out.write("                                        style=\"width:100%\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("\t                                            <th>序号</th>\r\n");
      out.write("\t                                            <th>名称</th> \r\n");
      out.write("\t                                            <th>父菜单</th> \r\n");
      out.write("\t                                            <th>URL</th>   \r\n");
      out.write("\t                                            <th>基本操作</th> \r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                        <!-- 此处调用业务层方法,返回一个Menu对象集合，循环遍历 -->\r\n");
      out.write("                                        ");
 IMenuService ims = new MenuService();
                                           List<Menu> menus = ims.find();
                                           int i = 1;
                                           for(Menu menu : menus){
                                        	  
                                        
      out.write("\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <span class=\"fw-bold\">");
      out.print(i++ );
      out.write("</span>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <!-- 菜单名称 -->\r\n");
      out.write("                                                    <span class=\"fw-bold ms-1\">");
      out.print(menu.getName());
      out.write("</span>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <!-- 父菜单-->\r\n");
      out.write("                                                   <span>");
      out.print(new MenuService().find(menu.getParent()).getName()==null?"无":new MenuService().find(menu.getParent()).getName() );
      out.write("</span>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <!-- URL -->\r\n");
      out.write("                                                    <span>");
      out.print(menu.getUrl());
      out.write("</span>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                               ");
      out.write("\r\n");
      out.write("                                                <td>\r\n");
      out.write("                                                    <div class=\"btn-group\" role=\"group\"\r\n");
      out.write("                                                        aria-label=\"Basic outlined example\">\r\n");
      out.write("                                                        \r\n");
      out.write("                                                        <button type=\"button\" class=\"btn btn-outline-secondary\"\r\n");
      out.write("                                                            data-bs-toggle=\"modal\" data-bs-target=\"#depedit\" onclick=\"edit(this,");
      out.print(menu.getId());
      out.write(")\"><i\r\n");
      out.write("                                                                class=\"icofont-edit text-success\"></i></button>\r\n");
      out.write("                                                             \r\n");
      out.write("                                                        <button type=\"button\"\r\n");
      out.write("                                                            onclick=\"window.location.href='");
      out.print(Data.URL);
      out.write("/menu?OP=delete&ID=");
      out.print(menu.getId());
      out.write("'\"><i\r\n");
      out.write("                                                                class=\"icofont-ui-delete text-danger\"></i></button>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </td>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                           ");
} 
      out.write("\r\n");
      out.write("                                        </tbody>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div><!-- Row End -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- Modal Custom Settings-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <!-- 添加菜单-->\r\n");
      out.write("            <div class=\"modal fade\" id=\"depadd\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("                <div class=\"modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h5 class=\"modal-title  fw-bold\" id=\"depaddLabel\">添加菜单</h5>\r\n");
      out.write("                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"deadline-form\">\r\n");
      out.write("                                <form action=\"");
      out.print(Data.URL);
      out.write("/menu?OP=add\" method=\"post\">\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"depone\" class=\"form-label\">菜单名称</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"depone\" name=\"NAME\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"deptwo\" class=\"form-label\">父菜单</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"deptwo\" name=\"PARENT\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"depthree\" class=\"form-label\">url</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"depthree\" name=\"URL\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                    <label for=\"depfour\" class=\"form-label\">预留</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"depfour\" name=\"YULIU\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"summernote\"></div>\r\n");
      out.write("                                    <!-- end row -->\r\n");
      out.write("                                    <!-- end row -->\r\n");
      out.write("                                    <!-- end container-fluid -->\r\n");
      out.write("                                    <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t                            <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t                            <button type=\"submit\" class=\"btn btn-primary\">添加</button>\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- 编辑菜单-->\r\n");
      out.write("            <div class=\"modal fade\" id=\"depedit\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("                <div class=\"modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h5 class=\"modal-title  fw-bold\" id=\"depeditLabel\"> 编辑菜单</h5>\r\n");
      out.write("                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"deadline-form\">\r\n");
      out.write("                                <form action=\"");
      out.print(Data.URL);
      out.write("/menu?OP=update\" method=\"post\">\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"depone\" class=\"form-label\">菜单名称</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"updateone\" name=\"NAME\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"deptwo\" class=\"form-label\">父菜单</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"updatetwo\" name=\"PARENT\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <label for=\"depthree\" class=\"form-label\">url</label>\r\n");
      out.write("                                        <input type=\"text\" class=\"form-control\" id=\"updatethree\" name=\"URL\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                    <label for=\"depfour\" class=\"form-label\">预留</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"updatefour\" name=\"YULIU\">\r\n");
      out.write("                                    <input type=\"hidden\" class=\"form-control\" id=\"updatefive\" name=\"ID\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"summernote\"></div>\r\n");
      out.write("                                    <!-- end row -->\r\n");
      out.write("                                    <!-- end row -->\r\n");
      out.write("                                    <!-- end container-fluid -->\r\n");
      out.write("                                    <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t                            <button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">取消</button>\r\n");
      out.write("\t\t\t                            <button type=\"submit\" class=\"btn btn-primary\">修改</button>\r\n");
      out.write("\t\t\t                            \r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                       \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Jquery Core Js -->\r\n");
      out.write("    <script src=\"static/js/libscripts.bundle.js\"></script>\r\n");
      out.write("    <!-- JAVASCRIPT -->\r\n");
      out.write("    <script src=\"static/js/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"static/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"static/js/metisMenu.min.js\"></script>\r\n");
      out.write("    <script src=\"static/js/simplebar.min.js\"></script>\r\n");
      out.write("    <script src=\"static/js/waves.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"static/js/bundle.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Summernote js -->\r\n");
      out.write("    <script src=\"static/js/summernote-bs4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- init js -->\r\n");
      out.write("    <script src=\"static/js/summernote.init.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"static/js/app.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Plugin Js-->\r\n");
      out.write("    <script src=\"static/js/dataTables.bundle.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Jquery Page Js -->\r\n");
      out.write("    <script src=\"static/js/template.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("\t    function edit(obj,id){\r\n");
      out.write("\t        var $td= $(obj).parents('tr').children('td');\r\n");
      out.write("\t       \r\n");
      out.write("\t        var name = $td.eq(1).text().replace(/\\s*/g,\"\");\r\n");
      out.write("\t        var parent = $td.eq(2).text().replace(/\\s*/g,\"\");\r\n");
      out.write("\t        var url = $td.eq(3).text().replace(/\\s*/g,\"\");\r\n");
      out.write("\t        var yuliu = $td.eq(4).text().replace(/\\s*/g,\"\");\r\n");
      out.write("\t        //alert(tel);\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t//var i= address.toString();\r\n");
      out.write("\t       \r\n");
      out.write("\t       $(\"#updateone\").val(name); \r\n");
      out.write("\t      //  $(\"#updateName\").css('color','red').val(\"qqq\"+tel);\r\n");
      out.write("\t      $(\"#updatetwo\").val(parent);\r\n");
      out.write("\t        $(\"#updatethree\").val(url);\r\n");
      out.write("\t        $(\"#updatefour\").val(yuliu);\r\n");
      out.write("\t      //  $(\"#updateTel\").css('color','red').css('text-align','left');\r\n");
      out.write("\t        $(\"#updatefive\").val(id);\r\n");
      out.write("\t\t\r\n");
      out.write("\t        //控制台输出测试\r\n");
      out.write("\t        //console.log(id);\r\n");
      out.write("\t        //console.log(name);\r\n");
      out.write("\t        //console.log(address);\r\n");
      out.write("\t        //console.log(principal);\r\n");
      out.write("\t        //console.log(tel);\r\n");
      out.write("\t      \r\n");
      out.write("\t    }    \r\n");
      out.write("    </script>\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("        // project data table\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $('#myProjectTable')\r\n");
      out.write("                .addClass('nowrap')\r\n");
      out.write("                .dataTable({\r\n");
      out.write("                    responsive: true,\r\n");
      out.write("                    columnDefs: [\r\n");
      out.write("                        { targets: [-1, -3], className: 'dt-body-right' }\r\n");
      out.write("                    ]\r\n");
      out.write("                });\r\n");
      out.write("            $('.deleterow').on('click', function () {\r\n");
      out.write("                var tablename = $(this).closest('table').DataTable();\r\n");
      out.write("                tablename\r\n");
      out.write("                    .row($(this)\r\n");
      out.write("                        .parents('tr'))\r\n");
      out.write("                    .remove()\r\n");
      out.write("                    .draw();\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}