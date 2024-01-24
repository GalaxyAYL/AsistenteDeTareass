package Modelo;

import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class SQLusuario {

    public boolean registrar(Usuario usuario) {
        Conexion con = new Conexion();

        PreparedStatement ps;

        try {

            //Metodo de conexion a la BS
            ConnectionImpl conexion = con.getConnection();
            //Prepared estatement para la conexion con DB
            ps = conexion.prepareStatement("insert into usuarios (nombreUsuario,passwd,nombre,correo ,idTipo_usuarios) values (?,?,?,?,?)");

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPasswd());
            ps.setString(3, usuario.getNick());
            ps.setString(4, usuario.getCorreo());
            ps.setInt(5, usuario.getIdTipo_usuario());
            ps.executeUpdate();
            return true; //Return true, si se envio el registro crrectamente
        } catch (Exception e) {

            System.err.println(e.getMessage());
            return false;//Return false, si no se envio el registro crrectamente
        }

    }

    public int verificarUsuario(String nombreUsuario) {
        Conexion con = new Conexion();

        PreparedStatement ps;
        ResultSet rs;

        try {

            //Metodo de conexion a la BS
            ConnectionImpl conexion = con.getConnection();
            //Prepared estatement para la conexion con DB
            ps = conexion.prepareStatement("select count(idusuarios) from usuarios where nombreUsuario=?");

            ps.setString(1, nombreUsuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            else{
                return 1;
            }
        } catch (Exception e) {

            System.err.println(e.getMessage());
            return 1;

        }
    }

    public boolean comprobarEmail(String correo) {
        //PATRON DE JAVA PARA EMAIL
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        //ENCUENTRO DE PATRON
        Matcher mather = pattern.matcher(correo);
        
        return mather.find();
    }

    public Usuario iniciarSesion(Usuario usuario) {
        Usuario usuarioAutenticado = new Usuario();
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        PreparedStatement ps1;
        try {

            //Metodo de conexion a la BS
            ConnectionImpl conexion = con.getConnection();
            //Prepared estatement para la conexion con DB
            ps = conexion.prepareStatement("SELECT idusuarios, nombreUsuario, passwd from usuarios where nombreUsuario=?");

            ps.setString(1, usuario.getNombreUsuario());

            rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null, "Se encontro usuario --1");
            if (rs.next()) {
                if(usuario.getPasswd().equals(rs.getString("passwd"))){
                    usuarioAutenticado.setId(rs.getInt("idusuarios"));
                    JOptionPane.showMessageDialog(null, "ID USUARIO AUTENTICADO");
                    try {
                        ps1 = conexion.prepareStatement("UPDATE usuarios SET ultima_sesion = ? WHERE idusuarios=?");
                    ps1.setString(1, usuario.getUltimaSesion());  // Esto debería ser un valor de fecha y hora
                    ps1.setInt(2, usuarioAutenticado.getId());  // Usar el ID del usuario autenticado
                    ps1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Se actualizo bien la hora");
                    } catch (Exception e) {
                        System.err.println("Error: "+e);
                    }
                    
                    return usuarioAutenticado;
                }
                else
                {
                    return null;
                }
            }
            else{
                return null;
            }
        } catch (Exception e) 
        {
            return null;
        }

    }
    
}
