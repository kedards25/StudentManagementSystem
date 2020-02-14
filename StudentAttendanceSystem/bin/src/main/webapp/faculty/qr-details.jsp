<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Generate QR</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body> 
<jsp:include page="../facultyNav.jsp"></jsp:include>
	<h1 align="center">QR Details</h1>
	
	<div class="container">
	<hr/>
		<div class="col-md-4 offset-md-4">
			<form action="generate_qr" method="Post">
				<div class="form-group">
					<label for="InputFacultyName">Faculty Name</label> <input
						type="text" readonly="readonly" value="<%=session.getAttribute("facultyName") %>" class="form-control"
						id="facultyName" name="facultyName">
				</div>

				<div class="form-group">
					<label for="InputCourseName">Course</label> <input type="text"
						class="form-control" placeholder="Enter course name" name="CourseName" id="CourseName">
				</div>

				<div class="form-group">
					<label for="InputBatchName">Batch</label> <input type="text"
						class="form-control" placeholder="Current batch code" name="BatchCode" id="BatchCode">
				</div>
				
				<div class="form-group">
					<label for="InputDateTime">Date</label> <input
						type="text" class="form-control" readonly="readonly" name="currentDateTime" value="<%= new java.util.Date().toLocaleString() %>" id="currentDateTime">
				</div>
				<button type="submit" class="btn btn-outline-primary">Generate QR</button>
				<button type="reset" class="btn btn-outline-warning">Cancel</button>
			</form>
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