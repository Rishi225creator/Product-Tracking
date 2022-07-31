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
@WebServlet("/showallcategory")
public class ShowAllCategoryController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category>catList  = new ArrayList<Category>();
		List<String>erroList  = new ArrayList<String>();
		//get list of cat from db
		
		//TODO
		Connection con =null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		
		try {
			con  = SisDatabaseConnectionUtil.getConnection();
			String sql="select * from spc_category";
			pstmt  = con.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			while(rs.next()){
				long id  =rs.getLong("id");
				String name =rs.getString("name");
				String details =rs.getString("details");
				
				Category cat  = new Category(id, name, details);
				catList.add(cat);
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
		
		
		
		
		
		
		
		
	//send view
		request.setAttribute("catlist", catList);
		request.setAttribute("erroList", erroList);
		RequestDispatcher rd = request.getRequestDispatcher("show_all_category.jsp");
		rd.forward(request, response);
		
		
		
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
