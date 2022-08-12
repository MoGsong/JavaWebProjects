package com.gxnu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0BaseDAO {
	 private static DataSource dataSource=null;  
	    static{  
	        dataSource=new ComboPooledDataSource();   
	    }  
	      
	    /** 
	     * 获取数据库连接 
	     * @return 
	     */  
	    public static Connection getConnection(){  
	        Connection conn=null;  
	        try {  
	             conn=dataSource.getConnection();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        return conn;  
	    }  
	  
	    public static DataSource getDataSource() {
	        return dataSource;
	    }
	    /** 
	     * 
	     * @param conn 
	     */  
	    public static void closeConnection(Connection conn){  
	        try {  
	            if(conn!=null && conn.isClosed()){  
	                conn.close();  
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }
}

