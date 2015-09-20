<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Product Backlog Details</title>
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


	<!-- User Story -->
	<div class="col-md-6 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>
					Add User Story for <b>${productbacklog.title }</b>
				</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<form:form action="details/userstory/add" id="demo-form2"
					data-parsley-validate="" class="form-horizontal form-label-left"
					novalidate="" commandName="userstory">

					<div class="form-group">
						<form:label for="title" path="title">User Story Title *</form:label>
						<form:input type="text" path="title" class="form-control"
							name="title" required="required" />
					</div>

					<div class="form-group">
						<form:label path="description" for="description">User Story Description *</form:label>
						<form:input path="description" type="text" class="form-control"
							id="description" required="required" name="description" />
					</div>

					<div class="form-group">
						<form:label path="estimatedDevHours" for="estimatedDevHours">Estimated Dev. Hours *</form:label>
						<form:input path="estimatedDevHours" type="text"
							class="form-control" id="estimatedDevHours" required="required"
							name="estimatedDevHours" />
					</div>

					<div class="form-group">
						<form:label path="remainingDevHours" for="remainingDevHours">Remaining Dev. Hours *</form:label>
						<form:input path="remainingDevHours" type="text"
							class="form-control" id="remainingDevHours" required="required"
							name="remainingDevHours" />
					</div>

					<div class="form-group">
						<form:label path="estimatedTestHours" for="estimatedTestHours">Estimated Test Hours *</form:label>
						<form:input path="estimatedTestHours" type="text"
							class="form-control" id="estimatedTestHours" required="required"
							name="estimatedTestHours" />
					</div>

					<div class="form-group">
						<form:label path="remainingTestHours" for="remainingTestHours">Remaining Test Hours *</form:label>
						<form:input path="remainingTestHours" type="text"
							class="form-control" id="remainingTestHours" required="required"
							name="remainingTestHours" />
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
				<h2>User Story List</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.N.</th>
							<th>Title</th>
							<th>Description</th>
							<th>Est. Dev. Hours</th>
							<th>Rem. Dev. Hours</th>
							<th>Est. Test Hours</th>
							<th>Rem. Test Hours</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userStoryList}" var="userstory">
							<tr>
								<td>${userstory.id}</td>
								<td><a
									href="/MUMScrumS5/productbacklog/${userstory.id}/details"><c:out
											value="${userstory.title}" /></a></td>
								<td>${userstory.description}</td>
								<td>${userstory.estimatedDevHours}</td>
								<td>${userstory.remainingDevHours}</td>
								<td>${userstory.estimatedTestHours}</td>
								<td>${userstory.remainingTestHours}</td>

								<td><a
									href="<c:url value='productbacklog/edit/${userstory.id}' />">Edit</a>/<a
									href="<c:url value='productbacklog/remove/${userstory.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>





			</div>
		</div>

	</div>

	<div class="col-md-6 col-xs-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>Add Release for <b>${productbacklog.title}</b></h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<form:form action="details/release/add" id="demo-form2"
					data-parsley-validate="" class="form-horizontal form-label-left"
					novalidate="" commandName="releasebacklog">
					
					<div class="form-group">
						<form:label for="name" path="name">Release Backlog Name *</form:label>
						<form:input type="text" path="name" class="form-control"
							name="name" required="required" />
					</div>

					<div class="form-group">
						<form:label path="description" for="description">Release Backlog Description *</form:label>
						<form:input path="description" type="text" class="form-control"
							id="description" required="required" name="description" />
					</div>
					
					<div class="form-group">
						<form:label path="startDate" for="startDate">Start Date *</form:label>
						<form:input path="startDate" type="text" class="form-control"
							id="startDate" required="required" name="startDate" />
					</div>
					
					<div class="form-group">
						<form:label path="endDate" for="endDate">End Date *</form:label>
						<form:input path="endDate" type="text" class="form-control"
							id="endDate" required="required" name="endDate" />
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
				<h2>Release Backlog List</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>S.N.</th>
							<th>Title</th>
							<th>Description</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${releaseBacklogList}" var="releaseBacklog">
							<tr>
								<td>${releaseBacklog.id}</td>
								<td><a
									href="/MUMScrumS5/productbacklog/${releaseBacklog.id}/details"><c:out
											value="${releaseBacklog.name}" /></a></td>
								<td>${releaseBacklog.description}</td>
								<td>${releaseBacklog.startDate}</td>
								<td>${releaseBacklog.endDate}</td>
								
								<td><a
									href="<c:url value='productbacklog/edit/${releaseBacklog.id}' />">Edit</a>/<a
									href="<c:url value='productbacklog/remove/${releaseBacklog.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



			</div>
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
