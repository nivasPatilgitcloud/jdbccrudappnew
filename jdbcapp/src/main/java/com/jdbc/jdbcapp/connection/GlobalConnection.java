package com.jdbc.jdbcapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GlobalConnection {
	
	 private static final String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
	 private static final String username = "root";
	 private static final String password = "Mysql@2238399";
	 private static final String driver = "com.mysql.cj.jdbc.Driver";

	 static {
		 try {
			 Class.forName(driver);
		 }catch(ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	 }

	public static Connection getGlobalConnection() throws SQLException{		
		return DriverManager.getConnection(url,username,password);
	}
}
