package sis.com.producttracking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sis.com.producttracking.bo.Category;
import sis.com.producttracking.bo.User;
import sis.com.producttracking.util.db.SisDatabaseConnectionUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//open form
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("login_id");
		String loginPassword = request.getParameter("login_password");
		List<String>erroList  = new ArrayList<String>();
		
		
		User user  = null;//if user found not null : else null user
		//TODO
		Connection con =null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		
		try {
			con  = SisDatabaseConnectionUtil.getConnection();
			String sql="  select * from spc_users"
					+ " where login_id=? and login_password=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			pstmt.setString(2, loginPassword);
			rs  = pstmt.executeQuery();
			
			if(rs.next()){
				long id  =rs.getLong("id");
				String name =rs.getString("name");
				String details =rs.getString("user_type");
				String userType =rs.getString("user_type");
				String email =rs.getString("email");
				String mobile =rs.getString("mobile");
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setLoginId(loginId);
				//user.setLoginPassword(loginPassword);
				user.setEmail(email);
				user.setMobile(mobile);
				user.setUserType(userType);
				 
			}
			
		} catch (SQLException e) {
			erroList.add("DB ERROR : "+e.getMessage());
		} catch (Exception e) {
			erroList.add("Other ERROR : "+e.getMessage());
		}finally {
			try {
				SisDatabaseConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				erroList.add("DB Close ERROR : "+e.getMessage());
		      
			}
		}
		
		//if user not null
		if(user!=null){
			 //login success
			// add user into session object for each user
			HttpSession session  =request.getSession();
			session.setAttribute("user", user);
			//LOgin validation task done
			//goto new path  
			response.sendRedirect(getServletContext().getContextPath());
			//http://localhost:8081                  /sisproducttracking
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//TODO EVEING  
		}else{
			//login failed
			//send error data into  login page
			request.setAttribute("loginErrorMessage","invalid user id or password");
			request.setAttribute("erroList",erroList);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);	
			
			
			
		}
		
		
		
		
	}

}
