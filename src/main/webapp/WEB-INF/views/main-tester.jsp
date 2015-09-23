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
						<th>Est. Test Hours</th>
						<th>Rem. Test Hours</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:if test = "${assignedUserStories.size() != 0}">
					<c:forEach items="${assignedUserStories}" var="userstory">
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

							<td><a href="#">Update</a></td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>

</div>