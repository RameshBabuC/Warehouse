<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to PurchaseOrder Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="purchaseOrder">
<pre>
Order Code       :<form:input path="prchsOrderCode"/>
Shipment Code    :<form:select path="shipment.shipTypId">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${shipmentEnables}" itemLabel="shipTypCode" itemValue="shipTypId"/>
                  </form:select>
Vendor           :<form:select path="userVendors">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${vendors }" itemLabel="whUsrTypCode" itemValue="whUsrTypId"/>
                  </form:select>
Reference Number :<form:input path="prchsRefNum"/>  
Quality Check    :<form:radiobutton path="prchsQltyCheck" value="Required"/>Required
                  <form:radiobutton path="prchsQltyCheck" value="Not Required"/>Not Required
Default status   :<form:input path="prchsDfltStatus" value="OPEN" readOnly="true"/>  
Description      :<form:textarea path="prchsDsc"/>
<input type="submit" value="Place Order"/>                    
</pre>
</form:form>
${message}
</body>
</html>