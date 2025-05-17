package conexion;

import modelos.Estudiante;
import java.sql.*;
import java.util.*;
import modelos.Asesoria;
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

    public static boolean verificaMatricula(String identificador) {
        boolean existe = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "SELECT 1 FROM alumnos WHERE matricula = '" + identificador + "' LIMIT 1";
            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            if (resultado.next()) {
                existe = true;
            }
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

    public static Boolean guardarCita(Asesoria asesoria) {

        int id;
        String nombre, contrasena, correo;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();
            String sqlCad = "INSERT INTO asesorias (nombre_completo, matricula, programa, profesor_id, materia_id, fecha, hora, asunto, alumno_profesor) "
                    + "VALUES ('" + asesoria.getNombreCompleto() + "', '"
                    + asesoria.getMatricula() + "', '"
                    + asesoria.getPrograma() + "', "
                    + asesoria.getIdDocente() + ", "
                    + asesoria.getIdMateria() + ", '"
                    + asesoria.getFecha() + "', '"
                    + asesoria.getHora() + "', '"
                    + asesoria.getAsunto() + "', "
                    + asesoria.getEsAlumno() + ")";

            int resultado = SentenciaSQL.executeUpdate(sqlCad);
            SentenciaSQL.close();
            Conexion.close();

            if (resultado > 0) {
                return true;
            }

        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static List<Asesoria> getAsesoriasPorEstudiante(String matricula) {

        List<Asesoria> asesorias = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();

            String sqlCad = "SELECT "
                    + "a.idAsesoria, "
                    + "a.nombre_completo, "
                    + "a.matricula, "
                    + "a.programa, "
                    + "m.idMateria, "
                    + "p.idProfesor, "
                    + "a.fecha, "
                    + "a.hora, "
                    + "a.asunto, "
                    + "a.alumno_profesor, "
                    + "a.estado, "
                    + "a.comentario_profesor, "
                    + "a.fecha_solicitud, "
                    + "m.idMateria, "
                    + "m.nombre AS materiaNombre, "
                    + "p.idProfesor, "
                    + "p.nombre AS docenteNombre "
                    + "FROM asesorias a "
                    + "JOIN materias m ON a.materia_id = m.idMateria "
                    + "JOIN profesores p ON a.profesor_id = p.idProfesor "
                    + "WHERE a.matricula = '" + matricula + "'";

            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            while (resultado.next()) {
                Asesoria asesoria = new Asesoria();

                asesoria.setId(resultado.getInt("idAsesoria"));
                asesoria.setNombreCompleto(resultado.getString("nombre_completo"));
                asesoria.setMatricula(resultado.getString("matricula"));
                asesoria.setPrograma(resultado.getString("programa"));
                asesoria.setIdDocente(resultado.getInt("idProfesor"));
                asesoria.setIdMateria(resultado.getInt("idMateria"));
                asesoria.setFecha(resultado.getString("fecha"));
                asesoria.setHora(resultado.getString("hora"));
                asesoria.setAsunto(resultado.getString("asunto"));
                asesoria.setEsAlumno(resultado.getInt("alumno_profesor"));
                asesoria.setEstado(resultado.getString("estado"));
                asesoria.setComentario(resultado.getString("comentario_profesor"));
                asesoria.setFechaSolicitud(resultado.getString("fecha_solicitud"));
                asesoria.setNombreMateria(resultado.getString("materiaNombre"));
                asesoria.setNombreDocente(resultado.getString("docenteNombre"));

                asesorias.add(asesoria);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return asesorias;
    }

    public static List<Asesoria> getAsesoriasPorDocente(int identificador) {

        List<Asesoria> asesorias = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();

            String sqlCad = "SELECT "
                    + "a.idAsesoria, "
                    + "a.nombre_completo, "
                    + "a.matricula, "
                    + "a.programa, "
                    + "m.idMateria, "
                    + "p.idProfesor, "
                    + "a.fecha, "
                    + "a.hora, "
                    + "a.asunto, "
                    + "a.alumno_profesor, "
                    + "a.estado, "
                    + "a.comentario_profesor, "
                    + "a.fecha_solicitud, "
                    + "m.idMateria, "
                    + "m.nombre AS materiaNombre, "
                    + "p.idProfesor, "
                    + "p.nombre AS docenteNombre "
                    + "FROM asesorias a "
                    + "JOIN materias m ON a.materia_id = m.idMateria "
                    + "JOIN profesores p ON a.profesor_id = p.idProfesor "
                    + "WHERE p.idProfesor  = '" + identificador + "'";

            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            while (resultado.next()) {
                Asesoria asesoria = new Asesoria();

                asesoria.setId(resultado.getInt("idAsesoria"));
                asesoria.setNombreCompleto(resultado.getString("nombre_completo"));
                asesoria.setMatricula(resultado.getString("matricula"));
                asesoria.setPrograma(resultado.getString("programa"));
                asesoria.setIdDocente(resultado.getInt("idProfesor"));
                asesoria.setIdMateria(resultado.getInt("idMateria"));
                asesoria.setFecha(resultado.getString("fecha"));
                asesoria.setHora(resultado.getString("hora"));
                asesoria.setAsunto(resultado.getString("asunto"));
                asesoria.setEsAlumno(resultado.getInt("alumno_profesor"));
                asesoria.setEstado(resultado.getString("estado"));
                asesoria.setComentario(resultado.getString("comentario_profesor"));
                asesoria.setFechaSolicitud(resultado.getString("fecha_solicitud"));
                asesoria.setNombreMateria(resultado.getString("materiaNombre"));
                asesoria.setNombreDocente(resultado.getString("docenteNombre"));

                asesorias.add(asesoria);
            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return asesorias;
    }

    public static Asesoria getAsesoriaPorId(int idAsesoria) {

        Asesoria asesoria = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();

            String sqlCad = "SELECT "
                    + "a.idAsesoria, "
                    + "a.nombre_completo, "
                    + "a.matricula, "
                    + "a.programa, "
                    + "m.idMateria, "
                    + "p.idProfesor, "
                    + "a.fecha, "
                    + "a.hora, "
                    + "a.asunto, "
                    + "a.alumno_profesor, "
                    + "a.estado, "
                    + "a.comentario_profesor, "
                    + "a.fecha_solicitud, "
                    + "m.idMateria, "
                    + "m.nombre AS materiaNombre, "
                    + "p.idProfesor, "
                    + "p.nombre AS docenteNombre "
                    + "FROM asesorias a "
                    + "JOIN materias m ON a.materia_id = m.idMateria "
                    + "JOIN profesores p ON a.profesor_id = p.idProfesor "
                    + "WHERE a.idAsesoria  = '" + idAsesoria + "'";

            ResultSet resultado = SentenciaSQL.executeQuery(sqlCad);

            if (resultado.next()) {
                asesoria = new Asesoria();

                asesoria.setId(resultado.getInt("idAsesoria"));
                asesoria.setNombreCompleto(resultado.getString("nombre_completo"));
                asesoria.setMatricula(resultado.getString("matricula"));
                asesoria.setPrograma(resultado.getString("programa"));
                asesoria.setIdDocente(resultado.getInt("idProfesor"));
                asesoria.setIdMateria(resultado.getInt("idMateria"));
                asesoria.setFecha(resultado.getString("fecha"));
                asesoria.setHora(resultado.getString("hora"));
                asesoria.setAsunto(resultado.getString("asunto"));
                asesoria.setEsAlumno(resultado.getInt("alumno_profesor"));
                asesoria.setEstado(resultado.getString("estado"));
                asesoria.setComentario(resultado.getString("comentario_profesor"));
                asesoria.setFechaSolicitud(resultado.getString("fecha_solicitud"));
                asesoria.setNombreMateria(resultado.getString("materiaNombre"));
                asesoria.setNombreDocente(resultado.getString("docenteNombre"));

            }

            resultado.close();
            Conexion.close();
            SentenciaSQL.close();
        } catch (ClassNotFoundException e) {
            System.out.println(" no encontrado");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return asesoria;
    }

    public static boolean actualizaAsesoria(int id, String estado, String comentario) {
        boolean actualizado = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/asesorias", "root", "");
            Statement SentenciaSQL = Conexion.createStatement();

            String sqlCad = "UPDATE asesorias SET estado = '" + estado + "', comentario_profesor = '" + comentario + "' WHERE idAsesoria = " + id;

            int filasAfectadas = SentenciaSQL.executeUpdate(sqlCad);

            if (filasAfectadas > 0) {
                actualizado = true;
            }

            SentenciaSQL.close();
            Conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador JDBC no encontrado: " + e);
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e);
        }

        return actualizado;
    }

}
