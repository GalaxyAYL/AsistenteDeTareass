
package Modelo;

import java.sql.Date;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String passwd;
    private String nick;
    private String correo;
    private String ultimaSesion;
    private int idTipo_usuario;

    
    
    
    
    
    
    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(String ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }


    public int getIdTipo_usuario() {
        return idTipo_usuario;
    }

    public void setIdTipo_usuario(int idTipo_usuario) {
        this.idTipo_usuario = idTipo_usuario;
    }
    
    
    
    
   
}
