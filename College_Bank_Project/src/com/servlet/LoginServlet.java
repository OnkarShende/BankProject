package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.User;
import com.utility.JDBC;


@WebServlet(urlPatterns ="/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession s=req.getSession();
		
		if(!s.isNew())
		{
			System.out.println("Old Session Destroy it & Create New One");
			s.invalidate();
			s=req.getSession();
		}
		
		s.setAttribute("username", req.getParameter("username"));
		s.setAttribute("password", req.getAttribute("password"));
		
		long laccno=Long.parseLong(req.getParameter("accno"));
		
		User u=new User();
			u.setAccountno(Long.parseLong((req.getParameter("accno"))));
			u.setPassword(req.getParameter("pass"));
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/01_May_BankProject","root","root");
			
			PreparedStatement pr1=con1.prepareStatement("Select * from user where accountno=? and password=?");
			
			pr1.setLong(1, u.getAccountno());
			pr1.setString(2, u.getPassword());
		
			ResultSet rs1=pr1.executeQuery();
		
		if(rs1.next())
		{
			User u2=new User();
			
			u2.setAccountno(Long.parseLong(rs1.getString("accountno")));
			u2.setName(rs1.getString("name"));
			u2.setUsername(rs1.getString("username"));
			u2.setPassword(rs1.getString("password"));
			u2.setBalance(Double.parseDouble(rs1.getString("balance")));
			
			req.setAttribute("user", u2);
			req.setAttribute("laccno", laccno);
						
			RequestDispatcher rd=req.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("error", "Enter Correct Acoount No & Password");
			
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

