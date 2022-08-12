package com.gxnu.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gxnu.entity.Rss;
import com.gxnu.service.IRssService;
import com.gxnu.service.imp.RssService;



@WebServlet(urlPatterns = {"/json"})
public class JsonAction extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		//对rss数据返回格式为json格式
		IRssService rssSevice = new RssService();
		List<Rss> rsss = new ArrayList<Rss>(); 
		rsss = rssSevice.find();
		JSONArray json = new JSONArray(); //创建JSONArray对象，以集合的方式存放JSONObject对象中的数据
		for(Rss rss : rsss ) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", rss.getId());
			jsonObject.put("title", rss.getTitle());
			jsonObject.put("url", rss.getUrl());
			jsonObject.put("content", rss.getContent());
			jsonObject.put("updatetime", rss.getUpdatetime());
			json.put(jsonObject); //存放JSONObject对象
		}
		
		resp.getWriter().write(json.toString());
		
		
	}

}
