<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Not found</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href='<spring:url value="/resources/css/home.css"/>' type="text/css"/>
	<link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap-select.min.css"/>' type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src='<spring:url value="/resources/js/bootstrap-select.min.js"/>'></script>

</head>
<body>
	<jsp:include page="../../views/fragments/header.jsp"></jsp:include>
	<div class="container">
  		<h2>400  Bad Request</h2>
  	</div>
</body>
</html>