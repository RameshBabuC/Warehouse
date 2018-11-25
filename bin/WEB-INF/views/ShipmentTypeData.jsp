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
<h2> Welcome to Shipment Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>SHIPMENT MODE</th>
<th>SHIPMENT CODE</th>
<th>ENABLE SHIPMENT</th>
<th>SHIPMENT GRADE</th>
<th>DESCRIPTION</th>
</tr>
<c:forEach items="${list }" var="s">
<tr>
<td><c:out value="${s.shipTypId}" /></td>
<td><c:out value="${s.shipTypMode}"/></td>
<td><c:out value="${s.shipTypCode}"/></td>
<td><c:out value="${s.shipTypEnabled}"/></td>
<td><c:out value="${s.shipTypGrade}"/></td>
<td><c:out value="${s.shipTypDsc}"/></td>
<td>
<a href="delete?id=${s.shipTypId}">DELETE</a>
</td>
<td><a href="edit?id=${s.shipTypId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>
${message }
</body>
</html>