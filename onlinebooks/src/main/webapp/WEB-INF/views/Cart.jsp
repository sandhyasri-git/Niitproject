<%@include file="header.jsp" %>

<style>
body{background: url('resources/images/pro.jpg') no-repeat center center fixed;
     background-size: cover;
}
</style>

<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl"> <!-- //AngularJS -->
 
   <hr></hr>
   <table class="table table-striped">
   <tr>
   <th>Id</th>
   <th>Product Name</th>
   <th>Product Price</th>
   <!-- <th>Quantity</th> -->
   <th>Product Image</th>
   </tr>
       <tr>
           <td>${product.productid}</td>
           <td>${product.prodname}</td>
           <td>${product.price}</td>
           <%-- <td>${product.quatity}</td> --%>
           <td><img src="resources/images/${product.prodname}.jpg" style=height:100px;width:100px;"/></td>
           
                <!--  <td><a href="Cart">Add to Cart</a></td> -->
   </tr>
   </table>
  </div>
  </div>




