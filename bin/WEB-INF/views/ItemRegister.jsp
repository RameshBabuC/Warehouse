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
<h2>Welcome to Item Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="item">
<pre>
Item Code:<form:input path="itmCode"/>
Item Dimensions:W<form:input path="itmWidth" size="10"/>L<form:input path="itmLength"  size="10"/>h<form:input path="itmHeight" size="10"/>
 Base Cost:<form:input path="itmCost"/>
 Base Currency:<form:select path="itmCurrency">
<form:option value="">--select--</form:option>
<form:option value="INR">INR</form:option>
<form:option value="USD">USD</form:option>
<form:option value="AUS">AUS</form:option>
<form:option value="ERU">ERU</form:option>
</form:select>
Item Uom:<form:select path="uom.umId">
<form:option value="">--SELECT--</form:option>
<form:options items="${uoms}" itemLabel="umModel" itemValue="umId"/>
</form:select>
<input type="submit" value="Create Item"/>
</pre>
</form:form>
${message }
</body>
</html>