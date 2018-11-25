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
<h2> Welcome to WhUserType Data Page</h2>
<table border="1">
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
<td><c:out value="${u.whUsrTypType}"/></td>
<td><c:out value="${u.whUsrTypCode}"/></td>
<td><c:out value="${u.whUrsTypForType}"/></td>
<td><c:out value="${u.whUsrTypEmail}"/></td>
<td><c:out value="${u.whUsrTypContact}"/></td>
<td><c:out value="${u.whUsrTypIdType}" /></td>
<td><c:out value="${u.whUsrTypIfOther}" /></td>
<td><c:out value="${u.whUsrTypIdNum}" /></td>
<td>
<a href="delete?id=${s.whUsrTypId}">DELETE</a>
</td>
<td><a href="edit?id=${s.whUsrTypId}">EDIT</a></td>
</tr>
</c:forEach>
</table>
<a href="excel">Excel Export</a>
<a href="pdf">PDF Export</a>

${message }
</body>
</html>