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
	



	form.action = "<%=request.getContextPath()%>/register";
	form.method = "post";
	form.submit();


}


</script>

<title><b>Citizen Card Consumer Application Online</b></title>
<meta name="viewport" content="width=device-width, initial-scale=1">





<style>
form {
    border: 1px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #2b6bacc2;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}


.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

</style>
</head>




<body  background="../images/background-wallpaper-web-images-sky-wallpaperweb-wallpapers.jpg" >
<h1 style="text-align:center;color: #080f17c2;" ><b>Citizen Card Consumer Application Online</b></h1>
      <!--   <hr/> -->


<form  name="loginform">





<table align="left">
  
  <tr>
    <th> <label><b>User Name</b></label></th>
   <td> <input type="text" placeholder="Username" name="login" id="login" required/></td>
  <th><label><b>Password </b></label></th>
     <td>   <input type="password" placeholder="Password" name="pwd" id="pwd" required/></td>
     <th><label><b>Email </b></label></th>
     <td> <input type="text" placeholder="Email" name="em" id="em"/></td>
  </tr>
  
  
  
    <tr>
    <th> <label><b>First Name</b></label></th>
   <td> <input type="text" placeholder="First Name" name="fname" id="fname" required/></td>
  <th><label><b>Middle Name </b></label></th>
     <td>   <input type="text" placeholder="Middle Name" name="mname" id="mname" required/></td>
     <th><label><b>Last Name </b></label></th>
     <td>   <input type="text" placeholder="Last Name" name="lname" id="lname" required/></td>
  </tr>
  
  
  <tr>
    <th> <label><b>Blood Group</b></label></th>
   <td> <input type="text" placeholder="Blood Group" name="bgroup" id="bgroup" required/></td>
  <th><label><b>Phone Number </b></label></th>
     <td>   <input type="text" placeholder="Phone Number" name="cn" id="cn" required/></td>
     <th><label><b>Date Of Birth</b></label></th>
     <td>   <input type="text" placeholder="Date Of Birth" name="dbth" id="dbth" required/></td>
  </tr>
  
  
  
  <tr>
    <th> <label><b>Adhar Number</b></label></th>
   <td><input type="text" placeholder="Adhar Number" name="adh" id="adh" required></td>
 <th> <label><b>PAN Number</b></label></th>
   <td><input type="text" placeholder="PAN Number" name="pan" id="pan" required></td>
     <th> <label><b>Driving Licence Number</b></label></th>
   <td><input type="text" placeholder="Enter Driving Licence" name="dr" id="dr" required></td>
  </tr>
  
 
   


   
   
    <tr>
    <th> <label><b>Passport Number</b></label></th>
   <td><input type="text" placeholder="Enter Passport Number " name="pn" id="pn" required></td>
    <th><label><b>Ration Card </b></label></th>
     <td>  <input type="text" placeholder="Ration Card" name="rcard" id="rcard" required></td>
      <th><label><b>Passport Expire Date </b></label></th>
     <td>  <input type="text" placeholder="Passport Expire Date" name="pexp" id="pexp" required></td>
  </tr>
 
 
      <tr>
    <th> <label><b>Street</b></label></th>
   <td><input type="text" placeholder="Enter Street " name="street" id="street" required></td>
    <th><label><b>City </b></label></th>
     <td>  <input type="text" placeholder="Enter City" name="ct" id="ct" required></td>
      <th><label><b>State </b></label></th>
     <td>  <input type="text" placeholder="Enter State" name="state" id="state" required></td>
  </tr>
   
   
    <tr>
    
    <td> </td>
     <td>   <button onclick="register()">Register User Details</button></td>
  </tr>
  
   
   
  
  
  
 
 </table>





  
</form>






</body>



</html>