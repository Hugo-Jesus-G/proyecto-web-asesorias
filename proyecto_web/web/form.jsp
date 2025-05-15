<%@ page import="java.util.*" %>
<%@ page import="modelos.Materia" %>
<%@ page import="modelos.Docente" %>
<%@ page import="conexion.Conexion" %>
<%

    List<Materia> materias = (List<Materia>) request.getAttribute("materias");
    List<Docente> docentes = (List<Docente>) request.getAttribute("docentes");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generar Cita de Asesoría</title>
</head>
<body>
    <h2>Generar Cita de Asesoría</h2>

    <form action="formCitaServlet" method="post">

        <label for="nombre">Nombre Completo:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="matricula">Matrícula:</label>
        <input type="text" id="matricula" name="matricula" required><br><br>

        <label for="programa">Programa Educativo:</label>
        <select id="programa" name="programa" required>
            <option value="ICC">ICC</option>
            <option value="LCC">LCC</option>
            <option value="ITI">ITI</option>
        </select><br><br>

        <label for="materia">Materia/Asignatura:</label>
        <select id="materia" name="materia" required>
            <%
                if (materias != null && !materias.isEmpty()) {
                    for (Materia m : materias) {
            %>
                        <option value="<%= m.getId() %>"><%= m.getNombre() %></option>
            <%
                    }
                } else {
            %>
                    <option disabled>No hay materias disponibles</option>
            <%
                }
            %>
        </select><br><br>

        <label for="profesor">Elección de Profesor:</label>
        <select id="profesor" name="profesor" required>
            <%
                if (docentes != null && !docentes.isEmpty()) {
                    for (Docente d : docentes) {
            %>
                        <option value="<%= d.getId() %>"><%= d.getNombre() %></option>
            <%
                    }
                } else {
            %>
                    <option disabled>No hay profesores disponibles</option>
            <%
                }
            %>
        </select><br><br>

        <label for="esAlumno">¿Es alumno del profesor elegido?</label><br>
        <input type="radio" id="siAlumno" name="esAlumno" value="Si" required>
        <label for="siAlumno">Sí</label><br>
        <input type="radio" id="noAlumno" name="esAlumno" value="No" required>
        <label for="noAlumno">No</label><br><br>

        <label for="fecha">Fecha de la Asesoría:</label>
        <input type="date" id="fecha" name="fecha" required><br><br>

        <label for="hora">Hora de la Asesoría:</label>
        <input type="time" id="hora" name="hora" required><br><br>

        <label for="asunto">Asunto:</label><br>
        <textarea id="asunto" name="asunto" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Generar Cita">
    </form>

</body>
</html>
