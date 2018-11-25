<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Welcome to Uom Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>UOM TYPE</th>
<th>UOM MODEL</th>
<th>DESCRIPTION</th>
</tr>
<c:forEach items="${list }" var="uom">
<tr>
<td><c:out value="${uom.umId }"/></td>
<td><c:out value="${uom.umType }"/></td>
<td><c:out value="${uom.umModel }"/></td>
<td><c:out value="${uom.umDsc}"/></td>
<td>
<a href="delete?id=${uom.umId}">DELETE</a>
</td>
<td><a href="edit?id=${uom.umId }">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>

${message }
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Data Page</title>
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

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>WELCOME TO UOM DATA PAGE</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<c:choose>
					<c:when test="${!empty list}">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>MODEL</th>
								<th>DESCRIPTION</th>
								<th>OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="uom">
								<tr>
									<td><c:out value="${uom.umId}" /></td>
									<td><c:out value="${uom.umType}" /></td>
									<td><c:out value="${uom.umModel}" /></td>
									<td><c:out value="${uom.umDsc}" /></td>
									<td><a href="delete?id=${uom.umId}" class="btn btn-danger">DELETE</a></td>
									<td><a href="edit?id=${uom.umId}" class="btn btn-danger">EDIT</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<a href="excel" class="btn btn-danger">EXCEL EXPORT</a> <a
					href="pdf" class="btn btn-danger">PDF EXPORT</a>
				<!-- card body end -->
			</div>


			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>


			<!-- card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</html>



