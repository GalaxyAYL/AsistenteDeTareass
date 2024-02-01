package Modelo;

import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class SQLtarea {

    private static ConnectionImpl conexion; //ESTANCIA DE CONEXION
    private static Conexion con; //ESTANCIA DE CONEXION CON NUESTRAS CREDENCIALES
    private static PreparedStatement ps; //OBJETO DE SENTENCIA INICIAL
    private static ResultSet rs; //OBJETO DE SENTENCIA RESULTANTE

    //METODO COMPROBAR CONEXION DE USUARIOS
    public String cargarDatos(Usuario usuario) {
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES
        String resultado;

        try {
            conexion = con.getConnection();//CONEXION CON DB CON NUETSRAS CREDENCIALES
            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            ps = conexion.prepareStatement("SELECT nombre FROM usuarios where idusuarios=?");
            ps.setInt(1, usuario.getId());          //INSERTAR ID TIPO

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            rs = ps.executeQuery();
            if (rs.next()) {            //EN CASO DE QUE EXISTAN RESULTADOS
                resultado = rs.getString("nombre"); //OBTENER COLUMNA NOMBRE
            } else {
                resultado = "Algo paso dentro";
            }

        } catch (Exception e) {
            System.err.println("Error: " + e);
            resultado = "Mal ingreso, algo fallo";
        }

        return resultado;
    }

    //METODO CREAR METODO
    public boolean crearTarea(Usuario usuario, Tarea tarea) {
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES

        try {
            conexion = con.getConnection();//CONEXION CON DB CON NUETSRAS CREDENCIALES

            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            ps = conexion.prepareStatement("INSERT INTO tareas (titulo,fecha_creacion,fecha_limite,descripcion,importancia,estado,id_usuarioJefe) VALUES (?,?,?,?,?,?,?);");//SENTENCIA DE BUSQUEDA INICIO
            ps.setString(1, tarea.getTitulo());           //INSERTAR EN TITULO
            ps.setDate(2, tarea.getFecha_creacion());     //INSERTAR EN FECHA CREACION
            ps.setDate(3, tarea.getFecha_limite());       //INSERTAR EN FECHA LIMITE
            ps.setString(4, tarea.getDescripcion());      //INSERTAR EN DESCRIPCION
            ps.setString(5, tarea.getImportancia());      //INSERTAR EN IMPORTANCIA
            ps.setString(6, tarea.getEstado());           //INSERTAR EN ESTADO
            ps.setInt(7, usuario.getId());                //INSERTAR EN ID_USUARIO
            ps.executeUpdate();

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            conexion.close();//CIERRE DE CONEXION MYSQL
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    //METODO DE BUSQUEDA DEPENDIENDO FILTROS
    public ResultSet buscarSupremo(Tarea tarea, Usuario usuario) { //RECIBE UN OBJETO CLASE TAREA, Y USUARIO QUE ESTA ACTIVO PARA OBTENER ID
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES

        //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
        try {
            conexion = con.getConnection();
            StringBuilder query = new StringBuilder("SELECT titulo, fecha_limite, descripcion, importancia, estado, id_usuarioJefe FROM tareas WHERE id_usuarioJefe = ?");//SENTENCIA DE BUSQUEDA INICIO

            //FILTRO POR FECHA
            if (tarea.getFecha_creacion() != null && tarea.getFecha_limite() != null) {
                query.append(" AND (fecha_limite BETWEEN ? AND ?)");                          //AGREGADA DE SENTENCIA CONDICIONAL
            }

            //FILTRO POR ESTADO PENDIENTE-REALIZADO
            if (tarea.getEstado() != null || tarea.getEstado2() != null) {
                query.append(" AND (estado = ?" + ((tarea.getEstado2() != null && tarea.getEstado() != null) ? " or estado = ?)" : ")")); //AGREGADA DE SENTENCIA CONDICIONAL
            }

            //FILTRO POR IMPORTANCIA DE LA TAREA
            if (tarea.getImportancia() != null && tarea.getImportancia1() != null && tarea.getImportancia2() != null) {                  // 1 1 1
                query.append(" AND (importancia = ? or importancia = ? or importancia = ?)"); //AGREGADA DE SENTENCIA CONDICIONAL
            } else if (tarea.getImportancia() != null && tarea.getImportancia1() != null && tarea.getImportancia2() == null
                    || // 1 1 0 
                    tarea.getImportancia() != null && tarea.getImportancia1() == null && tarea.getImportancia2() != null
                    || // 1 0 1 
                    tarea.getImportancia() == null && tarea.getImportancia1() != null && tarea.getImportancia2() != null) {               // 0 1 1
                query.append(" AND (importancia = ? OR importancia = ?)");                   //AGREGADA DE SENTENCIA CONDICIONAL
            } else if (tarea.getImportancia() != null && tarea.getImportancia1() == null && tarea.getImportancia2() == null
                    || // 1 0 0
                    tarea.getImportancia() == null && tarea.getImportancia1() != null && tarea.getImportancia2() == null
                    || // 0 1 0
                    tarea.getImportancia() == null && tarea.getImportancia1() == null && tarea.getImportancia2() != null) {              
                       // 0 0 1
                query.append(" AND (importancia = ?)");                                     //AGREGADA DE SENTENCIA CONDICIONAL
            }
            query.append(";");
            System.out.println(query);

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            ps = conexion.prepareStatement(query.toString());
            System.out.println("Usuario " + usuario.getId());
            ps.setInt(1, usuario.getId());
            int parameterIndex = 2; // INICIAR INDICE DE PARAMETRO DESPUES DEL PRIMER ?
            //INSERTAR EN ID_USUARIO

            if (tarea.getFecha_creacion() != null && tarea.getFecha_limite() != null) {
                ps.setDate(parameterIndex++, tarea.getFecha_creacion());            //INSERTAR EN FECHA CREACION
                ps.setDate(parameterIndex++, tarea.getFecha_limite());              //INSERTAR EN FECHA LIMITE
            }

            if (tarea.getEstado() != null || tarea.getEstado2() != null) {
                if (tarea.getEstado2() == null) {
                    ps.setString(parameterIndex++, tarea.getEstado());             //INSERTAR EN ESTADO
                } else if (tarea.getEstado() == null) {
                    ps.setString(parameterIndex++, tarea.getEstado2());            //INSERTAR EN ESTADO 2
                } else {
                    ps.setString(parameterIndex++, tarea.getEstado());             //INSERTAR EN ESTADO
                    ps.setString(parameterIndex++, tarea.getEstado2());            //INSERTAR EN ESTADO 2
                }
            }

            if (tarea.getImportancia() != null || tarea.getImportancia1() != null || tarea.getImportancia2() != null) {

                if (tarea.getImportancia() != null && tarea.getImportancia1() == null && tarea.getImportancia2() == null) { // 1 0 0
                    ps.setString(parameterIndex++, tarea.getImportancia());        //INSERTAR EN IMPORTANCIA
                } else if (tarea.getImportancia() == null && tarea.getImportancia1() != null && tarea.getImportancia2() == null) { // 0 1 0
                    ps.setString(parameterIndex++, tarea.getImportancia1());       //INSERTAR EN IMPORTANCIA
                } else if (tarea.getImportancia() == null && tarea.getImportancia1() == null && tarea.getImportancia2() != null) { // 0 0 1
                    ps.setString(parameterIndex++, tarea.getImportancia2());       //INSERTAR EN IMPORTANCIA
                } else if (tarea.getImportancia() != null && tarea.getImportancia1() != null && tarea.getImportancia2() == null) { //1 1 0
                    ps.setString(parameterIndex++, tarea.getImportancia());        //INSERTAR EN IMPORTANCIA
                    ps.setString(parameterIndex++, tarea.getImportancia1());       //INSERTAR EN IMPORTANCIA
                } else if (tarea.getImportancia() == null && tarea.getImportancia1() != null && tarea.getImportancia2() != null) {//0 1 1
                    ps.setString(parameterIndex++, tarea.getImportancia1());       //INSERTAR EN IMPORTANCIA
                    ps.setString(parameterIndex++, tarea.getImportancia2());       //INSERTAR EN IMPORTANCIA
                } else if (tarea.getImportancia() != null && tarea.getImportancia1() == null && tarea.getImportancia2() != null) {//1 0 1
                    ps.setString(parameterIndex++, tarea.getImportancia2());      //INSERTAR EN IMPORTANCIA
                    ps.setString(parameterIndex++, tarea.getImportancia());       //INSERTAR EN IMPORTANCIA
                } else {
                    ps.setString(parameterIndex++, tarea.getImportancia());       //INSERTAR EN IMPORTANCIA
                    ps.setString(parameterIndex++, tarea.getImportancia1());      //INSERTAR EN IMPORTANCIA
                    ps.setString(parameterIndex++, tarea.getImportancia2());      //INSERTAR EN IMPORTANCIA
                }

            }
            return ps.executeQuery();//OBTENCIO DE RESULTADOS DE WORKEANCJ
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public void actualizarTarea(Usuario usuario, Tarea tarea) {
        con = new Conexion();//CONEXION CON DB CON NUETSRAS CREDENCIALES

        try {
            conexion = con.getConnection();//CONEXION CON DB CON NUETSRAS CREDENCIALES

            //-----------DFINICION DE SENTENCIA DE BUSQUEDA-----------
            //UPDATE tareas SET descripcion = ?, estado = ? WHERE id_tareas = ?;
            ps = conexion.prepareStatement("UPDATE tareas SET ultima_sesion = ?,  WHERE idusuarios = ?");//SENTENCIA DE BUSQUEDA INICIO
            ps.setString(1, tarea.getTitulo());           //INSERTAR EN TITULO
            ps.setDate(2, tarea.getFecha_creacion());     //INSERTAR EN FECHA CREACION
            ps.setDate(3, tarea.getFecha_limite());       //INSERTAR EN FECHA LIMITE
            ps.setString(4, tarea.getDescripcion());      //INSERTAR EN DESCRIPCION
            ps.setString(5, tarea.getImportancia());      //INSERTAR EN IMPORTANCIA
            ps.setString(6, tarea.getEstado());           //INSERTAR EN ESTADO
            ps.setInt(7, usuario.getId());                //INSERTAR EN ID_USUARIO
            ps.executeUpdate();

            //----------DEFINICION DE RESULTADO DE BUSQUEDA------------
            conexion.close();//CIERRE DE CONEXION MYSQL
            JOptionPane.showMessageDialog(null, "Tarea Actualizada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No actualizado");
        }

    }

}
