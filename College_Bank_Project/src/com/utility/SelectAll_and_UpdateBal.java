package com.utility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import com.models.User;

public class SelectAll_and_UpdateBal 
{
	public static User selectAll(long laccno)
	{
		User u=new User();
		System.out.println(laccno);
		PreparedStatement pr=null;
		
		try 
		{
			pr = JDBC.getPreparedStatement("select * from user where accountno=?");

			pr.setLong(1, laccno);

			ResultSet rs = pr.executeQuery();

			if (rs.next()) 
			{
				
				u.setAccountno(rs.getLong("accountno"));
				u.setBalance(rs.getDouble("balance"));
				u.setName(rs.getString("name"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			} 
			else
			{
				System.out.println("wronge");
			}
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		return u;
	}
	
	
	public static void updateBal (long laccno , double bal)
	{
		try
		{
			PreparedStatement pr=null;
			
		pr=JDBC.getPreparedStatement("Update user set balance=? where accountno=?");
		
		pr.setDouble(1, bal);
		pr.setLong(2, laccno);
		
		int i=pr.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
