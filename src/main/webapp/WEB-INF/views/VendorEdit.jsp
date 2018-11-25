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
<h2>Welcome to Vendor Update Page</h2>
<form:form action="update" method="POST" modelAttribute="vendor">
<pre>
ID:<form:input path="venId" readOnly="true"/>
Vendor Name:<form:input path="venName"/>
            <form:errors path="venName" cssClass="err"></form:errors>
Vendor Code:<form:select path="venCode">
            <form:option value="">--SELECT--</form:option>
            <form:option value="CAT">CAT</form:option>
            <form:option value="RES">RES</form:option>
            </form:select>
            <form:errors path="venCode" cssClass="err"></form:errors>
Designation:<form:radiobutton path="venDesg" value="Sale"/>Sale
            <form:radiobutton path="venDesg" value="Service"/>Service
            <form:radiobutton path="venDesg" value="Both"/>Both
            <form:errors path="venDesg" cssClass="err"></form:errors>
Preserve:<form:checkbox path="venPreserve" value="A"/>A
         <form:checkbox path="venPreserve" value="B"/>B
         <form:checkbox path="venPreserve" value="C"/>C
 <input type="submit" value="Update Vendor"/>
 </pre>
</form:form>
${message }
</body>
</html>