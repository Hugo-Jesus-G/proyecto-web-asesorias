<%@page import="modelos.Estudiante"%>
<%@ page import="java.util.List" %>
<%@ page import="modelos.Asesoria" %>

<%
     List<Asesoria> asesorias = (List<Asesoria>) request.getAttribute("asesorias");

    Estudiante alumno = (Estudiante) request.getAttribute("alumno");
%>

<h2>Mis Asesorías</h2>
<h2>Bienvenido <%= alumno.getNombre()%> </h2>
<% if (asesorias != null && !asesorias.isEmpty()) { %>
<table>
    <thead>
        <tr>

            <th>Nombre Materua</th>
            <th>Nombre Docente</th>
            <th>Fecha de cita</th>
            <th>Hora de cita</th>
            <th>Asunto</th>
            <th>Estado</th>
            <th>Comentario del docente</th>
            <th>Eres alumno del Docente</th>

        </tr>
    </thead>
    <tbody>
        <% for (Asesoria asesoria : asesorias) {%>
        <tr>
            <td><%= asesoria.getNombreMateria()%></td>
            <td><%= asesoria.getNombreDocente()%></td>
            <td><%= asesoria.getFecha()%></td>
            <td><%= asesoria.getHora()%></td>
            <td><%= asesoria.getAsunto()%></td>
            <td><%= asesoria.getEstado()%></td>
            <td><%= asesoria.getComentario()%></td>
            <td>
                <%= asesoria.getEsAlumno() == 1 ? "sí" : "no"%>
            </td>

        </tr>
        <% } %>
    </tbody>
</table>
<% } else { %>
<p>No tienes asesorías programadas.</p>
<% }%>


<a href="CerrarSesionServlet">Cerrar sesión</a>
