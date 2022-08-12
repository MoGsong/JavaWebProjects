package com.gxnu.action.manage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Menu;
import com.gxnu.service.IMenuService;
import com.gxnu.service.imp.MenuService;
import com.gxnu.util.Data;

/**
 * Servlet implementation class MenuAction
 */
@WebServlet("/menu")
public class MenuAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  op = request.getParameter("OP");
		if(op!=null&&"add".equals(op)) {
			//添加数据
			String name = request.getParameter("NAME");
			String parent = request.getParameter("PARENT");
			String url = request.getParameter("URL");
			String yuliu =request.getParameter("YULIU");
			Menu menu = new Menu(name,Integer.parseInt(parent),url,yuliu);
			IMenuService menuService = new MenuService();
			menuService.add(menu);
			response.sendRedirect(Data.URL+"/Manage/Menu.jsp");
		} /*
			 * else if(op!=null&&"update".equals(op)){
			 * 
			 * String strid = request.getParameter("id"); int id = 0; if(strid!=null) { id =
			 * Integer.parseInt(strid); } IMenuService menuService = new MenuService(); Menu
			 * menu = menuService.find(id); //System.out.println(menu.toString());
			 * request.setAttribute(Data.MEAU, menu); //请求转发可以使用相对路径 //String path =
			 * request.getContextPath(); //String basePath =
			 * request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()
			 * +path+"/"; //System.out.println(basePath);
			 * request.getRequestDispatcher("/Manage/Menu.jsp").forward(request, response);
			 * 
			 * }
			 */else if(op!=null&&"update".equals(op)){
			
			String strid = request.getParameter("ID");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			String name = request.getParameter("NAME");
			String parent = request.getParameter("PARENT");
			String url = request.getParameter("URL");
			String yuliu =request.getParameter("YULIU");
			Menu menu = new Menu(id,name,Integer.parseInt(parent),url,yuliu);
			System.out.println(menu.toString());
			IMenuService menuService = new MenuService();
			menuService.update(menu);
			response.sendRedirect(Data.URL+"/Manage/Menu.jsp");
			
		}else if(op!=null&&"delete".equals(op)){
			
			//删除数据
			String strid = request.getParameter("ID");
			int id = 0;
			if(strid!=null) {
				id = Integer.parseInt(strid);
			}
			IMenuService menuService = new MenuService();
			menuService.remove(id);
			response.sendRedirect(Data.URL+"/Manage/Menu.jsp");
			
		}
	}

}
