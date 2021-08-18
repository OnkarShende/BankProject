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

@WebServlet(urlPatterns = "/change")
public class EditServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			// Called SelectAll Query from Utility Class
			req.setAttribute("user", SelectAll_and_UpdateBal.selectAll(Long.parseLong(req.getParameter("laccno"))));		
			RequestDispatcher rd=req.getRequestDispatcher("Edit.jsp");
			rd.forward(req, resp);
		
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		
		}
	}

}
