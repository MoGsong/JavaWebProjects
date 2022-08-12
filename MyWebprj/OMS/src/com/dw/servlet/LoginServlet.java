package com.dw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.Registration;
import com.gxnu.service.IRegistrationService;
import com.gxnu.service.imp.RegistrationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
 * 判断并处理预约的医生或患者进入医生的请求
 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
		   response.setContentType("text/html;charset=utf-8");
		 String registrationId=request.getParameter("registrationId");
		 String doctorId = request.getParameter("doctorId");
		 String patientId = request.getParameter("patientId");
		 IRegistrationService irs = new RegistrationService();
		 Registration registration = irs.find(Integer.parseInt(registrationId));
		 //会话对象名称
		 String name = null;
		 //传入预约id和医生id
		 if(registrationId!=null && doctorId!=null && patientId==null) {
			 if(registration.getDoctor().getId()==Integer.parseInt(doctorId)) {
				 //进来的医生是预约的医生
				 name = registration.getDoctor().getName();
				 HttpSession session=request.getSession();
				 session.setAttribute("NAME", name);
				 session.setAttribute("id", doctorId);
				 session.setAttribute("sid", registrationId);
				 System.out.println("id:"+doctorId+"-login-sid:"+registrationId);
				 System.out.println("sessionId:"+session.getId());
			 }else {
				 //进来的医生不是预约的医生
			 }
		 }else if(registrationId!=null && doctorId==null && patientId!=null) {
			 //进来的是患者
			    name = registration.getPatient().getName();
			   HttpSession session=request.getSession();
			   session.setAttribute("NAME", name);
			   session.setAttribute("id", patientId);
			   session.setAttribute("sid", registrationId);
//			   System.out.println("id:"+doctorId+"--sid:"+registrationId);
//			   System.out.println("sessionId:"+session.getId());
		 }
		  
		 //跳转到聊天室
		 request.getRequestDispatcher("/Chat/websocketChatroom.jsp").forward(request, response);
	}

}
