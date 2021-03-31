<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <jsp:include page="/views/include/Meta.jsp"></jsp:include>
<jsp:include page="/views/include/Imports.jsp"></jsp:include> --%>
<script>



function register()
{

	
	var form = document.loginform;

	
	 var login = form.login.value;
	 
	
	 
	var password = form.pwd.value;
	
	
	
	var fname = form.fname.value;
	var lname = form.lname.value;
	var cn = form.cn.value;
	var em = form.em.value;
	
	if(login=="")
	{
	alert("Please Enter Login !!!")
	return
	}
	
	if(fname=="")
	{
	alert("Please Enter First Name !!!")
	return
	}
	
	if(fname=="")
	{
	alert("Please Enter Last Name !!!")
	return
	}
	
	if(password=="")
	{
	alert("Please Enter Password !!!")
	return
	}

	
	if(cn=="")
	{
	alert("Please Enter Contact Number !!!")
	return
	}
	
	if(em=="")
	{
	alert("Please Enter Email !!!")
	return
	}
	



	form.action = "<%=request.getContextPath()%>/registerUpdate";
	form.method = "post";
	form.submit();


}


</script>

</head>




<body>
<br>

  <h2><b>Modify User Details</b></h2>
  <br>
<h4><b>Note: After modification please contact Goverment agent for verification , without verification you will not able to login consumer portal.</b></h4>
 <br>
<form  name="loginform">





<table align="left">
  
  <tr>
    <th> <label><b>User Name</b></label></th>
   <td> <input type="text" value={{user.login}} name="login" id="login" required/></td>
  <th><label><b>Password </b></label></th>
     <td>   <input type="text" value={{user.password}} name="pwd" id="pwd" required/></td>
     <th><label><b>Email </b></label></th>
     <td> <input type="text" value={{user.email}} name="em" id="em"/></td>
      <td>   <input type="hidden" value={{user.id}} name="id" id="id"/></td>
       <td>   <input type="hidden" value={{user.wallet}} name="wallet" id="wallet"/></td>
   
  </tr>
  
  
  
    <tr>
    <th> <label><b>First Name</b></label></th>
   <td> <input type="text" value={{user.firstName}} name="fname" id="fname" required/></td>
  <th><label><b>Middle Name </b></label></th>
     <td>   <input type="text" value={{user.middleName}} name="mname" id="mname" required/></td>
     <th><label><b>Last Name </b></label></th>
     <td>   <input type="text" value={{user.lastName}} name="lname" id="lname" required/></td>
  </tr>
  
  
  <tr>
    <th> <label><b>Blood Group</b></label></th>
   <td> <input type="text" value={{user.bloodGroup}} name="bgroup" id="bgroup" required/></td>
  <th><label><b>Phone Number </b></label></th>
     <td>   <input type="text" value={{user.contactNumber}} name="cn" id="cn" required/></td>
     <th><label><b>Date Of Birth</b></label></th>
     <td>   <input type="text" value={{user.dateOfBirth}} name="dbth" id="dbth" required/></td>
  </tr>
  
  
  
  <tr>
    <th> <label><b>Adhar Number</b></label></th>
   <td><input type="text" value={{user.adharNumber}} name="adh" id="adh" required></td>
 <th> <label><b>PAN Number</b></label></th>
   <td><input type="text" value={{user.panNumber}} name="pan" id="pan" required></td>
     <th> <label><b>Driving Licence Number</b></label></th>
   <td><input type="text" value={{user.drivingLicence}} name="dr" id="dr" required></td>
  </tr>
  
 
   


   
   
    <tr>
    <th> <label><b>Passport Number</b></label></th>
   <td><input type="text" value={{user.passportNumber}} name="pn" id="pn" required></td>
    <th><label><b>Ration Card </b></label></th>
     <td>  <input type="text" value={{user.rationCard}} name="rcard" id="rcard" required></td>
      <th><label><b>Passport Expire Date </b></label></th>
     <td>  <input type="text" value={{user.passportExpireDate}} name="pexp" id="pexp" required></td>
  </tr>
 
 
      <tr>
    <th> <label><b>Street</b></label></th>
   <td><input type="text" value={{user.street}} name="street" id="street" required></td>
    <th><label><b>City </b></label></th>
     <td>  <input type="text" value={{user.city}} name="ct" id="ct" required></td>
      <th><label><b>State </b></label></th>
     <td>  <input type="text" value={{user.state}} name="state" id="state" required></td>
  </tr>
   
   
    <tr>
    
    <td> </td>
     <td>   <button onclick="register()">Modify User Details</button></td>
  </tr>
  
   
   
  
  
  
 
 </table>





  
</form>






</body>



</html>