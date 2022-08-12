package com.gxnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.gxnu.entity.User;
import com.gxnu.service.IUserService;
import com.gxnu.service.imp.UserService;
import com.gxnu.util.Data;
import com.gxnu.util.Wrap;
import com.mysql.cj.xdevapi.JsonArray;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/dialogue")
public class DialogueAtion extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	   /**
     * 从HTTP请求中获取客户IP地址
     *
     * @param request http请求
     * @return 客户IP地址
     */
	/*ip伪装
	 * import com.taobao.gulu.http.PostRequest;
	 * 
	 * import com.taobao.gulu.http.Response;
	 * 
	 * import com.taobao.gulu.http.StringBodyEntity;
	 * 
	 * public class XuIPTest {
	 * 
	 * public static void main(String[] args) throws Exception {
	 * 
	 * String str = "{\"a\":\"a\"}";
	 * 
	 * StringBodyEntity body;
	 * 
	 * body = new StringBodyEntity(str);
	 * 
	 * PostRequest request = new PostRequest();
	 * 
	 * String header = "x-forwarded-for:1.1.1.1";//伪造IP放入请求头
	 * 
	 * Response response = request.doRequest("http://IP:8933",header,
	 * body);//构造header发起Post请求
	 * 
	 * System.out.println("结果是："+response.getResponseBodyAsString());
	 * 
	 * }
	 * 
	 * }
	 */

    public static String getIPAddress( HttpServletRequest request )
    {
        String ip = request.getHeader( "x-forwarded-for" );
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "Proxy-Client-IP" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "WL-Proxy-Client-IP" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "HTTP_CLIENT_IP" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "HTTP_X_FORWARDED_FOR" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("会诊中");
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String info = request.getParameter("text");
		String ip = getIPAddress(request);
		
		
		
		
		if(op!=null&&"send".equals(op)) {
			response.setHeader("Content-type", "text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			IUserService ius = new UserService();
			User u = ius.findById(Integer.parseInt(id));
			//放回json数据
			String text = null;
			if(op!=null&&"send".equals(op)) {
				Wrap w = new Wrap();
				text = w.sendWrap(u.getName(), info);
				
			}
			//JsonArray json = new JsonArray();
			
			org.json.JSONObject jsonObject = new JSONObject();
			jsonObject.put("erro", 0 );
			jsonObject.put("text", text );
			//json.put(jsonObject); 
			response.getWriter().write(jsonObject.toString());
		}
		
	}
	
}
