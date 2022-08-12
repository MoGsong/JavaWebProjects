package com.gxnu.action.patient;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.Feedback;
import com.gxnu.entity.Registration;
import com.gxnu.service.IFeedbackService;
import com.gxnu.service.imp.FeedbackService;
import com.gxnu.service.imp.RegistrationService;
import com.gxnu.util.Data;


@WebServlet(urlPatterns = {"/feedback"})
public class FeedbackAction extends HttpServlet{
	//继承父类javax.servlet.http.HttpServlet
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//不论get、post请求，均执行dopost方法
			doPost(req, resp);
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String op=req.getParameter("OP");
			/**
			 * 添加留言反馈
			 */
			if (op!=null&&"add".equals(op)) {
						   //获取页面传递过来的请求参数，即添加的记录id信息
							String content=req.getParameter("content");
							
							Date date = new Date();
							Timestamp time = new Timestamp(date.getTime());
							//Timestamp time = new Timestamp(System.currentTimeMillis());
							System.out.println("输出获取的时间"+time);
			
			              //System.out.println("输出获取的信息"+content+time+yuliu); //调用业务方法，实现添加某条留言反馈记录
			              Feedback feedback=new Feedback(content,time,null);
			              System.out.println(feedback); 
			              IFeedbackService feedbackService=new FeedbackService();
			              feedbackService.add(feedback);
			 
							//存储url
							String url = Data.URL+"/Patient/Feedback.jsp";
							//解决中文乱码
							resp.setContentType("text/html;charset = UTF-8");
							//设置弹出窗口，并设置跳转页面
							PrintWriter out = resp.getWriter();
							out.print("<script>window.alert('您的留言已发送，感谢您的反馈！');window.location.href='"+url+"';</script>");
	 }
			}
}
