<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
	
	
</head>
<body class="hold-transition register-page">
<!-- <h1>
	Add an Employee
</h1>
 -->
<c:url var="addAction" value="/employee/add" ></c:url>

<section class="content">
	<div class = "row">
	<div class= "col-md-2"></div>
		<div class = "col-md-8">
		<div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Add an Employee</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form:form action="${addAction}" commandName="employee">
                  <div class="box-body">
                    
                    <div class="form-group">
                      <form:label for="firstName" path="firstName">First Name</form:label>
                      <form:input path="firstName" type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "lastName" for="lastName">Last Name</form:label>
                      <form:input path="lastName" type="text" class="form-control" id="firstName" name="lastName" placeholder="Last Name"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "email" for="email">Email Address</form:label>
                      <form:input path = "email" type="email" class="form-control" id="email" name="email" placeholder="Enter email"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "username" for="username">Username</form:label>
                      <form:input path = "username" type="username" class="form-control" id="username" name="username" placeholder="Enter Username"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "password" for="exampleInputPassword1">Password</form:label>
                      <form:input path = "password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "salary" for="salary">Salary</form:label>
                      <form:input path = "salary" type="text" class="form-control" id="salary" name="salary" placeholder="Salary"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "joinDate" for="joinDate">Join Date</form:label>
                      <form:input path = "joinDate" type="text" class="form-control" id="joinDate" name="joinDate" placeholder="Join Date"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "street" for="street">Street</form:label>
                      <form:input path = "street" type="text" class="form-control" id="street" name="street" placeholder="Street"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "city" for="city">City</form:label>
                      <form:input path = "city" type="text" class="form-control" id="city" name="city" placeholder="City"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "state" for="state">State</form:label>
                      <form:input path = "state" type="text" class="form-control" id="state" name="state" placeholder="State"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "zip" for="zip">Zip</form:label>
                      <form:input path = "zip" type="text" class="form-control" id="zip" name="zip" placeholder="Zip"/>
                    </div>
                    
                    <div class="form-group">
                      <form:label path = "telephone" for="telephone">Telephone</form:label>
                      <form:input path = "telephone" type="text" class="form-control" id="telephone" name="telephone" placeholder="Telephone"/>
                    </div>
                    
                    
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form:form>
              </div>
		</div>
	</div>
</section>





<%-- 
<div class ="box box-primary">
	<form:form action="${addAction}" commandName="employee">
<table>
	<c:if test="${!empty employee.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="First Name"/>
			</form:label>
		</td>
		<td>
			<form:input class="form-control" path="firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastName">
				<spring:message text="Last Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastName" />
		</td>
	</tr>
	<tr>
	
		<td>
			<form:label path="street">
				<spring:message text="Street"/>
			</form:label>
		</td>
		<td>
			<form:input path="street" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
		</td>
		<td>
			<form:input path="email" />
		</td> 
	</tr>
	<tr>
	<tr>
		<td>
			<form:label path="city">
				<spring:message text="City"/>
			</form:label>
		</td>
		<td>
			<form:input path="city" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="state">
				<spring:message text="State"/>
			</form:label>
		</td>
		<td>
			<form:input path="state" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="zip">
				<spring:message text="Zip"/>
			</form:label>
		</td>
		<td>
			<form:input path="zip" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="telephone">
				<spring:message text="Telephone"/>
			</form:label>
		</td>
		<td>
			<form:input path="telephone" />
		</td> 
	</tr>
	
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
</div> --%>

</body>
</html>
