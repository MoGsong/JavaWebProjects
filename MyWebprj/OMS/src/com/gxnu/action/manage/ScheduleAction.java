package com.gxnu.action.manage;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Schedule;
import com.gxnu.entity.Unit;
import com.gxnu.service.IDoctorService;
import com.gxnu.service.IScheduleService;
import com.gxnu.service.IUnitService;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.ScheduleService;
import com.gxnu.service.imp.UnitService;
import com.gxnu.util.Data;
import com.mysql.cj.Session;


@WebServlet("/schedule")
public class ScheduleAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String op = req.getParameter("OP");
		if(op!=null && op.equals("add"))
		{

			
			int doctor_id = Integer.parseInt(req.getParameter("addDoctor"));
			String week = String.valueOf(req.getParameter("addWeek"));
			String period = req.getParameter("addPeriod");
			//Timestamp  time = Timestamp.valueOf(req.getParameter("addTime"));
		
			Timestamp  time = Timestamp.valueOf(req.getParameter("addTime")+" 00:00:00");//暂且如此
			
			IDoctorService dis = new DoctorService();
			Doctor doctor = dis.find(doctor_id);
			
			IScheduleService eis_add = new ScheduleService();
			Schedule schedule = new Schedule(doctor,period,week,time);
			System.out.println(schedule);
			eis_add.add(schedule);
			
			//int id = Integer.parseInt(req.getParameter("unitId"));
			resp.sendRedirect(Data.URL+"/Manage/Schedule.jsp"); //重新跳回页面，刷新
			
			//req.setAttribute("unitId", id);
//			请求转发
			//req.getRequestDispatcher("Manage/Schedule.jsp").forward(req, resp);
			
		}else  if(op!=null && op.equals("update")){
			String strid = req.getParameter("updateId");
			int id = 0;
			if(strid!=null) {
				id=Integer.parseInt(strid);
			}
			
			 
			int doctor_id = Integer.parseInt(req.getParameter(req.getParameter("selectName")));
			
			//int doctor_id = Integer.parseInt(req.getParameter("updateDoctor"));
			
			IDoctorService doctorService = new DoctorService();
			Doctor doctor = doctorService.find(doctor_id);

			
			IScheduleService iss = new ScheduleService();
			Schedule schedule = iss.find(id);
		    schedule.setDoctor(doctor);
			iss.update(schedule);
			
			System.out.println(doctor);
			System.out.println(schedule);
			
//			String strid1 = req.getParameter("unitId");
//			int unitId = 0;
//			if(strid1!=null) {
//				unitId=Integer.parseInt(strid1);
//			}
			
			//req.setAttribute("unitId", unitId);
			//	请求转发
			//req.getRequestDispatcher("Manage/Schedule.jsp").forward(req, resp);
			resp.sendRedirect(Data.URL+"/Manage/Schedule.jsp"); //重新跳回页面，刷新
			
		}else  if(op!=null && op.equals("getId")){
			
			String strid = req.getParameter("unitId");
			int id = 0;
			if(strid!=null) {
				id=Integer.parseInt(strid);
			}
//			System.out.println(id);
			 
		
			
//			IUnitService ius = new UnitService();
//			Unit unit1 = ius.find(id);
//			
//			System.out.println(unit1);
//			req.setAttribute(Data.UNIT, unit1);
			
			
			HttpSession session = req.getSession();
			session.setAttribute("unitId", id);
////			请求转发
//			req.getRequestDispatcher("Manage/Schedule.jsp").forward(req, resp);
			resp.sendRedirect(Data.URL+"/Manage/Schedule.jsp"); //重新跳回页面，刷新
		}
	}
}
