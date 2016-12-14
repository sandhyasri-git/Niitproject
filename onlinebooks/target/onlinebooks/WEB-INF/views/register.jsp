<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Spring MVC Form Handling</title>
    
    <style>
body{background: url('resources/images/reg.jpg') no-repeat center center fixed;
     background-size: cover;
}
</style>
</head>
<body>
<center>
  <h3>Registration</h3>
<%-- <p>ALREADY REGISTERED? <a href= "login">login</a></>
<a href="${flowExecutionUrl}&_eventId_home">Home</a>  --%>
<form:form commandName="us">
  
<table>

<tr padding="50"><td>
Enter Name</td><td><form:input type="text" path="username"/></td></tr>
 <!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('username')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
				
		

<tr padding="50"><td>

Enter Password</td><td><form:input type="password" path="password"/></td></tr>
<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
				
			

<tr padding="50"><td>
Enter Confirmed Password</td><td><form:input type="password" path="confirmpassword"/></td></tr>
<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach>
				
		
<tr padding="50"><td>
Phone no.</td><td><form:input type="text" path="emailid"/></td></tr>
<!-- to display validation messages -->
			<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
                
                <br>
				

<tr padding="50"><td>
Email id</td><td> <form:input type="text" path="phno"/></td></tr>

<!-- to display validation messages -->
				<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('phno')}" var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
				
				<br>

<tr><td>
<input type="CHECKBOX" NAME="OFFER" CHECKED>I agree to receive information about exciting offers
</td></tr>
<tr>
   <td><input type="submit" name="_eventId_submit" value="Submit"/></td>
   
</tr>
</center>

</table>
<br/><br/>
</form:form>
