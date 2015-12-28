<%-- 
    Document   : adding aircraft
    Created on : Dec 20, 2015, 5:21:23 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding aircraft page</title>
         <link rel="stylesheet" type="text/css" href="Style1.css">
         <script type="text/javascript" src="aircraftFormVaildation.js"></script>
         <script>
             
             function validateForm() {
                var model = document.forms["aircraftForm"]["model"].value;
                var name = document.forms["aircraftForm"]["name"].value;
                var weight = document.forms["aircraftForm"]["weight"].value;
                var country = document.forms["aircraftForm"]["country"].value;
                var seatsNum = document.forms["aircraftForm"]["seats"].value;
                var classesNum = document.forms["aircraftForm"]["classes"].value;
                if ( model == null || model== "") {
                    alert("model must be filled out");
                    return false;
                }
                if (name == null || name == "") {
                    alert("Name must be filled out");
                    return false;
                }
                if (name.length <=2) {
                    alert("Name must be bigger than 3 char");
                    return false;
                }
                
                if (weight == null || weight== "") {
                    alert("weight must be filled out");
                    return false;
                }if (country == null || country == "") {
                    alert("country must be filled out");
                    return false;
                }if (seatsNum == null || seatsNum == "") {
                    alert("seatsNum must be filled out");
                    return false;
                }if (classesNum == null || classesNum == "") {
                    alert("classes must be filled out");
                    return false;
                }
				return true;
            }
            
          </script>
     </head>
    <body>
      <h1>Aircraft details</h1>
      <!-- action ="confirm adding aircraft.html"--> 
      <form name="aircraftForm"  action = "addAirCarftDB" onsubmit="return validateForm()">
	     <table>
   		    <tr>
   		      <td align ="right">Model</td>
                      <td><input type="text" name ="model"></td>
   		    </tr> <tr>
   		      <td align ="right">Name</td>
                      <td><input type="text" name ="name"></td>
   		    </tr>
   		    <tr>
   		    	<td align ="right">Manufacturer country</td>
                        <td><input type ="text" name ="country"></td>
   		    </tr>
                    <tr>
                      <td align ="right">Weight</td> 
                      <td><input type="number" name ="weight"></td>
                    </tr>
                    <tr>
                      <td align ="right">Number of Seats</td>
                      <td><input type ="number" name ="seats"></td>
                    </tr>
                    <tr>
                      <td align ="right">Number of Classes</td>
                      <td><input type ="number" name ="classes"></td>
                    </tr> 
   		    <tr>
   		    	<td></td><td align ="right">
                        <input type ="submit" value ="Add Aircraft" ></td>
   		    </tr>
         </table>
      </form>
    </body>
</html>
