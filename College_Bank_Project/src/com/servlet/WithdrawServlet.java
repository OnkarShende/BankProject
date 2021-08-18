package com.servlet;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/withdraw")
public class WithdrawServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PreparedStatement pr=null;
		
		User u=new User();	
		u.setAccountno(Long.parseLong(req.getParameter("laccno")));
		HttpSession s=req.getSession(false);

		if(s==null)
		{
			System.out.println("New Object");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		else
		{
		
		try
		{
		pr=JDBC.getPreparedStatement("select balance from user where accountno=?");
		
		pr.setLong(1, u.getAccountno());
		
		ResultSet rs=pr.executeQuery();
		
		if(rs.next())
		{
			u.setBalance(rs.getDouble("balance"));	
		}
		
		req.setAttribute("user", u);
		
		RequestDispatcher rd=req.getRequestDispatcher("Withdraw.jsp");
		rd.forward(req, resp);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}	
}
