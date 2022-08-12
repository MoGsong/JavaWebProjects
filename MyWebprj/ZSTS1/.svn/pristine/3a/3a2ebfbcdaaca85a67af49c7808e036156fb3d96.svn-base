package com.gxnu.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;

/**
 * Servlet implementation class ResetPasswordAction
 */
@WebServlet("/ResetPasswordAction")
public class ResetPasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOperatorService ios = new OperatorService();
		String pwd = request.getParameter("password");
		String id = request.getParameter("operatorId");
		Operator op = ios.find(Integer.parseInt(id));
		op.setPassword(pwd);
		ios.update(op);
		System.out.println("重置密码成功！");
		//跳转到登录页
		response.sendRedirect(Data.URL+"/web/login.jsp");
	}

}
