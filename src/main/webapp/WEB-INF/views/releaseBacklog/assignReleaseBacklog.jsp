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


	<!-- User Story -->
	<form:form action="assign">
	<div class="x_title">
		<h2>
			Assign Scrum Master to <b>${releasebacklog.name }</b>
		</h2>
		
		<div class="clearfix"></div>
	</div>

		<div class="x_content">

			<!-- start form for validation -->

			<ul id="parsley-id-multiple-hobbies" class="parsley-errors-list"></ul>
			<p>
				<label for="heard">Select Scrum Master:</label> <select
					data-parsley-id="9143" id="heard" class="form-control" name="userId">
					<option>Choose..</option>
					<c:forEach items="${scrummasters}" var="user">
						<option value="${user.id}">${user.username}</option>
					</c:forEach>

				</select>
			<ul id="parsley-id-9143" class="parsley-errors-list"></ul>

			<br>

			<button type="submit" class="btn btn-success">Assign</button>

			<!-- end form for validations -->

		</div>
	</form:form>


</body>
</html>
