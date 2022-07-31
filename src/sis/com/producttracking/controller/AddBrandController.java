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

import sis.com.producttracking.util.db.SisDatabaseConnectionUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/addbrand")
public class AddBrandController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//show empty form
		
		RequestDispatcher rd = request.getRequestDispatcher("add_brand.jsp");
		rd.forward(request, response);	
	
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//get parameter send by user
				String name  = request.getParameter("brand_name");
				String details  = request.getParameter("brand_details");
				
				
				//add into db 
				
				        boolean isAddedBrand=false;  
				//TODO
						List<String>erroList  = new ArrayList<String>();
						Connection con =null;
						PreparedStatement pstmt  = null;
						ResultSet rs = null;
						
						try {
							con  = SisDatabaseConnectionUtil.getConnection();
							String sql=" insert into spc_brand(id,name,details)"
									+ "values(spc_brand_seq.nextval,?,?)";
							pstmt  = con.prepareStatement(sql);
							pstmt.setString(1, name);
							pstmt.setString(2, details);
							
							int r = pstmt.executeUpdate();
							if(r==1){
								//added successfully
								isAddedBrand=true;
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
						
						
				
				//send info to jsp file view 
						request.setAttribute("erroList",erroList);
						request.setAttribute("isAddedBrand",isAddedBrand);
		RequestDispatcher rd = request.getRequestDispatcher("add_brand_message.jsp");
						rd.forward(request, response);
							
	}

}
