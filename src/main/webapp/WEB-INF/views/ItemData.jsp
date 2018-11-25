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
<h2> Welcome to Item Data Page</h2>
<table border="1">
<tr>
<th>ID</th>
<th>ITEM CODE</th>
<th>ITEM DIMENSIONS</th>
<th>BASE COST</th>
<th>BASE CURRENCY</th>
<th>ITEM UOM</th>
<th>SALE</th>
<th>PURCHASE</th>
<th>VENDOR</th>
<th>CUSTOMER</th>
</tr>
<c:forEach items="${list }" var="item">
<tr>
<td><c:out value="${item.itmId }"/></td>
<td><c:out value="${item.itmCode }"/></td>
<td>  W<c:out value="${item.itmWidth }"/>   L<c:out value="${item.itmLength }"/>    H<c:out value="${item.itmHeight }"/></td>
<td><c:out value="${item.itmCost}"/></td>
<td><c:out value="${item.itmCurrency}"/></td>
<td><c:out value="${item.uom.umModel}"/></td>
<td><c:out value="${item.omSale.ordMethCode }"></c:out></td>
<td><c:out value="${item.omPurchase.ordMethCode }"></c:out></td>
<td>
<c:forEach items="${item.venUsers}" var="ven" >
<c:out value="${ven.whUsrTypCode }"></c:out>
</c:forEach>
</td>
<td>
<c:forEach items="${item.custUsers}" var="cust" >
<c:out value="${cust.whUsrTypCode }"></c:out>
</c:forEach>
</td>
<td>
<a href="delete?id=${item.itmId}">DELETE</a>
</td>
<td><a href="edit?id=${item.itmId }">EDIT</a></td>
</tr>
</c:forEach>
</table>

${message }
</body>
</html>