package com.gxlq.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class JNDIBaseDAO {

	    public Connection getConnection() throws ClassNotFoundException, SQLException {
	    	Connection  conn = null;;
	    	try {
				Context c = new InitialContext();
				DataSource ds = (DataSource) c.lookup("java:comp/env/jdbc/xxx");
				conn = ds.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return conn;
	    }

	    public void closeConnection(Connection conn) throws SQLException {
	        if (conn != null) {
	            conn.close();
	        }
	    }
}

