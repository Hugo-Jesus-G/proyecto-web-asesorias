 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h1>INCIA SESION !</h1>

        <%
            String error = request.getParameter("error");
            if (error != null && error.equals("1")) {
        %>
        <p style="color:red;">Usuario no existe</p>
        <%
            }
        %>

        <form action="loginServlet" method="post">
            <label for="matricula">Matrícula/ID:</label><br>
            <input type="text" id="matricula" name="matricula" required><br><br>

            <label for="contrasena">Contraseña:</label><br>
            <input type="password" id="contrasena" name="contrasena" required><br><br>

            <input type="submit" value="Ingresar">
        </form>

</body>
</html>
