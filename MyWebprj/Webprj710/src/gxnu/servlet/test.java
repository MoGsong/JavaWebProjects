package gxnu.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxlq.dao.BaseDAO;
import com.gxlq.entity.Operator;
import com.gxlq.service.IOperatorService;
import com.gxlq.service.imp.OperatorService;

/**
 * Servlet implementation class test
 */
//@WebServlet(urlPatterns = {"/test","myTest","myWeb"})���·������ͬһservlet��Դ<%@ include file="" %>
@WebServlet("/xxx")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
    	 BaseDAO baseDAO = new BaseDAO();
		 try {
			if (baseDAO.getConnection() != null) {
			        Connection conn = baseDAO.getConnection();
			        System.out.println("mysql连接成功");
			 }else {
				 System.out.println("连接失败，账号或密码错误");
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init() throws ServletException {
		System.out.println("Servlet初始化");
	}
    @Override
	public void destroy() {
		System.out.println("Servlet结束");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Welcome you!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("textfield");
		String password = request.getParameter("textfield2");
		System.out.println(username +","+ password);
		
		String dist = "";
		IOperatorService ios = new OperatorService();
        Operator operator = ios.find(username, password);
        if (operator.getId() > 0) {
        	System.out.println("账号密码正确");
        	//添加成功登录到会话，然后监听会话，记录用户登录、退出操作
        	HttpSession session = request.getSession();
        	session.setAttribute("USER",username);
        	session.setAttribute("OPERATOR", operator);
        	dist = "http://192.168.1.167:8080/Webprj710/web/main.html";
        }else {
        	System.out.println("账号或密码有误");
        	dist = "http://192.168.1.167:8080/Webprj710/login/login.html";
        }
        response.sendRedirect(dist);
	}

}