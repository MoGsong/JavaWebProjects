package com.gxnu.action.manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Inventory;
import com.gxnu.service.IInventoryService;
import com.gxnu.service.imp.DrugInfoService;
import com.gxnu.service.imp.InventoryService;
import com.gxnu.service.imp.MeasureService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = {"/inventory"})
public class InventoryAction extends HttpServlet{

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
			
			String drugInfo = req.getParameter("DRUGINFO");
			int drugInfoId = 0;
			if(drugInfo!=null) {drugInfoId=Integer.parseInt(drugInfo);}
			String xpriceString = req.getParameter("XPRICE");
			int xprice = 0;
			if(xpriceString!=null) {xprice=Integer.parseInt(xpriceString);}
			String numString = req.getParameter("NUM");
			int num = 0;
			if(numString!=null) {num=Integer.parseInt(numString);}
			String measureString = req.getParameter("MEASURE");
			int measure = 0;
			if(measureString!=null) {measure=Integer.parseInt(measureString);}
			
			Inventory inventory = new Inventory(new DrugInfoService().find(drugInfoId),new MeasureService().find(measure),xprice,num);
			IInventoryService iis = new InventoryService();
			iis.add(inventory);
			resp.sendRedirect(Data.URL+"/Manage/Inventory.jsp");
		}else if(op!=null&&op.equals("delete")) {
			IInventoryService iis = new InventoryService();
			iis.remove(id);
			resp.sendRedirect(Data.URL+"/Manage/Inventory.jsp");
		}else if(op!=null&&op.equals("update")) {
			
			String drugInfo = req.getParameter("DRUGINFO");
			int drugInfoId = 0;
			if(drugInfo!=null) {drugInfoId=Integer.parseInt(drugInfo);}
			String xpriceString = req.getParameter("XPRICE");
			int xprice = 0;
			if(xpriceString!=null) {xprice=Integer.parseInt(xpriceString);}
			String numString = req.getParameter("NUM");
			int num = 0;
			if(numString!=null) {num=Integer.parseInt(numString);}
			String measureString = req.getParameter("MEASURE");
			int measure = 0;
			if(measureString!=null) {measure=Integer.parseInt(measureString);}
			
			Inventory inventory = new Inventory(id,new DrugInfoService().find(drugInfoId),new MeasureService().find(measure),xprice,num);
			IInventoryService iis = new InventoryService();
			iis.update(inventory);
			resp.sendRedirect(Data.URL+"/Manage/Inventory.jsp");
		}
	}

	
}
