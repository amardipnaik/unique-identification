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
<h2><b>E-Bill Payment </b></h2>

<table align="left">
  
  <tr>
    <th> <label><b>E-bill Holder Name</b></label></th>
   <td> <input type="text" placeholder="E-bill Holder Name"  required/></td>
  
    
  </tr>
  
  <tr>
  <th><label><b>E-bill  Number </b></label></th>
     <td>   <input type="text" placeholder="E-bill  Number " required/></td>
</tr>
  
<tr>
 <th><label><b>E-bill Date </b></label></th>
     <td> <input type="text" placeholder="E-bill Date" required/></td>
   </tr>
   
   <tr>
 <th><label><b>Amount </b></label></th>
     <td> <input type="text" placeholder="Amount" name="amt" id="amt" required/></td>
   </tr>
   
    <tr>
    
   <th><label><b>Pay Bill </b></label></th>
     <td>   <button ng-click="subMoney()">Pay Bill</button></td>
  </tr>

 </table>
</body>
</html>