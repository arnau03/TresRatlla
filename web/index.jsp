<%-- 
    Document   : index
    Created on : 12-feb-2013, 19:25:12
    Author     : trivium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <form action="buscarPartida" method='POST'>
            <input type='text' name='nick'>${errorn}</br>
            <input type='submit' value='start'> ${errorp}
        </form>
    </body>
</html>
