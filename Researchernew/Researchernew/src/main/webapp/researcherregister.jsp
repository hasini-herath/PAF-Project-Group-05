<%@page import="model.researcherregister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Researcher Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/researcherregister.js"></script>
</head>
<body>
		<div class="container"><div class="row"><div class="col-6">
		<h1>Researcher Management </h1>
		<form id="formresearcher" name="formresearcher">
		
 		First Name:
 		<input id="fname" name="fname" type="text"class="form-control form-control-sm">
 		<br> Last Name:
 		<input id="lname" name="lname" type="text"class="form-control form-control-sm">
 		<br> Phone:
 		<input id="phone" name="phone" type="text"class="form-control form-control-sm">
 		<br> Birth Date:
 		<input id="bdate" name="bdate" type="text"class="form-control form-control-sm">
 		<br>
 		Email:
 		<input id="email" name="email" type="text"class="form-control form-control-sm">
 		<br>	
 		Inovation Category:
 		<input id="inoctgry" name="inoctgry" type="text"class="form-control form-control-sm">
 		<br> Country:
 		<input id="country" name="country" type="text"class="form-control form-control-sm">
 		<br> Education Status:
 		<input id="edustate" name="edustate" type="text"class="form-control form-control-sm">
 		<br> Password:
 		<input id="password" name="password" type="text"class="form-control form-control-sm">
 		<br>
 		Confirm Password:
 		<input id="cpasswored" name="cpasswored" type="text"class="form-control form-control-sm">
 	
 		
 	
 		
 	
		
		<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
 		<input type="hidden" id="hidridSave"name="hidridSave" value="">
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		
		<div id="divItemsGrid">
		
		 <%
		   
		 researcherregister itemObj = new researcherregister();
 			
 			out.print(itemObj.readResercher());
 		%>
</div>
</div> </div> </div>
</body>
</html>