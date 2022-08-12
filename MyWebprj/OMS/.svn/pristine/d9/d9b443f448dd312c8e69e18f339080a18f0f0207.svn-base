package com.gxnu.action.manage;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gxnu.service.IOperatorService;
import com.gxnu.service.IRoleService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.service.imp.RoleService;
import com.gxnu.util.Data;
import com.gxnu.entity.Operator;
import com.gxnu.entity.Role;

@WebServlet(urlPatterns = {"/Operaor"})
@MultipartConfig
public class OperatorAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   String op = req.getParameter("OP");	
		   if(op!=null && "toupdate".equals(op)) {			
			//获取页面传递过来的请求参数，即修改的记录id信息
			String strid = req.getParameter("id");				
			int id=0;
			if(strid!=null) {
				id = Integer.parseInt(strid); 
			}	
			
			//获取角色id
			String strroleid = req.getParameter("roleid");				
			int roleid=0;
			if(strid!=null) {
			roleid = Integer.parseInt(strroleid);			
			}	
			//根据角色id查找角色
			IRoleService roleService=new RoleService();
			Role role=roleService.find(roleid);
			
			
				//获取页面提交过来的请求参数，即添加的记录信息
				String password = req.getParameter("name1"); //获取页面的name
				String tel = req.getParameter("name2");
				//String pic = req.getParameter("newstitle3");	
				//String pic = req.getParameter("name3");
				String email = req.getParameter("name4");
				
				String userName = req.getParameter("userName");

			
				//获取上传的头像文件				
				   Part file= req.getPart("pic");
				   
				   //通过http协议消息中key  Content-Disposition			 
				    String info=file.getHeader("Content-Disposition");
				    //截取文件的后缀
				    int b=info.indexOf("filename=\"")+10;  //去文件名和忘记属性：如jsp等等
				    int e=info.length()-1; 
				    String filename=info.substring(b,e);
				    System.out.println(filename);
				
				//调用业务方法，修改邮件信息			
				 IOperatorService operatorService=new OperatorService();	
				 Operator operator=new Operator(id,userName,password,tel,email,filename,role);
				 operatorService.update(operator);
				 
				 
			
				//跳转到下个资源，请求转发
		  		   resp.sendRedirect(Data.URL+"/Manage/Login.jsp");
			}			
			
			}
		
	

}
