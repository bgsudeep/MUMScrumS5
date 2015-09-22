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

		<form>
			<div>
				<div class="x_panel">
					<div class="x_title">
						<h2>
							Available User Stories for Sprint: <b>${sprint.title }</b>
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
										<td><a
											href="/MUMScrumS5/productbacklog/${userstory.id}/details"><c:out
													value="${userstory.title}" /></a></td>
										<td>${userstory.description}</td>
										<td>${userstory.estimatedDevHours}</td>
										<td>${userstory.remainingDevHours}</td>
										<td>${userstory.estimatedTestHours}</td>
										<td>${userstory.remainingTestHours}</td>

										<td>
											<%-- <button
												formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/add/${userstory.id}/"
												type="submit">Add to Sprint</button> --%>
												
												
												<div class="x_content">

                                <ul class="nav nav-pills" role="tablist">
                                    
                                    <li role="presentation" class="dropdown">
                                        <a id="drop4" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                                Select
                                <span class="caret"></span>
                            </a>
                                        <ul id="menu6" class="dropdown-menu animated fadeInDown" role="menu">
                                            <li role="presentation" class="divider"></li>
                                        
                                            <li role="presentation"><a role="menuitem" tabindex="-1" onclick="new PNotify({
                                title: 'Success',
                                text: 'Adding User Story to Sprint completed',
                                type: 'success'
                            });" href="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/add/${userstory.id}/">Add to Sprint</a>
                                            </li>
                                            <li role="presentation" class="divider"></li>
                                        </ul>
                                    </li>
                                    
                                </ul>

                            </div>
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
						User Story List for Sprint: <b>${sprint.title }</b>
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
										<%-- <button
											formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/remove/${userstory.id}/"
											type="submit">Remove from Sprint</button>
										<button
											formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/remove/${userstory.id}/"
											type="submit">Assign Dev.</button>
										<button
											formaction="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/remove/${userstory.id}/"
											type="submit">Assign Tester</button>  --%>
											
											
											
											<div class="x_content">

                                <ul class="nav nav-pills" role="tablist">
                                    
                                    <li role="presentation" class="dropdown">
                                        <a id="drop4" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
                                Select
                                <span class="caret"></span>
                            </a>
                                        <ul id="menu6" class="dropdown-menu animated fadeInDown" role="menu">
                                            <li role="presentation" class="divider"></li>
                                        
                                            <li role="presentation"><a role="menuitem" tabindex="-1" onclick="new PNotify({
                                title: 'Success',
                                text: 'Removing User Story from Sprint completed',
                                type: 'success'
                            });" href="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/remove/${userstory.id}/">Remove from Sprint</a>
                                            </li>
                                            <li role="presentation" class="divider"></li>
                                            
                                            <li role="presentation"><a role="menuitem" tabindex="-1" href="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/${userstory.id}/assign/developer">Assign Developer</a>
                                            </li>
                                            <li role="presentation"><a role="menuitem" tabindex="-1" href="/MUMScrumS5/productbacklog/${productbacklog.id}/releasebacklog/${releasebacklog.id}/sprint/${sprint.id}/userstory/${userstory.id}/assign/tester">Assign Tester</a>
                                            </li>
                                            <li role="presentation" class="divider"></li>
                                            <li role="presentation"> <a data-toggle="modal" data-target=".bs-example-modal-lg">Large Modal</a>
                                            </li>
                                            
                                        </ul>
                                    </li>
                                    
                                </ul>
                                
                                <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-hidden="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">

                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">Assign Developer</h4>
                                            </div>
                                            <div class="modal-body">
                                                <h4>Text in a modal</h4>
                                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
                                                <p>Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Save changes</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </div>

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
