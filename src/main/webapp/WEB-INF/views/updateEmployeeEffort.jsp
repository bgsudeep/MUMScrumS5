
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
<body>


	<div class="x_panel">
		<div class="x_title">
			<h2>Work Log</h2>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
	
			<!-- start form for validation -->
			<form:form action="" commandName="worklog"
				id="demo-form" data-parsley-validate="" novalidate="">
				<%-- Value = ${employee} --%>
				<input type="hidden" class="form-control" name="userStory_Id" value = "${userstoryId}" />
				<input type="hidden" class="form-control" name="employeeID" value = "${employeeId}" />
				

				<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true"></span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Update Development
							Estimated Effort</h4>
					</div>
					<div class="modal-body">
						<h4>Actual Development Effort : [Hours]</h4>

						<input class="form-control" style="height: 30px; font-size: 14pt;"
							type="text" name="actualEffort_Dev" id="ActualEffortDev">
						<br>
						<h4>Day</h4>
						<input class="form-control" style="height: 30px; font-size: 14pt;"
							type="text" name="day" id="Day">
					</div>



				<button type="submit" class="btn btn-success">Submit</button>

			</form:form>
			<!-- end form for validations -->

		</div>
	</div>

</body>
</html>
