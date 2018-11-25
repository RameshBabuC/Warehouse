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
<h2>Welcome to Uom Register Page</h2>
<form:form action="update" method="POST" modelAttribute="uom">
<pre>
ID:<form:input path="umId" readOnly="true"/>
 Uom Type:<form:select path="umType">
<form:option value="">--select--</form:option>
<form:option value="PACKING">packing</form:option>
<form:option value="NO PACKING">No Packing</form:option>
<form:option value="NA">--NA--</form:option>
</form:select>
Uom Model:<form:input path="umModel"/>
Description:<form:input path="umDsc"/>
<input type="submit" value="Create Uom"/>
</pre>
</form:form>
${message }
</body>
</html>