<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Faculty Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<h1 align="center">Faculty Login</h1>

	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4" align="center">
			<br/><br/>
				<form action="login" method="post">
					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" placeholder="Enter email" name="email">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" placeholder="Enter password" name="pwd">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<!--  <br/><br/>					
					<a href="signUp.jsp">
						New Faculty??					
					</a>-->
				</form>
			</div>
		</div>
	</div>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>