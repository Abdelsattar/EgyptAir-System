<%-- 
    Document   : Show flights Admin
    Created on : Dec 24, 2015, 5:42:51 AM
    Author     : Khaled
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flights</title>
        <link rel="stylesheet" type="text/css" href="styles/Sytle Tables.css">
        <script>
            function validateForm() {
                var flightID = document.forms["Edit"]["flightID"].value;
                if (flightID == null || flightID == "") {
                    alert("ID must be filled out");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <%
            ArrayList<String> flightIDs
                    = (ArrayList<String>) request.getSession().getAttribute("flightIDs");
            ArrayList<String> flightNames
                    = (ArrayList<String>) request.getSession().getAttribute("flightNames");
            ArrayList<String> destinations
                    = (ArrayList<String>) request.getSession().getAttribute("destinations");
            ArrayList<String> sources
                    = (ArrayList<String>) request.getSession().getAttribute("sources");
            ArrayList<String> dept_places
                    = (ArrayList<String>) request.getSession().getAttribute("dept_places");
            ArrayList<Date> fdates
                    = (ArrayList<Date>) request.getSession().getAttribute("fdates");
            ArrayList<String> flightsAircraftnames
                    = (ArrayList<String>) request.getSession().getAttribute("flightsAircraftNames");
            ArrayList<String> costs
                    = (ArrayList<String>) request.getSession().getAttribute("costs");
        %>
        <h1>Flights</h1>
        <table border ="2">
            <tr>
                <td align ="center">ID </td> 
                <td align ="center">Source </td>
                <td align ="center">Destination</td>
                <td align ="center">Date</td>
                <td align ="center">Departure Place</td>
                <td align ="center">Cost</td>
                <td align ="center">Aircraft ID</td>
            </tr>
            <%
                for (int i = 0; i < flightIDs.size(); i++) {
            %>
            <tr>
                <td><%=flightIDs.get(i)%></td>
                <td><%=sources.get(i)%></td>
                <td><%=destinations.get(i)%></td>
                <td><%=fdates.get(i)%></td>
                <td><%=dept_places.get(i)%></td>
                <td><%=costs.get(i)%></td>
                <td><%=flightsAircraftnames.get(i)%></td>

            </tr>   
            <%}%>
        </table>
        <form name="Edit" action="getflight" onsubmit="return validateForm();">
            Enter Flight ID to Edit : <input type="text" name ="flightID">
            <input type="submit" value ="Edit Flight">
        </form>
    </body>
</html>
