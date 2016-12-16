<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
  <script type="text/javascript">
  var app = angular.module('myApp', []);

	function MyController($scope, $http) {
		$scope.sortType = 'name'; // set the default sort type
		$scope.sortReverse = false; // set the default sort order
		$scope.searchPTitle = '';

		$scope.getDataFromServer = function() {
			$http({
				method : 'GET',
				url : 'GsonCon'
			}).success(function(data, status, headers, config) {
				$scope.prod = data;
			}).error(function(data, status, headers, config) {
				// called asynchronously if an error occurs
				// or server returns response with an error status.
			});
		};
	};
  
  </script>
  </head>
  <body>
  
  <div class="container" ng-app="myApp" ng-controller="MyController" ng-init="getDataFromServer()">

  <form>
    <div class="form-group">
      <div class="input-group">
        <div class="input-group-addon"><i class="fa fa-search"></i></div>
       <input type="text" class="form-control" placeholder="Search Product Name" ng-model="searchPTitle">      
       </div>      
    </div>
  </form>
  <table class="table table-hover" style="min-width:1200px">
   <thead>
      <tr>
      <td>
          <a href="#" ng-click="sortType = 'productid'; sortReverse = !sortReverse">
            Product Id 
            <span ng-show="sortType == 'productid' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'productid' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'productname'; sortReverse = !sortReverse">
            Product Name 
            <span ng-show="sortType == 'productname' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'productname' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'quatity'; sortReverse = !sortReverse">
          Quantity
            <span ng-show="sortType == 'quatity' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'quatity' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
        <td>
          <a href="#" ng-click="sortType = 'price'; sortReverse = !sortReverse">
          Price
            <span ng-show="sortType == 'price' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'price' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         <td>
          <a href="#" ng-click="sortType = 'more'; sortReverse = !sortReverse">
          Image
            <span ng-show="sortType == 'more' && !sortReverse" class="fa fa-caret-down"></span>
            <span ng-show="sortType == 'more' && sortReverse" class="fa fa-caret-up"></span>
          </a>
        </td>
         </tr>
    </thead>
     <tbody>
      <tr ng-repeat="p1 in prod | orderBy:sortType:sortReverse | filter:searchPTitle">
           		<td>{{p1.productid}}</td>
           		<td>{{p1.prodname}}</td>
           		<td>{{p1.quatity}}</td>
           		<td>{{p1.price}}</td>
           		<td><img src="resources/images/{{p1.prodname}}.jpg" style="height:100px;width:100px"></td>
           		
   
    <td><a href="deleteproduct&{{p1.productid}}">Delete</a></td>
    <td><a href="updateproduct&{{p1.productid}}">Edit</a></td>
    </tr>
    </tbody>
    </table>
  <center><a href="addProduct"><h1 align="center"><h3><font color="Black">Back</a></center>
</div>


