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
<h2> Welcome to Order Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>ORDER MODE</th>
<th>ORDER CODE</th>
<th>ORDER METHOD</th>
<th>ORDER ACCEPT</th>
<th>DESCRIPTION</th>
</tr>
<c:forEach items="${list }" var="o">
<tr>
<td><c:out value="${o.ordMethId}" /></td>
<td><c:out value="${o.ordMethMode}"/></td>
<td><c:out value="${o.ordMethCode}"/></td>
<td><c:out value="${o.ordMethMethod}"/></td>
<td><c:out value="${o.ordMethAccept}"/></td>
<td><c:out value="${o.ordMethDsc}"/></td>
<td>
<a href="delete?id=${o.ordMethId}">DELETE</a>
</td>
<td><a href="edit?id=${o.ordMethId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>
${message }
</body>
</html>
