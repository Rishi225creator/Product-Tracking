<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
 <%
 
 List<String>erroList =null;
 erroList = (List<String>)request.getAttribute("erroList");
 boolean isDeletedBrand   = (Boolean)request.getAttribute("isDeletedBrand");
 
 %>
 <fieldset><legend>Message</legend>
 Brand Deleted <%=isDeletedBrand?"Successfuly":" failed" %>
 </fieldset>
 
 <%if(erroList.size()>0){ %>
 <fieldset style="color:red;"><legend>ERROR LIST</legend>
   <%=erroList   %>
 </fieldset>
 <%} %>
 
</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
