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
<h2>Welcome to Uom Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="uom">
<pre>
 Uom Type:<form:select path="umType">
<form:option value="">--select--</form:option>
<form:option value="PACKING">packing</form:option>
<form:option value="NO PACKING">No Packing</form:option>
<form:option value="NA">--NA--</form:option>
</form:select>
<form:errors path="umType" cssClass="err"></form:errors>
Uom Model:<form:input path="umModel"/>
<form:errors path="umModel" cssClass="err"></form:errors>
Description:<form:input path="umDsc"/>
<form:errors path="umDsc" cssClass="err"></form:errors>
<input type="submit" value="Create Uom"/>
</pre>
</form:form>
${message }
</body>
</html>