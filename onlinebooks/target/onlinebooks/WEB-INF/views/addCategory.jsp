<%@include file="adminheader.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
    <title>Spring MVC Form Handling</title>
     <style>
body{background: url('resources/images/addcat.jpg') no-repeat center center fixed;
     background-size: cover;
}
</style>
</head>

<body>
<center>
<h2>Category Information</h2>
<form:form action="addCategory" commandName="category">
		<table>
   
   <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
		
			<c:if test="${!empty category.name}">
			
				<tr>
					<td><form:label path="catid">
				ID
			</form:label></td>
					<td><form:input path="catid" readonly="true" size="8"
							disabled="true"/> <form:hidden path="catid" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
				Category Name
			</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
			Category Description
			</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
			
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit" value="Edit category" />
				 	</c:if></td> 
				 	<td><c:if test="${empty category.name}">
						<input type="submit" value="Add category" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th>category ID</th>
				<th width="120">category Name</th>
				<th width="120">category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.catid}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a
						href="<c:url value='/editcategory${category.catid}' />">Edit</a></td>
					<td><a
						href="<c:url value='/deletecategory${category.catid}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>




<%-- <%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<center>
<h2>Category Information</h2>
</center>


<form:form method="POST" action="addCat" commandName="category">

   <table>
   <tr>
        <td><form:label path="name">Categoy Name</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description"/></td>
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
</html>
<%@include file="footer.jsp" %> --%>