<%-- 
    Document   : testing
    Created on : 08/02/2017, 19:59:26
    Author     : emaramirez1306
--%>

<%@page import="com.ramsys.ejb.TasktypeFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="http://localhost:16535/RSTaskManager-war/rest/rsusers" method="POST">
            <input type="text" name="nombre">
            <input type="Submit" value="Verificar AFIP">
        </form> 

        <form action="http://localhost:16535/RSTaskManager-war/rest/rsusers" method="GET">
            <input type="Submit" value="Verificar GET">
        </form> 
    </body>
</html>
