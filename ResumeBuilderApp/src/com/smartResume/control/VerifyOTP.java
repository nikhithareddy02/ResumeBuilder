package com.smartResume.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartResume.lib.RegistrationClass;

/**
 * Servlet implementation class VerifyOTP
 */
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyOTP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Pragma", "cache");
		response.setHeader("Cache-Control", "private, must-revalidate");
		PrintWriter out=response.getWriter();
		int OTP=0;
		if(!request.getParameter("otp").equals("")){
			OTP=Integer.parseInt(request.getParameter("otp"));
		}
		//System.out.println(OTP);

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		RegistrationClass reg = new RegistrationClass();
		if(reg.VerifyOTP(email, OTP)){
			//System.out.println("TRUE");
			out.println("1");
		}
		else{
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
