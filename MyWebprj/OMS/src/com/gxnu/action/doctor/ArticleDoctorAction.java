package com.gxnu.action.doctor;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gxnu.entity.Article;
import com.gxnu.service.IArticleService;
import com.gxnu.service.imp.ArticleService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = { "/article2" })
@MultipartConfig
public class ArticleDoctorAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String OP = req.getParameter("OP");
		// System.out.println(OP);
		if (OP != null && "add".equals(OP)) {

			// 获取页面文件框中文件
			Part file = req.getPart("pic");

			// 通过http协议头消息中的key,"Content-Disposition"可以获取上传的一些文件的信息
			String info = file.getHeader("Content-Disposition");
			// System.out.println("文件的信息"+info);

			// 截取文件的后缀
			// 开始下标和结束下标可以动态的设置，即”10“和”1“视情况改变
			int b = info.indexOf("filename=\"") + 10; // int b=info.lastIndexOf("=")+2;
			int e = info.length() - 1;

			// 获取文件名
			String fileName = info.substring(b, e);
			System.out.println("文件名是：" + fileName);

			// 把文件另存到d盘根目录下
			// file.write("D://"+fileName);

			String path = getServletContext().getRealPath("/") + "/Doctor/static/picture/" + fileName;
			/*
			 * 获取部署环境的根目录，如
			 * D:\Users\johny\Documents\workspace-spring-tool-suite-4-4.2.2.RELEASE\.
			 * metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\prj712
			 */
			file.write(getServletContext().getRealPath("/") + "/Doctor/static/picture/" + fileName);// 把文件存入到部署环境的根目录里

			// 获取页面提交过来的请求参数，即添加的记录信息

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			// String pic =req.getParameter("pic");
			String author = req.getParameter("author");

			Date date = new Date();

			Timestamp time = new Timestamp(date.getTime());

			Article article = new Article(title, content, fileName, author, time);

			IArticleService articleService = new ArticleService();
			articleService.add(article);

			// 跳转
			resp.sendRedirect(Data.URL + "/Doctor/Article.jsp");

		} else if (OP != null && "toupdate".equals(OP)) {

		} else if (OP != null && "doupdate".equals(OP)) {

			// 获取页面文件框中文件
			Part file = req.getPart("updatepic");

			// 通过http协议头消息中的key,"Content-Disposition"可以获取上传的一些文件的信息
			String info = file.getHeader("Content-Disposition");
			// System.out.println("文件的信息"+info);

			// 截取文件的后缀
			// 开始下标和结束下标可以动态的设置，即”10“和”1“视情况改变
			int b = info.indexOf("filename=\"") + 10; // int b=info.lastIndexOf("=")+2;
			int e = info.length() - 1;

			// 获取文件名
			String fileName = info.substring(b, e);
			System.out.println("文件名是：" + fileName);

			// 把文件另存到d盘根目录下
			// file.write("D://"+fileName);

			String path = getServletContext().getRealPath("/") + "/Doctor/static/picture/" + fileName;
			/*
			 * 获取部署环境的根目录，如
			 * D:\Users\johny\Documents\workspace-spring-tool-suite-4-4.2.2.RELEASE\.
			 * metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\prj712
			 */
			file.write(getServletContext().getRealPath("/") + "/Doctor/static/picture/" + fileName);// 把文件存入到部署环境的根目录里

			String strid = req.getParameter("id");
			int aid = 0;
			if (strid != null) {
				aid = Integer.parseInt(strid);
			}

			String title = req.getParameter("updatetitle");
			String content = req.getParameter("updatecontent");
			// String pic =req.getParameter("updatepic");
			String author = req.getParameter("updateauthor");
			//String time = req.getParameter("updatetime");
			
			Date date = new Date();

			Timestamp updatetime = new Timestamp(date.getTime());


			IArticleService articleService = new ArticleService();
			Article article = new Article(aid, title, content, fileName, author, updatetime);

			articleService.update(article);

			// 跳转
			String url = Data.URL + "/Doctor/Article.jsp";
			resp.sendRedirect(url);

		}
	}

}
