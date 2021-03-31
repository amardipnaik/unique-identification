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
<h2><b>NEFT Money Transfer </b></h2>

<table align="left">
  
  <tr>
    <th> <label><b>beneficiary Name</b></label></th>
   <td> <input type="text" placeholder="beneficiary Name"  required/></td>
  
    
  </tr>
  
  <tr>
  <th><label><b>beneficiary Account Number </b></label></th>
     <td>   <input type="text" placeholder="beneficiary Account Number" required/></td>
</tr>
  
<tr>
 <th><label><b>beneficiary IFSC Code </b></label></th>
     <td> <input type="text" placeholder="beneficiary IFSC Code " required/></td>
   </tr>
   
   <tr>
 <th><label><b>Amount </b></label></th>
     <td> <input type="text" placeholder="Amount" name="amt" id="amt" required/></td>
   </tr>
   
    <tr>
    
   <th><label><b>Send Money </b></label></th>
     <td>   <button ng-click="subMoney()">Send Money</button></td>
  </tr>

 </table>
</body>
</html>