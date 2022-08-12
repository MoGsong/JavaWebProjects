package com.gxnu.action;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.lnformation;
import com.gxnu.dao.lnformationDAO;
import com.gxnu.service.IInformationService;
import com.gxnu.service.imp.InformationService;
import com.gxnu.util.Data;
import com.gxnu.entity.*;


@WebServlet(urlPatterns = {"/xxx"})
public class lnformationAction extends HttpServlet{
	
	//不论get/post请求，均执行doPost方法
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		    //调用业务方法，查询所有信息
		IInformationService iis = new InformationService();
		List<lnformation> informations = new ArrayList<lnformation>();
		
		String op = req.getParameter("OP");  //获取页面传递过来的OP进行判断
		if(op!=null && "toupdate".equals(op)) {			
			//获取页面提交过来的请求参数，即要删除的id信息
			String strid = req.getParameter("id");  //获取页面id
			int id=0;  //进行强转
			if(strid!=null) { //进行判断
				id = Integer.parseInt(strid);
			}	
			
			 lnformation information=iis.find(id);
			 req.setAttribute("INFORMATION",information);//把完整的邮件信息存放到请求对象中
			 //跳转到下一个资源,请求转发
			 req.getRequestDispatcher("web/lnfomartion2.jsp").forward(req, resp);
			 
		}else if(op!=null && "doupdate".equals(op)) {   //判断是不是等于doupdate
			//获取页面传递过来的请求参数，即修改的记录id信息
			String strid = req.getParameter("id");
			System.out.println(strid+"55555");
			int id=0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			
			//获取页面提交过来的请求参数，即添加的记录信息
			String types = req.getParameter("types");
			String content = req.getParameter("content");
			String picture = req.getParameter("picture");
			String time = req.getParameter("time");
			String yuliu ="";
				
			//调用业务方法，修改邮件信息					
			lnformation information = new lnformation(id,types,content,picture,Timestamp.valueOf(time),yuliu);
			iis.update(information);		
			
			//跳转到下一个资源,请求转发
			resp.sendRedirect(Data.URL +"/web/lnfomartion.jsp");
	
	        }else if(op!=null && "add".equals(op)) {   //判断是不是等于doupdate
	
				//获取页面提交过来的请求参数，即添加的记录信息
				String types = req.getParameter("types");
				String content = req.getParameter("content");
				String picture = req.getParameter("picture");
				String time = req.getParameter("time");
				String yuliu ="";
				
				//调用业务方法，修改邮件信息					
				lnformation information = new lnformation(types,content,picture,Timestamp.valueOf(time),yuliu);
				iis.add(information);		
				
				//跳转到下一个资源,请求转发
				resp.sendRedirect(Data.URL +"/web/lnfomartion.jsp");

				
		        }else {
	        	//获取页面传递过来的id  
	 		   String strid=req.getParameter("id");
	 		   int id=0;
	 		   if(strid!=null) {
	 			   id=Integer.parseInt(strid);
	 		   }
	                iis.remove(id);
	                
	              //跳转到下个资源，请求转发
	     		   resp.sendRedirect(Data.URL +"/web/lnfomartion.jsp");
	        }
		  
		 
		   
	}
}
