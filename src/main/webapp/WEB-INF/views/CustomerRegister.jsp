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
<h2>Welcome to Customer Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="customer">
<pre>
Customer Code:<form:input path="custCode"/>
<form:errors path="custCode" cssClass="err"></form:errors>
Address:<form:textarea path="custAddr"/>
<form:errors path="custAddr" cssClass="err"></form:errors>
Locations:<form:select path="custLocs" multiple="true">
           <form:option value="HYD">Hyderabad</form:option>
           <form:option value="BAN">Banglore</form:option>
           <form:option value="CHN">Chennai</form:option>
</form:select>
<form:errors path="custLocs" cssClass="err"></form:errors>
Enable Customer:<form:radiobutton path="custEnabled" value="Yes"/>Yes
                <form:radiobutton path="custEnabled" value="No"/>No
                <form:errors path="custEnabled" cssClass="err"></form:errors>
Customer Email:<form:input path="custEmail"/>
<form:errors path="custEmail" cssClass="err"></form:errors>
Customer Contact:<form:input path="custContact"/>
<form:errors path="custContact" cssClass="err"></form:errors>
<input type="submit" value="Create Customer"/>
</pre>
</form:form>
${message }
</body>
</html>