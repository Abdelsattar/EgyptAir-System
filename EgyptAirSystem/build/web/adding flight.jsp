<%-- 
    Document   : adding flight
    Created on : Dec 24, 2015, 5:41:46 AM
    Author     : Khaled
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding Flight page</title>
        <link rel="stylesheet" type="text/css" href="styles/Style1.css">
        <script>
            function validateForm() {
                var source = document.forms["flightForm"]["source"].value;
                var destination = document.forms["flightForm"]["destination"].value;
                var day = document.forms["flightForm"]["day"].value;
                var month = document.forms["flightForm"]["month"].value;
                var year = document.forms["flightForm"]["year"].value;
                var dept_place = document.forms["flightForm"]["dept_place"].value;
                var cost = document.forms["flightForm"]["cost"].value;
                var aircraftID = document.forms["flightForm"]["aircraftID"].value;
                var name = document.forms["flightForm"]["name"].value;
                
                if (name == null || name == "") {
                    alert("Name must be filled out");
                    return false;
                }
                if (source == null || source == "") {
                    alert("Source must be filled out");
                    return false;
                }
                if (destination == null || destination == "") {
                    alert("Destination must be filled out");
                    return false;
                }
                if (day == null || day == "") {
                    alert("Day must be filled out");
                    return false;
                }
                if (day <1 || day >31) {
                    alert("Invalid Day value");
                    return false;
                }
                if (month == null || month == "") {
                    alert("Month must be filled out");
                    return false;
                }
                if (month <1 || month >12) {
                    alert("Invalid month value");
                    return false;
                }
                if (year == null || year == "") {
                    alert("Year must be filled out");
                    return false;
                }
                if (year <2015 || year >2016) {
                    alert("Invalid year value");
                    return false;
                }
                if (dept_place == null || dept_place == "") {
                    alert("Depature Place must be filled out");
                    return false;
                }
                if (cost == null || cost == "") {
                    alert("cost must be filled out");
                    return false;
                }
                if (cost < 200)
                {
                    alert("cost cannot be less than 200 LE");
                    return false;
                }
                if (aircraftID == null || aircraftID == "") {
                    alert("Aircraft must be filled out");
                    return false;
                }
                return true;
            }

        </script>
    </head>
    <body>
        <h1>Flight details</h1>
        <form name="flightForm" action ="flights.AddFlightDB" onsubmit="return validateForm();">
            <table>
                <tr>
                    <td align ="right">Name</td> <td><input type="text" name ="name"></td>
                </tr>
                <tr>
                    <td align ="right">Source</td> <td><input type="text" name ="source"></td>
                </tr>
                <tr>
                    <td align ="right">Destination</td><td><input type ="text" name ="destination"></td>
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
                    <td align ="right">Departure Place</td><td><input type ="text" name ="dept_place"></td>
                </tr>
                <tr>
                    <td align ="right">Cost</td><td><input type ="text" name ="cost"></td>
                </tr> 
                <tr>
                    <td align ="right">Aircraft</td><td><input type ="text" name ="aircraftID"></td>
                </tr> 
                <tr>
                    <td></td><td align ="right"><input type ="submit" value ="Add flight" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
