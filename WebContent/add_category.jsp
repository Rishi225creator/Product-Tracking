<%@include file="sis_header.jsp" %>

<!-- body start -->
<div  id="sis_main">



<fieldset style="width:40%;border: 5px double red; margin-left: 15px;"> 
<legend style="font-size: 50px;">
	Create New Category
</legend>
<center>
<form action="addcategory" method="post">
 <table>
   
   </tr>
    <!--   <tr>
    <td>ID</td>
    <td><input type="text" style="width:200px;" autofocus="autofocus" required="required"></td>
   </tr> -->
   </tr>
      <tr>
    <td>Name</td>
    <td><input type="text" name="cat_name" style="width:200px;"  required="required"></td>
   </tr>
 
      <tr>
    <td>Details</td>
    <td><textarea  name="cat_details" rows="" cols="" style="width:200px;"  required="required"></textarea> </td>
   </tr>
      <tr>
    <td></td>
    <td  align="right">
    <input type="submit" value="Add Category"
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
