<%@page import="java.util.List"%>
<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">

<%

%>

 
<fieldset style="width:40%;border: 5px double red; margin-left: 15px;"> 
<legend style="font-size: 50px;">
	Add New User
</legend>
<center>
<form action="adduser" method="post">
 <table>
   
      <tr>
    <td>Name</td>
    <td><input type="text"  name="user_name" style="width:200px;"  required="required"></td>
   </tr>
     <tr>
    <td>DOB</td>
    <td><input type="date" name="user_dob" style="width:200px;"  required="required"></td>
   </tr>
   
        <tr>
    <td>login_id</td>
    <td><input type="text" name="user_login_id" style="width:200px;"  required="required"></td>
	</td>
   </tr>
    <tr>
    <td>Password</td>
    <td><input type="password" name="user_login_password" style="width:200px;"  required="required"></td>
	</td>
   </tr>
   
    <tr>
    <td>User TYpe</td>
    <td>
     <select name="user_type">
      <option value="super admin">SUPER ADMIN</option>
      <option value="admin">ADMIN</option>
      <option value="employee">EMPLOYEE</option>
     </select>
    </td>
   </tr>
    <tr>
    <td>mobile</td>
    <td><input type="text" name="user_mobile" style="width:200px;"  required="required"></td>
	</td>
   </tr>
   
    <tr>
    <td>Email</td>
    <td><input type="text" name="user_email_" style="width:200px;"  required="required"></td>
	</td>
   </tr>
   
     
   
   
     
      <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Add User"
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
