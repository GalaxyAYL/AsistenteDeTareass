
package Modelo;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    
    private static String usuario = "root";
    private static String passwd = "root";
    private static String rute = "jdbc:mysql://localhost:3306/db_asistente?autoReconnet=true";
    
    public ConnectionImpl getConnection (){
        ConnectionImpl conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (ConnectionImpl) DriverManager.getConnection(rute, usuario, passwd);
            JOptionPane.showMessageDialog(null, "Conexion exitosa MYSQL");
        } catch (Exception e) {
            System.err.println("Error"+ e);
        }
        return conexion;
    }
    
}
