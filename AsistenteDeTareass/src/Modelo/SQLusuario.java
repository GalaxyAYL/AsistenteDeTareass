package Modelo;

import java.sql.PreparedStatement;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLusuario {

    private static ConnectionImpl conexion; //ESTANCIA DE CONEXION
    private static Conexion con; //ESTANCIA DE CONEXION CON NUESTRAS CREDENCIALES
    private static PreparedStatement ps; //OBJETO DE SENTENCIA INICIAL
    private static ResultSet rs; //OBJETO DE SENTENCIA RESULTANTE

    //METODO REGISTRAR USUARIO
    public boolean registrar(Usuario usuario) {
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES

        try {

            conexion = con.getConnection();//CONEXION CON DB CON NUETSRAS CREDENCIALES

            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            ps = conexion.prepareStatement("insert into usuarios (nombreUsuario,passwd,nombre,correo ,idTipo_usuarios) values (?,?,?,?,?)");

            ps.setString(1, usuario.getNombreUsuario());    //INSERTAR EN NOMBRE USUARIO
            ps.setString(2, usuario.getPasswd());           //INSERTAR EN PASSWD
            ps.setString(3, usuario.getNick());             //INSERTAR EN NICK
            ps.setString(4, usuario.getCorreo());           //INSERTAR EN CORREO
            ps.setInt(5, usuario.getIdTipo_usuario());      //INSERTAR ID TIPO USUARIO

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            ps.executeUpdate();
            conexion.close();//CIERRE DE CONEXION MYSQL
            return true; //Return true, si se envio el registro crrectamente
        } catch (Exception e) {
            return false;//Return false, si no se envio el registro crrectamente
        }

    }

    //METODO VERIFICAR USUARIOS
    public int verificarUsuario(String nombreUsuario) {
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES

        try {
            conexion = con.getConnection();//CONEXION CON DB CON NUETSRAS CREDENCIALES

            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            ps = conexion.prepareStatement("select count(idusuarios) from usuarios where nombreUsuario=?");
            ps.setString(1, nombreUsuario);

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            rs = ps.executeQuery();
            if (rs.next()) {            //EN CASO DE QUE EXISTAN RESULTADOS
                return rs.getInt(1);    //EN CASO DE QUE SI EXISTA
            } else {
                return 1;               //EN CASO DE QUE NO EXISTA
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 1;

        }
    }

    //METODO PARA COMPROBRAR EMAIL
    public boolean comprobarEmail(String correo) {
        //PATRON DE JAVA PARA EMAIL
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        //ENCUENTRO DE PATRON
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

    //METODO PARA INICIAR SESION
    public Usuario iniciarSesion(Usuario usuario) {
        Usuario usuarioAutenticado = new Usuario();
        PreparedStatement ps1;
        con = new Conexion(); //CONEXION CON DB CON NUETSRAS CREDENCIALES

        try {
            conexion = con.getConnection();

            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            ps = conexion.prepareStatement("SELECT idusuarios, nombreUsuario, passwd from usuarios where nombreUsuario=?");
            ps.setString(1, usuario.getNombreUsuario());                    //INSERTAR EN TITULO

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            rs = ps.executeQuery();

            if (rs.next()) {
                if (usuario.getPasswd().equals(rs.getString("passwd"))) {
                    usuarioAutenticado.setId(rs.getInt("idusuarios"));      //INSERTAR EN passwd
                    try {

                        //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
                        ps1 = conexion.prepareStatement("UPDATE usuarios SET ultima_sesion = ? WHERE idusuarios=?");
                        ps1.setString(1, usuario.getUltimaSesion());        //INSERTAR EN ULTIMA SESION
                        ps1.setInt(2, usuarioAutenticado.getId());          //INSERTAR EN ID USUARIO

                        //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
                        ps1.executeUpdate();

                    } catch (Exception e) {
                        System.err.println("Error: " + e);
                    }

                    return usuarioAutenticado;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

}
