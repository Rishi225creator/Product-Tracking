package sis.com.producttracking.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	boolean  createNewSession=false;
	HttpSession session = request.getSession(createNewSession);
	
	String sessionMessage=null;;
	
	if(session==null){
		//session already expired
		sessionMessage="Session already Exprired/Logout ";
	}else{
		session.invalidate();//expired session 
		sessionMessage="Session  Exprired : logout successfuly";
	}
	
	
	//redirect to login page   
	//response.sendRedirect("login");

	//create new page and show message
	request.setAttribute("sessionMessage",sessionMessage );
	request.getRequestDispatcher("logout_message.jsp").forward(request, response);;
	
	
	
	
	
	
	
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
