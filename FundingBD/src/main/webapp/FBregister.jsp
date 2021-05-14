<%@page import="model.FBregister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Funding Body Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/FBregister.js"></script>
</head>
<body>
		<div class="container"><div class="row"><div class="col-6">
		<h1>Funding Body Management </h1>
		<form id="formfunding" name="formfunding">
		
 		First Name:
 		<input id="fname" name="fname" type="text"class="form-control form-control-sm">
 		<br> Country:
 		<input id="fcountry" name="fcountry" type="text"class="form-control form-control-sm">
 		<br> Years:
 		<input id="fyears" name="fyears" type="text"class="form-control form-control-sm">
 		<br> Category:
 		<input id="fcategory" name="fcategory" type="text"class="form-control form-control-sm">
 		<br>
 		Requirements:
 		<input id="frequirements" name="frequirements" type="text"class="form-control form-control-sm">
 	
 		
 	
		
		<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
 		<input type="hidden" id="hidfidSave"name="hidfidSave" value="">
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		
		<div id="divItemsGrid">
		
		 <%
		   
		 FBregister itemObj = new FBregister();
 			
 			out.print(itemObj.readfd());
 		%>
</div>
</div> </div> </div>
</body>
</html>