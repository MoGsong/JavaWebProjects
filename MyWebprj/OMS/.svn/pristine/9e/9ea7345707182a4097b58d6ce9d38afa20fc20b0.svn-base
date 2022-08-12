package com.gxnu.action.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gxnu.entity.Doctor;
import com.gxnu.entity.Operator;
import com.gxnu.service.IDoctorService;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;
@WebServlet(urlPatterns = {"/doctorlogin"})
public class LoginAction extends HttpServlet {
	
	public static String change(String str) {
		String rst = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <='Z') {
				rst += (char)(str.charAt(i) - 'A' +'a');
			}else {
				rst += str.charAt(i);
			}
		}
		return rst;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op =  req.getParameter("OP");
		if(op!=null && "login".equals(op)) {
			//获取登陆信息
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String checkcode = change(req.getParameter("checkcode"));
			
			//调用业务层方法，根据用户名和密码查找用户是否存在
			IDoctorService doctorService = new DoctorService();
			Doctor doctor = doctorService.find(username, password);
			//获取登陆验证码信息
	        HttpSession checkCode = req.getSession();
			Object code = checkCode.getAttribute("CODE");
			String code1 = change((String)code);
			resp.setContentType("text/html;charset = UTF-8");
			PrintWriter out = resp.getWriter();
			String dist = "";
			if(code1.equals(checkcode)) {
				if(doctor.getId()>0) {
					System.out.println("合法");
					dist=Data.URL+"/Doctor/main.jsp";
					//将登陆信息存到session会话中
					HttpSession session = req.getSession();
					session.setAttribute("USER", username);
					session.setAttribute(Data.DOCTOR, doctor);//将医生对象存到session会话中
				}else {
					out.print("<script>window.alert('输入账号或密码错误，请重新输入');</script>");
					System.out.println("非法");
					dist=Data.URL+"/Doctor/Login.jsp";
				}
			}else {
				//非法
				out.print("<script>window.alert('验证码有误');</script>");
				dist=Data.URL+"/Doctor/Login.jsp";
			}
			
			//跳转到下一资源
			resp.sendRedirect(dist);
		}else {
			
		}
	}

}