package com.gxnu.action.patient;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gxnu.dao.PatientDAO;
import com.gxnu.entity.Patient;
import com.gxnu.service.IPatienService;
import com.gxnu.service.IPatientService;
import com.gxnu.service.imp.PatientService;
import com.gxnu.util.Data;
@WebServlet(urlPatterns = {"/register"})
@MultipartConfig
public class RegisterAction extends HttpServlet {

	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取输入信息
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String age = req.getParameter("age");
		int age1 = 0 ;
		if(age!=null) {
			 age1 = Integer.parseInt(age);
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String idcard = req.getParameter("idcard");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		System.out.println(name+" "+sex+" "+age+" "+username+" "+password+" "+email);
		//获取页面文件框中的文件
    	Part file = req.getPart("pic");
    	//通过http协议头部消息中的key “Content-Disposition”可以获取上传文件的一些信息
    	String info = file.getHeader("Content-Disposition");
    	//截取文件的后缀
    	int b =  info.indexOf("filename=\"")+10;
    	int e = info.length()-1;
    	String filename = info.substring(b, e);
    	if(!filename.equals("")) {
    		String savePath = getServletContext().getRealPath("/")+"/Image"+filename;		      
	  		file.write(savePath);
    		//调用业务方法，在表中增加一条记录（包含相应的信息）
    		IPatientService pstientService = new PatientService();
    		Patient patient = new Patient(name, sex, age1, username, password, idcard, filename, tel, email);
    		pstientService.add(patient);
    	}else {
    		//调用业务方法，在表中增加一条记录（包含相应的信息）
    		IPatientService pstientService = new PatientService();
    		Patient patient = new Patient(name, sex, age1, username, password, idcard, tel, email);
    		pstientService.add(patient);
    	}
		//跳转下一资源
		resp.sendRedirect(Data.URL+"/Patient/Login.jsp");
		
	}
}
