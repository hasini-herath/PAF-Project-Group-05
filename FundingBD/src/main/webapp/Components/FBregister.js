

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
var type = ($("#hidfidSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "FundingAPI",
 type : type,
 data : $("#formfunding").serialize(),
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
 				     document.location = "fundinglogging.jsp";
 
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

 		$("#hidfidSave").val("");
 		$("#formfunding")[0].reset();
}


$(document).on("click", ".btnUpdate", function(event)
{
$("#hidfidSave").val($(this).data("fidd"));
 //$("#itemID").val($(this).closest("tr").find('td:eq(0)').text());
 $("#fname").val($(this).closest("tr").find('td:eq(0)').text());
 $("#fcountry").val($(this).closest("tr").find('td:eq(1)').text());
 $("#fyears").val($(this).closest("tr").find('td:eq(2)').text());
 $("#fcategory").val($(this).closest("tr").find('td:eq(3)').text());
 $("#frequirements").val($(this).closest("tr").find('td:eq(4)').text());

});


$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "FundingAPI",
 type : "DELETE",
 data : "fid=" + $(this).data("fidd"),
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
// Name
if ($("#fname").val().trim() == "")
 {
 return "Insert Name";
 }
// Country
if ($("#fcountry").val().trim() == "")
 {
 return "Insert Country";
 }
// Years--------------------
if ($("#fyears").val().trim() == "")
 {
 return "Insert Years";
 }

// Category-----------------------
if ($("#fcategory").val().trim() == "")
 {
 return "Insert Category";
 }
// Requirements
if ($("#frequirements").val().trim() == "")
 {
 return "Insert Requirements";
 }

return true;
}

