package com.gxnu.action.patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

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
import com.gxnu.util.SendMailUtil;
import com.gxnu.util.SmsUtil;
@WebServlet(urlPatterns = {"/foegetpassword"})
public class ForgetPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op =  req.getParameter("OP");
		PrintWriter out = resp.getWriter();
		req.setCharacterEncoding("UTF-8");	
		resp.setCharacterEncoding("UTF-8");	
		resp.setContentType("text/html;charset=UTF-8");
		if(op!=null && "sendemail".equals(op)) {
			//获取用户和邮箱参数，验证用户是否存在
		    //验证成功及显示限时重置密码连接的标志
			boolean flag = false;
			//获取页面参数
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			System.out.println(username +"-" +email);
			//调用业务方法查找存在用户
			IPatientService patientService = new PatientService();
			Patient patient = patientService.findrole(username, email);
			System.out.println(patient.toString());
			//判断用户输入邮箱与输入邮箱是否一致
			if(username.equals(patient.getUsername()) && email.equals(patient.getEmail())) {
				flag = true;
				//设置截止时间
				Date  time = new Date();
				//获取当前时间,即开始时间
				long start = time.getTime();
				//持续时间分钟
				int duration = 1000*60*3;
				//结束时间
				long end = start + duration;
				System.out.println(start+'-'+end);
				//验证成功
				//发送邮件
				String text = "这是您的重置密码连接，请不要轻易告知他人，以免密码被他人篡改，该行为造成的不良影响将由用户自行承担。" + 
						Data.URL+"/Patient/UpdatePasswordByEmail.jsp?userid="+patient.getId()+"&lating=" + end + "&flag="+flag;
				SendMailUtil sendMailUtil = new SendMailUtil();
				sendMailUtil.sendMail(email, text, "重置密码");
				resp.sendRedirect(Data.URL+"/Patient/SendEmailSuccessful.jsp");
			}else {
				//邮箱验证失败
				resp.sendRedirect(Data.URL+"/Patient/SendEmailUnsuccessful.jsp");
			}
		}else if(op!=null && "sendmsg".equals(op)) {
			//获取用户输入手机号
			String tel = req.getParameter("tel");
			//生成六位随机码，用于注册改密
			Random r = new Random();
			String message = r.nextInt(900000) + 100000 + "";
			//把验证码存到session会话对象中
			HttpSession session = req.getSession();
			SmsUtil sms = new SmsUtil(); //调用发送短信util类
			System.out.println(message);
			//模板数组是在类SmsUtil中已设置好，根据不同请求选择响应的短信模板即可
			sms.Sendms(tel, sms.templateId[2], message);
			//调用业务方法查找存在用户
			IPatientService patientService = new PatientService();
			Patient patient = patientService.findrole(tel);
			System.out.println(patient.toString());
			resp.sendRedirect(Data.URL+"/Patient/UpdatePasswordByMsg.jsp?code="+message+"&userid="+patient.getId());
		}
		
		
	}

}
