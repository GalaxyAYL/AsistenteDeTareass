
package Modelo;

import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.ResultSet;


public class SQLusuario {
    public boolean registrar(Usuario usuario){
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
    
    
    public int verificarUsuario(String nombreUsuario){
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
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            return 1;
            
        }
        return 1;
        
    }
    
}
