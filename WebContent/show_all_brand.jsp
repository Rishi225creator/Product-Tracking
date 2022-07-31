<%@page import="sis.com.producttracking.bo.Brand"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">


<%

List<Brand>brandList =null;
List<String>erroList =null;

brandList =(List<Brand>) request.getAttribute("brandList");
erroList = (List<String>)request.getAttribute("erroList");


%>



 
<table border="1" width="100%"  id="course_table_1" class="view_table">
  <caption><span style="font-size:60px;">All(<%=brandList.size() %>) Brands Details </span></caption>
 <tr>
  <th>Id</th>
  <th> Name</th>
  <th>Details</th>
  
  <th>Action</th>
 </tr>
 
 <%for(Brand brand : brandList){ %>
 
  <tr>
   <td><%=brand.getId() %></td>
   <td><%=brand.getName() %></td>
   <td><%=brand.getDetails() %></td>
  <td>
    <a href="updatebrand?id=<%=brand.getId()%>">Update</a> &nbsp;
    <a href="deletebrand?id=<%=brand.getId()%>">Delete</a> &nbsp;
  </td>
 </tr>
 <%} %>
  
 
</table>

</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
