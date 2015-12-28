<%-- 
    Document   : adminHome
    Created on : Dec 20, 2015, 5:01:28 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home Page</title>
        <link rel="stylesheet" type="text/css" href="Style.css">
    </head>
    <body>
        <h1>Admin Operations</h1>
        <form action="adding aircraft.jsp">
            <input type="submit" value="Add an aircraft">
        </form>
        <br><br>
        <form action="getAircrafts">
            <input type="submit" value="update aircraft">
        </form>
        <br><br>
        <form action="adding flight.jsp">
            <input type="submit" value="Add Flight">
        </form>
        <br><br>
        <form action="Show flights Admin.jsp">
            <input type="submit" value="Show Flight">
        </form>

    </body>
</html>
