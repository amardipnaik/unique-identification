<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th , td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
<body>
<br>
<h2><b>Goverment Agent Portal For User Verification</b></h2>
<table>
<th>Sr.No</th>
<th>User Name</th>
<th>First Name</th>
<th>Middle Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Phone Number</th>
<th>Blood Group</th>
<th>Date Of Birth</th>
<th>Adhar Number</th>
<th>PAN Number</th>
<th>Driving Licence</th>
<th>Passport Number</th>
<th>Ration Card</th>
<th>Passport Expire Date</th>
<th>Street</th>
<th>city</th>
<th>state</th>
<th>Verify User</th>
  <tr ng-repeat="x in userList">
     <td>{{ $index + 1 }}</td>
    <td>{{ x.login }}</td>
    <td>{{ x.firstName}}</td>
     <td>{{ x.middleName}}</td>
     <td>{{ x.lastName}}</td>
     <td>{{ x.email}}</td>
     <td>{{ x.contactNumber}}</td>
      <td>{{ x.bloodGroup}}</td>
       <td>{{ x.dateOfBirth}}</td>
       <td>{{ x.adharNumber}}</td>
       <td>{{ x.panNumber}}</td>
        <td>{{ x.drivingLicence}}</td>
         <td>{{ x.passportNumber}}</td>
         <td>{{ x.rationCard}}</td>
           <td>{{ x.passportExpireDate}}</td>
         <td>{{ x.street}}</td>
          <td>{{ x.city}}</td>
            <td>{{ x.state}}</td>
      
       
         <td> <button ng-click="resetPassword(x.id)">Verify User</button></td>
      
     
  </tr>
</table>
</body>
</html>