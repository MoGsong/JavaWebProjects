package com.gxnu.action.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Patient;
import com.gxnu.service.IPatientService;
import com.gxnu.service.imp.PatientService;
import com.gxnu.util.Data;
@WebServlet(urlPatterns = {"/updatepwd"})
public class UpdatePwdAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op =  req.getParameter("OP");
		if(op!=null && "email".equals(op)) {
			//获取用户id和密码
			String userid = req.getParameter("userid");
			int id = 0 ;
			if(userid!=null) {
				id = Integer.parseInt(userid);
			}
			String pwd = req.getParameter("newpassword");
			IPatientService patientService = new PatientService();
			Patient patient = patientService.find(id);
			patient.setPassword(pwd);//重置密码
			patientService.update(patient);//将数据库中的密码修改
			System.out.println("重置密码成功！");
			resp.sendRedirect(Data.URL+"/Patient/Login.jsp");
		}else if(op!=null && "msg".equals(op)) {
			String checkcode =  req.getParameter("CHECKCODE");
			System.out.println(checkcode);
			String userid = req.getParameter("id");
			int id = 0 ;
			if(userid!=null) {
				id = Integer.parseInt(userid);
			}
			String pwd = req.getParameter("newpassword");
			IPatientService patientService = new PatientService();
			Patient patient = patientService.find(id);
			patient.setPassword(pwd);//重置密码
			patientService.update(patient);//将数据库中的密码修改
			System.out.println("重置密码成功！");
			resp.sendRedirect(Data.URL+"/Patient/Login.jsp");
		}
		
		
	}

}
