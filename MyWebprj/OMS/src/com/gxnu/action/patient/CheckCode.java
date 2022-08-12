package com.gxnu.action.patient;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/checkcode"})
public class CheckCode extends HttpServlet{

	//随机生成数字、大小写字母
	private static char getchar() {
		Random r = new Random();
		int tmp = r.nextInt(10);
		if(tmp < 3)
			return (char)('0'+r.nextInt(10));
		else if(tmp < 6)
			return (char)('a'+r.nextInt(26));
		else
			return (char)('A'+r.nextInt(26));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当通过get方式请求当前servlet类时，响应一个验证码图片到浏览器端
		resp.setContentType("image/jpeg"); //设置响应的内容类型
		
		//设置页面不缓存
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("expires", 0);
		
		// 在内存中创建图像，宽度为width，高度为height
        int width = 80, height = 40;
        StringBuilder str = new StringBuilder();//定义验证码字符串
        //基于特定面积和色彩创建一个Java图片对象
        BufferedImage pic = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        
        // 获取图形上下文环境（即画图板）
        Graphics gc = pic.getGraphics();
        
        // 设定背景色并进行填充
        gc.setColor(Color.white);
        gc.fillRect(0, 0, width, height);
        
        Random r = new Random();
    	
    	for(int i = 0; i < 4; i++) {//画4条线
    	    Color color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));//随机颜色
    	    gc.setColor(color);//把颜色给画笔
    	    //生成两个点的坐标，即4个值
    	    int x1 = r.nextInt(width);
    	    int y1 = r.nextInt(height);
    	    int x2 = r.nextInt(width);
    	    int y2 = r.nextInt(height);
    	    gc.drawLine(x1, y1, x2, y2);//画线：x1y1为线段的一个端点，x2y2为另一个端点
    	}
    	//使用画圆来加入噪点
    	for(int i = 0; i < 50; i++){//99个噪点,x,y为噪点坐标
    	    Color color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));//随机颜色
    	    gc.setColor(color);//把颜色给画笔
    	    int x = r.nextInt(width);
    	    int y = r.nextInt(height);
    	    gc.drawOval(x,y,1,1);//xy是椭圆的圆心左边，width为宽，height为高
    	}

    	String[] fontNames  = {"宋体", "黑体", "微软雅黑", "楷体"};//定义字体取值
    	
    	while (true){//生成验证码字符串
	        char a = getchar();//随机生成数字或大小写字母
	        gc.setFont(new Font(fontNames[r.nextInt(fontNames.length)],Font.BOLD,r.nextInt(15)+25));//随机字体
	        Color color = new Color(r.nextInt(150),r.nextInt(150),r.nextInt(150));//随机字体颜色
	        gc.setColor(color);//把颜色给画笔
	        gc.drawString(a+"",20*str.toString().length(),30);//写入字符
	        str.insert(str.length(),a);//在字符串末尾加入字符，记录验证码备用

    	    if(str.toString().length()==4)//当验证码长度为4时退出循环
    	        break;
    	}

    	
        //将验证码上传到会话中
        HttpSession checkCode = req.getSession();
        checkCode.setAttribute("CODE", str.toString());
		
    	// 释放图形上下文环境
        gc.dispose();
		//把验证码图片传输到浏览器端
        //输出生成后的验证码图像到页面
        ImageIO.write(pic, "JPEG", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
