<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
</html>