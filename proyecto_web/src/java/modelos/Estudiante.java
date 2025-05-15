package modelos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class Estudiante {

    private int idAlumno;
    private String nombre;
    private String matricula;
    private String carrera;
    private String contrasena;

    public Estudiante() {

    }

    public Estudiante(int idAlumno, String nombre, String matricula, String carrera, String contrasena) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.contrasena = contrasena;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
