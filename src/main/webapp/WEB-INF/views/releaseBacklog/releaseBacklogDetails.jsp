<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Release Backlog Details</title>
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




	<c:url var="saveAction"
		value="/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/save" />
	<!-- User Story -->
	<div class="col-md-12">

		<div class="x_panel">
			<div class="x_title">
				<h2>
					${buttonTitle} Sprint for Release: <b>${releasebacklog.name}</b>
				</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br>
				<form:form action="${saveAction}" id="demo-form2"
					data-parsley-validate="" class="form-horizontal form-label-left"
					novalidate="" commandName="sprint">

					<form:input type="hidden" path="id" class="form-control" name="id" />

					<div class="form-group">
						<form:label for="title" path="title">Sprint Name *</form:label>
						<form:input type="text" path="title" class="form-control"
							name="title" required="required" />
					</div>

					<div class="form-group">
						<form:label path="description" for="description">Sprint Description *</form:label>
						<form:input path="description" type="text" class="form-control"
							id="description" required="required" name="description" />
					</div>

					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-sm-6 col-xs-12">


							<button type="submit" class="btn btn-success">${buttonTitle}</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>



		<div class="x_panel">
			<div class="x_title">
				<h2>
					Sprint List for Release: <b>${releasebacklog.name }</b>
				</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sprintList}" var="sprint">
							<tr>
								<td><a
									href="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}"><c:out
											value="${sprint.title}" /></a></td>
								<td>${sprint.description}</td>

								<td><a href="<c:url value='#' />">View Burndown Chart</a>/<a
									href="<c:url value='/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/edit' />">Edit</a>/<a
									href="<c:url value='/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/delete' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



			</div>
		</div>

		<form>
			<div>
				<div class="x_panel">
					<div class="x_title">
						<h2>
							Available User Stories for Release: <b>${releasebacklog.name }</b>
						</h2>

						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<table class="table table-striped">
							<thead>
								<tr>
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
								<c:forEach items="${availableUserStories}" var="userstory">
									<tr>
										<td>${userstory.title}</td>
										<td>${userstory.description}</td>
										<td>${userstory.estimatedDevHours}</td>
										<td>${userstory.remainingDevHours}</td>
										<td>${userstory.estimatedTestHours}</td>
										<td>${userstory.remainingTestHours}</td>

										<td>
											<button
												formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/userstory/add/${userstory.id}/"
												type="submit">Add to Release</button>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>

		<form method="GET" id="addUserStory">

			<div class="x_panel">
				<div class="x_title">
					<h2>
						User Story List for release: <b>${releasebacklog.name }</b>
					</h2>

					<div class="clearfix"></div>
				</div>
				<div class="x_content">

					<table class="table table-striped">
						<thead>
							<tr>
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
									<td><a
										href="/MUMScrumS5/productbacklog/${userstory.id}/details"><c:out
												value="${userstory.title}" /></a></td>
									<td>${userstory.description}</td>
									<td>${userstory.estimatedDevHours}</td>
									<td>${userstory.remainingDevHours}</td>
									<td>${userstory.estimatedTestHours}</td>
									<td>${userstory.remainingTestHours}</td>

									<td>
										<button
											formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/userstory/remove/${userstory.id}/"
											type="submit">Remove from Release</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
