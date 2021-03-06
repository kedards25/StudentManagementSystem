<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--  <meta http-equiv="refresh" content="10">-->
<meta charset="ISO-8859-1">
<title>Generate QR</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<%response.setHeader("Cache-Control", "no-store"); %>
	<jsp:include page="../facultyNav.jsp"></jsp:include>
	<h2 align="center">Generate QR</h2>
	<div class="container">
		<hr />
		<div class="col-md-4 offset-md-4">
			<img src="faculty/QR-images/AttendanceQR.jpg" width="300"
				height="300" />
				<div class="ml-5">
				<button class="btn btn-outline-primary">Show Attendance</button>
				</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script>
		function myFunction() {
			setInterval(function() {
				$("img").attr("src","faculty/QR-images/AttendanceQR.jpg");
			}, 6000);
		}
		myFunction();
	</script>
</body>
</html>