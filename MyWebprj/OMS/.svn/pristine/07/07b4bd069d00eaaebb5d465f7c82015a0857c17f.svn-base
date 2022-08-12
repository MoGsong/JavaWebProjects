package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Measure;
import com.gxnu.service.IMeasureService;
import com.gxnu.service.imp.MeasureService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = {"/measure"})
public class MeasureAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String op = req.getParameter("OP");
		String idString = req.getParameter("ID");
		int id = 0;
		if(idString!=null) {id=Integer.parseInt(idString);}
		
		if(op!=null&&op.equals("add")) {
			
			String name = req.getParameter("NAME");
			Measure measure = new Measure(name);
			IMeasureService ims = new MeasureService();
			ims.add(measure);
			resp.sendRedirect(Data.URL+"/Manage/Measure.jsp");
		}else if(op!=null&&op.equals("delete")) {
			IMeasureService iis = new MeasureService();
			iis.remove(id);
			resp.sendRedirect(Data.URL+"/Manage/Measure.jsp");
		}else if(op!=null&&op.equals("update")) {

			String name = req.getParameter("NAME");
			Measure measure = new Measure(id,name);
			IMeasureService ims = new MeasureService();
			ims.update(measure);
			resp.sendRedirect(Data.URL+"/Manage/Measure.jsp");
		}
	}

	
}
