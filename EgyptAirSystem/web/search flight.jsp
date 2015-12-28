<%-- 
    Document   : search flight
    Created on : Dec 28, 2015, 5:06:00 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="searchFlight">
            <input type="text" name="input">
            <select name="criteria">
                <option value="dest">Destination </option>
                <option value="src">Source</option>
                <option value="flightPlace"> Flight Place</option>
                <option value="cost">Cost</option>
            </select>   
            <input type="submit" value="Search">
        </form>
       
    </body>
</html>
