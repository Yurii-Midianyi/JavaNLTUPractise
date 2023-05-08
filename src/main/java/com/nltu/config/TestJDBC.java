package com.nltu.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			System.out.println("Connection to data base: "+ jdbcUrl);
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.print("Connection successful");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
