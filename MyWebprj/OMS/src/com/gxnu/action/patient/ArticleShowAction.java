package com.gxnu.action.patient;



import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import com.gxnu.entity.Article;
import com.gxnu.service.IArticleService;
import com.gxnu.service.imp.ArticleService;
import com.gxnu.util.Data;




@WebServlet(urlPatterns = {"/articleShow"})
@MultipartConfig
public class ArticleShowAction extends HttpServlet {
     
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doPost(req,resp);
		 
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String OP =req.getParameter("OP");
       //System.out.println(OP);		
		if(OP!=null&&"show".equals(OP)) {
			
			//获取客户端发送的参数
			 String articleid = req.getParameter("ARTICLEID");
			 if(articleid != null) {
				 // 请求传到Servlet 返回object
				 req.setAttribute("ARTICLE", articleid);
				 
				 //请求转发跳转 只能使用相对路径
				 req.getRequestDispatcher("Patient/ArticleInfo.jsp").forward(req, resp);
			 }
		} 
	}
			 
}
		 
