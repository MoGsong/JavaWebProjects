package com.gxnu.action.patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Patient;
import com.gxnu.entity.Registration;
import com.gxnu.entity.Schedule;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.RegistrationService;
import com.gxnu.service.imp.ScheduleService;
import com.gxnu.util.Data;



@WebServlet(urlPatterns = {"/RegistrationPatient"})
public class RegistrationPatient extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("OP");
		if(op != null && "findDr".equals(op)) {
			//获取表单中的unitId
			String unitid = req.getParameter("unitId");
			/* System.out.println("这是是unitid："+ unitid); */
			if(unitid != null) {
				//新建session，将unitId上传
				HttpSession loginses = req.getSession();
				loginses.setAttribute("UNITID", Integer.parseInt(unitid));
				//存储url
				String url = Data.URL+"/Patient/RegistrationDr.jsp";
				//解决中文乱码
				resp.setContentType("text/html;charset = UTF-8");
				//设置弹出窗口，并设置跳转页面
				PrintWriter out = resp.getWriter();
				out.print("<script>window.location.href='"+url+"';</script>");
				
				/*
				 * System.out.println("准备跳转"+ Data.URL+"/Patient/RegistrationDr.jsp");
				 * req.getParameter(Data.URL+"/Patient/RegistrationDr.jsp");
				 */
				/*
				 * //将角色信息传送到请求对象中 req.setAttribute("UNITID", unitid); //请求转发,跳转到下一个资源
				 * req.getRequestDispatcher("Patient/RegistrationDr.jsp").forward(req, resp);
				 */
			}else {
				req.getParameter("RegistrationUnit.jsp");
			}

		}else if(op != null && "pay".equals(op)) {
			//获取用户选中的预约信息和填写的预约时间
			String scheduleStr = req.getParameter("scheduleId");
			String reservetime = req.getParameter("selectTime");
			//获取session对象，获取登陆的用户信息
			HttpSession patientSession = req.getSession();
			Object obj = patientSession.getAttribute("PATIENT");
			//将obj强转为Patient对象
			Patient patient = (Patient)obj;
			System.out.println("这里是患者："+ patient);
			System.out.println("这里是时间："+ reservetime);
			//判断获取到的值是否为空
			if(scheduleStr != null && reservetime != null) {
				//通过传过来的scheduleId获取对应的schedule对象
				Schedule schedule = new ScheduleService().find(Integer.parseInt(scheduleStr));
				//确定时间显示格式
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				DateFormat format_day = new SimpleDateFormat("yyyy-MM-dd");
				//初始化reserveTime
				Timestamp reserveTime = new Timestamp(0);
				//将String类型的变量reservetime转化为规定好的日期格式，再将其转化为long类型数据，通过构造方法形成Timestamp类型对象
				try {
					//在jsp中获取到的时间缺少日期，需要从排班表中的时间中提取
					reserveTime = new Timestamp(format.parse(format_day.format(schedule.getDay()) + " " + reservetime + ":00").getTime());
					System.out.println("检查是否转换成功："+ reserveTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//根据当前时间生成随机订单号
				Date vNow = new Date();
				String sNow = "";
				sNow += String.valueOf(vNow.getYear());
				sNow += String.valueOf(vNow.getMonth() + 1);
				sNow += String.valueOf(vNow.getDate());
				sNow += String.valueOf(vNow.getHours());
				sNow += String.valueOf(vNow.getMinutes());
				sNow += String.valueOf(vNow.getSeconds());
				sNow += String.valueOf((int)((Math.random()*9+1)*1000));
				String orderName = "挂号费";
				String detail = "亲爱的患者朋友，你的预约编号是：" + "请按时登陆网站进行咨询哦";
				//
				//将角色信息传送到请求对象中
				System.out.println("这是orderId：" + sNow);
				req.setAttribute("orderId", sNow);
				System.out.println("这是orderName：" + orderName);
				req.setAttribute("orderName", orderName);
				System.out.println("这是orderNumber：" + schedule.getDoctor().getPost().getPrice());
				req.setAttribute("orderNumber", schedule.getDoctor().getPost().getPrice());
				System.out.println("这是orderDetail：" + detail);
				req.setAttribute("orderDetail", detail);
				
				//新建Registration变量，用于存储当前已获得的各类数据
				Registration registration = new Registration(schedule.getDoctor(),patient,reserveTime,reserveTime,"0",sNow);
				new RegistrationService().add(registration);
				System.out.println("这里是Registration："+ registration);
				//新建session，将Registration对象上传
				HttpSession loginses = req.getSession();
				loginses.setAttribute("REGISTRATION", registration);
				
				/*
				 * //解决中文乱码 resp.setContentType("text/html;charset = UTF-8"); //设置弹出窗口，并设置跳转页面
				 * PrintWriter out = resp.getWriter();
				 * out.print("<script>window.alert('跳走咯');window.location.href='"+url+
				 * "';</script>");
				 */
				
				//请求转发,跳转到下一个资源
				req.getRequestDispatcher("Patient/alipay.trade.page.pay.jsp").forward(req, resp);
			}
		}else if(op != null && "show".equals(op)) {
			HttpSession patientSes = req.getSession();
			Object obj = patientSes.getAttribute(Data.PATIENT);
			Patient patient = new Patient();
			if(obj!=null){
			    patient=(Patient)obj; 
			    System.out.println("输出患者信息："+ patient.toString());
			}
			RegistrationService registrationService = new RegistrationService();
			List<Registration> registrationAll = registrationService.findByPatientId(patient.getId());
			System.out.println("servlet测试：" + registrationAll.toString());
			
			req.setAttribute("REGISTRATION", registrationAll);
			//请求转发,跳转到下一个资源
			req.getRequestDispatcher("Patient/RegistrationShow.jsp").forward(req, resp);
		}
	}
}
