
<%@page import="modelos.Docente"%>
<%@ page import="java.util.List" %>
<%@ page import="modelos.Asesoria" %>

<%
    List<Asesoria> asesorias = (List<Asesoria>) request.getAttribute("asesorias");

    Docente docente = (Docente) request.getAttribute("docente");
%>

<h2>Mis Asesorías</h2>
<h2>Bienvenido <%= docente.getNombre()%> </h2>
<% if (asesorias != null && !asesorias.isEmpty()) { %>
<table>
    <thead>
        <tr>
            <th>Nombre del Alumno</th>
            <th>Matricula</th>
            <th>Programa</th>

            <th>Nombre de la Materia</th>

            <th>Fecha de cita</th>
            <th>Hora de cita</th>
            <th>Asunto</th>
            <th>Estado</th>
            <th>Comentario </th>
            <th>Es tu alumno</th>
            <th>Ver mas</th>
        </tr>
    </thead>
    <tbody>
        <% for (Asesoria asesoria : asesorias) {%>
        <tr>

            <td><%= asesoria.getNombreCompleto()%></td>
            <td><%= asesoria.getMatricula()%></td>
            <td><%= asesoria.getPrograma()%></td>
            <td><%= asesoria.getNombreMateria()%></td>

            <td><%= asesoria.getFecha()%></td>
            <td><%= asesoria.getHora()%></td>
            <td><%= asesoria.getAsunto()%></td>
            <td><%= asesoria.getEstado()%></td>
            <td><%= asesoria.getComentario()%></td>
            <td>
                <%= asesoria.getEsAlumno() == 1 ? "sí" : "no"%>
            </td>

           
            <td>
                <a href="verDetalles?id=<%= asesoria.getId()%>">Ver detalles</a>
            </td>
           

        </tr>
        <% } %>




    </tbody>
</table>
<% } else { %>
<p>No tienes asesorías programadas.</p>
<% }%>


<a href="CerrarSesionServlet">Cerrar sesión</a>
