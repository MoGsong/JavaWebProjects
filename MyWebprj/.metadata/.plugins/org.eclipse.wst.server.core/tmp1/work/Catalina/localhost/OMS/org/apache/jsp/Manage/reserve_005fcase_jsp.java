/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2022-08-11 01:19:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gxnu.util.Data;
import java.util.ArrayList;
import com.gxnu.dao.ReserveCaseDAO;
import java.util.List;
import com.gxnu.entity.ReserveCase;
import com.gxnu.service.imp.ReserveCaseService;

public final class reserve_005fcase_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.gxnu.dao.ReserveCaseDAO");
    _jspx_imports_classes.add("com.gxnu.entity.ReserveCase");
    _jspx_imports_classes.add("com.gxnu.util.Data");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.gxnu.service.imp.ReserveCaseService");
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
      out.write("    \r\n");
      out.write("     ");

        ReserveCaseDAO reservecaseDAO = new ReserveCaseDAO();    
		List<ReserveCase> reservecases =reservecaseDAO.findAll();			
     
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html class=\"no-js\" lang=\"en\" dir=\"ltr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <title>:: 操作员管理 </title>\r\n");
      out.write("    <!-- plugin css file  -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/parsley.css\">\r\n");
      out.write("\r\n");
      out.write("    <!-- project css file  -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"static/css/ihealth.style.min.css\">\r\n");
      out.write("    \r\n");
      out.write("    <script >\r\n");
      out.write("function tj(){\r\n");
      out.write("\t//获取html页面中的表单\r\n");
      out.write("\twindow.document.getElementById(\"js\").submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"ihealth-layout\" class=\"theme-tradewind\">\r\n");
      out.write("   <!-- main body area -->\r\n");
      out.write("      <div class=\"main px-lg-4 px-md-4\">\r\n");
      out.write("        <!-- Body: Body -->\r\n");
      out.write("        <div class=\"body d-flex py-3\">\r\n");
      out.write("            <div class=\"container-xxl\">\r\n");
      out.write("                <div class=\"row align-items-center\">\r\n");
      out.write("                    <div class=\"border-0 mb-4\">\r\n");
      out.write("                        <div class=\"card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">\r\n");
      out.write("                            <h3 class=\"fw-bold mb-0\">可预约情况信息查看</h3>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div> <!-- Row end  -->\r\n");
      out.write("                          <table\r\n");
      out.write("\t\t\t                  \t\tclass=\"table table-striped table-bordered table-hover  dataTable\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=\"editable\" aria-describedby=\"editable_info\" width=\"130%\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr align=\"center\" class=\"gradeA even\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"sorting_1\" >编号</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\" \">医生</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\" \">时间</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center \">以预约人数</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center \">预留</td>\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");

											//循环遍历集合，每循环一次，生成一行html<tr></tr>，在每一个单元格中 <td></td>,把静态数据改成数据库表中的记录
											for (ReserveCase reserveCase : reservecases) {
											
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  <tr align=\"center\" class=\"gradeA even\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"sorting_1\">");
      out.print(reserveCase.getId());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\" \">");
      out.print(reserveCase.getDoctor().getName());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\" \">");
      out.print(reserveCase.getTime());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center \">");
      out.print(reserveCase.getAl_reserve());
      out.write("</td>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<td class=\"center \"></td>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");

											}
										
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print(Data.URL);
      out.write("/Manage/index.jsp\"> 返回页面</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<table style=\"width: 100%\" border=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html> ");
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
