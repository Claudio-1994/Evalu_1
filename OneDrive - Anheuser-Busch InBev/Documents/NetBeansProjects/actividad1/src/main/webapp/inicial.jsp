

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actividad Calificada 1 </h1>
        

        <form name="frmFormulario1" action="primerServlet" method="get">
            <label>Nombre</label>
           
            <input type="text" name="txtNombre" />

            <br>    
            <label>seccion</label>
            <input type="text" name="txtSeccion" />
            <br>
            <br><br>
            
            <input type="submit" value="Enviar">
            
        </form>
 
     
    </body>
</html>
