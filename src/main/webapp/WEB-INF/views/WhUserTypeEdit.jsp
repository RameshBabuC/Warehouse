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
<h2>Welcome to WhUserType Update Page</h2>
<form:form action="update" method="POST" modelAttribute="whUserType">
<pre>
ID:<form:input path="whUsrTypId" readOnly="true"/>
 UserType :<form:radiobutton path="whUsrTypType" value="Vendor"/>Vendor
           <form:radiobutton path="whUsrTypType" value="Customer"/>Customer
 User Code:<form:input path="whUsrTypCode"/>
 User For :<form:radiobutton path="whUrsTypForType" value="Purchase"/>Purchase
           <form:radiobutton path="whUrsTypForType" value="Sale"/>Sale
 User Email:<form:input path="whUsrTypEmail"/>
 User Contact:<form:input path="whUsrTypContact"/>
 User ID Type:<form:select path="whUsrTypIdType">
<form:option value="">--select--</form:option>
<form:option value="PANCARD">PANCARD</form:option>
<form:option value="AADHAR">AADHAR</form:option>
<form:option value="VOTER ID">VOTER ID</form:option>
<form:option value="OTHER">OTHER</form:option>
</form:select>
If Other:<form:input path="whUsrTypIfOther"/>
ID Number:<form:input path="whUsrTypIdNum"/>
<input type="submit" value="Update User"/>
</pre>
</form:form>
${message }
</body>
</html>