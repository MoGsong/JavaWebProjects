package com.gxnu.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;
//import com.gxnu.util.DesUtil;
import com.gxnu.util.SendMailUtil;

@WebServlet(urlPatterns = {"/ForgetPwdAction"})
public class ForgetPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 分别用doGet和doPost进行跳转邮箱验证界面和发送重置密码邮件到目标邮箱
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取用户和邮箱参数，验证用户是否存在
		//验证成功及显示限时重置密码连接的标志
		boolean flag = false;	
		IOperatorService ios = new OperatorService();
		String username = req.getParameter("USER");
		String email = req.getParameter("EMAIL");
		System.out.println(username +"-" +email);
		//查找是否存在用户"
		Operator op = ios.findrole(username, email);
		System.out.println(op.toString());
		//判断用户邮箱验证是否成功
		if(username.equals(op.getUsername())&&email.equals(op.getEmail())) {
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
			//验证成功页面
			String success=Data.URL + "/web/success.html";

			String text = "这是您的重置密码连接，请不要轻易告知他人，以免密码被他人篡改，该行为造成的不良影响将由用户自行承担。" + 
					Data.URL+"/web/ResetPassword.jsp?operatorid="+op.getId()+"&lating=" + end + "&flag="+flag;
			SendMailUtil sendMailUtil = new SendMailUtil();
			sendMailUtil.sendMail(email, text, "重置密码");
			resp.sendRedirect(success);
		}else {
			//验证失败页面
			String failure=Data.URL + "/web/failure.html";
			resp.sendRedirect(failure);
		}
		
	}
}

