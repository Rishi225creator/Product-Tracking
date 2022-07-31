<%@page import="sis.com.producttracking.bo.Category"%>
<%@page import="sis.com.producttracking.bo.Brand"%>
<%@page import="java.util.Map"%>
<%@page import="sis.com.producttracking.bo.Product"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
<%

List<Product>productList =null;
List<String>erroList =null;

productList =(List<Product>) request.getAttribute("productList");
erroList = (List<String>)request.getAttribute("erroList");

Map<Long,Brand>brandMap  = (Map<Long,Brand>)request.getAttribute("brandMap"); 
Map<Long,Category>catMap  =(Map<Long,Category>)request.getAttribute("catMap");

%>
<%-- <%= productList%><br>
<%= brandMap%><br>
<%= catMap%><br> --%>
<%if(erroList.size()>0){ %>
 <fieldset style="color:red;"><legend>ERROR LIST</legend>
   <%=erroList   %>
 </fieldset>
 <%} %>
 
 
 <fieldset style="border: 5px red double; "><legend>Product Search</legend>
 
  <form action="searchproduct" method="get">
  <span style="font-size: 30px;">
  Product Name  
  <input type="text"  name="product_search_name_text" style="font-size: 30px;"
   autofocus="autofocus" placeholder="Enter Product Name for search"
   size="40" >
   
   <input type="submit" value="Search Product" style="font-size: 30px;">
  </span>
  </form>
 
 <%if(request.getAttribute("lastProductSearchText")!=null){ %>
<span style="font-size: 30px;">
 Last Product search name text was 
 <span style="color:green;">"<%=request.getAttribute("lastProductSearchText") %>"</span>
 </span>
 <%} %>
 
 
 </fieldset>
 
 
 
<table border="1" width="100%"  id="course_table_1" class="view_table">
  <caption><span style="font-size:60px;">Products Details
   <%=productList.size() %>
  </span></caption>
 <tr>
  <th>Id</th>
  <th> Name</th>
  <th>price</th>
  <th>brand_ID</th>
  <th>category Id</th>
  <th>details</th>
  <th>Action</th>
 </tr>
 
 <%for(Product product: productList){
	 
	 Long brandId  = product.getBrand().getId();
	 Long catId  = product.getCategory().getId();
	 Brand brand  = brandMap.get(brandId);
	 Category category  = catMap.get(catId);
	 
	 %>
 
  <tr>
   <td><%=product.getId() %></td>
   <td><%=product.getName() %></td>
   <td><%=product.getPrice() %></td>
   <td><%-- <%=brandId %> --%>  <%=brand.getName() %></td>
   <td><%-- <%=catId %> --%> <%=category.getName() %></td>
   <td><%=product.getDetails()%></td>
  
  <td>
    <a href="updatepro?id=<%=product.getId()%>">update</a> &nbsp;
    <a href="deleteproduct?id=<%=product.getId()%>">Delete</a> &nbsp;
  </td>
 </tr>
  <%} %> 
  
</table>
 

</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
