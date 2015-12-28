<%-- 
    Document   : LoginUser
    Created on : Dec 25, 2015, 7:01:06 PM
    Author     : leila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="userHome.jsp">
            Name : <input type="text" name="nameUser"> <br>
            Password : <input type="password" name="passwordUser"> <br>
            <input type="submit" value="Login" name="loginUser">
        </form>
    </body>
</html>
