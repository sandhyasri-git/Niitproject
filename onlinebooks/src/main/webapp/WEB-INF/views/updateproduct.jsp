<%@include file="adminhome.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <div class="jumbotron"></div>
   
   <form:form method="POST" action="delete" CommandName="product">
   <table>
   <tr>
     <td>productid :</td>
     <td><form:input path="productid"/></td>
     
     <tr>
     <td>prodname :</td>
     <td><form:input path="prodname"/></td>
     
     <tr>
         <td>
    <tr>
     <td>price :</td>
     <td><form:input path="price"/></td>
   
   <tr>
     <td>quatity :</td>
     <td><form:input path="quatity"/></td>
     </tr>
   
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="reset" value="Reset"/>
        </td>
    </tr>
   </table>
   </form:form>
   </div>