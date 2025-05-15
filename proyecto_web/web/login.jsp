 
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

        <%@ page import="java.util.*" %>
        <%@ page import="java.sql.*" %>
        <%@ page import="modelos.Materia" %> <!-- Asegúrate de importar la clase Materia -->

        <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>Lista de Materias</title>
        </head>
        <body>
            <h1>Materias disponibles:</h1>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Creamos la lista de materias
                        List<Materia> materias = new ArrayList<>();
                        String url = "jdbc:mysql://localhost:3306/asesorias";
                        String user = "root";
                        String password = "";
                        Connection conn = null;
                        Statement stmt = null;
                        ResultSet rs = null;

                        try {
                            // Establecer la conexión
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            conn = DriverManager.getConnection(url, user, password);

                            // Crear la sentencia SQL
                            String sql = "SELECT * FROM materias";
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);

                            // Recorrer el ResultSet y agregar las materias a la lista
                            while (rs.next()) {
                                int id = rs.getInt("idMateria");
                                String nombre = rs.getString("nombre");
                                Materia materia = new Materia(id, nombre);
                                materias.add(materia);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            // Cerrar recursos
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                                if (stmt != null) {
                                    stmt.close();
                                }
                                if (conn != null) {
                                    conn.close();
                                }
                            } catch (SQLException se) {
                                se.printStackTrace();
                            }
                        }

                        // Mostrar las materias en la tabla
                        for (Materia materia : materias) {
                    %>
                    <tr>
                        <td><%= materia.getId()%></td>
                        <td><%= materia.getNombre()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </body>
    </html>

</body>
</html>
