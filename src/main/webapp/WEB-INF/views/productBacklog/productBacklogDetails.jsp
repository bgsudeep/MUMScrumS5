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
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<i class="fa fa-align-left"></i> User Story <small>Sessions</small>
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>

				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<!-- start accordion -->
				<div class="accordion" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel">
						<a class="panel-heading collapsed" role="tab" id="headingOne"
							data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="false"
							aria-controls="collapseOne">
							<h4 class="panel-title">${buttonTitle}
								User Story for <b>${productbacklog.title }
							</h4>
						</a>
						<div id="collapseOne" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<form:form
									action="/MUMScrumS5/productbacklog/${productbacklog.id}/userstory/save"
									id="demo-form2" data-parsley-validate=""
									class="form-horizontal form-label-left" novalidate=""
									commandName="userstory">

									<form:input type="hidden" path="id" class="form-control"
										name="id" />

									<div class="form-group">
										<form:label for="title" path="title">User Story Title *</form:label>
										<form:input type="text" path="title" class="form-control"
											name="title" required="required" />
									</div>

									<div class="form-group">
										<form:label path="description" for="description">User Story Description *</form:label>
										<form:input path="description" type="text"
											class="form-control" id="description" required="required"
											name="description" />
									</div>

									<div class="form-group">
										<form:label path="estimatedDevHours" for="estimatedDevHours">Estimated Dev. Hours *</form:label>
										<form:input path="estimatedDevHours" type="text"
											class="form-control" id="estimatedDevHours"
											required="required" name="estimatedDevHours" />
									</div>

									<div class="form-group">
										<form:label path="remainingDevHours" for="remainingDevHours">Remaining Dev. Hours *</form:label>
										<form:input path="remainingDevHours" type="text"
											class="form-control" id="remainingDevHours"
											required="required" name="remainingDevHours" />
									</div>

									<div class="form-group">
										<form:label path="estimatedTestHours" for="estimatedTestHours">Estimated Test Hours *</form:label>
										<form:input path="estimatedTestHours" type="text"
											class="form-control" id="estimatedTestHours"
											required="required" name="estimatedTestHours" />
									</div>

									<div class="form-group">
										<form:label path="remainingTestHours" for="remainingTestHours">Remaining Test Hours *</form:label>
										<form:input path="remainingTestHours" type="text"
											class="form-control" id="remainingTestHours"
											required="required" name="remainingTestHours" />
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
					</div>
					<div class="panel">
						<a class="panel-heading collapsed" role="tab" id="headingTwo"
							data-toggle="collapse" data-parent="#accordion"
							href="#collapseTwo" aria-expanded="false"
							aria-controls="collapseTwo">
							<h4 class="panel-title">
								User Story List for <b>${productbacklog.title}</b>
							</h4>
						</a>
						<div id="collapseTwo" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<table class="table table-striped jambo_table">
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

												<td><a
													href="<c:url value='${productbacklog.id}/userstory/${userstory.id}/edit' />">Edit</a>/<a
													href="<c:url value='${productbacklog.id}/userstory/${userstory.id}/delete' />">Delete</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- end of accordion -->


			</div>
		</div>
	</div>



	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					<i class="fa fa-align-left"></i> Release
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>

				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">

				<!-- start accordion -->
				<div class="accordion" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel">
						<a class="panel-heading collapsed" role="tab" id="headingThree"
							data-toggle="collapse" data-parent="#accordion"
							href="#collapseThree" aria-expanded="false"
							aria-controls="collapseThree">
							<h4 class="panel-title">${buttonTitle}
								Add Release for <b>${productbacklog.title }
							</h4>
						</a>
						<div id="collapseThree" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingThree">
							<div class="panel-body">
							<form:form action="${productbacklog.id}/releasebacklog/add"
					id="demo-form2" data-parsley-validate=""
					class="form-horizontal form-label-left" novalidate=""
					commandName="releasebacklog">

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
					</div>
					<div class="panel">
						<a class="panel-heading collapsed" role="tab" id="headingFour"
							data-toggle="collapse" data-parent="#accordion"
							href="#collapseFour" aria-expanded="false"
							aria-controls="collapseFour">
							<h4 class="panel-title">
								Release Backlog List
							</h4>
						</a>
						<div id="collapseFour" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingFour">
							<div class="panel-body">
								<table class="table table-striped">
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
						<c:forEach items="${releaseBacklogList}" var="releaseBacklog">
							<tr>
								<td><a
									href="/MUMScrumS5/productbacklog/${releaseBacklog.id}/details"><c:out
											value="${releaseBacklog.name}" /></a></td>
								<td>${releaseBacklog.description}</td>
								<td>${releaseBacklog.startDate}</td>
								<td>${releaseBacklog.endDate}</td>

								<td><a
									<%-- href="<c:url value='productbacklog/edit/${releaseBacklog.id}' />">Edit</a>/<a --%>
									href="<c:url value='${productbacklog.id}/releasebacklog/${releaseBacklog.id}/delete' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
							</div>
						</div>
					</div>
				</div>
				<!-- end of accordion -->


			</div>
		</div>
	</div>
	
	

</body>
</html>
