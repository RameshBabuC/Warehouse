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
<h2>Welcome to WhUserType Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="whUserType">
<pre>
 UserType :<form:radiobutton path="whUsrTypType" value="Vendor"/>Vendor
           <form:radiobutton path="whUsrTypType" value="Customer"/>Customer
           <form:errors path="whUsrTypType" cssClass="err"></form:errors>
 User Code:<form:input path="whUsrTypCode"/>
            <form:errors path="whUsrTypCode" cssClass="err"></form:errors>
 User For :<form:radiobutton path="whUrsTypForType" value="Purchase"/>Purchase
           <form:radiobutton path="whUrsTypForType" value="Sale"/>Sale
           <form:errors path="whUrsTypForType" cssClass="err"></form:errors>
 User Email:<form:input path="whUsrTypEmail"/>
            <form:errors path="whUsrTypEmail" cssClass="err"></form:errors>
 User Contact:<form:input path="whUsrTypContact"/>
            <form:errors path="whUsrTypContact" cssClass="err"></form:errors>
 User ID Type:<form:select path="whUsrTypIdType">
<form:option value="">--select--</form:option>
<form:option value="PANCARD">PANCARD</form:option>
<form:option value="AADHAR">AADHAR</form:option>
<form:option value="VOTER ID">VOTER ID</form:option>
<form:option value="OTHER">OTHER</form:option>
</form:select>
           <form:errors path="whUsrTypIdType" cssClass="err"></form:errors>
If Other:<form:input path="whUsrTypIfOther"/>
ID Number:<form:input path="whUsrTypIdNum"/>
           <form:errors path="whUsrTypIdNum" cssClass="err"></form:errors>
<input type="submit" value="Create User"/>
</pre>
</form:form>
${message }
</body>
</html>