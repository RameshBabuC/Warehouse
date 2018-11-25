  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Purchase Order Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>ORDER CODE</th>
<th>SHIPMENT CODE</th>
<th>VENDOR</th>
<th>REFERENCE NUMBER</th>
<th>QUALITY CHECK</th>
<th>DEFAULT STATUS</th>
<th>DESCRIPTION</th>
</tr>
<c:forEach items="${list}" var="p">
<tr>
<td><c:out value="${p.prchsId}"></c:out></td>
<td><c:out value="${p.prchsOrderCode}"></c:out></td>
<td><c:out value="${p.shipment.shipTypCode}"></c:out></td>
<td>
<c:out value="${p.userVendors.whUsrTypCode}"></c:out>
</td>
<td><c:out value="${p.prchsRefNum }"></c:out></td>
<td><c:out value="${p.prchsQltyCheck}"></c:out></td>
<td><c:out value="${p.prchsDfltStatus}"></c:out></td>
<td><c:out value="${p.prchsDsc}"></c:out></td>
</tr>
</c:forEach>
</table>
</body>
</html>