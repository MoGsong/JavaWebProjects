package com.gxnu.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;  
import org.json.JSONObject;
/**
 *使用举例
 *	http://ip:8080/prj0717/jsonAction?tablename=lnformation
 *	http://ip:8080/prj0717/jsonAction?tablename=menu
 *	http://ip:8080/prj0717/jsonAction?tablename=operator  
 * @author ymp0519
 * 结果显示在控制台console
 * 关于ResultSetMetaData,可以查看:  https://blog.csdn.net/wuyujin1997/article/details/89668631
 */
@WebServlet(urlPatterns={"/jsonAction"})
@MultipartConfig
public class JsonAction  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	        String driver = "com.mysql.cj.jdbc.Driver";

    	//数据库连接字符串，注意需要ip和数据库名
    	        String url = "jdbc:mysql://192.168.1.158/zsts4?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    	        String user = "ys"; 
    	        String pwd = "ys";  
    	        try {
    	//连接数据库
    	            Class.forName(driver);
    	            Connection con =   DriverManager.getConnection(url,user,pwd);
    	            Statement stet = con.createStatement();

    	//查出固定表的所有记录
    	           //String sql = "select * from operator";
    	            
	      

    	            
    	    //从请求参数中动态获取表名
			String tablename = req.getParameter("tablename");
			
			//检查指定的表名是否存在,查询结果为: count(table_name):value, 不存在即value=0
			String sql0="SELECT count(table_name) FROM information_schema.TABLES WHERE table_name ='"+tablename+"'";
			ResultSet rs0 = stet.executeQuery(sql0);//将查询结果存入结果集ResultSet   
			ResultSetMetaData metaData1 =  rs0.getMetaData();  //获取结果集的元数据信息
			int flag=0;
			 while(rs0.next()){
				   String columnName = metaData1.getColumnLabel(1);  
	               String value =rs0.getString(columnName);  //查出列名对应的值
	               System.out.println(tablename+":"+columnName+":"+value);  
	               flag=Integer.valueOf(value); 
			 }
			 if(flag==0) {
				 System.out.println("表名错误,请修改");
				 PrintWriter out = resp.getWriter();
				 out.print("<script>window.alert('Table name is wrong, please modify!')</script>");
			 }else {
			
			//查出tablename指定的表的所有记录
		        String sql = "select * from "+tablename;
		        
	    	//将查询结果存入结果集ResultSet            
	    	            ResultSet rs = stet.executeQuery(sql);
	    	            ResultSetMetaData metaData =  rs.getMetaData();  //获取结果集的元数据信息
	    	            int columnCount= metaData.getColumnCount();   	//获取结果集的列数
	    	            
	    	            JSONArray array = new JSONArray();
	    	            System.out.println("将mysql的"+tablename+"表中的数据以(“字段名”:“value”)的形式存入json对象");  
	    	            int count=0;
	    	            while(rs.next()){ 
	    	             JSONObject jsonObj = new JSONObject(); 
	    	             count++;
	    	             System.out.println("第"+count+"个json对象开始封装……");
	    	             for(int i = 1; i <= columnCount;i++)  
	    	              {  
	    	               String columnName = metaData.getColumnLabel(i);  
	    	               String value =rs.getString(columnName);  //查出列名对应的值
	    	               jsonObj.put(columnName, value);  
	    	               System.out.println("存入"+columnName+":"+value);
	    	              }  
	    	             System.out.println("第"+count+"个json对象封装完成");
	    	             System.out.println();
	    	              array.put(jsonObj);  
	    	            }
	    	            System.out.println("转换为JSON数据，结果如下：");  
	    	            System.out.println(array.toString());  
	    	            
	    	            //弹框
	    	            PrintWriter out = resp.getWriter();
	   				 	out.print("<script>window.alert('The JSON data conversion is successful, please check the console output')</script>");
	    	            con.close();
			 		}//end_for_else
    	            
    	        } catch (Exception e) {

    	            e.printStackTrace();// TODO: handle exception
    	        } 
    	      
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    }


}
