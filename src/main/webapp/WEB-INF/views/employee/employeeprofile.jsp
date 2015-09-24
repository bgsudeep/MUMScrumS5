<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Profile</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}


 /*body {
	width: 600px;
	margin: 40px auto;
	font-family: 'trebuchet MS', 'Lucida sans', Arial;
	font-size: 14px;
	color: #444;
}
*/
table {
	*border-collapse: collapse; /* IE7 and lower */
	border-spacing: 0;
	width: 100%;
}

.bordered {
	border: solid #ccc 1px;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 1px #ccc;
	-moz-box-shadow: 0 1px 1px #ccc;
	box-shadow: 0 1px 1px #ccc;
}

.bordered tr:hover {
	background: #fbf8e9;
	-o-transition: all 0.1s ease-in-out;
	-webkit-transition: all 0.1s ease-in-out;
	-moz-transition: all 0.1s ease-in-out;
	-ms-transition: all 0.1s ease-in-out;
	transition: all 0.1s ease-in-out;
}

.bordered td, .bordered th {
	border-left: 1px solid #ccc;
	border-top: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.bordered th {
	background-color: #dce9f9;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc),
		to(#dce9f9));
	background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
	background-image: linear-gradient(top, #ebf3fc, #dce9f9);
	-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .8) inset;
	border-top: none;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
	text-align: center;
}

.bordered td:first-child, .bordered th:first-child {
	border-left: none;
}

.bordered th:first-child {
	-moz-border-radius: 6px 0 0 0;
	-webkit-border-radius: 6px 0 0 0;
	border-radius: 6px 0 0 0;
}

.bordered th:last-child {
	-moz-border-radius: 0 6px 0 0;
	-webkit-border-radius: 0 6px 0 0;
	border-radius: 0 6px 0 0;
}

.bordered th:only-child {
	-moz-border-radius: 6px 6px 0 0;
	-webkit-border-radius: 6px 6px 0 0;
	border-radius: 6px 6px 0 0;
}

.bordered tr:last-child td:first-child {
	-moz-border-radius: 0 0 0 6px;
	-webkit-border-radius: 0 0 0 6px;
	border-radius: 0 0 0 6px;
}

.bordered tr:last-child td:last-child {
	-moz-border-radius: 0 0 6px 0;
	-webkit-border-radius: 0 0 6px 0;
	border-radius: 0 0 6px 0;
}
</style>
</head>

<body class="hold-transition register-page">
	<div class="x_panel">
		<div class="x_title">
			<h2>
			User Profie
				<!--  <a href="<c:url value='/dashboard' />">Home page</a> -->
			</h2>

			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<table class="bordered table table-striped" >
				<thead>
					<tr>
					  <th>Employee Profile </th>			
					</tr>
    	</thead>
    	
    	<tr disable="true">   
       			 <td>Employee Id</td>
        		<td>${empName.id}</td>
    </tr>     
   			 <tr>   
       			 <td>First Name</td>
        		<td>${empName.firstName}</td>
    </tr>        
    <tr>     
        <td>Last Name</td>
        <td>${empName.lastName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${empName.email}</td>
    </tr>
    <tr>     
        <td>Salary</td>
        <td>${empName.salary}</td>
    </tr>
    <tr>
        <td>Join Date</td>
        <td>${empName.joinDate}</td>
    </tr>
    <tr>
        <td>Street</td>
        <td>${empName.street}</td>
    </tr>    
    <tr> 
        <td>City</td>
        <td>${empName.street}</td>
    </tr>
    <tr>
        <td>State</td>
        <td>${empName.state}</td>
    </tr>
    <tr>       
        <td>Zip</td>
        <td>${empName.zip}</td>
    </tr> 
	<tr>       
        <td>Telephone</td>
        <td>${empName.telephone}</td>
    </tr> 

	<tr>
       <td size="20" colspan="2" ><a href="<c:url value='/employee/edit/${empName.id}' />">Edit</a></td>
       </tr> 
</table>


</div>
	</div>

</body>
</html>
