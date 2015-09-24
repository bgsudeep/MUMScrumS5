<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-12">
	<div class="x_panel">
		<div class="x_title">
			<h2>Assigned User Stories for ${loggedInEmployee.firstName}
				${loggedInEmployee.lastName}</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><i
						class="fa fa-wrench"></i></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Settings 1</a></li>
						<li><a href="#">Settings 2</a></li>
					</ul></li>
				<li><a class="close-link"><i class="fa fa-close"></i></a></li>
			</ul>
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

						<th>Action</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach items="${assignedUserStories}" var="userstory">
						<tr>
							<td>${userstory.id}</td>
							<td><a
								href="/MUMScrumS5/productbacklog/${userstory.id}/details"><c:out
										value="${userstory.title}" /></a></td>
							<td>${userstory.description}</td>
							<td>${userstory.estimatedDevHours}</td>
							<td>${userstory.remainingDevHours}</td>

							<td><a href = "<c:url value = "/userEffortLog/${userstory.id}/${loggedInEmployee.id}"/>" class = "confirmation">Update</a></td>
							<!-- <td><a data-toggle="modal"
								data-target=".bs-example-modal-lg">Update</a></td> -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="modal fade bs-example-modal-lg" tabindex="-1"
				role="dialog" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<form action="userEffortLog" method="GET">
						<input type="hidden" name="userStory_Id" value="${userstory.id}">
						<input type="hidden" name="employeeID" value="${loggedInEmployee.id}">
						
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Update
									Development Estimated Effort</h4>
							</div>
							<div class="modal-body">
								<h4>Actual Development Effort : [Hours]</h4>

								<input class="form-control"
									style="height: 30px; font-size: 14pt;" type="text"
									name="actualEffort_Dev" id="ActualEffortDev"> <br>
								<h4>Day</h4>
								<input class="form-control"
									style="height: 30px; font-size: 14pt;" type="text"
									name="day" id="Day">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</div>

</div>
