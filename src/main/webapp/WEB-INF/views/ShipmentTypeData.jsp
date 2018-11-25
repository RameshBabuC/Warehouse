<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SHIPMENT TYPE Data Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to Shipment Data Page</h2>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty list }">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>SHIPMENT MODE</th>
								<th>SHIPMENT CODE</th>
								<th>ENABLE SHIPMENT</th>
								<th>SHIPMENT GRADE</th>
								<th>DESCRIPTION</th>
								<th>OPERATIONS</th>
							</tr>
							<c:forEach items="${list }" var="s">
								<tr>
									<td><c:out value="${s.shipTypId}" /></td>
									<td><c:out value="${s.shipTypMode}" /></td>
									<td><c:out value="${s.shipTypCode}" /></td>
									<td><c:out value="${s.shipTypEnabled}" /></td>
									<td><c:out value="${s.shipTypGrade}" /></td>
									<td><c:out value="${s.shipTypDsc}" /></td>
									<td><a href="delete?id=${s.shipTypId}"
										class="btn btn-danger">DELETE</a> <a
										href="edit?id=${s.shipTypId}" class="btn btn-danger">EDIT</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">NO DATA FOUND IN DATABASE</div>
					</c:otherwise>
				</c:choose>

				<a href="excel" class="btn btn-danger">Excel Export</a> <a
					href="pdf" class="btn btn-danger">PDF Export</a>
			</div> <!-- card body end -->
			<c:if test="${message ne null }">
				<div class="text-warning">${message }</div>
			</c:if>
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>