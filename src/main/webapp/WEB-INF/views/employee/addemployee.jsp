<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Employee Page</title>
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
</style>

</head>
<body class="hold-transition register-page">
	<!-- <h1>
	Add an Employee
</h1>
 -->
	<c:url var="addAction" value="/employee/add"></c:url>

	<div class="x_panel">
		<div class="x_title">
			<h2>
				Add an Employee
			</h2>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">

			<!-- start form for validation -->
			<form:form action="${addAction}" commandName="employee"
				id="demo-form" data-parsley-validate="" novalidate="">
				<%-- Value = ${employee} --%>
				<form:input type="hidden" path="id" class="form-control" name="id" />

				<div class="form-group">
					<form:label for="firstName" path="firstName">First Name *</form:label>
					<form:input type="text" path="firstName" class="form-control"
						name="firstName" required="required" />
				</div>

				<div class="form-group">
					<form:label path="lastName" for="lastName">Last Name *</form:label>
					<form:input path="lastName" type="text" class="form-control"
						id="firstName" required="required" name="lastName" />
				</div>

				<div class="form-group">
					<form:label path="email" for="email">Email Address *</form:label>
					<form:input path="email" type="email" class="form-control"
						id="email" data-validate-linked="email" required="required"
						name="email" />
				</div>

				<div class="form-group">
					<label for="username">Username *</label>
					<form:input path="user.username" type="text" class="form-control"
						id="username" required="required" />
				</div>

				<div class="form-group">
					<label for="password">Password *</label>
					<form:input path="user.password" type="password"
						class="form-control" id="password" required="required"
						data-validate-length="6,8" />
				</div>

				<div class="form-group">
					<form:label path="salary" for="salary">Salary *</form:label>
					<form:input path="salary" type="text" class="form-control"
						id="salary" name="salary" required="required" />
				</div>

				<div class="form-group">
					<form:label path="joinDate" for="joinDate">Join Date *</form:label>
					<form:input path="joinDate" type="text" class="form-control"
						id="joinDate" name="joinDate" required="required"
						aria-describedby="inputSuccess2Status" />
					<span id="inputSuccess2Status" class="sr-only">(success)</span>
				</div>

				<div class="form-group">
					<form:label path="street" for="street">Street *</form:label>
					<form:input path="street" type="text" class="form-control"
						id="street" name="street" required="required" />
				</div>

				<div class="form-group">
					<form:label path="city" for="city">City *</form:label>
					<form:input path="city" type="text" class="form-control" id="city"
						name="city" required="required" />
				</div>

				<div class="form-group">
					<form:label path="state" for="state">State *</form:label>
					<form:input path="state" type="text" class="form-control"
						id="state" required="required" name="state" />
				</div>

				<div class="form-group">
					<form:label path="zip" for="zip">Zip *</form:label>
					<form:input path="zip" type="text" class="form-control" id="zip"
						name="zip" required="required" />
				</div>

				<div class="form-group">
					<form:label path="telephone" for="telephone">Telephone *</form:label>
					<form:input path="telephone" type="text"
						data-inputmask="'mask' : '(999) 999-9999'" class="form-control"
						id="telephone" required="required" name="telephone" />
				</div>

				<c:if test="${empty employee.firstName}">

					<div class="">
						<label class="control-label" for="role">Select Role:</label> <br>
						<c:forEach items="${roles}" var="role" varStatus="loopCounter">

							<form:radiobutton path="user.roleID" value="${role.id}" /> ${role.role}
				<br>
						</c:forEach>
						<br>
					</div>

				</c:if>
				<c:if test = "${!empty employee.firstName}">
					<form:input path = "user.roleID" value = "${roleID}" type = "hidden"></form:input>
				</c:if>

				

				<form:input path="id" type="hidden" />
				<form:input path="user.enabled" type="hidden" value="true" />

				<button type="submit" class="btn btn-success">Submit</button>

				</p>
			</form:form>
			<!-- end form for validations -->

		</div>
	</div>



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
	</ body>
</html>
