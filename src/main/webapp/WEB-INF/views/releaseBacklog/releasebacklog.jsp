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
	<c:forEach var="productBacklog" items="${productBacklogList}">

		<div class="x_panel">
			<div class="x_title">
				<h2>
					Release Backlog for <b>${productBacklog.title}</b>
				</h2>

				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<table class="table table-striped jambo_table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="release" items="${productBacklog.releases}">
							<tr>
								<td><a
									href="../productbacklog/${productBacklog.id}/releasebacklog/${release.id}/"><c:out
											value="${release.name}" /></a></td>
								<td>${release.description}</td>
								<td>${release.startDate}</td>
								<td>${release.endDate}</td>

								<td><a href="<c:url value='${release.id}/assign' />"> <c:choose>
											<c:when test="${!empty release.employee}">Change Assignee</c:when>
											<c:otherwise>Assign to SM<br />
											</c:otherwise>
										</c:choose>
								</a>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:forEach>
</body>
</html>
