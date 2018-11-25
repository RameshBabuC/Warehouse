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
<h2>Welcome to Customer Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="customer">
<pre>
Customer Code:<form:input path="custCode"/>
Address:<form:textarea path="custAddr"/>
Locations:<form:select path="custLocs" multiple="true">
           <form:option value="HYD">Hyderabad</form:option>
           <form:option value="BAN">Banglore</form:option>
           <form:option value="CHN">Chennai</form:option>
</form:select>
Enable Customer:<form:radiobutton path="custEnabled" value="Yes"/>Yes
                <form:radiobutton path="custEnabled" value="No"/>No
Customer Email:<form:input path="custEmail"/>
Customer Contact:<form:input path="custContact"/>
<input type="submit" value="Create Customer"/>
</pre>
</form:form>
${message }
</body>
</html>