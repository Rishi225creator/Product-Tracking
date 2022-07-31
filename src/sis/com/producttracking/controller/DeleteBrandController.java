package sis.com.producttracking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet("/deletebrand")
public class DeleteBrandController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		//show
		//get id 
		//perform delete  from db by id
		//show message	
		String idStr = request.getParameter("id");
		Long id  = Long.parseLong(idStr);

				
	  //delete from spc_category where id=123
				
		        boolean isDeletedBrand=false;  
		//TODO
				List<String>erroList  = new ArrayList<String>();
				Connection con =null;
				PreparedStatement pstmt  = null;
				
				try {
					con  = SisDatabaseConnectionUtil.getConnection();
					String sql=" delete from spc_brand where id=?";
					pstmt  = con.prepareStatement(sql);
					pstmt.setLong(1, id);
					
					int r = pstmt.executeUpdate();
					if(r==1){
						//added successfully
						isDeletedBrand=true;
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
				
				
				//if detete  success
				//else delete fails
			
			request.setAttribute("erroList",erroList);
			request.setAttribute("isDeletedBrand",isDeletedBrand);
			RequestDispatcher rd = request.getRequestDispatcher("delete_brand_message.jsp");
			rd.forward(request, response);
					
	}

	 
}
