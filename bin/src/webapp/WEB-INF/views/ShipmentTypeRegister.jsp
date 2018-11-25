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
<h2>Welcome to ShipmentType Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="shipmentType">
<pre>

 Shipment Mode:<form:select path="shipTypMode">
<form:option value="">--select--</form:option>
<form:option value="AIR">Air</form:option>
<form:option value="TRUCK">Truck</form:option>
<form:option value="SHIP">Ship</form:option>
<form:option value="TRAIN">Train</form:option>
</form:select>
Shipment Code:<form:input path="shipTypCode"/>
Enable Shipment:<form:checkbox path="shipTypEnabled" value="YES"/>yes
      Shipment Grade:<form:radiobutton path="shipTypGrade" value="A"/>A
                      <form:radiobutton path="shipTypGrade" value="B"/>B
                      <form:radiobutton path="shipTypGrade" value="C"/>C
Description:<form:textarea path="shipTypDsc"/>
<input type="submit" value="Create Shipment"/>
</pre>
</form:form>
${message }
</body>
</html>