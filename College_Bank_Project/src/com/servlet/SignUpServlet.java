package com.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.User;
import com.utility.JDBC;

@WebServlet(urlPatterns = "/signup")
public class SignUpServlet  extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PreparedStatement pr=null;
		
		User u=new User();
			u.setName(req.getParameter("name"));
			u.setAccountno(Long.parseLong(req.getParameter("accno")));
			u.setUsername(req.getParameter("uname"));
			u.setPassword(req.getParameter("pass"));
			u.setBalance(Double.parseDouble(req.getParameter("initbal")));
			
			System.out.println("___-");
			System.out.println(u.getAccountno());
			
			if(u.getBalance()>1000)
			{
				try
				{
				pr=JDBC.getPreparedStatement("insert into user values (?,?,?,?,?)");
				
				pr.setLong(1, u.getAccountno());
				pr.setString(2, u.getPassword());
				pr.setString(3, u.getUsername());
				pr.setString(4, u.getName());
				pr.setDouble(5, u.getBalance());
				
				pr.execute();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
				req.setAttribute("user", u);
				
			RequestDispatcher rd=req.getRequestDispatcher("SignUpSuccess.jsp");
				rd.forward(req, resp);	
			}
			else
			{
				System.out.println("Not Ok");
				req.setAttribute("error", "Please Deposit Initial Amount alteast 1000 RS");
				
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
		}
	}
