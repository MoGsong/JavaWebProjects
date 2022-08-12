package com.gxnu.action;



import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Operator;
import com.gxnu.entity.Role;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;




@WebServlet(urlPatterns = {"/operator"})
public class OperatorAction extends HttpServlet {
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req,resp);
		 
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String op =req.getParameter("op");
       //System.out.println(op);		
		 if(op!=null&&"add".equals(op)) {
			 //获取页面提交过来的请求参数，即添加的记录信息
			 String username =req.getParameter("username");
			 String password =req.getParameter("password");
			 String tel =req.getParameter("tel");
			 String pic =req.getParameter("pic");
			 //获取roleid，强转成整形  
			 //新建一个role对象，将roleid赋给它
			 String strroleid =req.getParameter("role");
			 int roleid = Integer.parseInt(strroleid);
			 Role role = new Role();
			 role.setId(roleid);
			
			 String yuliu =req.getParameter("yuliu");
			 String email =req.getParameter("email");
			 int status = 1;
			 int falsetime = 0;
			
			 Operator operator =new Operator(username,password,tel,pic,role,yuliu,email,status,falsetime);
			 IOperatorService operatorService =new OperatorService();
			 operatorService.add(operator);
		  
		 //跳转
		 resp.sendRedirect("http://192.168.1.196:8080/ZSTS/web/operator.jsp");
		 
	
				 }else  if(op!=null&&"toupdate".equals(op)) {
					 //获取页面提交过来的请求参数，即添加的记录信息
					 
					 String strid=req.getParameter("id");
					 int id=0;
					 if(strid!=null) {
						 id=Integer.parseInt(strid);
						 
					 }
				 
				 IOperatorService operatorService =new OperatorService();
				 Operator operator=operatorService.find(id);
				 
				  req.setAttribute("OPERATOR", operator);
				 
				 //跳转(请求转发)
				 req.getRequestDispatcher("web/updateoperator.jsp").forward(req, resp);
				 
				 }else if(op!=null&&"doupdate".equals(op)) {
					 
					 String strid=req.getParameter("ID");
					 int id=0;
					 if(strid!=null) {
						 id=Integer.parseInt(strid); 
					 }
					 
					 String username =req.getParameter("username");
					 String password =req.getParameter("password");
					 String tel =req.getParameter("tel");
					 String pic =req.getParameter("pic");
					 
					 String strroleid =req.getParameter("role");
					 int roleid = Integer.parseInt(strroleid);
					 Role role = new Role();
					 role.setId(roleid);
					 
					 String yuliu =req.getParameter("yuliu");
					 String email =req.getParameter("email");
					 int status = 1;
					 int falsetime = 0;

					 
					 IOperatorService operatorService =new OperatorService();
					 Operator operator =new Operator(id,username,password,tel,pic,role,yuliu,email,status,falsetime);
					 operatorService.update(operator);
					 
					  
					 //跳转
					 resp.sendRedirect("http://192.168.1.196:8080/ZSTS/web/operator.jsp");
			 
					 
			 
				 }else  {
			 
				 
				 String strid=req.getParameter("id");
				 int id=0;
				 if(strid!=null) {
					 id=Integer.parseInt(strid);
					 
				 }
				 IOperatorService operatorService =new OperatorService();
				 operatorService.remove(id);//根据获取到的id删除相应记录
				 
				
				  
				 //跳转
				 resp.sendRedirect("http://192.168.1.196:8080/ZSTS/web/operator.jsp");
				 } 
			 }
			 
				 }
		 
