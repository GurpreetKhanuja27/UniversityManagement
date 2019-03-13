package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// JDBC Code
		private static final String dbdriver = "com.mysql.jdbc.Driver";
		private static final String url = "jdbc:mysql://localhost:3306/testdatabase";
		private static final String username = "root";
		private static final String password = "root";
		private static java.sql.Connection conn = null;
	
	public Connection getConnection() {
	
		try {

			Class.forName(dbdriver);
			conn = DriverManager.getConnection(url, username, password);// get db connection

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
}
