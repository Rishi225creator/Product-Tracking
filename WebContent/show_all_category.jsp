<%@page import="sis.com.producttracking.bo.Category"%>
<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
<%

List<Category>catList =null;
List<String>erroList =null;

catList =(List<Category>) request.getAttribute("catlist");
erroList = (List<String>)request.getAttribute("erroList");


%>



 
<table border="1" width="100%"  id="course_table_1" class="view_table">
  <caption><span style="font-size:60px;">All(<%=catList.size() %>) Category Details </span></caption>
 <tr>
  <th>Id</th>
  <th> Name</th>
  <th>Details</th>
  
  <th>Action</th>
 </tr>
 
 <%for(Category cat : catList){ %>
 
  <tr>
   <td><%=cat.getId() %></td>
   <td><%=cat.getName() %></td>
   <td><%=cat.getDetails() %></td>
  <td>
    <a href="updatecategory?id=<%=cat.getId()%>">Update</a> &nbsp;
    <a href="deletecategory?id=<%=cat.getId()%>">Delete</a> &nbsp;
  </td>
 </tr>
 <%} %>
  
 
</table>
</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
