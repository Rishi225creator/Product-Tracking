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

import sis.com.producttracking.bo.Category;
import sis.com.producttracking.util.db.SisDatabaseConnectionUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/addcategory")
public class AddCategoryController extends HttpServlet {
	 
	
	//open form 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("add_category.jsp");
		rd.forward(request, response);
	
	}

	 //get data na add into db 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameter send by user
		String name  = request.getParameter("cat_name");
		String details  = request.getParameter("cat_details");
		
		
		//add into db 
		
		        boolean isAddedCategory=false;  
		//TODO
				List<String>erroList  = new ArrayList<String>();
				Connection con =null;
				PreparedStatement pstmt  = null;
				ResultSet rs = null;
				
				try {
					con  = SisDatabaseConnectionUtil.getConnection();
					String sql="insert into spc_category(id,name,details)"
							+ "values(spc_category_seq.nextval,?,?)";
					pstmt  = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, details);
					
					int r = pstmt.executeUpdate();
					if(r==1){
						//added successfully
						isAddedCategory=true;
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
				request.setAttribute("isAddedCategory",isAddedCategory);
				RequestDispatcher rd = request.getRequestDispatcher("add_cat_message.jsp");
				rd.forward(request, response);
					
		
		//show message 
		
		
		
		
		
		
		
	}
}
