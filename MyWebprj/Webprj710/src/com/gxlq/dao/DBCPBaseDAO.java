package com.gxlq.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPBaseDAO {

	    public Connection getConnection() throws ClassNotFoundException, SQLException {
	    	//新建属性文件对象和连接对象
	    	Properties pro = new Properties();
	    	Connection  conn = null;
	    	//类加载dbcp属性文件
	    	try {
				//pro.load(DBCPBaseDAO.class.getClassLoader().getResourceAsStream("/dbcp.propeties"));
	    		
	    		pro.load(DBCPBaseDAO.class.getClassLoader().getResourceAsStream("D:/eclipse/spring eclipse/sts-4.2.2.RELEASE/MyWeb/Webprj710/src/dbcp.propeties"));
				//新建数据源对象
				DataSource ds = BasicDataSourceFactory.createDataSource(pro);
				conn = ds.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	        return conn;
	    }

	    public void closeConnection(Connection conn) throws SQLException {
	        if (conn != null) {
	            conn.close();
	        }
	    }
}

