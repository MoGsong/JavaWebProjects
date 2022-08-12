/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2022-08-11 01:29:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Manage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.gxnu.util.Data;
import com.gxnu.entity.Doctor;
import java.util.List;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.IDoctorService;

public final class Doctor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.gxnu.util.Data");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.gxnu.service.imp.DoctorService");
    _jspx_imports_classes.add("com.gxnu.entity.Doctor");
    _jspx_imports_classes.add("com.gxnu.service.IDoctorService");
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<!doctype html>\r\n");
      out.write("<html class=\"no-js\" lang=\"en\" dir=\"ltr\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<title>:: 医生信息管理:: 所有医生</title>\r\n");
      out.write("<!-- plugin css file  -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/responsive.dataTables.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/dataTables.bootstrap5.min.css\">\r\n");
      out.write("<!-- project css file  -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/ihealth.style.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"ihealth-layout\" class=\"theme-tradewind\">\r\n");
      out.write("\t\t<div class=\"main px-lg-4 px-md-4\">\r\n");
      out.write("\t\t\t<!-- Body: Header -->\r\n");
      out.write("\t\t\t<div class=\"header\">\r\n");
      out.write("\t\t\t\t<nav class=\"navbar py-4\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container-xxl\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Body: Body -->\r\n");
      out.write("\t\t\t<div class=\"body d-flex py-3\">\r\n");
      out.write("\t\t\t\t<div class=\"container-xxl\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"border-0 mb-4\">\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h3 class=\"fw-bold mb-0\">医生信息管理</h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ibox-content\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-auto d-flex w-sm-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-primary btn-set-task w-sm-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"icofont-plus-circle me-2 fs-6\"></i><a\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\thref=\"AddDoctor.jsp\">添加医生</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<!-- Row end  -->\r\n");
      out.write("\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"row g-3 row-cols-1 row-cols-sm-2 row-cols-md-2 row-cols-lg-4 row-cols-xl-4 row-cols-xxl-4 row-deck py-1 pb-4\">\r\n");
      out.write("\t\t\t\t\t\t\t");

								IDoctorService doctorService = new DoctorService();
								List<Doctor> doctors = doctorService.find();
								for (Doctor doctor : doctors) {
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card teacher-card \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"profile-av mx-auto text-center w220\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img src=\"");
      out.print(Data.URL);
      out.write('/');
      out.print(doctor.getPic());
      out.write("\" alt=\"\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"avatar xl rounded-circle img-thumbnail shadow-sm\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"teacher-info  w-100 text-center mt-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h6 class=\"mb-2 mt-2  fw-bold d-block fs-6\">");
      out.print(doctor.getName());
      out.write("</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"light-info-bg py-2 px-2 rounded-1 d-inline-block fw-bold small-11 mb-0 mt-1\">");
      out.print(doctor.getUnit().getName());
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"doctor-profile.html\" class=\"btn btn-primary btn-sm\">更多</a></br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"btn-group\" role=\"group\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"Basic outlined example\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-outline-secondary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print(Data.URL);
      out.write("/doctor?OP=toupdate&id=");
      out.print(doctor.getId());
      out.write("\"><i class=\"icofont-edit text-success\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-outline-secondary \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print(Data.URL);
      out.write("/doctor?id=");
      out.print(doctor.getId());
      out.write("\"><i class=\"icofont-ui-delete text-danger\"></i></a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}
							
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Jquery Core Js -->\r\n");
      out.write("\t\t\t\t<script src=\"static/js/libscripts.bundle.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Plugin Js-->\r\n");
      out.write("\t\t\t\t<script src=\"static/js/dataTables.bundle.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Jquery Page Js -->\r\n");
      out.write("\t\t\t\t<script src=\"static/js/template.js\"></script>\r\n");
      out.write("\t\t\t\t<script>\r\n");
      out.write("\t\t\t\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t\t\t\t$('#patient-table').addClass('nowrap').dataTable({\r\n");
      out.write("\t\t\t\t\t\t\tresponsive : true,\r\n");
      out.write("\t\t\t\t\t\t\tcolumnDefs : [ {\r\n");
      out.write("\t\t\t\t\t\t\t\ttargets : [ -1, -3 ],\r\n");
      out.write("\t\t\t\t\t\t\t\tclassName : 'dt-body-right'\r\n");
      out.write("\t\t\t\t\t\t\t} ]\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
