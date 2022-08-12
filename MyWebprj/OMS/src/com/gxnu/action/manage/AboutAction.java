package com.gxnu.action.manage;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gxnu.entity.About;
import com.gxnu.entity.About;
import com.gxnu.service.IAboutService;
import com.gxnu.service.IAboutService;
import com.gxnu.service.imp.AboutService;
import com.gxnu.service.imp.AboutService;
import com.gxnu.util.Data;

/**
 * 后台管理：操作员修改“关于医院”信息
 * @author 胖子不露小酒窝
 */
@WebServlet(urlPatterns = {"/about"})
@MultipartConfig
public class AboutAction extends HttpServlet{
	//继承父类javax.servlet.http.HttpServlet
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//不论get、post请求，均执行dopost方法
			doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String op=req.getParameter("OP");
			/**
			 * 修改关于医院			
			 */
			if (op!=null&&"toupdate".equals(op)) {
							//获取页面传递过来的请求参数，即修改的记录id信息
							String strid=req.getParameter("id");
							System.out.println("strid="+strid);
							int id=0;
									if(strid!=null) {
										id=Integer.parseInt(strid);
									}
							
							//调用业务方法，实现修改某条关于医院记录						
							IAboutService aboutService=new AboutService();
							About about=aboutService.find(id);	
							//把完整的关于医院信息存放到请求对象中
							req.setAttribute("ABOUT", about);
							
							//跳转到下一个资源，请求转发
							req.getRequestDispatcher("Manage/UpdateAbout.jsp").forward(req, resp);
							
			}else if (op!=null&&"doupdate".equals(op)) {
				//获取页面文件框中文件
				Part file=req.getPart("pic");
				
				//通过http协议头消息中的key,"Content-Disposition"可以获取上传的一些文件的信息
				String info = file.getHeader("Content-Disposition");
				System.out.println("文件的信息"+info);
								
				//截取文件的后缀
				//开始下标和结束下标可以动态的设置，即”10“和”1“视情况改变
				int b=info.indexOf("filename=\"")+10;			//int b=info.lastIndexOf("=")+2;
				int e=info.length()-1;
				
				//获取文件名
				String fileName=info.substring(b,e);
				System.out.println("文件名是："+fileName);
								
				//把文件另存到d盘根目录下
				//file.write("D://"+fileName);
				
				String path = getServletContext().getRealPath("/")+"/Manage/static/picture/" +fileName;
				/*获取部署环境的根目录，如
				D:\Users\johny\Documents\workspace-spring-tool-suite-4-4.2.2.RELEASE\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\prj712  */
				file.write(getServletContext().getRealPath("/") + "/Manage/static/picture/" + fileName);//把文件存入到部署环境的根目录里
				System.out.println(path);
				
				//获取页面传递过来的请求参数，即修改的记录id信息
				String strid=req.getParameter("id");
				int id=0;
						if(strid!=null) {
							id=Integer.parseInt(strid);
						}
				
				//获取页面传递过来的请求参数，即修改的记录id信息
				String name=req.getParameter("name");
				String address=req.getParameter("address");
				String synopsis=req.getParameter("synopsis");
				String tel=req.getParameter("tel");
				//String pic=req.getParameter("pic");
				String postcode=req.getParameter("postcode");//邮政编码最多6位
				String yuliu=req.getParameter("yuliu");
			
								
				//调用业务方法，实现修改某条关于医院记录
				IAboutService aboutService=new AboutService();
				About about=new About(id,name,address,synopsis,tel,fileName,postcode,yuliu);	//容易忽略id，则导致修改后回到主页面显示修改前而非后的内容
				aboutService.update(about);
				System.out.println(about);
				
				//跳转到关于医院页面
				resp.sendRedirect(Data.URL+"/Manage/About.jsp");
			}
		}		
}
