<%-- 
    Document   : edit aircraft
    Created on : Dec 21, 2015, 1:19:41 PM
    Author     : Mohammed
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editing aircraft page</title>
        <link rel="stylesheet" type="text/css" href="Style1.css">
    </head>
    <body>
        <%
           // boolean checkDB = (boolean) request.getSession().getAttribute("aircraftexsit");
                String model = (String) request.getSession().getAttribute("model");
                String name = (String) request.getSession().getAttribute("name");
                String weight =( String) request.getSession().getAttribute("weight");
                String country = (String) request.getSession().getAttribute("country");
                String seatsNum = (String) request.getSession().getAttribute("seats");
                String classes = (String) request.getSession().getAttribute("classes");
            %>
      <h1>Aircraft details</h1>
      <form action = "updateAircraft">
	     <table>
                   <tr>
                       <td align ="right">Name</td>
                       <td><input type="text" name ="name" value ="<%= name %>" ></td>
   		    </tr>
   		    <tr>
   			   <td align ="right">Model</td>
                           <td><input type="text" name ="model" value ="<%= model %>" ></td>
   		    </tr>
                     
   		    <tr>
   		    	<td align ="right">Manufacturer country</td>
                        <td><input type ="text" name ="country" value ="<%= country %>"></td>
   		    </tr>
                    <tr>
                      <td align ="right">Weight</td>
                      <td><input type="text" name ="weight" value ="<%= weight %>" ></td>
                    </tr>
                    <tr>
                      <td align ="right">Number of Seats</td>
                      <td><input type ="text" name ="seats" value ="<%= seatsNum %>"></td>
                    </tr>
                    <tr>
                      <td align ="right">Number of Classes</td>
                      <td><input type ="text" name ="classes" value ="<%= classes %>"></td>
                    </tr> 
   		    <tr>
   		    	<td></td><td align ="right">
                            <input type ="submit" value ="Update Aircraft" ></td>
   		    </tr>
         </table>
      </form>
    </body>
</html>
