<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<h2><b>Add Money To Wallet </b></h2>

<table align="left">
  
  <tr>
    <th> <label><b>Account Holder Name</b></label></th>
   <td> <input type="text" placeholder="Account Holder Name"  required/></td>
  
    
  </tr>
  
  <tr>
  <th><label><b>Account Number </b></label></th>
     <td>   <input type="text" placeholder="Account Number" required/></td>
</tr>
  
<tr>
 <th><label><b>IFSC Code </b></label></th>
     <td> <input type="text" placeholder="IFSC Code" required/></td>
   </tr>
   
   <tr>
 <th><label><b>Amount </b></label></th>
     <td> <input type="text" placeholder="Amount" name="amt" id="amt" required/></td>
   </tr>
   
    <tr>
    
   <th><label><b>Add Money </b></label></th>
     <td>   <button ng-click="addMoney()">Add Money</button></td>
  </tr>

 </table>


</body>
</html>