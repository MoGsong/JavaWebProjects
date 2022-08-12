package com.gxnu.action.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;
@WebServlet(urlPatterns = {"/managelogin"})
public class LoginAction extends HttpServlet {
	
	public static String change(String str) {
		String rst = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <='Z') {
				rst += (char)(str.charAt(i) - 'A' +'a');
			}else {
				rst += str.charAt(i);
			}
		}
		return rst;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op =  req.getParameter("OP");
		if(op!=null && "login".equals(op)) {
			//鑾峰彇鐢ㄦ埛杈撳叆淇℃伅
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String checkcode = change(req.getParameter("checkcode"));
			
			//璋冪敤涓氬姟鏂规硶锛屾煡璇㈡槸鍚﹀瓨鍦ㄨ鐢ㄦ埛
			IOperatorService operatorService = new OperatorService();
			Operator operator = operatorService.find(username, password);
			//閫氳繃浼氳瘽鑾峰彇楠岃瘉鐮�,骞惰繘琛屾瘮瀵�
	        HttpSession checkCode = req.getSession();
			Object code = checkCode.getAttribute("CODE");
			String code1 = change((String)code);
			resp.setContentType("text/html;charset = UTF-8");
			PrintWriter out = resp.getWriter();
			String dist = "";
			if(code1.equals(checkcode)) {
				if(operator.getId()>0) {
					System.out.println("鍚堟硶");
					dist=Data.URL+"/Manage/index.jsp";
					//鎶婂綋鍓嶇敤鎴风殑淇℃伅锛堢敤鎴峰悕锛夊瓨鏀惧埌浼氳瘽瀵硅薄session涓�
					HttpSession session = req.getSession();
					session.setAttribute("USER", username);
					session.setAttribute(Data.OPERATOR, operator);//鎶婄敤鎴峰畬鏁翠俊鎭瓨鏀惧埌session浼氳瘽瀵硅薄涓�
					resp.sendRedirect(dist);
				}else {
//					out.print("<script>window.alert('鐢ㄦ埛鍚嶆垨瀵嗙爜鏈夎锛岃閲嶆柊鐧诲綍');</script>");
//					System.out.println("闈炴硶");
//					dist=Data.URL+"/Manage/Login.jsp";
					out.println("<script>window.alert('用户名或密码错误!');window.location.href='"
	            			+ Data.URL+ "/Manage/Login.jsp';</script>");
				}
			}else {
				//楠岃瘉鐮佽緭鍏ラ敊璇�,鐧诲綍澶辫触
//				out.print("<script>window.alert('楠岃瘉鐮佹湁璇�');</script>");
//				dist=Data.URL+"/Manage/Login.jsp";
				out.println("<script>window.alert('验证码错误!');window.location.href='"
            			+ Data.URL+ "/Manage/Login.jsp';</script>");
			}
			
			//璺宠浆鍒颁笅涓�涓祫婧�
//			resp.sendRedirect(dist);
		}else {
			
		}
	}

}
