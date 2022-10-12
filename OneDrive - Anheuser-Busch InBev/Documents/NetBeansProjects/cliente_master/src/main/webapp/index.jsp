<%-- 
    Document   : index
    Created on : 11-10-2022, 20:51:51
    Author     : claudio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario Ingreso Clientes</h1>
        
        <form  name="formulario1" action="controller" method="get">
        
            <label>RUT</label><br>
            <input type="text" name="rutID" size="3" />
            <br>
            
            <label>Nombre</label><br>
            <input type="text" name="nombre_1" value="" />
            <br>
            
            <label>Apellido</label><br>
            <input type="text" name="apellido_1" value="" />
            <br>
            
            <label>Correo</label><br>
            <input type="text" name="correo_1" value="" />
            <br>
            
            <label>Comuna</label><br>
            <input type="text" name="comuna_1" value="" />
            <br>
            
            <input type="submit" value="Enviar" />
            
        </form>
        
    </body>
</html>
