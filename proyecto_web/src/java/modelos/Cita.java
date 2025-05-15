/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class Cita{

private int id;
private int idAlumno;
private int idDocente;
private int idMateria;
private String fecha;
private String hora;
private String asunto;
private int esAlumno;
private String estado;
private String comentario;

    public Cita(int id, int idAlumno, int idDocente, int idMateria, String fecha, String hora, String asunto, int esAlumno, String estado, String comentario) {
        this.id = id;
        this.idAlumno = idAlumno;
        this.idDocente = idDocente;
        this.idMateria = idMateria;
        this.fecha = fecha;
        this.hora = hora;
        this.asunto = asunto;
        this.esAlumno = esAlumno;
        this.estado = estado;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getEsAlumno() {
        return esAlumno;
    }

    public void setEsAlumno(int esAlumno) {
        this.esAlumno = esAlumno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }








}