<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
	<%-- ${productBacklogList} --%>

	<%-- <c:forEach var = "productBacklog" items = "${productBacklogList}">
		<c:forEach var = "release" items = "${productBacklog.releases}">
			Sprint for &nbsp; 
			<c:forEach var = "sprint" items = "${release.sprints}">
				${sprint.title}
			</c:forEach>
		</c:forEach>
	
	</c:forEach> --%>

	<c:forEach var="productBacklog" items="${productBacklogList}">
		<div class="col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						<i class="fa fa-align-left"></i> <b>Product: </b>${productBacklog.title}
					</h2>
					<ul class="nav navbar-right">
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">

					<!-- start accordion -->
					<div class="accordion" id="accordion" role="tablist"
						aria-multiselectable="true">

						<c:forEach var="release" items="${productBacklog.releases}"
							varStatus="count">
							<%-- <c:if test="${!empty release.sprints }"> --%>

							<div class="panel">
								<a class="panel-heading collapsed" role="tab"
									id="${heading[count.index]}" data-toggle="collapse"
									data-parent="#accordion" href=#${collapse[count.index]}
									aria-expanded="false" aria-controls="${collapse[count.index] }">
									<h4 class="panel-title">
										${fn:length(release.sprints) } Sprint(s) for <b>${release.name}</b>
									</h4>
								</a>
								<div id="${collapse[count.index]}"
									class="panel-collapse collapse" role="tabpanel"
									aria-labelledby="${heading[count.index]} aria-expanded="
									false" style="height: 0px;">


									<div class="panel-body">
										<table class="table table-striped jambo_table">
											<thead>
												<tr>
													<th>Title</th>
													<th>Description</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="sprint" items="${release.sprints}">
													<tr>
														<td><a
															href="../productbacklog/${productBacklog.id}/releasebacklog/${release.id}/sprint/${sprint.id}"><c:out
																	value="${sprint.title}" /></a></td>
														<td>${sprint.description }</td>
														<td>Add/Delete</td>
													</tr>
												</c:forEach>
											</tbody>

										</table>
									</div>
								</div>
							</div>
							<%-- </c:if> --%>
						</c:forEach>
					</div>
					<!-- end of accordion -->


				</div>
			</div>
		</div>
	</c:forEach>

</body>
</html>
