package sis.com.producttracking.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet("/searchproduct")
public class ProductSearchController extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String  productSearchNameText= request.getParameter("product_search_name_text");
		
		
		List<Product>searchProductList  = new ArrayList<Product>();
		List<String>erroList  = new ArrayList<String>();
		//get list of cat from db
		
		
		Map<Long,Brand>brandMap  = new LinkedHashMap<Long,Brand>();
		Map<Long,Category>catMap  = new LinkedHashMap<Long,Category>();
		
		
		//TODO
		Connection con =null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		
		try {
			con  = SisDatabaseConnectionUtil.getConnection();
			String sql="select * from spc_product "
					+ " where  lower(name) like lower('%"+productSearchNameText+"%')";
			pstmt  = con.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			while(rs.next()){
				long prodId  =rs.getLong("id");
				long catId  =rs.getLong("CATEGORY_ID");
				long brandId  =rs.getLong("BRAND_ID");
				float productPrice =rs.getFloat("PRICE");
				String name =rs.getString("name");
				String details =rs.getString("details");
				
				
				Product product = new Product();
				product.setId(prodId);
				product.setName(name);
				product.setPrice(productPrice);
				product.setDetails(details);
				product.setBrand(new Brand(brandId));
				product.setCategory(new Category(catId));
				searchProductList.add(product);
			}
			
			
			
			//all brand
			//all cat
			
			String sqlCat="select * from spc_category";
			pstmt  = con.prepareStatement(sqlCat);
			rs  = pstmt.executeQuery();
			while(rs.next()){
				long id  =rs.getLong("id");
				String name =rs.getString("name");
				String details =rs.getString("details");
				Category cat  = new Category(id, name, details);
				//add into map
				catMap.put(id, cat);
			}
			
			
			
			String sqlBrabd="select * from spc_brand";
			pstmt  = con.prepareStatement(sqlBrabd);
			ResultSet brandResultSet  = pstmt.executeQuery();
			while(brandResultSet.next()){
				long id  =brandResultSet.getLong("id");
				String name =brandResultSet.getString("name");
				String details =brandResultSet.getString("details");
				Brand brand  = new Brand(id, name, details);
				brandMap.put(id, brand);
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
		request.setAttribute("lastProductSearchText", productSearchNameText);
		request.setAttribute("productList", searchProductList);
		request.setAttribute("brandMap", brandMap);
		request.setAttribute("catMap", catMap);
		request.setAttribute("erroList", erroList);
		RequestDispatcher rd = request.getRequestDispatcher("show_all_products.jsp");
		rd.forward(request, response);
		
		
	
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
