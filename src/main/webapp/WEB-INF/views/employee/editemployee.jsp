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
				Edit Employee
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
					<form:input placeholder = "example@gmail.com" path="email" type="email" class="form-control"
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
					<form:input placeholder = "0.00" path="salary" type="text" class="form-control"
						id="salary" name="salary" required="required" />
				</div>

				<div class="form-group">
					<form:label path="joinDate" for="joinDate">Join Date *</form:label>
					<form:input placeholder = "MM-dd-YYYY" path="joinDate" type="text" class="form-control"
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
				<button type="submit" class="btn btn-success" >Cancel</button>

				
			</form:form>
			<!-- end form for validations -->

		</div>
	</div>
	</body>
</html>
