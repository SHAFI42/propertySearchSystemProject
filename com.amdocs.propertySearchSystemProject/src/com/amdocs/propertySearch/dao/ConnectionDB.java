package com.amdocs.propertySearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.amdocs.propertySearch.model.Property;

public class ConnectionDB {
	public Connection getConnection() {
		// jdbc object initialization
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");			
		}
		catch(Exception e) { // fileNotFoundE, SQLE
			System.out.println("Error Occured!, " + "Error: " + e.getMessage());
		}
		return c;
	}
}
