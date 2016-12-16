<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
    <title>Spring MVC Form Handling</title>
    
    <style>
body{background: url('resources/images/product.jpg') no-repeat center center fixed;
     background-size: cover;
}
</style>
</head>

<body>
<center>
<h3>Product Information</h3>
</center>


<form:form method="POST" action="addProd" commandName="product" enctype="multipart/form-data">

   <table>
    <tr>
        <td><form:label path="prodname">ProductName</form:label></td>
        <td><form:input path="prodname"/></td>
    </tr>
    <tr>
        <td><form:label path="quatity">Quantity</form:label></td>
        <td><form:input path="quatity"/></td>
    </tr>
    <tr>
        <td><form:label path="price">Price</form:label></td>
        <td><form:input path="price"/></td>
    </tr>
    <tr>
				<td>Category</td>
				<td><form:select path="catid"
						items="${categoryList}" itemValue="catid" itemLabel="catid">
					</form:select></td>
	</tr>
       
     <tr>
				<td >Supplier</td>
				<td><form:select path="id"
						items="${supplierList}" itemValue="id" itemLabel="id">
					</form:select></td>
			</tr>
			
     
     <tr>
        <td ><form:label path="image">Image</form:label></td>
        <td><form:input type="file" path="image"/></td>
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

<center>
<h3> Product List</h3></center>


<c:if test="${!empty productList }">
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


       <tr>
           <th>Product Id</th>
           <th>Product Name</th>
           <th>Price</th>
           <th>Quantiy</th>
           <th>Category</th>
           <th>Supplier</th>
           <th>Edit</th>
           <th>Delete</th>
       </tr>
  <c:forEach items="${productList}" var="product">   
     <tr>
         <td>${product.productid}</td>
         <td>${product.prodname}</td>
         <td>${product.price}</td>
         <td>${product.quatity}</td>
         <td>${product.category.catid}</td>
         <td>${product.supplier.id}</td>
         <td><a href="<c:url value='updateproduct${product.productid}'/>">Edit</a></td>
         <td><a href="<c:url value='deleteproduct${product.productid}'/>">Delete</a></td>
         
        </tr>
    </c:forEach>
   </table>
   </c:if>
</body>
</html>
<%@include file="footer.jsp" %>