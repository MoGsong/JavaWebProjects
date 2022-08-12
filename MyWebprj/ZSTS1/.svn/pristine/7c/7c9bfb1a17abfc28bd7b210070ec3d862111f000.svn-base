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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gxnu.dao.C3P0BaseDAO;
import org.json.JSONObject;

import com.mysql.cj.Session;
/**
 *使用举例
 * @author ymp0519
 * 结果显示在控制台console
 * 关于ResultSetMetaData,可以查看:  https://blog.csdn.net/wuyujin1997/article/details/89668631
 */
@WebServlet(urlPatterns={"/jsonAction"})
@MultipartConfig
public class JsonAction  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //数据库连接
        C3P0BaseDAO baseDAO = new C3P0BaseDAO();
        try {
        	 Connection con= baseDAO.getConnection();
        	 Statement stet = con.createStatement();

            
            //获取传输参数
            String op = req.getParameter("OP");
            if(op==null ) {

	            //查出所有的表名
				String sql2="show tables;";
				ResultSet rs2 = stet.executeQuery(sql2);//将查询结果存入结果集ResultSet   
				ResultSetMetaData metaData2 =  rs2.getMetaData();  //获取结果集的元数据信息
				List<String> tableNameList = new ArrayList<String>();
				 while(rs2.next()){
					   String columnName = metaData2.getColumnLabel(1);  
		               String value =rs2.getString(columnName);  //查出列名对应的值
		               System.out.println(columnName+":"+value);
		               tableNameList.add(value);
		               
				 }
				 System.out.println(tableNameList);
				req.setAttribute("TABLENAMELIST", tableNameList);
				
				
				req.getRequestDispatcher("web/JsonShow.jsp").forward(req, resp);
            }else {
            	//改变页面显示编码方式！！！！
            	resp.setHeader("Content-type", "text/html;charset=UTF-8");
            	resp.setContentType("text/html;charset=UTF-8");
            
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
				             for(int i = 1; i <= columnCount;i++){  
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
				            String JsonStr = array.toString();
				         
				            //弹框
				            PrintWriter out = resp.getWriter();
							out.print("<script>window.alert('The JSON data conversion is successful~')</script>");
				            con.close();
				            
						
							out.print("转换为JSON数据，结果如下：");
							out.print("<br>");//换行
							out.print(JsonStr);
							
							
				 		}//end_for_else(flag)
			        }//end_for_else(op)
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

    }


}
