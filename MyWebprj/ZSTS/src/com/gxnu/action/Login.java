package com.gxnu.action;

import com.gxnu.entity.Operator;
import com.gxnu.service.IOperatorService;
import com.gxnu.service.imp.OperatorService;
import com.gxnu.util.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet(urlPatterns = {"/loginAction"})
//继承父类javax.servlet.http.HttpServlet
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("USERNAME");
        String password = req.getParameter("PASSWORD");
        String OP = req.getParameter("OP");
        
        if(OP!=null&&OP.equals("login")) {
        	IOperatorService ios = new OperatorService();
            Operator op = ios.find(username, password);
            if(op.getId()>0 && op.getStatus()==1) {
            	HttpSession hs = req.getSession();
            	hs.setAttribute("OPERATOR", op);
            	op.setFalsetime(0);
            	ios.update(op);
                resp.sendRedirect(Data.URL+"/web/main.jsp");
            }else if(op.getId()>0 && op.getStatus()==0) {
            	resp.setContentType("text/html;charset=UTF-8");
            	PrintWriter pw = resp.getWriter();
            	pw.println("<script>window.alert('您的账号已冻结，请联系管理员进行处理!');window.location.href='"
            			+ Data.URL+"/web/login.jsp';</script>");
            	
            }else {
	            	List<Operator> operators = ios.find();
	            	boolean flag = false; 
	            	for(Operator operator : operators) {
	            		if(operator.getUsername().equals(username)) {
	            			if(operator.getFalsetime()<3 && operator.getFalsetime()>=0) {
	            				operator.setFalsetime(operator.getFalsetime()+1);
	            			    resp.sendRedirect(Data.URL+"/web/login.jsp");
	            			}else if(operator.getFalsetime()>=2) {
	            				operator.setStatus(0);
	            				resp.setContentType("text/html;charset=UTF-8");
	            				PrintWriter pw = resp.getWriter();
	                        	pw.println("<script>window.alert('您的账号已锁定，请1分钟后再试!');window.location.href='"
	                        			+Data.URL+ "/web/login.jsp';</script>");	                        	
	                        	
	                        	//java工具类，延时函数
	                            Timer timer = new Timer();
	                            TimerTask task = new TimerTask(){
	                                public void run(){
	                                	operator.setStatus(1);
	                                	operator.setFalsetime(0);
	                                    ios.update(operator);
	                                    this.cancel();}
	                             };
	                            timer.schedule(task,1000*60);
	            			}
	            			ios.update(operator);
	            			flag = true;
	            		}break;
	            	}
	            	if(!flag) {
	            		resp.setContentType("text/html;charset=UTF-8");
	                	PrintWriter pw = resp.getWriter();
	                	pw.println("<script>window.alert('无此用户!');window.location.href='"
	                			+ Data.URL+ "/web/login.jsp';</script>");
	            	}
              }
        }else if(OP!=null&&OP.equals("exit")) {
            	req.removeAttribute("OPERATOR");
            	resp.sendRedirect(Data.URL+"/web/login.jsp");
            }
        }       
    }

