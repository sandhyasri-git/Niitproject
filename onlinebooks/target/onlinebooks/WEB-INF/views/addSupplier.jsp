<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<center>
<h2>Supplier Information</h2>
<form:form action="addSup" commandName="supplier">
		<table>
			<c:if test="${!empty supplier.name}">
				<tr>
					<td><form:label path="id">
				ID
			</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true"/> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
				Supplier Name
			</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
			Supplier Address
			</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty supplier.name}">
						<input type="submit" value="Edit supplier" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit" value="Add supplier" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Suppliers List</h3>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th>supplier ID</th>
				<th width="120">supplier Name</th>
				<th width="120">supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a
						href="<c:url value='/editsupplier${supplier.id}' />">Edit</a></td>
					<td><a
						href="<c:url value='/deletesupplier${supplier.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

<%-- </center>


<form:form method="POST" action="addSupplier" commandName="supplier">

   <table>
    <tr>
        <td><form:label path="name">Supplier Name</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="address">Addr  ess</form:label></td>
        <td><form:input path="address"/></td>
    </tr>
     <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
    <tr>
    <td>
     <a href="logout">Logout</a>
     </td>
     </tr>
</table>  
</form:form>
</body>
</html> --%>
<%@include file="footer.jsp" %>