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
<h2> Welcome to Customer Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>CUSTOMER CODE</th>
<th>ADDRESS</th>
<th>LOCATIONS</th>
<th>ENABLE CUSTOMER</th>
<th>CUSTOMER EMAIL</th>
<th>CUSTOMER CONTACT</th>
</tr>
<c:forEach items="${list }" var="c">
<tr>
<td><c:out value="${c.custId }"/></td>
<td><c:out value="${c.custCode }"/></td>
<td><c:out value="${c.custAddr }"/></td>
<td><c:out value="${c.custLocs}"/></td>
<td><c:out value="${c.custEnabled}"/></td>
<td><c:out value="${c.custEmail}"/></td>
<td><c:out value="${c.custContact}"/></td>
<td>
<a href="delete?id=${c.custId}">DELETE</a>
</td>
<td><a href="edit?id=${c.custId }">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>

${message }
</body>
</html>