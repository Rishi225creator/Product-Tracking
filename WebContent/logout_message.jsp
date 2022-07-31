<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
 <%
 
String sessionMessage = (String)request.getAttribute("sessionMessage");
 %>
 <fieldset><legend>Logout Message</legend>
 <h1><%=sessionMessage %></h1>
 </fieldset>
 
</div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
