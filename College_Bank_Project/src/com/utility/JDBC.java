package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC 
{
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/01_May_BankProject";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static Connection con=null;
	private static PreparedStatement pr=null;
	
	
	public static PreparedStatement getPreparedStatement(String sql)
	{
		try 
		{
			Class.forName(DRIVER);
			
			con=DriverManager.getConnection(URL,USER,PASSWORD);
			
			pr=con.prepareStatement(sql);	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return pr;
	}
	
	public void close()
	{
		try
		{
			pr.close();
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}
}
