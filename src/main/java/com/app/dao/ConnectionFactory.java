package com.app.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static Properties prop = new Properties();// key : value pairs
	private static String propertiesfname = "dbconfig.properties";
	private static java.sql.Connection conn = null;

	static {
		InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream(propertiesfname);

		if (is != null) {
			try {
				prop.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {

		try {

			Class.forName(prop.getProperty("dbdriver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));// get db connection

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
