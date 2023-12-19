
package Modelo;

import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import javax.swing.JOptionPane;


public class SQLusuario {
    public boolean registrar(Usuario usuario){
        Conexion con = new Conexion();
        
        PreparedStatement ps;
        
        try {
            
            ConnectionImpl conexion = con.getConnection();
            JOptionPane.showMessageDialog(null, "paso 1 bien");
            
            ps = conexion.prepareStatement("insert into usuarios (nombreUsuario,passwd,nombre,correo,idTipo_usuarios) values (?,?,?,?,?)");
            
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPasswd());
            ps.setString(3, usuario.getNick());
            ps.setString(4, usuario.getCorreo());
             
            ps.setInt(5, usuario.getIdTipo_usuario());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Hasta aqui todo bien");
            
            return true;
        } catch (Exception e) {
            
            System.err.println(e.getMessage());
            return false;
        }
        
    }
}
