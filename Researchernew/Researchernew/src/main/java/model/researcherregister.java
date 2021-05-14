
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class researcherregister {

	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reseacher", "root", "Root@123");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
	
	public String insertreseacher(String fname, String lname, String phone, String bdate, String email, String inoctgry, String country, String edustate, String password, String cpasswored)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " insert into rdetails(`rid`,`fname`,`lname`,`phone`,`bdate`,`email`,`inoctgry`,`country`,`edustate`,`password`,`cpasswored`)"
	 + " values (?, ?, ?, ?, ?,?,?,?,?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, fname);
	 preparedStmt.setString(3, lname);
	 preparedStmt.setString(4, phone);
	 preparedStmt.setString(5, bdate);
	 preparedStmt.setString(6, email);
	 preparedStmt.setString(7, inoctgry);
	 preparedStmt.setString(8, country);
	 preparedStmt.setString(9, edustate);
	 preparedStmt.setString(10, password);
	 preparedStmt.setString(11, cpasswored);
	// execute the statement
	
	 preparedStmt.execute();
	 con.close();
	 String newItems = readResercher();
	 output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
	 }
	 catch (Exception e)
	 {

		 output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}";
		 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	
	public String readResercher()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }

	 /*output = "<table border='1'><tr><th>First Name</th>" +"<th>Last Name</th>" +"<th>Contact Nunmber</th>" +"<th>Date Of Birth</th><th>Email</th>"+"<th>Inovation Catogery</th>"+"<th>Country</th>"+"<th>Education Status</th>"+"<th>Password</th>"+"<th>Confirm Password</th></tr>";

	 String query = "select * from rdetails";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String rid = Integer.toString(rs.getInt("rid"));
	 String fname = rs.getString("fname");
	 String lname = rs.getString("lname");
	 String phone = rs.getString("phone");
	 String bdate = rs.getString("bdate");
	 String email = rs.getString("email");
	 String inoctgry = rs.getString("inoctgry");
	 String country = rs.getString("country");
	 String edustate = rs.getString("edustate");
	 String password = rs.getString("password");
	 String cpasswored = rs.getString("cpasswored");
	 // Add into the html table
	 
	 
	 output += "<tr><td><input id='hidridUpdate' name='hidridUpdate'type='hidden' value='" + rid
				+ "'>" + fname + "</td>";
	 //output += "<tr><td>" + rid + "</td>";
	 //output += "<td>" + fname + "</td>";
	 output += "<td>" + lname + "</td>";
	 output += "<td>" + phone + "</td>";
	 output += "<td>" + bdate + "</td>";
	 output += "<td>" + email + "</td>";
	 output += "<td>" + inoctgry + "</td>";
	 output += "<td>" + country + "</td>";
	 output += "<td>" + edustate + "</td>";
	 output += "<td>" + password + "</td>";
	 output += "<td>" + cpasswored + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' "+ "class='btnUpdate btn btn-secondary' data-ridd='" + rid + "'></td>"

	 + "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-ridd='" + rid + "'>" +"</td>";
	
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";*/
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	
	public String updateResercher(String ridd,String fname, String lname, String phone, String bdate, String email, String inoctgry, String country, String edustate, String password, String cpasswored)
	
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE rdetails SET fname=?,lname=?,phone=?,bdate=?,email=?,inoctgry=?,country=?,edustate=?,password=?,cpasswored=? WHERE rid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, fname);
	 preparedStmt.setString(2, lname);
	 preparedStmt.setString(3,phone);
	 preparedStmt.setString(4, bdate);
	 preparedStmt.setString(5, email);
	 preparedStmt.setString(6,inoctgry);
	 preparedStmt.setString(7, country);
	 preparedStmt.setString(8, edustate);
	 preparedStmt.setString(9, password);
	 preparedStmt.setString(10,cpasswored);
	 preparedStmt.setInt(11, Integer.parseInt(ridd));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newItems = readResercher();
	 output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}"; 
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
		 	System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	
	
	
	
	
	
	
	
	
	public String deleteResercher(String rid)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from rdetails where rid=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(rid));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 String newItems = readResercher();
	 output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
	 }
	 catch (Exception e)
	 {
		 output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
		 System.err.println(e.getMessage());
	 }
	 return output;
	 }
}
