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
<h2> Welcome to Vendor Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>VENDOR NAME</th>
<th>VENDOR CODE</th>
<th>DESIGNATION</th>
<th>PRESERVE</th>
</tr>
<c:forEach items="${list }" var="v">
<tr>
<td><c:out value="${v.venId }"/></td>
<td><c:out value="${v.venName }"/></td>
<td><c:out value="${v.venCode }"/></td>
<td><c:out value="${v.venDesg}"/></td>
<td><c:out value="${v.venPreserve}"/></td>
<td>
<a href="delete?id=${v.venId}">DELETE</a>
</td>
<td><a href="edit?id=${v.venId }">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>

${message }
</body>
</html>