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

@WebServlet(urlPatterns = "/transactdeposit")
public class DepositTransact extends HttpServlet {
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
		
		if (Double.parseDouble(req.getParameter("dvalue")) >= 300) 
		{
			
			double dvalue=Double.parseDouble(req.getParameter("dvalue"));
			double oldbal=Double.parseDouble(req.getParameter("oldbal"));
			
			double newbal=oldbal+dvalue;
			Long laccno=Long.parseLong(req.getParameter("laccno"));
							
			try
			{
				//Called Update balance query from utility class
				SelectAll_and_UpdateBal.updateBal(laccno, newbal);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try 
			{
				
			//Called Selact All Query of Utility Class
				req.setAttribute("msg", "Money Successfully Deposited");
				req.setAttribute("user", SelectAll_and_UpdateBal.selectAll(Long.parseLong(req.getParameter("laccno"))));
				RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(req, resp);

			}
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}
		}
		else 
		{
			try
			{	
				//Called Selact All Query of Utility Class
				req.setAttribute("error", "Deposit Atleast 300 RS");
				req.setAttribute("user", SelectAll_and_UpdateBal.selectAll(Long.parseLong(req.getParameter("laccno"))));
				RequestDispatcher rd = req.getRequestDispatcher("Deposit.jsp");
				rd.forward(req, resp);

			}
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}		
		}
		
		}
	}
}
