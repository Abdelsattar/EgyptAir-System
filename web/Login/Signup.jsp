<%-- 
    Document   : Signup
    Created on : Dec 25, 2015, 6:58:18 PM
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
        <script>
            function valid (form){
                if(form.name.value == ""){
                    alert("Enter Name");
                    return false;
                }
                if(form.password.value == ""){
                    alert("Enter password");
                    return false;
                }
                if(form.email.value == ""){
                    alert("Enter Email");
                    return false;
                }
                if(form.creditCard.value == ""){
                    alert("Enter credit card");
                    return false;
                }
                if(isNaN(form.phone.value) && isNaN(form.creditCard.value)){
                    alert("phone and credit card should be numbers only");
                    return false;
                }
            }
        </script>
        <form action="LoginUser.jsp" onsubmit="return valid(this);">
            Name : <input type="text" name="name"> <br>
            Password : <input type="password" name="password"> <br>
            Email : <input type="text" name="email"> <br>
            phone : <input type="number" name="phone"> <br>
            credit card : <input type="number" name="creditCard"> <br>
            <input type="submit" value="Signup" name="signup">
        </form>
    </body>
</html>
