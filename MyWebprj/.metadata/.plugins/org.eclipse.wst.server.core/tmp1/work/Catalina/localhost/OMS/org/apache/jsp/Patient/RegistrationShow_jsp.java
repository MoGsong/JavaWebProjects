/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.45
 * Generated at: 2022-08-11 07:29:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Patient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.sun.org.apache.regexp.internal.recompile;
import java.text.SimpleDateFormat;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.RegistrationService;
import com.gxnu.entity.Registration;
import java.util.List;
import com.gxnu.util.Data;
import com.gxnu.entity.Patient;

public final class RegistrationShow_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.gxnu.util.Data");
    _jspx_imports_classes.add("com.sun.org.apache.regexp.internal.recompile");
    _jspx_imports_classes.add("com.gxnu.service.imp.DoctorService");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("com.gxnu.service.imp.RegistrationService");
    _jspx_imports_classes.add("com.gxnu.entity.Patient");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("com.gxnu.entity.Registration");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String tabPath = basePath + "Patient/";

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html class=\"no-js\" lang=\"zxx\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- Meta Tags -->\r\n");
      out.write("\t\t<meta charset=\"utf-8\">\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t\t<meta name=\"keywords\" content=\"Site keywords here\">\r\n");
      out.write("\t\t<meta name=\"description\" content=\"\">\r\n");
      out.write("\t\t<meta name='copyright' content=''>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Title -->\r\n");
      out.write("        <title></title>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Favicon -->\r\n");
      out.write("        <link rel=\"icon\" href=\"img/favicon.png\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Google Fonts -->\r\n");
      out.write("\t\t<link href=\"https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- Bootstrap CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/bootstrap.min.css\">\r\n");
      out.write("\t\t<!-- Nice Select CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/nice-select.css\">\r\n");
      out.write("\t\t<!-- Font Awesome CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/font-awesome.min.css\">\r\n");
      out.write("\t\t<!-- icofont CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/icofont.css\">\r\n");
      out.write("\t\t<!-- Slicknav -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/slicknav.min.css\">\r\n");
      out.write("\t\t<!-- Owl Carousel CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/owl-carousel.css\">\r\n");
      out.write("\t\t<!-- Datepicker CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/datepicker.css\">\r\n");
      out.write("\t\t<!-- Animate CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/animate.min.css\">\r\n");
      out.write("\t\t<!-- Magnific Popup CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/magnific-popup.css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Medipro CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/normalize.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/responsive.css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Color CSS -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color1.css\">\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color2.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color3.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color4.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color5.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color6.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color7.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color8.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color9.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color10.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color11.css\">-->\r\n");
      out.write("\t\t<!--<link rel=\"stylesheet\" href=\"");
      out.print(tabPath );
      out.write("css/color/color12.css\">-->\r\n");
      out.write("\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"#\" id=\"colors\">\r\n");
      out.write("\t\t\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- Preloader -->\r\n");
      out.write("        <div class=\"preloader\">\r\n");
      out.write("            <div class=\"loader\">\r\n");
      out.write("                <div class=\"loader-outter\"></div>\r\n");
      out.write("                <div class=\"loader-inner\"></div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"indicator\"> \r\n");
      out.write("                    <svg width=\"16px\" height=\"12px\">\r\n");
      out.write("                        <polyline id=\"back\" points=\"1 6 4 6 6 11 10 1 12 6 15 6\"></polyline>\r\n");
      out.write("                        <polyline id=\"front\" points=\"1 6 4 6 6 11 10 1 12 6 15 6\"></polyline>\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End Preloader -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

		Object obj = request.getAttribute(Data.REGISTRATION);
		List<Registration> registrations = new ArrayList<>();
		if(obj!=null){
			registrations=(List<Registration>)obj; 
		}
		System.out.println(registrations.toString());
		
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- Breadcrumbs -->\r\n");
      out.write("\t\t<div class=\"breadcrumbs overlay\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<div class=\"bread-inner\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>查看预约信息</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"bread-list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"index.html\">首页</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><i class=\"icofont-simple-right\"></i></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"active\">查看预约信息</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- End Breadcrumbs -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <!-- Start Faq -->\r\n");
      out.write("        <section class=\"faq-area section\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row faq-wrap\">\r\n");
      out.write("                    <div class=\"col-lg-12\">\r\n");
      out.write("                        <div class=\"faq-head\">\r\n");
      out.write("                            <h2>查看历史预约信息</h2>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"faq-item\">\r\n");
      out.write("                            <ul class=\"accordion\">\r\n");
      out.write("                            \t");

                            	if(registrations != null){
                            		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            		int i = 3;
                            		for(Registration registration : registrations){
                            		
                            	
      out.write("\r\n");
      out.write("                                <li class=\"wow fadeInUp\" data-wow-delay=\".3s\">\r\n");
      out.write("                                    <a>预约医生：");
      out.print(new DoctorService().find(registration.getDoctor().getId()).getName() );
      out.write("&nbsp;&nbsp;预约的时间：");
      out.print(df.format(registration.getReserve_time()) );
      out.write("</a>\r\n");
      out.write("                                    <p>您的预约编号是：");
      out.print(registration.getNumber() );
      out.write("&nbsp;&nbsp;预约费用是：");
      out.print(new DoctorService().find(registration.getDoctor().getId()).getPost().getPrice() );
      out.write("\r\n");
      out.write("                                    &nbsp;&nbsp;支付预约费时间：");
      out.print(registration.getPay_time() );
      out.write("</p>\r\n");
      out.write("                                    \r\n");
      out.write("                                    &nbsp;&nbsp;<a target=\"IFrameBox\" href=\"");
      out.print(Data.URL);
      out.write("/login?registrationId=");
      out.print(registration.getId() );
      out.write("&patientId=");
      out.print(registration.getPatient().getId() );
      out.write("\">进入会诊室</a>\r\n");
      out.write("                                    \r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");

                            		}
                            	}else{
                                
      out.write("\r\n");
      out.write("                                <p>您还没有预约记录哟</p>\r\n");
      out.write("                                ");
} 
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        <!-- End Faq -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- jquery Min JS -->\r\n");
      out.write("        <script src=\"");
      out.print(tabPath );
      out.write("js/jquery.min.js\"></script>\r\n");
      out.write("\t\t<!-- jquery Migrate JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/jquery-migrate-3.0.0.js\"></script>\r\n");
      out.write("\t\t<!-- jquery Ui JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/jquery-ui.min.js\"></script>\r\n");
      out.write("\t\t<!-- Easing JS -->\r\n");
      out.write("        <script src=\"");
      out.print(tabPath );
      out.write("js/easing.js\"></script>\r\n");
      out.write("\t\t<!-- Color JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/colors.js\"></script>\r\n");
      out.write("\t\t<!-- Popper JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/popper.min.js\"></script>\r\n");
      out.write("\t\t<!-- Bootstrap Datepicker JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\t\t<!-- Jquery Nav JS -->\r\n");
      out.write("        <script src=\"");
      out.print(tabPath );
      out.write("js/jquery.nav.js\"></script>\r\n");
      out.write("\t\t<!-- Slicknav JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/slicknav.min.js\"></script>\r\n");
      out.write("\t\t<!-- ScrollUp JS -->\r\n");
      out.write("        <script src=\"");
      out.print(tabPath );
      out.write("js/jquery.scrollUp.min.js\"></script>\r\n");
      out.write("\t\t<!-- Niceselect JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/niceselect.js\"></script>\r\n");
      out.write("\t\t<!-- Tilt Jquery JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/tilt.jquery.min.js\"></script>\r\n");
      out.write("\t\t<!-- Owl Carousel JS -->\r\n");
      out.write("        <script src=\"");
      out.print(tabPath );
      out.write("js/owl-carousel.js\"></script>\r\n");
      out.write("\t\t<!-- counterup JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/jquery.counterup.min.js\"></script>\r\n");
      out.write("\t\t<!-- Steller JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/steller.js\"></script>\r\n");
      out.write("\t\t<!-- Wow JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/wow.min.js\"></script>\r\n");
      out.write("\t\t<!-- Magnific Popup JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("\t\t<!-- Counter Up CDN JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/waypoints.min.js\"></script>\r\n");
      out.write("\t\t<!-- Bootstrap JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t<!-- Main JS -->\r\n");
      out.write("\t\t<script src=\"");
      out.print(tabPath );
      out.write("js/main.js\"></script>\r\n");
      out.write("    </body>\r\n");
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
