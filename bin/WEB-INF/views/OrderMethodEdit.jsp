<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to OrderMethod update Page</h2>
<form:form action="update" method="POST" modelAttribute="orderMethod">
<pre>
Order ID:  <form:input path="ordMethId" readOnly="true"/>
Order Mode:<form:radiobutton path="ordMethMode" value="Sale"/>Sale
           <form:radiobutton path="ordMethMode" value="Purchase"/>Purchase

Order Code:<form:input path="ordMethCode"/>
 Order Method:<form:select path="ordMethMethod">
<form:option value="">--select--</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FCFO">FCFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
Order Accept:<form:checkbox path="ordMethAccept" value="Multi-Model"/>Multi-Model
             <form:checkbox path="ordMethAccept" value="AcceptReturn"/>AcceptReturn
              
Description:<form:textarea path="ordMethDsc"/>
<input type="submit" value="update Order Method"/>
</pre>
</form:form>
${message }
</body>
</html>