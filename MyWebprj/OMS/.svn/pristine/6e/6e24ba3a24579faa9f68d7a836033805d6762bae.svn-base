package com.gxnu.action.patient;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(urlPatterns = {"/typical_caseShow"})
@MultipartConfig
public class Typical_caseShowAction extends HttpServlet {
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req,resp);
		 
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String OP =req.getParameter("OP");
		
       //System.out.println(OP);		
		if(OP!=null&&"show".equals(OP)) {
			System.out.println(1);
			//获取客户端发送的参数
			 String typical_caseid = req.getParameter("TypicalCaseID");
			 if(typical_caseid != null) {
				 System.out.println(1);
				 // 请求传到Servlet 返回object
				 req.setAttribute("TypicalCase", typical_caseid);
				 
				 //请求转发跳转 只能使用相对路径
				 req.getRequestDispatcher("Patient/Typical_caseInfo.jsp").forward(req, resp);
			 }
		} 
	}
			 
}
		 
