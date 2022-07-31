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
@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get all brand  from db
		//get all category  from db
		//send to form
 
		List<Category>catList  = new ArrayList<Category>();
		List<Brand>brandList  = new ArrayList<Brand>();
		
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
			
			
			
			String sql2="select * from spc_brand";
			pstmt  = con.prepareStatement(sql2);
			ResultSet brandResultSet  = pstmt.executeQuery();
			while(brandResultSet.next()){
				long id  =brandResultSet.getLong("id");
				String name =brandResultSet.getString("name");
				String details =brandResultSet.getString("details");
				Brand brand  = new Brand(id, name, details);
				brandList.add(brand);
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
		
		
		
		
		//send data to form
		
		request.setAttribute("brandList", brandList);
		request.setAttribute("catList", catList);
		request.setAttribute("erroList", erroList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("add_product.jsp");
		rd.forward(request, response);
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get product new data
		String  productName= request.getParameter("product_name");
		String  productDetails= request.getParameter("product_details");
		
		String priceStr = request.getParameter("product_price");
		String  productBrandIdStr= request.getParameter("product_brand_id");
		String  productCategoryIdStr= request.getParameter("product_cat_id");
 
		float price  = Float.parseFloat(priceStr);
		Long proBrandId  = Long.parseLong(productBrandIdStr);
		Long proCatId  = Long.parseLong(productCategoryIdStr);
		
		
		
	//insert into db
	//show message	
		
		
		//add into db 
		
        boolean isAddedProduct=false;  
//TODO
		List<String>erroList  = new ArrayList<String>();
		Connection con =null;
		PreparedStatement pstmt  = null;
		 
		// insert into spc_product(id,name,price,details,brand_id,category_id)
		//values(spc_product_seq.nextval,'product5',700,'details...',6002,5004)
		try {
			con  = SisDatabaseConnectionUtil.getConnection();
			String sql="insert into spc_product"
					+ "(id,name,price,details,brand_id,category_id)"
					+ "values(spc_product_seq.nextval,?,?,?,?,?)";
			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1, productName);
			pstmt.setFloat(2, price);
			pstmt.setString(3, productDetails);
			pstmt.setLong(4, proBrandId);
			pstmt.setLong(5, proCatId);
			int r = pstmt.executeUpdate();
			if(r==1){
				//added successfully
				isAddedProduct=true;
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
	request.setAttribute("isAddedProduct",isAddedProduct);
	RequestDispatcher rd = request.getRequestDispatcher("add_product_message.jsp");
	rd.forward(request, response);
		
		
	
	}
}
