package Modelo;

import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLusuario {

    public boolean registrar(Usuario usuario) {
        Conexion con = new Conexion();

        PreparedStatement ps;

        try {

            //Metodo de conexion a la BS
            ConnectionImpl conexion = con.getConnection();
            //Prepared estatement para la conexion con DB
            ps = conexion.prepareStatement("insert into usuarios (nombreUsuario,passwd,nombre,correo,idTipo_usuarios) values (?,?,?,?,?)");

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
            ps = conexion.prepareStatement("select count(id) from usuarios where nombreUsuario=?");

            ps.setString(1, nombreUsuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

            System.err.println(e.getMessage());
            return 1;

        }
        return 1;

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

    public boolean iniciarSesion(Usuario usuario) {
        Conexion con = new Conexion();

        PreparedStatement ps;
        ResultSet rs;

        try {

            //Metodo de conexion a la BS
            ConnectionImpl conexion = con.getConnection();
            //Prepared estatement para la conexion con DB
            ps = conexion.prepareStatement("select id, nombreUsuario, passwd, nombre, idTipo_usuario from usuarios where nombreUsuario=?");

            ps.setString(1, usuario.getNombreUsuario());

            rs = ps.executeQuery();
            if (rs.next()) {
                if(usuario.getPasswd().equals(rs.getString("passwd"))){
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                    usuario.setIdTipo_usuario(rs.getInt("idTipo_usuario"));
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else{
                System.err.println("Uusario no encontrado");
                return false;
            }
        } catch (Exception e) 
        {
            return false;
        }

    }
    
}
