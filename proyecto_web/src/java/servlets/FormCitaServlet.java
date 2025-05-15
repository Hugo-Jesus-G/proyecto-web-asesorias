/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import conexion.Conexion;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import modelos.Docente;
import modelos.Materia;

@WebServlet(urlPatterns = {"/formCitaServlet"})
public class FormCitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Materia> materias = Conexion.getMaterias();
        List<Docente> docentes = Conexion.getDocentes();
        request.setAttribute("materias", materias);
        request.setAttribute("docentes", docentes);
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }
    
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recuperar los datos del formulario
        String nombre = request.getParameter("nombre");
        String matricula = request.getParameter("matricula");
        String programa = request.getParameter("programa");
        int materiaId = Integer.parseInt(request.getParameter("materia"));
        int profesorId = Integer.parseInt(request.getParameter("profesor"));
        String esAlumno = request.getParameter("esAlumno");
        boolean esAlumnoValor = esAlumno.equals("Si");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String asunto = request.getParameter("asunto");
        
        
    }

}
