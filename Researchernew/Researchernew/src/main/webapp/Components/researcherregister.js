

$(document).ready(function()

 {
 $("#alertSuccess").hide();
 
 $("#alertError").hide();
});


// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();


// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }


// If valid------------------------
var type = ($("#hidridSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "researcherAPI",
 type : type,
 data : $("#formresearcher").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onItemSaveComplete(response.responseText, status);
 }
 });
});




function onItemSaveComplete(response, status)
{
		if (status == "success")
 			{
 				var resultSet = JSON.parse(response);
 				if (resultSet.status.trim() == "success")
 				{
					 $("#alertSuccess").text("Successfully saved.");
					 $("#alertSuccess").show();
					 $("#divItemsGrid").html(resultSet.data);
				 // Redirect the valid user-----------------
				     document.location = "researcherlogging.jsp";
 
				} 
				else if (resultSet.status.trim() == "error")
 				{
				 $("#alertError").text(resultSet.data);
 				$("#alertError").show();
 				}
 			} 
		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
		    $("#alertError").show();
 		}
		 else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		} 

 		$("#hidridSave").val("");
 		$("#formresearcher")[0].reset();
}


$(document).on("click", ".btnUpdate", function(event)
{
$("#hidridSave").val($(this).data("ridd"));
 //$("#itemID").val($(this).closest("tr").find('td:eq(0)').text());
 $("#fname").val($(this).closest("tr").find('td:eq(0)').text());
 $("#lname").val($(this).closest("tr").find('td:eq(1)').text());
 $("#phone").val($(this).closest("tr").find('td:eq(2)').text());
 $("#bdate").val($(this).closest("tr").find('td:eq(3)').text());
 $("#email").val($(this).closest("tr").find('td:eq(4)').text());
 $("#inoctgry").val($(this).closest("tr").find('td:eq(5)').text());
 $("#country").val($(this).closest("tr").find('td:eq(6)').text());
 $("#edustate").val($(this).closest("tr").find('td:eq(7)').text());
$("#password").val($(this).closest("tr").find('td:eq(8)').text());
 $("#cpasswored").val($(this).closest("tr").find('td:eq(9)').text());

});


$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "researcherAPI",
 type : "DELETE",
 data : "rid=" + $(this).data("ridd"),
 dataType : "text",
 complete : function(response, status)
 {
 onItemDeleteComplete(response.responseText, status);
 }
 });
});


function onItemDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}



function validateItemForm()
{
// Fname
if ($("#fname").val().trim() == "")
 {
 return "Insert First Name.";
 }
// Lname
if ($("#lname").val().trim() == "")
 {
 return "Insert Last Name.";
 }
// Phone-------------------------------
if ($("#phone").val().trim() == "")
 {
 return "Insert Phone Number";
 }

// BirthDate------------------------
if ($("#bdate").val().trim() == "")
 {
 return "Insert Birthdate";
 }
// Email
if ($("#email").val().trim() == "")
 {
 return "Insert Email";
 }
// Inocatgry
if ($("#inoctgry").val().trim() == "")
 {
 return "Insert Inocatagory";
 }
// Country
if ($("#country").val().trim() == "")
 {
 return "Insert Country";
 }
// Edustate
if ($("#edustate").val().trim() == "")
 {
 return "Insert Education Status";
 }
// Password
if ($("#password").val().trim() == "")
 {
 return "Insert Password";
 }
// Cpassword
if ($("#cpasswored").val().trim() == "")
 {
 return "Insert Confirm Password";
 }
return true;
}

