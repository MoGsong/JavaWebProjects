package com.gxnu.action.doctor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gxnu.entity.Doctor;

import com.gxnu.entity.Post;
import com.gxnu.entity.Unit;
import com.gxnu.service.IDoctorService;

import com.gxnu.service.IPostService;
import com.gxnu.service.IUnitService;
import com.gxnu.service.imp.DoctorService;

import com.gxnu.service.imp.PostService;
import com.gxnu.service.imp.UnitService;
import com.gxnu.util.Data;

@WebServlet(urlPatterns = { "/doctor" })
//指定当前servlet支持接收页面提交过来的非文本数据，如文件
@MultipartConfig
public class DoctorAction extends HttpServlet {
	// 继承父类javax.servlet.http.HttpServlet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 不论get、post请求，均执行dopost方法
		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("OP");

		if (op != null && "add".equals(op)) {
			// 获取页面传递过来的请求参数，即添加的记录id信息
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String agesrt = req.getParameter("age");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String unitsrt = req.getParameter("unit");
			String poststr = req.getParameter("post");
			System.out.println(tel);
			String addnote = req.getParameter("addnote");

			int age = 0;
			if (agesrt != null) {
				age = Integer.parseInt(agesrt);

			}
			int unitid = 0;
			if (agesrt != null) {
				unitid = Integer.parseInt(unitsrt);

			}
			int postid = 0;
			if (agesrt != null) {
				postid = Integer.parseInt(poststr);

			}

			Part file = req.getPart("pic");
			// 通过http协议头部消息中的key “Content-Disposition”可以获取上传文件的一些信息
			String info = file.getHeader("Content-Disposition");
			// 截取文件的后缀
			int b = info.indexOf("filename=\"") + 10;
			int e = info.length() - 1;
			String filename = info.substring(b, e);
			String savePath = getServletContext().getRealPath("/") + filename;
			file.write(savePath);

			IDoctorService doctorService = new DoctorService();
			IUnitService unitService = new UnitService();
			Unit unit = unitService.find(unitid);
			System.out.println(unit);
			IPostService postService = new PostService();
			Post post = postService.find(postid);
			System.out.println(post);
			String yuliu = "";
			Doctor doctor = new Doctor(name, sex, age, username, password, unit, post, filename, tel, email, yuliu);// 要看构造函数顺序
			System.out.println(doctor);
			doctorService.add(doctor);
			resp.sendRedirect(Data.URL + "/Manage/Doctor.jsp");

		} else if (op != null && "toupdate".equals(op)) {

			String strid = req.getParameter("id");
			int id = 0;
			if (strid != null) {
				id = Integer.parseInt(strid);
			}

			IDoctorService doctorService = new DoctorService();
			Doctor doctor = doctorService.find(id);
			req.setAttribute("DOCTOR", doctor);
			// 请求转发
			req.getRequestDispatcher("Manage/UpdateDoctor.jsp").forward(req, resp);
		} else if (op != null && "doupdate".equals(op)) {

			String strid = req.getParameter("id");
			int id = 0;
			if (strid != null) {
				id = Integer.parseInt(strid);
			}
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String tel = req.getParameter("tel");
			String email = req.getParameter("email");
			String agesrt = req.getParameter("age");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String unitsrt = req.getParameter("unit");
			String poststr = req.getParameter("post");
			System.out.println(tel);
			String addnote = req.getParameter("addnote");

			int age = 0;
			if (agesrt != null) {
				age = Integer.parseInt(agesrt);

			}
			int unitid = 0;
			if (agesrt != null) {
				unitid = Integer.parseInt(unitsrt);

			}
			int postid = 0;
			if (agesrt != null) {
				postid = Integer.parseInt(poststr);

			}

			Part file = req.getPart("pic");
			// 通过http协议头部消息中的key “Content-Disposition”可以获取上传文件的一些信息
			String info = file.getHeader("Content-Disposition");
			// 截取文件的后缀
			int b = info.indexOf("filename=\"") + 10;
			int e = info.length() - 1;
			String filename = info.substring(b, e);
			String savePath = getServletContext().getRealPath("/") + filename;
			file.write(savePath);

			IDoctorService doctorService = new DoctorService();
			IUnitService unitService = new UnitService();
			Unit unit = unitService.find(unitid);
			System.out.println(unit);
			IPostService postService = new PostService();
			Post post = postService.find(postid);
			System.out.println(post);
			String yuliu = "";
			Doctor doctor = new Doctor(id,name, sex, age, username, password, unit, post, filename, tel, email, yuliu);// 要看构造函数顺序
			System.out.println(doctor);
			doctorService.update(doctor);
			resp.sendRedirect(Data.URL + "/Manage/Doctor.jsp");
			

		} else {
			// 获取页面传递过来的请求参数，即删除的记录id信息
			String strid = req.getParameter("id");
			System.out.println(strid);
			int id = 0;
			if (strid != null) {
				id = Integer.parseInt(strid);
			}

			// 调用业务方法，实现删除某条处方记录
			IDoctorService doctorService = new DoctorService();
			doctorService.remove(id);

			// 刷新页面
			resp.sendRedirect(Data.URL + "/Manage/Doctor.jsp");
		}
	}
}
