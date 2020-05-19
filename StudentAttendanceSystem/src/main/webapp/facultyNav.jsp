<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">QR-Attendance System</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/faculty/qr-details.jsp">Generate QR</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/faculty/student-details.jsp">Students</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/faculty/batch-details.jsp">Batches</a>
      </li>
    </ul>
  </div>
</nav>
<br/>

</html>