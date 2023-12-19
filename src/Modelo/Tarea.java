
package Modelo;


public class Tarea {
    
    private String fecha;
    private String titulo;
    private String descripcion;
    private boolean realizado;

    public Tarea(String fecha, String titulo, String descripcion, boolean realizado) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.realizado = realizado;
    }
    
    
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }
    
    
    
    
    
}
