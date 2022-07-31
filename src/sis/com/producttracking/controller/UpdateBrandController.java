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

import sis.com.producttracking.bo.Brand;
import sis.com.producttracking.bo.Category;
import sis.com.producttracking.util.db.SisDatabaseConnectionUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/updatebrand")
public class UpdateBrandController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get id //fetch info from db and who update form
		//create filled form for update
				String idStr  = request.getParameter("id");
				Long id  = Long.parseLong(idStr);
				
				//get all cat data from db by id
				
				Brand brand  = null;
				
				//select * from spc_category where id=5001;
				
				List<String>erroList  = new ArrayList<String>();
				//get list of cat from db
				
				//TODO
				Connection con =null;
				PreparedStatement pstmt  = null;
				ResultSet rs = null;
				
				try {
					con  = SisDatabaseConnectionUtil.getConnection();
					String sql="select * from spc_Brand where id=?";
					pstmt  = con.prepareStatement(sql);
					pstmt.setLong(1, id);
					rs  = pstmt.executeQuery();
					if(rs.next()){
						String name =rs.getString("name");
						String details =rs.getString("details");
						brand  = new Brand(id, name, details);
						 
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
				
				//
				
				request.setAttribute("brand", brand);
				request.setAttribute("erroList", erroList);
				RequestDispatcher rd = request.getRequestDispatcher("update_brand.jsp");
				rd.forward(request, response);
				
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get all data
	//update info into db by id 	
	
		 //get new updated data
	      //update into db
		  //show message
			String idStr = request.getParameter("brand_id");
			String name = request.getParameter("brand_name");
			String details = request.getParameter("brand_details");
			Long id  = Long.parseLong(idStr);
		   
			// update spc_brand  set name='x',details='y' where id=6001;
		
			
			//add into db 
			
	        boolean isUpdatedBrand=false;  
	//TODO
			List<String>erroList  = new ArrayList<String>();
			Connection con =null;
			PreparedStatement pstmt  = null;
			ResultSet rs = null;
			
			try {
				con  = SisDatabaseConnectionUtil.getConnection();
				String sql="update spc_brand  set name=?,details=? where id=?";
				pstmt  = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, details);
				pstmt.setLong(3, id);
				
				int r = pstmt.executeUpdate();
				if(r==1){
					//added successfully
					isUpdatedBrand=true;
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
			
			
			//if update  success
			//else update fails
		
		request.setAttribute("erroList",erroList);
		request.setAttribute("isUpdatedBrand",isUpdatedBrand);
		RequestDispatcher rd = request.getRequestDispatcher("update_brand_message.jsp");
		rd.forward(request, response);
				
	}

}
