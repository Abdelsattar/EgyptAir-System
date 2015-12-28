<%-- 
    Document   : show aircrafts
    Created on : Dec 20, 2015, 10:53:57 PM
    Author     : Mohammed
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aircrafts</title>
        <link rel="stylesheet" type="text/css" href="Sytle Tables.css">
    </head>
    <body>
        <%
            boolean checkDB = (boolean) request.getSession().getAttribute("checkaircrfts");
           // if(checkDB){
                 ArrayList<String> models = 
                    (ArrayList<String>) request.getSession().getAttribute("MODELS");
                ArrayList<String> names = 
                        (ArrayList<String>) request.getSession().getAttribute("NAMES");
                ArrayList<String> weights = 
                        (ArrayList<String>) request.getSession().getAttribute("WEIGHTS");
                ArrayList<String> countries = 
                        (ArrayList<String>) request.getSession().getAttribute("COUNTRIES");
                ArrayList<String> seats = 
                        (ArrayList<String>) request.getSession().getAttribute("SEATS");
                ArrayList<String> aircraftsIDs = 
                        (ArrayList<String>) request.getSession().getAttribute("AIRCRAFTSIDs");
                ArrayList<String> classes = 
                        (ArrayList<String>) request.getSession().getAttribute("CLASSES");
         //   } 
           
            
            %>
        <h1>Aircrafts</h1>
        <form>
	<table border ="2">
            <tr>
                <td align ="center">ID </td> 
                <td align ="center">Model </td>
                <td align ="center">Name </td>
                <td align ="center">Manufacturer country</td>
                <td align ="center">Weight</td>
                <td align ="center">Number of Seats</td>
                <td align ="center">Number of Classes</td>
            <td></td>
            <td></td>
            </tr>
            <tr>
             <%
                 if(checkDB && models.size() !=0){
                     for(int i=0 ; i<models.size() ; i ++){
                        out.print("<td>"+ aircraftsIDs.get(i) + "</td>");
                        out.print("<td>"+ models.get(i) +  "</td>");
                        out.print("<td>"+ names.get(i) + "</td>");
                        out.print("<td>"+ countries.get(i) + "</td>");
                        out.print("<td>"+ weights.get(i) + "</td>");
                        out.print("<td>"+ seats.get(i) + "</td>"); 
                        out.print("<td>"+ classes.get(i) + "</td>");
                        out.print("<input type=\"radio\" name=\"radio1\" value=\""+ i + "\">");
                        // ana 3ayz bas ab3t el i we henak a2der agebhom mn el arrays
//                        out.print("<form action =\"edit aircraft.jsp\">");
//                        out.print("     <td align=\"center\"><input type=\"submit\" value =\"Update\"></td>"); 
//                        out.print("</form>");
//                        
//                        //m4 3aref a3mlha wla la lanha ht5ed w2t aw m7taga eny ams7 elly raw abo el id dh 
//                        // la isa htb2a zay el update m4 7war
//                        out.print("<form action =\"confirm deleting aircraft.html\">");
//                        out.print("     <td align=\"center\"><input type=\"submit\" value =\"Delete\"></td>");
//                        out.print("</form>");
                     }
                     
                 } else{
                 %>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            <br><br><br><br><br>
            <h2> there is no aircrafts to show </h>
                <%}%>
            </tr>
        </table>
     </form>

    </body>
</html>
