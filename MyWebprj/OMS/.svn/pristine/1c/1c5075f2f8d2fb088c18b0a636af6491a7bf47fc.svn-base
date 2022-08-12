package com.gxnu.action.manage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.gxnu.entity.Image;
import com.gxnu.service.IImageService;
import com.gxnu.service.imp.ImageService;
import com.gxnu.util.Data;

/**
 * 图片信息管理
 * 
 * @author MoHX
 *
 */
@WebServlet(urlPatterns = "/image")
@MultipartConfig
public class ImageAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("OP");
		resp.setContentType("text/html;charset = UTF-8");
		PrintWriter out = resp.getWriter();

		if (op != null && "delete".equals(op)) {
			// 对应Case.jsp（图片信息管理）删除按钮
			// 获取页面传递过来的请求参数，即删除的记录id信息
			String imageid = req.getParameter("id");
			int id = 0;
			if (imageid != null) {
				id = Integer.parseInt(imageid);
			}

			// 调用业务方法，实现删除某条图片信息
			IImageService imageservice = new ImageService();
			imageservice.remove(id);
			String dist = Data.URL + "/Manage/Image.jsp";			
			out.print("<script>window.alert('删除成功！')</script>");
			resp.sendRedirect(dist);
			
		} else if (op != null && "add".equals(op)) {

			// 对应Image.jsp（添加图片信息信息）提交按钮
			Part file = req.getPart("addName");
			// 获取页面传递过来的请求参数
			String url = req.getParameter("addURL");

			// 通过http协议头部消息中的key “Content-Disposition”可以获取上传文件的一些信息
			String info = file.getHeader("Content-Disposition");
			// 截取文件的后缀
			int b = info.indexOf("filename=\"") + 10;
			int e = info.length() - 1;
			String filename = info.substring(b, e);
			String savePath = getServletContext().getRealPath("/") + filename;
			file.write(savePath);

			IImageService imageServer = new ImageService();

			Image image = new Image(filename, url, null);
			imageServer.add(image);
			resp.sendRedirect(Data.URL + "/Manage/Image.jsp");

		} else if (op != null && "doupdate".equals(op)) {
			System.out.println(req.getParameter("updateid"));
			int id=Integer.parseInt(req.getParameter("updateid"));
			// 对应Image.jsp（编辑图片信息）提交按钮
			Part file = req.getPart("updatename");
			// 获取页面传递过来的请求参数
			String url = req.getParameter("updateurl");

			// 通过http协议头部消息中的key “Content-Disposition”可以获取上传文件的一些信息
			String info = file.getHeader("Content-Disposition");
			// 截取文件的后缀
			int b = info.indexOf("filename=\"") + 10;
			int e = info.length() - 1;
			String filename = info.substring(b, e);
			String savePath = getServletContext().getRealPath("/") + filename;
			file.write(savePath);

			IImageService imageServer = new ImageService();

			Image image = new Image(id,filename, url, null);
			System.out.println(image+"88888");
			imageServer.update(image);
			resp.sendRedirect(Data.URL + "/Manage/Image.jsp");

		}
	}
}
