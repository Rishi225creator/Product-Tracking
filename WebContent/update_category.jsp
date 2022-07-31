<%@page import="sis.com.producttracking.bo.Category"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
 <%
 
 List<String>erroList =null;
 erroList = (List<String>)request.getAttribute("erroList");
 
Category oldCategory  = (Category)request.getAttribute("cat");
 
 %>
 <%if(erroList.size()>0){ %>
 <fieldset style="color:red;"><legend>ERROR LIST</legend>
   <%=erroList%>
 </fieldset>
 <%} %>
 
 
 
 

<fieldset style="width:70%;border: 5px double red; margin-left: 15px;"> 
<legend style="font-size: 50px;">
	Update Category
</legend>
<center>
<form action="updatecategory" method="post">
 <table>
   
   </tr>
       <tr>
    <td>ID</td>
    <td><input type="text" name="cat_id" 
     value ="<%=oldCategory.getId() %>" 
      readonly="readonly"
       style="width:200px;background-color: gray;" autofocus="autofocus" required="required"></td>
   </tr> 
   </tr>
      <tr>
    <td>Name</td>
    <td><input type="text" name="cat_name"  value ="<%=oldCategory.getName() %>"  style="width:200px;"  required="required"></td>
   </tr>
 
      <tr>
    <td>Details</td>
    <td><textarea  name="cat_details" rows="" cols=""  
    style="width:200px;"  required="required"><%=oldCategory.getDetails() %></textarea> </td>
   </tr>
      <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Update Category"
     style="height: 50px;font-size: 20px;"
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
