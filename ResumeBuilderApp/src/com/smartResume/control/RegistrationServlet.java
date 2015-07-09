package com.smartResume.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smartResume.helper.CaesarCipher;
import com.smartResume.lib.RegistrationClass;
import com.smartResume.lib.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		/*
		 * Getting parameters from html page
		 */
		String firstName,lastName,email,password,mobileNumber;
		firstName = request.getParameter("firstname");
		lastName = request.getParameter("lastname");
		email = request.getParameter("email");
		password = request.getParameter("password");
		mobileNumber = request.getParameter("phonenumber");
		//System.out.println(firstName+"\n"+lastName+"\n"+email+"\n"+password+"\n"+mobileNumber);
		/*
		 * Creating a http session with email as a attribute
		 */
		HttpSession session= request.getSession();
		session.setAttribute("email", email);

		CaesarCipher cc= new CaesarCipher();
		/*
		 * Creating a user object and setting the variable values
		 */
		User user = new User();
		user.setEmailId(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMobileNumber(Long.parseLong(mobileNumber));
		String encryptedPwd = cc.encrypt(password, 3);
		user.setPassword(encryptedPwd);
		user.setVerifiedStatus(0);
		/*
		 * Call to registration class to insert the user to database
		 * and to send verification code to the user mail
		 */
		RegistrationClass reg = new RegistrationClass();
		reg.InsertAndSendOTP(user);
		/*
		 * Redirecting to enterOTP page which will ask user to enter OTP
		 */
		RequestDispatcher rd=request.getRequestDispatcher("EnterOTP.html");
		rd.include(request, response);

	}

}
