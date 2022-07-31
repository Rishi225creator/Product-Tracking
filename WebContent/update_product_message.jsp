<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
 <%
 
 List<String>erroList =null;
 erroList = (List<String>)request.getAttribute("erroList");
 boolean isUpdatedProduct   = (Boolean)request.getAttribute("isUpdatedProduct");
 
 %>
 <fieldset><legend>Message</legend>
 Product Updated?  <%=isUpdatedProduct?"Successfuly":" failed" %>
 </fieldset>
 
 <%if(erroList.size()>0){ %>
 <fieldset style="color:red;"><legend>ERROR LIST</legend>
   <%=erroList   %>
 </fieldset>
 <%} %>
 
</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
