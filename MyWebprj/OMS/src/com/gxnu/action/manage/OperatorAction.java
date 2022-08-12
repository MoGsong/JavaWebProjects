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
			//��ȡҳ�洫�ݹ�����������������޸ĵļ�¼id��Ϣ
			String strid = req.getParameter("id");				
			int id=0;
			if(strid!=null) {
				id = Integer.parseInt(strid); 
			}	
			
			//��ȡ��ɫid
			String strroleid = req.getParameter("roleid");				
			int roleid=0;
			if(strid!=null) {
			roleid = Integer.parseInt(strroleid);			
			}	
			//���ݽ�ɫid���ҽ�ɫ
			IRoleService roleService=new RoleService();
			Role role=roleService.find(roleid);
			
			
				//��ȡҳ���ύ�������������������ӵļ�¼��Ϣ
				String password = req.getParameter("name1"); //��ȡҳ���name
				String tel = req.getParameter("name2");
				//String pic = req.getParameter("newstitle3");	
				//String pic = req.getParameter("name3");
				String email = req.getParameter("name4");
				
				String userName = req.getParameter("userName");

			
				//��ȡ�ϴ���ͷ���ļ�				
				   Part file= req.getPart("pic");
				   
				   //ͨ��httpЭ����Ϣ��key  Content-Disposition			 
				    String info=file.getHeader("Content-Disposition");
				    //��ȡ�ļ��ĺ�׺
				    int b=info.indexOf("filename=\"")+10;  //ȥ�ļ������������ԣ���jsp�ȵ�
				    int e=info.length()-1; 
				    String filename=info.substring(b,e);
				    System.out.println(filename);
				
				//����ҵ�񷽷����޸��ʼ���Ϣ			
				 IOperatorService operatorService=new OperatorService();	
				 Operator operator=new Operator(id,userName,password,tel,email,filename,role);
				 operatorService.update(operator);
				 
				 
			
				//��ת���¸���Դ������ת��
		  		   resp.sendRedirect(Data.URL+"/Manage/Login.jsp");
			}			
			
			}
		
	

}
