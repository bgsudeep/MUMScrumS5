<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Product Backlog</title>
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
<body>
	<!-- <h1>
	Employee List
</h1> -->


	<div class="x_panel">
		<div class="x_title">
			<h2>Add Product Backlog</h2>

			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			<br>
			<form:form action="add" id="demo-form2"
				data-parsley-validate="" class="form-horizontal form-label-left"
				novalidate="" commandName="productbacklog">
				<%-- Value = ${productbacklog } --%>
				<div class="form-group">
					<c:if test="${!empty productbacklog.title}">

						<form:label for="id" path="id">ID *</form:label>
						<form:input type="text" path="id" readonly="true" disabled="true"
							class="form-control" name="id" required="required" />
						<form:hidden path="id" />

					</c:if>
				</div>

				<div class="form-group">
					<form:label for="title" path="title">Product Backlog Name *</form:label>
					<form:input type="text" path="title" class="form-control"
						name="title" required="required" />
				</div>

				<div class="form-group">
					<form:label path="description" for="description">Product Backlog Description *</form:label>
					<form:input path="description" type="text" class="form-control"
						id="description" required="required" name="description" />
				</div>



				<div class="ln_solid"></div>
				<div class="form-group">
					<div class="col-sm-6 col-xs-12">


						<button type="submit" class="btn btn-success">Add</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>


	<div class="x_panel">
		<div class="x_title">
			<h2>
				Product Backlog List
			</h2>

			<div class="clearfix"></div>
		</div>
		<div class="x_content">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productBacklogList}" var="productbacklog">
						<tr>
							<td><a href="${productbacklog.id}"><c:out
									value="${productbacklog.title}" /></a></td>
							<td>${productbacklog.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



		</div>
	</div>



	<%-- 
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">Username</th>
		<th width="120">Email</th>
		<th width="120">Salary</th>
		<th width="120">Street</th>
		<th width="120">City</th>
		<th width="120">State</th>
		<th width="120">Zip</th>
		<th width="120">Join Date</th>
		<th width="120">Telephone</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.username}</td>
			<td>${employee.email}</td>
			<td>${employee.salary}</td>
			<td>${employee.street}</td>
			<td>${employee.city}</td>
			<td>${employee.state}</td>
			<td>${employee.zip}</td>
			<td>${employee.joinDate}</td>
			<td>${employee.telephone}</td>
			<td><a href="<c:url value='/edit/${employee.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
 --%>

</body>
</html>
