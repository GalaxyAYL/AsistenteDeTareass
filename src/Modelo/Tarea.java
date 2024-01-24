
package Modelo;

import java.sql.Date;


public class Tarea {
    
    private int id_tareas;
    private String titulo;
    private Date fecha_creacion;
    private Date fecha_limite;
    private String descripcion;
    private String importancia;
    private String estado;
    private int id_usuarioJefe;

    public int getId_tareas() {
        return id_tareas;
    }

    public void setId_tareas(int id_tareas) {
        this.id_tareas = id_tareas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_usuarioJefe() {
        return id_usuarioJefe;
    }

    public void setId_usuarioJefe(int id_usuarioJefe) {
        this.id_usuarioJefe = id_usuarioJefe;
    }

    
    
    
}
