<%@page import="sis.com.producttracking.bo.Product"%>
<%@page import="sis.com.producttracking.bo.Brand"%>
<%@page import="sis.com.producttracking.bo.Category"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">


<%

List<Brand>brandList =null;
List<Category>catList = null;
List<String>errorList =null;
Product editProduct  = null;
brandList =(List<Brand>) request.getAttribute("brandList");
catList =(List<Category>) request.getAttribute("catList");
errorList = (List<String>)request.getAttribute("errorList");
editProduct = (Product)request.getAttribute("editProduct");

%>











<fieldset style="width:40%;border: 5px double red; margin-left: 15px;"> 
<legend style="font-size: 50px;">
	Update Old Product
</legend>
<center>
<form action="updatepro" method="post">
 <table>
   
   </tr>
       <tr>
    <td>ID</td>
    <td><input  name="product_id" type="text" readonly="readonly" value="<%=editProduct.getId()%>" style="width:200px;background-color: gray;" autofocus="autofocus" required="required"></td>
   </tr>  
   </tr>
      <tr>
    <td>Name</td>
    <td><input type="text" value="<%=editProduct.getName()%>"   name="product_name" style="width:200px;"  required="required"></td>
   </tr>
     <tr>
    <td>price</td>
    <td><input type="text"value="<%=editProduct.getPrice()%>" name="product_price" style="width:200px;"  required="required"></td>
   </tr>
   
        <tr>
    <td>Brand Name</td>
    <td> 
	  <select name="product_brand_id"> 
	    <%for(Brand brand:brandList){ %>
	     
		     <%if(editProduct.getBrand().getId().equals(brand.getId())){ 
		     %>
		     <option value="<%=brand.getId()%>" selected="selected"><%=brand.getName() %></option>
		     <%}else{
		     %>
		     <option value="<%=brand.getId()%>"><%=brand.getName() %></option>
		     <%}%>
	     <%} %>
	  </select>
	
	</td>
   </tr>
       <tr>
    <td>Category name</td>
    <td>
	  <select name="product_cat_id"> 
	    <%for(Category cat:catList){ %>
	     
	         <%if(editProduct.getCategory().getId().equals(cat.getId())){ 
		     %>
	     		<option value="<%=cat.getId()%>" selected="selected" ><%=cat.getName() %></option>
		     <%}else{
		     %>
	     		<option value="<%=cat.getId()%>"><%=cat.getName() %></option>
		     <%}%>
	     
	     <%}%>
	  </select>
	
	</td>
   </tr>
      <tr>
    <td>Details</td>
    <td><textarea  name="product_details" rows="" cols="" style="width:200px;"  required="required"><%=editProduct.getDetails()%></textarea> </td>
   </tr>
      <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Update product"
     style="width:150px;height: 50px;font-size: 20px;"
    ></td>
   </tr>
      <tr>
    <td></td>
    <td></td>
   </tr>
   
   
 </table>

</form>
</center>

</fieldset>
 
  </center>

</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
