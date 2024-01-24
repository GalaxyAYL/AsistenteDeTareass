package Modelo;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SQLtarea {

    public String cargarDatos(Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        String resultado;

        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT nombre FROM usuarios where idusuarios=?");
            ps.setInt(1, usuario.getId());

            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getString("nombre");
            } else {
                resultado = "Algo paso dentro";
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            resultado = "Mal ingreso, algo fallo";
        }

        return resultado;
    }

    public boolean crearTarea(Usuario usuario, Tarea tarea) {
        Conexion con = new Conexion();
        PreparedStatement ps;

        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("INSERT INTO tareas (titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe) VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, tarea.getTitulo());
            ps.setDate(2, tarea.getFecha_creacion());
            ps.setDate(3, tarea.getFecha_limite());
            ps.setString(4, tarea.getDescripcion());
            ps.setString(5, tarea.getImportancia());
            ps.setString(6, tarea.getEstado());
            ps.setInt(7, usuario.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tarea agregadaaaaa");
            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            System.err.println("Mal subida a db, algo fallo");
        }
        return true;
    }

    public ResultSet llenarTabla(Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe FROM tareas WHERE id_usuarioJefe=?;");
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet llenarTablaPendientes(Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe FROM tareas WHERE estado=? AND id_usuarioJefe=?;");
            ps.setString(1, "Pendiente");
            ps.setInt(2, usuario.getId());
            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet llenarTablaFechas(Tarea tarea, Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe FROM tareas WHERE id_usuarioJefe=? AND fecha_limite BETWEEN ? AND ?;");
            ps.setInt(1, usuario.getId());
            ps.setDate(2, tarea.getFecha_creacion());
            ps.setDate(3, tarea.getFecha_limite());

            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet buscarSupremo(Tarea tarea, Usuario usuario) {
        Conexion con = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ConnectionImpl conexion = con.getConnection();
            ps = conexion.prepareStatement("SELECT titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe FROM tareas WHERE id_usuarioJefe=? AND fecha_limite BETWEEN ? AND ?;");
            ps.setInt(1, usuario.getId());
            ps.setDate(2, tarea.getFecha_creacion());
            ps.setDate(3, tarea.getFecha_limite());

            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            return null;
        }
    }

}
