<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<h1><spring:message code="label.project.add.page.title" /></h1>	
		<div class="row">
			
			<spring:url value="/project/add" var="formUrl"/>
			<form:form action="${formUrl}" method="post" modelAttribute="project"  >
			
				<div class="form-group">
					<label for="project-name">Name</label>
					<form:input  id="project-name" 
							cssClass="form-control" path="name"/>
				</div>

				<div class="form-group">
					<label for="project_type">Type</label>
					<form:select path="type" items="${types}" cssClass="selectpicker"/>
					<!-- <select name="type" class="selectpicker">
						<option></option>
						<option value="single">Single Year</option>
						<option value="multi">Multi-Year</option>
					</select> -->
				</div>
							
				<div class="form-group">
					<label for="sponsor-name">Sponsor Name</label>
					<form:input id="sponsor-name"  
							cssClass="form-control" path="sponsor.name"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input id="sponsor-phone"  
							cssClass="form-control" path="sponsor.phone"/>
				</div>
				
				<div class="form-group">
					<label for="sponsor-mail">Sponsor Email</label>
					<form:input id="sponsor-mail" 
							cssClass="form-control" path="sponsor.email"/>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<form:input id="funds" 
						cssClass="form-control" path="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<form:input id="hours" 
						cssClass="form-control" path="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="desc">Description</label>
					<form:textarea cssClass="form-control" rows="3" path="description" id="desc"/>
				</div>
				
				<div class="form-group">
					<label for="poc1">POC-1</label>
					<form:input id="poc1"  
							cssClass="form-control" path="pointsOfContact[0]"/>
				</div>
				<div class="form-group">
					<label for="poc2">POC-2</label>
					<form:input id="poc2"  
							cssClass="form-control" path="pointsOfContact[1]"/>
				</div>
				<div class="form-group">
					<label for="poc3">POC-3</label>
					<form:input id="poc3"  
							cssClass="form-control" path="pointsOfContact[2]"/>
				</div>
				
				
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" path="special" />
				</div>
			
				<button type="submit" class="btn btn-default">Submit</button>
	
			</form:form>
			
		</div>
	</div>
</body>
</html>