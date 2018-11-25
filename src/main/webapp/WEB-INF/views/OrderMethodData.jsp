<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ORDER METHOD Data Page</title>
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
				<h2>Welcome to Order Data Page</h2>
			</div>
			<!-- card header end -->
			<div class="card-body ">
				<c:choose>
					<c:when test="${!empty list }">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>ORDER MODE</th>
								<th>ORDER CODE</th>
								<th>ORDER METHOD</th>
								<th>ORDER ACCEPT</th>
								<th>DESCRIPTION</th>
								<th>OPERATIONS</th>
							</tr>
							<c:forEach items="${list }" var="o">
								<tr>
									<td><c:out value="${o.ordMethId}" /></td>
									<td><c:out value="${o.ordMethMode}" /></td>
									<td><c:out value="${o.ordMethCode}" /></td>
									<td><c:out value="${o.ordMethMethod}" /></td>
									<td><c:out value="${o.ordMethAccept}" /></td>
									<td><c:out value="${o.ordMethDsc}" /></td>
									<td><a href="delete?id=${o.ordMethId}"
										class="btn btn-danger">DELETE</a></td>
									<td><a href="edit?id=${o.ordMethId}"
										class="btn btn-danger">EDIT</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">NO DATA FOUND IN DATABASE</div>
					</c:otherwise>
				</c:choose>

				<!-- card body end -->
				<a href="excel" class="btn btn-danger">EXCEL EXPORT</a> <a
					href="pdf" class="btn btn-danger">PDF EXPORT</a>
			</div>
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message }</div>
			</c:if>
			<!-- card footer end -->
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
</body>
</html>
