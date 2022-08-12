package com.gxnu.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gxnu.entity.Config;
import com.gxnu.service.IConfigService;
import com.gxnu.service.imp.ConfigService;
import com.mchange.v2.cfg.PropertiesConfigSource.Parse;
import com.sun.org.apache.xerces.internal.parsers.XMLDocumentParser;


@WebServlet("/config")
public class ConfigAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  op = request.getParameter("OP");
		if(op!=null&&"update".equals(op)){
			
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			String version = request.getParameter("textfield1");
			String ip = request.getParameter("textfield2");
			String port = request.getParameter("textfield3");
			Config config = new Config(id,Integer.parseInt(port),ip,version);
			IConfigService configService = new ConfigService();
			//修改数据库的信息
			//configService.modify(config);
			//修改服务器xml配置参数
//			try {
//				modifyServer(config);
//			} catch (DocumentException e) {
//				e.printStackTrace();
//			}
			//response.sendRedirect("http://192.168.1.167:8080/GIMS/web/main.jsp");
		}else{
			System.out.println("正在查询服务器配置");
			IConfigService configService = new ConfigService();
			Config config = configService.find();
			request.setAttribute("CONFIG", config);
			System.out.println(config.toString());
			System.out.println("正在跳转服务器配置修改");
			request.getRequestDispatcher("web/config.jsp").forward(request, response);

		} 
		
	}

}
