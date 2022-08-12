package com.gxnu.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxnu.entity.Menu;
import com.gxnu.service.IMenuService;
import com.gxnu.service.imp.MenuService;


@WebServlet(urlPatterns = {"/menu"})
public class MenuAction extends HttpServlet{
	//继承父类javax.servlet.http.HttpServlet
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//不论get、post请求，均执行dopost方法
			doPost(req, resp);
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String op=req.getParameter("OP");
			System.out.println(op+888);
			
			/**
			 * 添加菜单
			 */
			if (op!=null&&"add".equals(op)) {
						   //获取页面传递过来的请求参数，即添加的记录id信息
							String name=req.getParameter("name");
							String parent=req.getParameter("parent");
							String URL=req.getParameter("URL");
							String yuliu=req.getParameter("yuliu");
							
							System.out.println("输出获取的信息"+name+parent+URL+yuliu);
							//调用业务方法，实现添加某条菜单记录
							Integer parent1=Integer.parseInt(parent);
							Menu menu=new Menu(name,parent1,URL,yuliu);
							System.out.println(menu);
							IMenuService menuService=new MenuService();
							menuService.add(menu);
			
							//跳转到菜单页面
							resp.sendRedirect("http://192.168.1.163:8080/ZSTS/web/menu.jsp");
			
			/**
			 * 修改菜单			
			 */
			}else if (op!=null&&"toupdate".equals(op)) {
							//获取页面传递过来的请求参数，即修改的记录id信息
							String strid=req.getParameter("ID");
							System.out.println(strid);
							int id=0;
									if(strid!=null) {
										id=Integer.parseInt(strid);
									}
							
							//调用业务方法，实现修改某条菜单记录						
							IMenuService menuService=new MenuService();
							Menu menu=menuService.find(id);	
							System.out.println(menu+"111");
							//把完整的菜单信息存放到请求对象中
							req.setAttribute("MENU", menu);
							
							//跳转到下一个资源，请求转发
							req.getRequestDispatcher("web/updatemenu.jsp").forward(req, resp);
							
			}else if (op!=null&&"doupdate".equals(op)) {
				//获取页面传递过来的请求参数，即修改的记录id信息
				String strid=req.getParameter("ID");
				int id=0;
						if(strid!=null) {
							id=Integer.parseInt(strid);
						}
				System.out.println(id);
				//获取页面传递过来的请求参数，即修改的记录id信息
				String name=req.getParameter("name");
				String parent=req.getParameter("parent");
				String URL=req.getParameter("URL");
				String yuliu=req.getParameter("yuliu");
				
				//调用业务方法，实现修改某条菜单记录
				IMenuService menuService=new MenuService();
				Menu menu=new Menu(id,name,Integer.parseInt(parent),URL,yuliu);	//容易忽略id，则导致修改后回到主页面显示修改前而非后的内容
				//把完整的菜单信息存放到请求对象中
				//req.setAttribute("MENU", menu);
				
				//跳转到登录页面
				resp.sendRedirect("http://192.168.1.163:8080/ZSTS/web/menu.jsp");
			
			/**
			 * 删除菜单			
			 */
			}else {					
								//获取页面传递过来的请求参数，即删除的记录id信息
								String strid=req.getParameter("id");
								int id=0;
										if(strid!=null) {
											id=Integer.parseInt(strid);
										}
								
								//调用业务方法，实现删除某条菜单记录
								IMenuService menuService=new MenuService();
								menuService.remove(id);
							
								//刷新页面
								resp.sendRedirect("http://192.168.1.163:8080/ZSTS/web/menu.jsp");
						
				}
				}
}
