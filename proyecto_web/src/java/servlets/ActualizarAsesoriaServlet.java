/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ActualizarAsesoriaServlet", urlPatterns = {"/ActualizarAsesoriaServlet"})
public class ActualizarAsesoriaServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idAsesoria = Integer.parseInt(request.getParameter("idAsesoria"));
        String estado = request.getParameter("estado");
        String comentario = request.getParameter("comentario");

        boolean actualizado = Conexion.actualizaAsesoria(idAsesoria, estado, comentario);

        if (actualizado) {
            response.sendRedirect("CargaAsesoriasServlet");
        } else {
            request.setAttribute("mensaje", " Error al actualizar la asesoría.");
        }

    }
}
