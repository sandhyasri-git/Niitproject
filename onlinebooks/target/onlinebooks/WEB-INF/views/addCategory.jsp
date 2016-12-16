<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>

<body>
<center>
<h2>Category Information</h2>
</center>


<form:form method="POST" action="addCategory" commandName="category">

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
<%@include file="footer.jsp" %>