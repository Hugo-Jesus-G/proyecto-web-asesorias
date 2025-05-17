package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Docente;
import modelos.Estudiante;

@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Estudiante estudiante = new Estudiante();
        Docente docente = new Docente();

        String identificador = request.getParameter("matricula");
        String contrasena = request.getParameter("contrasena");

        estudiante = Conexion.getEstudiante(identificador, contrasena);
        docente = Conexion.getDocente(identificador, contrasena);
        if (estudiante != null) {
            sesion.setAttribute("usuario", estudiante);
            sesion.setAttribute("rol", "estudiante");
            response.sendRedirect("CargaAsesoriasServlet");
        } else if (docente != null) {
            sesion.setAttribute("usuario", docente);
            sesion.setAttribute("rol", "docente");
            response.sendRedirect("CargaAsesoriasServlet");

        } else {
            response.sendRedirect("login.jsp?error=1");
        }

    }

}
