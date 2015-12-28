<%-- 
    Document   : get flight
    Created on : Dec 27, 2015, 8:40:41 AM
    Author     : Khaled
--%>

<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editing Flight page</title>
        <link rel="stylesheet" type="text/css" href="styles/Style1.css">
    </head>
    <body>
        <%
            String cost = (String) request.getSession().getAttribute("Selectedcost");
            String flightID = (String) request.getSession().getAttribute("SelectedflightID");
            String name = (String) request.getSession().getAttribute("SelectedflightName");
            String source = (String) request.getSession().getAttribute("Selectedsource");
            String destination = (String) request.getSession().getAttribute("Selecteddestination");
            String aircraftID = (String) request.getSession().getAttribute("SelectedflightsAircraftID");
            String dept_place = (String) request.getSession().getAttribute("Selecteddept_place");
            Date fdate = (Date) request.getSession().getAttribute("Selectedfdate");
        %>
        <h1>Flight details</h1>

        <form>
            <table>
                <tr>
                    <td align ="right">Flight ID</td>
                    <td><p><%=flightID%></p></td>
                </tr>
                <tr>
                    <td align ="right">Name</td> <td><input type="text" name ="name" value=<%=name%>></td>
                </tr>
                <tr>
                    <td align ="right">Source</td> <td><input type="text" name ="source"value=<%=source%>></td>
                </tr>
                <tr>
                    <td align ="right">Destination</td><td><input type ="text" name ="destination"value=<%=destination%>></td>
                </tr>
                <tr>
                    <td align ="right">Date</td><td></td>
                </tr>
                <tr>
                    <td align ="right">Day</td> <td><input type="text" name ="day"></td>
                </tr>
                <tr>
                    <td align ="right">Month</td> <td><input type="text" name ="month"></td>
                </tr>
                <tr>
                    <td align ="right">Year</td> <td><input type="text" name ="year"></td>
                </tr>
                <tr>
                    <td align ="right">Departure Place</td><td><input type ="text" name ="dept_place"value=<%=dept_place%>></td>
                </tr>
                <tr>
                    <td align ="right">Cost</td><td><input type ="text" name ="cost"value=<%=cost%>></td>
                </tr> 
                <tr>
                    <td align ="right">Aircraft</td><td><input type ="text" name ="aircraftID"value=<%=aircraftID%>></td>
                </tr>
            </table>
        </form>
    </body>
</html>
