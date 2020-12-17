package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {
	private static ConnFactory cf;
	private ConnFactory() {
		super();
	}
	private String url="jdbc:postgresql://projectone.cagd9qgsp3uo.us-east-2.rds.amazonaws.com:5432/projectone";
	private String username="projectone";
	private String password="2010usfjava";
	public static synchronized ConnFactory getInstance() {
		 if (cf==null) {
			 cf= new ConnFactory();
		 }
		 return cf;
	 }
	 
	 public Connection getConnection() {
		 Connection conn = null; 
		 try {
			 conn = DriverManager.getConnection(this.url,this.username,this.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	 }
	 
	}

