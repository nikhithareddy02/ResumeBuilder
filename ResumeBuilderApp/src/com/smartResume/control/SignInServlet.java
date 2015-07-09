package com.smartResume.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartResume.lib.SignInClass;
import com.smartResume.lib.UserObject;

/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		/*
		 * Getting parameters from html page
		 */
		String email,password;
		email = request.getParameter("username");
		password = request.getParameter("password");
		System.out.println(email+"\n"+password);
		
		HttpSession session = request.getSession();
		
		SignInClass signIn = new SignInClass();
		UserObject user = new UserObject();
		Boolean bool = signIn.ValidateLogin(email, password);
		if(bool){
			//System.out.println("Sign In Successful");
			if(signIn.isVerified(email))
			{
				//System.out.println("Login Success");
				session.setAttribute("user", user.getFilledUser(email));
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				rd.include(request, response);
			}
			else{
				System.out.println("Not-Active");
				RequestDispatcher rd=request.getRequestDispatcher("EnterOTP.html");
				rd.include(request, response);
			}
		}
		else{
			System.out.println("Sign In fails");
			HttpSession ss1=request.getSession(false);
			ss1.invalidate();
			out.println("<h1>Invalid Login Please Try Again</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
	}

}
