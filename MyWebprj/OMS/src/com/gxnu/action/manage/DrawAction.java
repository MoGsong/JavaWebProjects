package com.gxnu.action.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Post;
import com.gxnu.entity.Unit;
import com.gxnu.service.IDrawService;
import com.gxnu.service.IUnitService;
import com.gxnu.service.imp.DrawService;
import com.gxnu.service.imp.UnitService;

@WebServlet(urlPatterns = {"/draw"})
public class DrawAction extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String time=req.getParameter("time");
		IDrawService drawService = new DrawService();
		IUnitService unitService = new UnitService();
		List<Unit> units = unitService.findAll();
		List<Integer> sums = new ArrayList<>();
		for (Unit unit : units) {
			try {
				 sums.add(drawService.find(time, unit.getId()));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		req.setAttribute("UNITS", units);
		req.setAttribute("SUMS", sums);
		req.getRequestDispatcher("Manage/Draw.jsp").forward(req, resp);
		//System.out.println(sums);
		
	}

}
