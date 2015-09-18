<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>MUMScrum Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.modal-footer {
	border-top: 0px;
}


#loginModal {
	
	margin-top: 10%;
}


html, body {
	
	background-color: #131313;
	background-size: 20px 20px;
}
</style>
</head>

<body>

	<!--login modal-->
	<div id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Header Section -->
				<div class="modal-header">
					<c:if test="${not empty logoutSuccessful}">
						<div class="alert alert-success" role="alert">
							<h4>${logoutSuccessful}</h4>
						</div>
					</c:if>

					<c:if test="${not empty error}">
						<div class="alert alert-danger" role="alert">
							<h4>${error}</h4>
						</div>
					</c:if>

					<h2>Please sign in</h2>

				</div>

				<!-- Body Section -->
				<div class="modal-body">
					<form class="form col-md-12"
						action="<c:url value='/j_spring_security_check' />"
						name="loginForm" method="POST">
						<p>
						<input type="text" class="form-control input-lg"
							placeholder="Username or Email" required autofocus
							name='username' /> 
						<p>
						<input type="password"
							class="form-control input-lg" placeholder="Password" required
							name='password' /> 
							
						<!-- <label class="checkbox"> <input
							type="checkbox" value="remember-me" /> Remember me
						
						</label> --> 
						<p>
						<input name="submit" type="submit"
							class="btn btn-primary btn-lg btn-block" value="Sign In" /> 
							
						<input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>

				<!-- Footer Section -->
				<div class="modal-footer">
					<div class="col-md-12">
						<!-- <span class="pull-left"><a href="#">Forgot Password?</a></span> <span><a
							href="#">Register</a></span> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>