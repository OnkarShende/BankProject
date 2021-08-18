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
import com.utility.SelectAll_and_UpdateBal;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PreparedStatement pr=null;
		
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
		pr=JDBC.getPreparedStatement("Update user set name=?, username=?, password=? where accountno=?");
		
		pr.setString(1, req.getParameter("name"));
		pr.setString(2, req.getParameter("uname"));
		pr.setString(3, req.getParameter("pass"));
		pr.setLong(4, Long.parseLong(req.getParameter("laccno")));
		
		int i=pr.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{		
			//Called Selact All Query of Utility Class
			req.setAttribute("msg", "Successfully Updated All Details");
			req.setAttribute("user", SelectAll_and_UpdateBal.selectAll(Long.parseLong(req.getParameter("laccno"))));
			RequestDispatcher rd=req.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(req, resp);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		}
	
	}
}