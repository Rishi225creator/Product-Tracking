<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">
 
 
 <%
 List<String>erroList =null;
 erroList = (List<String>)request.getAttribute("erroList");
 
 %>
 
 
 <fieldset style="width:300px"> 
<legend >
	User Login
</legend>

<%if(request.getAttribute("loginErrorMessage")!=null){ %>
 <fieldset style="">
  <h1 style="color:red;" ><%=request.getAttribute("loginErrorMessage") %></h1>
 </fieldset> 
<%} %>
<%if(erroList!=null  && erroList.isEmpty()==false){ %>
 <fieldset style="">
  <h1 style="color:red;" ><%=erroList %></h1>
 </fieldset> 
<%} %>
 
<form action="login" method="post">
 <table>
   <tr>
    <td>Login Id</td>
    <td><input type="text" name="login_id" style="width:200px;" autofocus="autofocus" required="required"></td>
   </tr>
   <tr>
    <td>Login password</td>
    <td><input type="password" name="login_password" style="width:200px;" required="required"></td>
   </tr>
     
   <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Login"
     style="width:150px;height: 50px;font-size: 20px;"
    ></td>
   </tr>
      <tr>
    <td></td>
    <td></td>
   </tr>
   
   
 </table>

</form>
 </fieldset>
 
 
 
 
 </div>
<!-- body end -->

<%@include file="sis_footer.jsp" %>
