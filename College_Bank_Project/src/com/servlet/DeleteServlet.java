package com.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.User;
import com.utility.JDBC;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet
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
		
			User u=new User();
			u.setAccountno(Long.parseLong(req.getParameter("laccno")));
			
			try
			{
			pr=JDBC.getPreparedStatement("delete from user where accountno=?");
			
			pr.setLong(1, u.getAccountno());
			
			int i=pr.executeUpdate();
			
			System.out.println(i);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			req.setAttribute("error", "Account Deleted Successfully");
			
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
			
		}
	}

}
