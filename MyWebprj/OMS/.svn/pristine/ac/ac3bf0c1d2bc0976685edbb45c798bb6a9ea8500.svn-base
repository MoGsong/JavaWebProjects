package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.DrugInfo;
import com.gxnu.service.IDrugInfoService;
import com.gxnu.service.IInventoryService;
import com.gxnu.service.imp.DrugInfoService;
import com.gxnu.service.imp.InventoryService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = {"/drugInfo"})
public class DrugInfoAction extends HttpServlet {
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
			String element = req.getParameter("ELEMENT");
			String effect = req.getParameter("EFFECT");
			String notice = req.getParameter("NOTICE");
			
			IDrugInfoService ids = new DrugInfoService();
			DrugInfo drugInfo = new DrugInfo(name,element,effect,notice);
			ids.add(drugInfo);		
			resp.sendRedirect(Data.URL+"/Manage/DrugInfo.jsp");
		}else if(op!=null&&op.equals("delete")) {
			IInventoryService iis = new InventoryService();
			iis.remove(id);
			resp.sendRedirect(Data.URL+"/Manage/DrugInfo.jsp");
		}else if(op!=null&&op.equals("update")) {
			
			String name = req.getParameter("NAME");
			String element = req.getParameter("ELEMENT");
			String effect = req.getParameter("EFFECT");
			String notice = req.getParameter("NOTICE");
			
			IDrugInfoService ids = new DrugInfoService();
			DrugInfo drugInfo = new DrugInfo(id,name,element,effect,notice);
			ids.update(drugInfo);
			resp.sendRedirect(Data.URL+"/Manage/DrugInfo.jsp");
		}
	}

}
