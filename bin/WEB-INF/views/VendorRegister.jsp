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
<h2>Welcome to Vendor Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="vendor">
<pre>
Vendor Name:<form:input path="venName"/>
Vendor Code:<form:select path="venCode">
            <form:option value="">--SELECT--</form:option>
            <form:option value="CAT">CAT</form:option>
            <form:option value="RES">RES</form:option>
</form:select>
Designation:<form:radiobutton path="venDesg" value="Sale"/>Sale
<form:radiobutton path="venDesg" value="Service"/>Service
<form:radiobutton path="venDesg" value="Both"/>Both
Preserve:<form:checkbox path="venPreserve" value="A"/>A
<form:checkbox path="venPreserve" value="B"/>B
 <form:checkbox path="venPreserve" value="C"/>C
 <input type="submit" value="Create Vendor"/>
 </pre>
</form:form>
${message }
</body>
</html>