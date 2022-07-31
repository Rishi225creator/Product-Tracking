<!DOCTYPE html>
<%@page import="sis.com.producttracking.bo.User"%>
<html>
<head>
<title>SiS Product Tracking</title>
<link rel="shortcut icon" href="images/sis.ico">
<link rel="stylesheet" href="css/sis.css">
<script type="text/javascript" src="js/sis.js"></script>
<style type="text/css">
 
</style>

</head>
<body>
<!-- header start -->
<div  id="sis_header">
	<!-- sis_header_top start-->
	  <div  id="sis_header_top">
	   
		<!-- sis_header_top_logo start-->
	    <div  id="sis_header_top_logo">
	      <center>
	    <a href="sis_home_main_page.html">
	       <img src="images/sis_logo.png" width="200" height="100">
	      </a> 
	       </center>
	     </div>
		<!-- sis_header_top_logo End-->

		
		<!-- sis_header_top_Project_titile Start-->
	    <div id="sis_header_top_Project_titile">
	    <h1 style="font-size:50px;">
	    <marquee behavior="alternate">
	    <center>&nbsp;&nbsp;&nbsp;SiS Product Tracking &nbsp;&nbsp;&nbsp;</center>
	    </marquee>
	     </h1> 
	     </div>
		<!-- sis_header_top_Project_titile End-->
		
		
		<!-- sis_header_top_login start-->
	    <div  id="sis_header_top_login">
	     <!-- login/logout -->
	      <% 
	      
	      User loginUserObj = null;
	      
	      if( session.getAttribute("user")!=null){
	    	  loginUserObj =(User) session.getAttribute("user");
	      }
	      
	      if(loginUserObj!=null){ %>
	        <%=loginUserObj.getName()%>(<%=loginUserObj.getLoginId() %>) 
		    <br>
	        User Type : <%=loginUserObj.getUserType()%>
			
		    <br>
	       <a href="logout">logout</a>
	      <%}else{ %>
		       <a href="login">Login</a>  
	      <%} %>
	       
	      
	       
	     </div>
		<!-- sis_header_top_login End-->
	  
	  </div>
	<!-- sis_header_top end-->
	<!-- sis_header_bottom start -->
	  <div  id="sis_header_bottom">
	  <!-- Menu -->
	    
	     <%if(loginUserObj!=null){ %>
	        <%if("super admin".equals(loginUserObj.getUserType())){ %>
			  <a href="#">+ user</a>&nbsp;&nbsp;
			  <a href="#">all Users</a>&nbsp;&nbsp;  
	      <%} %>
	     
	 <a href="addcategory">+category</a>&nbsp;&nbsp;
	 <a href="showallcategory">Categories</a>&nbsp;&nbsp;
	 <a href="addbrand">+Brand</a>&nbsp;&nbsp;
	 <a href="showallbrand">Brands</a>&nbsp;&nbsp;
	 <a href="addproduct">+product</a>&nbsp;&nbsp;
	 <a href="showallproduct">products</a>&nbsp;&nbsp;
	     <%}%>
	  <a href="contact.jsp">Contact</a>&nbsp;&nbsp;
	  </div>
	<!-- sis_header_bottom End -->
</div>
<!-- header end -->
