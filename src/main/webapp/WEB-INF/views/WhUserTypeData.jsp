<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WHUSERTYPE Data Page</title>
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
				<h2>Welcome to WhUserType Data Page</h2>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty list }">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>USERTYPE</th>
								<th>USER CODE</th>
								<th>USER FOR</th>
								<th>USER EMAIL</th>
								<th>USER CONTACT</th>
								<th>USER ID TYPE</th>
								<th>IF OTHER</th>
								<th>ID NUMBER</th>
							</tr>
							<c:forEach items="${list }" var="u">
								<tr>
									<td><c:out value="${u.whUsrTypId}" /></td>
									<td><c:out value="${u.whUsrTypType}" /></td>
									<td><c:out value="${u.whUsrTypCode}" /></td>
									<td><c:out value="${u.whUrsTypForType}" /></td>
									<td><c:out value="${u.whUsrTypEmail}" /></td>
									<td><c:out value="${u.whUsrTypContact}" /></td>
									<td><c:out value="${u.whUsrTypIdType}" /></td>
									<td><c:out value="${u.whUsrTypIfOther}" /></td>
									<td><c:out value="${u.whUsrTypIdNum}" /></td>
									<td><a href="delete?id=${u.whUsrTypId}"
										class="btn btn-danger">DELETE</a> <a
										href="edit?id=${u.whUsrTypId}" class="btn btn-danger">EDIT</a></td>
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
			</div>
			<!-- card body end -->
			<c:if test="${message ne null }">
				<div class="text-warning">${message }</div>
			</c:if>
		</div>
		<!-- card end -->
</body>
</html>