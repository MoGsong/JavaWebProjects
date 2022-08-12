package com.gxnu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxnu.entity.Config;
import com.gxnu.service.IConfigService;
import com.gxnu.service.imp.ConfigService;


@WebServlet("/config")
public class ConfigAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//显示所有服务器信息
		//点击提交修改请求的时候，获取表单数据进行数据库修改
		//还可以添加正则表达式验证修改的服务器IP格式是否正确
		String  op = request.getParameter("OP");
		String  flag = request.getParameter("flag");
		System.out.println(op+','+flag);
		if(op!=null&&"toupdate".equals(op)){
			String strid = request.getParameter("id");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			//点击修改的时候，调用servlet处理请求并响应服务器修改界面
			IConfigService configService = new ConfigService();
			Config config = configService.find(id);
			request.setAttribute("CONFIG", config);
			System.out.println(config.toString());
			System.out.println("正在跳转服务器配置修改界面");
			request.getRequestDispatcher("web/configmodify.jsp").forward(request, response);
		
		}else if(op!=null&&"update".equals(op)){
			if(Boolean.parseBoolean(flag)) {
				//获取修改信息，并对数据库进行修改
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
				configService.modify(config);
				System.out.println(config.toString());
				response.sendRedirect("http://192.168.1.167:8080/GIMS/web/Guide.html");
			}else {
				String strid = request.getParameter("id");
				int id = 0;
				if(strid!=null) {
					id = Integer.parseInt(strid);
				}
				//点击修改的时候，调用servlet处理请求并响应服务器修改界面
				IConfigService configService = new ConfigService();
				Config config = configService.find(id);
				request.setAttribute("CONFIG", config);
				String FLAG = "";
				request.setAttribute("flag",FLAG);
				System.out.println(config.toString());
				System.out.println("正在跳转服务器配置修改界面");
				request.getRequestDispatcher("web/configmodify.jsp").forward(request, response);
			}
			
		}else{
			//显示所有服务器信息
			IConfigService configService = new ConfigService();
			List<Config> configs = configService.find();
			System.out.println(configs.toString());
			request.setAttribute("CONFIGS", configs);
			request.getRequestDispatcher("web/config.jsp").forward(request, response);
		} 
		
	}

}
