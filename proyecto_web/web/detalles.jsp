<%@page import="modelos.Docente"%>
<%@ page import="java.util.List" %>
<%@ page import="modelos.Asesoria" %>

<%
    Asesoria asesoria = (Asesoria) request.getAttribute("asesoria");
%>

<h2>Mis Asesorías</h2>
<%
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) {
%>
<div style="color: red; font-weight: bold;"><%= mensaje%></div>
<%
    }
%>


<% if (asesoria != null) {%>
<form action="ActualizarAsesoriaServlet" method="post">
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
                <th>Estado Actual(<%= asesoria.getEstado()%>)</th>
                <th>Comentario</th>
                <th>Es tu alumno</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= asesoria.getNombreCompleto()%></td>
                <td><%= asesoria.getMatricula()%></td>
                <td><%= asesoria.getPrograma()%></td>
                <td><%= asesoria.getNombreMateria()%></td>
                <td><%= asesoria.getFecha()%></td>
                <td><%= asesoria.getHora()%></td>
                <td><%= asesoria.getAsunto()%></td>

                <td>
                    <select name="estado">
                        <% if ("en proceso".equals(asesoria.getEstado())) {%>
                        <option value="<%= asesoria.getEstado()%>" selected><%= asesoria.getEstado()%></option>
                        <% }%>

                        <option value="Aceptada" <%= asesoria.getEstado().equals("Aceptada") ? "selected" : ""%>>Aceptada</option>

                        <option value="Rechazada" <%= asesoria.getEstado().equals("Rechazada") ? "selected" : ""%>>Rechazada</option>
                    </select>
                </td>

                <td>
                    <textarea name="comentario" rows="4" cols="50"><%= asesoria.getComentario()%></textarea>
                </td>

                <td>
                    <%= asesoria.getEsAlumno() == 1 ? "sí" : "no"%>
                </td>
            </tr>
        </tbody>
    </table>

    <input type="hidden" name="idAsesoria" value="<%= asesoria.getId()%>">
    <input type="submit" value="Actualizar Asesoría">
</form>

<% }%>

<a href="CargaAsesoriasServlet">Regresar</a>
