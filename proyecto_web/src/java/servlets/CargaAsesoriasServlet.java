/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Asesoria;
import modelos.Docente;
import modelos.Estudiante;

@WebServlet(name = "CargaAsesoriasServlet", urlPatterns = {"/CargaAsesoriasServlet"})
public class CargaAsesoriasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rol = (String) request.getSession().getAttribute("rol");

        if ("estudiante".equals(rol)) {
            Estudiante estudiante = (Estudiante) request.getSession().getAttribute("usuario");
            String matricula = estudiante.getMatricula();

            List<Asesoria> asesorias = Conexion.getAsesoriasPorEstudiante(matricula);

            request.setAttribute("alumno", estudiante);
            request.setAttribute("asesorias", asesorias);

            RequestDispatcher dispatcher = request.getRequestDispatcher("alumno.jsp");
            dispatcher.forward(request, response);

        } else if ("docente".equals(rol)) {
            Docente docente = (Docente) request.getSession().getAttribute("usuario");

            int id = docente.getId();

            List<Asesoria> asesorias = Conexion.getAsesoriasPorDocente(id);

            request.setAttribute("docente", docente);
            request.setAttribute("asesorias", asesorias);

            RequestDispatcher dispatcher = request.getRequestDispatcher("docente.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
