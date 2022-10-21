

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pequeño Formulario</h1>
        

        <form name="frmFormulario1" action="primerServlet" method="get">
            <label>Nombre</label>
            <input type="text" name="txtnombre" />
            <br>    
            <label>Apellido</label>
            <input type="text" name="txtapellido" />
            <br>
           <label>Edad</label>
            <input type="text" name="txtedad" />
            <br><br>
            <input type="submit" value="Enviar">
            
        </form>
 
     
    </body>
</html>
