package com.gxnu.action.doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Doctor;
import com.gxnu.entity.Patient;
import com.gxnu.entity.Record;
import com.gxnu.service.IDoctorService;
import com.gxnu.service.IPatientService;
import com.gxnu.service.IRecordService;
import com.gxnu.service.imp.DoctorService;
import com.gxnu.service.imp.PatientService;
import com.gxnu.service.imp.RecordService;
import com.gxnu.util.Data;

/**
 * 病例信息管理
 * @author MoHX
 *
 */
@WebServlet(urlPatterns = "/record")
public class RecordAction extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("OP");
		resp.setContentType("text/html;charset = UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		
		if(op!=null&&"delete".equals(op)) {
			//对应Case.jsp（病例信息管理）删除按钮
			//获取页面传递过来的请求参数，即删除的记录id信息
			String recordid=req.getParameter("id");
			int id=0;
			if(recordid!=null) {
				id=Integer.parseInt(recordid);
			}
			
			//调用业务方法，实现删除某条病例信息
			IRecordService recordservice=new RecordService();
			recordservice.remove(id);
			String dist=Data.URL+"/Manage/Case.jsp";
			resp.sendRedirect(dist);			
			out.print("<script>window.alert('删除成功！');window.location.href='"+dist+"';</script>");
			
		}else if(op!=null&&"add".equals(op)) {
			//对应addRecord.jsp（添加病例信息）提交按钮
			//获取页面传递过来的请求参数
			
			int patientid = Integer.parseInt(req.getParameter("patientid"));
			int doctorid = Integer.parseInt(req.getParameter("doctorid"));
			String disease=req.getParameter("disease");
			String time=req.getParameter("time");
			String result=req.getParameter("result");	
			
			IPatientService patientServer = new PatientService();
			Patient patient =patientServer.find(patientid);
			IDoctorService doctorService = new DoctorService(); 
			Doctor doctor = doctorService.find(doctorid);
			Record record=new Record(patient,doctor,disease,Timestamp.valueOf(time),result,null);
			IRecordService recordService = new RecordService();
			recordService.add(record);
			String dist=Data.URL+"/Doctor/Registration.jsp";
			resp.sendRedirect(dist);
		}
	}
}
