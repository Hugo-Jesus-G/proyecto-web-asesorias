package conexion;

import modelos.Estudiante;
import java.sql.*;
import java.util.*;
import modelos.Cita;
import modelos.Docente;
import modelos.Materia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Conexion {

    public static Estudiante getEstudiante(String identificador, String pass) {
        int id;
        String nombre, contrasena, programa, matricula;
        Estudiante alumno = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT * FROM alumnos WHERE matricula = '" + identificador + "' AND contrasena = '" + pass + "'";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            if (resultado.next()) {
                id = resultado.getInt("idAlumno");
                matricula = resultado.getString("matricula");
                nombre = resultado.getString("nombre");
                contrasena = resultado.getString("contrasena");
                programa = resultado.getString("programaEducativo");
                alumno = new Estudiante(id, nombre, matricula, programa, contrasena);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return alumno;
    }

    public static Docente getDocente(String identificador, String pass) {
        int id;
        String nombre, contrasena, correo;
        Docente docente = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT * FROM profesores WHERE idProfesor = '" + identificador + "' AND contrasena = '" + pass + "'";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            if (resultado.next()) {
                id = resultado.getInt("idProfesor");
                nombre = resultado.getString("nombre");
                contrasena = resultado.getString("contrasena");
                correo = resultado.getString("correo");
                docente = new Docente(id, nombre, correo, contrasena);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docente;
    }

    public static Boolean verificaMatricula(String matricula) {
        boolean existe = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT 1 FROM alumnos WHERE matricula = '" + matricula + "' LIMIT 1";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            existe = resultado.next();
            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return existe;
    }

    public static List<Materia> getMaterias() {
        int id;
        List<Materia> materias = new ArrayList<>();
        String nombre;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT * FROM materias ";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            while (resultado.next()) {
                id = resultado.getInt("idMateria");
                nombre = resultado.getString("nombre");
                Materia materia = new Materia(id, nombre);
                System.out.println("materuas " + materia);
                materias.add(materia);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return materias;
    }

    public static List<Docente> getDocentes() {

        List<Docente> docentes = new ArrayList<>();
        int id;
        String nombre, contrasena, correo;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT * FROM profesores ";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            while (resultado.next()) {
                id = resultado.getInt("idProfesor");
                nombre = resultado.getString("nombre");
                contrasena = resultado.getString("contrasena");
                correo = resultado.getString("correo");
                Docente docente = new Docente(id, nombre, correo, contrasena);

                docentes.add(docente);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return docentes;
    }

    public static Boolean guardarCita(Cita cita) {

        List<Docente> docentes = new ArrayList<>();
        int id;
        String nombre, contrasena, correo;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT * FROM profesores ";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            while (resultado.next()) {
                id = resultado.getInt("idProfesor");
                nombre = resultado.getString("nombre");
                contrasena = resultado.getString("contrasena");
                correo = resultado.getString("correo");
                Docente docente = new Docente(id, nombre, correo, contrasena);

                docentes.add(docente);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
