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
import sis.com.producttracking.bo.Product;
import sis.com.producttracking.util.db.SisDatabaseConnectionUtil;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/updatepro")
public class UpdateProductController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get id
		String idStr = request.getParameter("id");
		Long productId  = Long.parseLong(idStr);
		
		
	//get all product detail by id
	//send to form and show it for update
		
		List<Category>catList  = new ArrayList<Category>();
		List<Brand>brandList  = new ArrayList<Brand>();
		
		List<String>errorList  = new ArrayList<String>();
		//get list of cat from db
		Product editProduct = null;
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
				long catId  =rs.getLong("id");
				String name =rs.getString("name");
				String details =rs.getString("details");
				
				Category cat  = new Category(catId, name, details);
				catList.add(cat);
			}
			
			
			
			String sql2="select * from spc_brand";
			pstmt  = con.prepareStatement(sql2);
			ResultSet brandResultSet  = pstmt.executeQuery();
			while(brandResultSet.next()){
				long brandID  =brandResultSet.getLong("id");
				String name =brandResultSet.getString("name");
				String details =brandResultSet.getString("details");
				Brand brand  = new Brand(brandID, name, details);
				brandList.add(brand);
			}
			
			
			
	 		String sqlProduct="select * from  spc_product where id=?";
			pstmt  = con.prepareStatement(sqlProduct);
			pstmt.setLong(1, productId);
			ResultSet rs3  = pstmt.executeQuery();
			if(rs3.next()){
				long prodId  =rs3.getLong("id");
				long catId  =rs3.getLong("CATEGORY_ID");
				long brandId  =rs3.getLong("BRAND_ID");
				float productPrice =rs3.getFloat("PRICE");
				String name =rs3.getString("name");
				String details =rs3.getString("details");
				
				  editProduct = new Product();
				  editProduct.setId(prodId);
				  editProduct.setName(name);
				  editProduct.setPrice(productPrice);
				  editProduct.setDetails(details);
				  editProduct.setBrand(new Brand(brandId));
				  editProduct.setCategory(new Category(catId));
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			errorList.add("DB ERROR : "+e.getMessage());
		} catch (Exception e) {
			errorList.add("Other ERROR : "+e.getMessage());
		}finally {
			try {
				SisDatabaseConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				errorList.add("DB Close ERROR : "+e.getMessage());
		      
			}
		}
		
		
		
		
		//send data to form
		
		request.setAttribute("brandList", brandList);
		request.setAttribute("catList", catList);
		request.setAttribute("errorList", errorList);
		request.setAttribute("editProduct", editProduct);
		
		RequestDispatcher rd = request.getRequestDispatcher("update_product.jsp");
		rd.forward(request, response);	
		
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   //get all data
	//insert into db
	//show message	
		
			String idStr = request.getParameter("product_id");
		
				String  productName= request.getParameter("product_name");
				String  productDetails= request.getParameter("product_details");
				
				String priceStr = request.getParameter("product_price");
				String  productBrandIdStr= request.getParameter("product_brand_id");
				String  productCategoryIdStr= request.getParameter("product_cat_id");
		 
				Long productId  = Long.parseLong(idStr);
				float price  = Float.parseFloat(priceStr);
				Long proBrandId  = Long.parseLong(productBrandIdStr);
				Long proCatId  = Long.parseLong(productCategoryIdStr);
				
		//db insert
				
		
				
				//insert into db
				//show message	
					
					
					//add into db 
					
			        boolean isUpdatedProduct=false;  
			//TODO
					List<String>erroList  = new ArrayList<String>();
					Connection con =null;
					PreparedStatement pstmt  = null;
					 
					try {
						con  = SisDatabaseConnectionUtil.getConnection();
						String sql="update  spc_product"
								+ " set name=?,price=?,details=?,brand_id=?,category_id=?"
								+ " where id=?";
						pstmt  = con.prepareStatement(sql);
						pstmt.setString(1, productName);
						pstmt.setFloat(2, price);
						pstmt.setString(3, productDetails);
						pstmt.setLong(4, proBrandId);
						pstmt.setLong(5, proCatId);
						pstmt.setLong(6, productId);
						int r = pstmt.executeUpdate();
						if(r==1){
							//added successfully
							isUpdatedProduct=true;
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
				request.setAttribute("isUpdatedProduct",isUpdatedProduct);
				RequestDispatcher rd = request.getRequestDispatcher("update_product_message.jsp");
				rd.forward(request, response);
					
	
	}

}
