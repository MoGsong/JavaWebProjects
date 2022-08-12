package com.gxnu.action.patient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.Patient;
import com.gxnu.service.IPatientService;
import com.gxnu.service.imp.PatientService;
import com.gxnu.util.Data;
@WebServlet(urlPatterns = {"/patientlogin"})
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
			//获取用户输入信息
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String checkcode = change(req.getParameter("checkcode"));
			
			//调用业务方法，查询是否存在该用户
			IPatientService patientService = new PatientService();
			Patient patient = patientService.find(username, password);
			//通过会话获取验证码,并进行比对
	        HttpSession checkCode = req.getSession();
			Object code = checkCode.getAttribute("CODE");
			String code1 = change((String)code);
			resp.setContentType("text/html;charset = UTF-8");
			PrintWriter out = resp.getWriter();
			String dist = "";
			if(code1.equals(checkcode)) {
				if(patient.getId()>0) {
					System.out.println("合法");
					dist=Data.URL+"/Patient/main.jsp";
					//把当前用户的信息（用户名）存放到会话对象session中
					HttpSession session = req.getSession();
					session.setAttribute("USER", username);
					session.setAttribute(Data.PATIENT, patient);//把用户完整信息存放到session会话对象中
				}else {
					out.print("<script>window.alert('用户名或密码有误，请重新登录');</script>");
					System.out.println("非法");
					dist=Data.URL+"/Patient/Login.jsp";
				}
			}else {
				//验证码输入错误,登录失败
				out.print("<script>window.alert('验证码有误');</script>");
				dist=Data.URL+"/Patient/Login.jsp";
			}
			
			//跳转到下一个资源
			out.print("<script>window.top.location.href='"+dist+"';</script>");
		}else if(op!=null && "exit".equals(op)) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.setContentType("text/html;charset = UTF-8");
			PrintWriter out = resp.getWriter();
			String dist = Data.URL + "/Patient/main.jsp";
			out.print("<script>window.alert('注销成功。');window.top.location.href='"+dist+"';</script>");
			
		}
	}

}
