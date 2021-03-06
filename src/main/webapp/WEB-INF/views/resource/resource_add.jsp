<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href='<spring:url value="/resources/css/bootstrap-select.min.css"/>'
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src='<spring:url value="/resources/js/bootstrap-select.min.js"/>'></script>


</head>
<body>

	<jsp:include page="../../views/fragments/header.jsp"></jsp:include>

	<div class="container">

		<div class="row">
			<h1>
				<spring:message code="label.resource.add.page.title"></spring:message>
			</h1>
		</div>

		<spring:url value="/resource/review" var="formUrl" />
		<form:form action="${formUrl }" method="POST"
			modelAttribute="resource">

			<div class="row">

				<div class="form-group">
					<label for="resource-name">Name</label>
					<!-- <input type="text" name="name" class="form-control" id="resource-name"> -->
					<form:input path="name" id="resource-name" cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="resource-type">Type</label>
					<form:select id="resource-type" path="type" items="${typeOptions}"
						cssClass="selectpicker" />
					<!-- <select id="resource-type" name="type" class="selectpicker">
						<option></option>
						<option value="material">Material</option>
						<option value="other">Other</option>
						<option value="staff">Staff</option>
						<option value="tech">Technical Equipment</option>
					</select> -->
				</div>

				<div class="form-group">
					<label for="cost">Cost</label>
					<!-- <input id="cost" type="text" class="form-control" name="cost" /> -->
					<form:input id="cost" path="cost" cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="unit">Unit of Measure</label>
					<!-- <input id="unit" type="text" class="form-control" name="unitOfMeasure" /> -->
					<form:radiobuttons id="unit" path="unitOfMeasure" items="${radios}" />
				</div>

				<div class="form-group">
					<label for="indicators">Indicators</label>
					<!-- <input id="unit" type="text" class="form-control" name="unitOfMeasure" /> -->
					<form:checkboxes id="indicators" path="indicators"
						items="${checks}" />
					<a href="/resource/request" id="sendReq">Send Request</a>
				</div>

				<div class="form-group">
					<label for="note">Notes</label>
					<!-- <input id="cost" type="text" class="form-control" name="cost" /> -->
					<form:textarea id="note" path="notes" cssClass="form-control"
						rows="3" />
				</div>

				<button type="submit" class="btn btn-default">Submit</button>

			</div>
		</form:form>

	</div>
</body>

<script type="text/javascript">
document.getElementById('sendReq').addEventListener('click',(e)=>{
    e.preventDefault(); console.log('click me');
	fetch('./request',{method: 'POST',
	    headers: {
	        'Accept': 'application/json',
	        'Content-Type': 'application/json'
	      },body:$('form').serialize()})
	.then(response=>response.text())
	.then(data=> console.log(data))
	.catch(error=>console.log(error));

});
</script>
</html>