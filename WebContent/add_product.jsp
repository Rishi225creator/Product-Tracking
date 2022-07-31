<%@page import="sis.com.producttracking.bo.Category"%>
<%@page import="sis.com.producttracking.bo.Brand"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">

<%
List<Brand>brandList =null;
List<Category>catList = null;
List<String>erroList =null;

brandList =(List<Brand>) request.getAttribute("brandList");
catList =(List<Category>) request.getAttribute("catList");
erroList = (List<String>)request.getAttribute("erroList");




%>

 
<fieldset style="width:40%;border: 5px double red; margin-left: 15px;"> 
<legend style="font-size: 50px;">
	Create New Product
</legend>
<center>
<form action="addproduct" method="post">
 <table>
   
   </tr>
   <!--    <tr>
    <td>ID</td>
    <td><input type="text" style="width:200px;" autofocus="autofocus" required="required"></td>
   </tr> -->
   </tr>
      <tr>
    <td>Name</td>
    <td><input type="text"  name="product_name" style="width:200px;"  required="required"></td>
   </tr>
     <tr>
    <td>price</td>
    <td><input type="text" name="product_price" style="width:200px;"  required="required"></td>
   </tr>
   
        <tr>
    <td>Brand Name</td>
    <td> 
	  <select name="product_brand_id"> 
	    <%for(Brand brand:brandList){ %>
	     <option value="<%=brand.getId()%>"><%=brand.getName() %></option>
	     <%} %>
	  </select>
	
	</td>
   </tr>
       <tr>
    <td>Category name</td>
    <td>
	  <select name="product_cat_id"> 
	    <%for(Category cat:catList){ %>
	     <option value="<%=cat.getId()%>"><%=cat.getName() %></option>
	     <%}%>
	  </select>
	
	</td>
   </tr>
      <tr>
    <td>Details</td>
    <td><textarea  name="product_details" rows="" cols="" style="width:200px;"  required="required"></textarea> </td>
   </tr>
      <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Add product"
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
