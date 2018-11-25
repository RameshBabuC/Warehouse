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
<h2>Welcome to Item Register Page</h2>
<form:form action="update" method="POST" modelAttribute="item">
<pre>
ID             :  <form:input path="itmId" readOnly="true"/>
Item Code      :  <form:input path="itmCode"/>
                  <form:errors path="itmCode" cssClass="err"></form:errors>
Item Dimensions: W<form:input path="itmWidth" size="10"/>    L<form:input path="itmLength"  size="10"/>    h<form:input path="itmHeight" size="10"/>
                  <form:errors path="itmLength" cssClass="err"></form:errors>
Base Cost      :  <form:input path="itmCost"/>
                  <form:errors path="itmCost" cssClass="err"></form:errors>
Base Currency  :  <form:select path="itmCurrency">
                  <form:option value="">--select--</form:option>
                  <form:option value="INR">INR</form:option>
                  <form:option value="USD">USD</form:option>
                  <form:option value="AUS">AUS</form:option>
                  <form:option value="ERU">ERU</form:option>
                  </form:select>
                  <form:errors path="itmCurrency" cssClass="err"></form:errors>
Item Uom       :  <form:select path="uom.umId">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${uoms}" itemLabel="umModel" itemValue="umId"/>
                  </form:select>
                  <form:errors path="uom" cssClass="err"></form:errors>
OrderMethod    :  (Sale Type)
                  <form:select path="omSale.ordMethId">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${sales }" itemLabel="ordMethCode" itemValue="ordMethId"/>
                  </form:select>
                  <form:errors path="omSale" cssClass="err"></form:errors>
OrderMethod    :  (Purchase Type)
                  <form:select path="omPurchase.ordMethId">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${purchases }" itemLabel="ordMethCode" itemValue="ordMethId"/>
                  </form:select>
                  <form:errors path="omPurchase" cssClass="err"></form:errors>
 Item Vendors  :
                  <form:select path="venUsers" multiple="true">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${vendors }" itemLabel="whUsrTypCode" itemValue="whUsrTypId"/>
                  </form:select>
                  <form:errors path="venUsers" cssClass="err"></form:errors>
 Item Customers:
                  <form:select path="custUsers" multiple="true">
                  <form:option value="">--SELECT--</form:option>
                  <form:options items="${customers }" itemLabel="whUsrTypCode" itemValue="whUsrTypId"/>
                  </form:select> 
                  <form:errors path="custUsers" cssClass="err"></form:errors>         
<input type="submit" value="Update Item"/>
</pre>
</form:form>
${message }
</body>
</html>