<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
color:red;
}
</style>
</head>
<body>
<h2>Welcome to OrderMethod Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="orderMethod">
<pre>
Order Mode:<form:radiobutton path="ordMethMode" value="Sale"/>Sale
           <form:radiobutton path="ordMethMode" value="Purchase"/>Purchase
<form:errors path="ordMethMode" cssClass="err"></form:errors>
Order Code:<form:input path="ordMethCode"/>
<form:errors path="ordMethCode" cssClass="err"></form:errors>
 Order Method:<form:select path="ordMethMethod">
<form:option value="">--select--</form:option>
<form:option value="FIFO">FIFO</form:option>
<form:option value="LIFO">LIFO</form:option>
<form:option value="FCFO">FCFO</form:option>
<form:option value="FEFO">FEFO</form:option>
</form:select>
<form:errors path="ordMethMethod" cssClass="err"></form:errors>
Order Accept:<form:checkbox path="ordMethAccept" value="Multi-Model"/>Multi-Model
             <form:checkbox path="ordMethAccept" value="AcceptReturn"/>AcceptReturn
       <form:errors path="ordMethAccept" cssClass="err"></form:errors>       
Description:<form:textarea path="ordMethDsc"/>
<form:errors path="ordMethDsc" cssClass="err"></form:errors>
<input type="submit" value="Create Order Method"/>
</pre>
</form:form>
${message }
</body>
</html>