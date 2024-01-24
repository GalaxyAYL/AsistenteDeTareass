package Controlador;

import Modelo.SQLtarea;
import Modelo.Tarea;
import Modelo.Usuario;
import Vista.Vista_nuevaTarea;
import Vista.Vista_principal;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cont_principal implements ActionListener {

    private static Usuario usuario;
    private Vista_principal principal;
    private SQLtarea sqlTarea = new SQLtarea();
    public static Vista_nuevaTarea nuevaTarea = null;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    ResultSet rs ;

    public Cont_principal(Vista_principal principal, Usuario usuario) {
        this.principal = principal;
        this.usuario = usuario;
        principal.jlabel_nombre.setText(sqlTarea.cargarDatos(usuario));
        principal.btn_crearTarea.addActionListener(this);
        principal.btn_mostrrarTodasLasTareas.addActionListener(this);
        principal.btn_filPendientes.addActionListener(this);
        modeloTabla.addColumn("Titulo");
            modeloTabla.addColumn("Fecha Creacion");
            modeloTabla.addColumn("Fecha limite");
            modeloTabla.addColumn("Descripcion");
            modeloTabla.addColumn("Importancia");
            modeloTabla.addColumn("Estado");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == principal.btn_crearTarea) {
            if (nuevaTarea == null) {
                nuevaTarea = new Vista_nuevaTarea(this);
                nuevaTarea.setVisible(true);
                nuevaTarea.btn_crear.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == nuevaTarea.btn_crear) {
                            SQLtarea sqlTarea = new SQLtarea();
                            Tarea tarea = new Tarea();

                            if (nuevaTarea.ent_titulo.getText().isEmpty() || nuevaTarea.ent_descripcion.getText().isEmpty() || nuevaTarea.btns_importancia.getSelection() == null || nuevaTarea.ent_limite.getDate() == null) {
                                JOptionPane.showMessageDialog(null, "Campos vacíos");
                            } else {
                                try {
                                    DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    java.util.Date fechaActual = new java.util.Date();
                                    java.sql.Date sqlFecha_creacion = new java.sql.Date(fechaActual.getTime());
                                    java.sql.Date sqlFecha_limite = new java.sql.Date(nuevaTarea.ent_limite.getDate().getTime());

                                    if (sqlFecha_limite.before(sqlFecha_creacion)) {
                                        JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                                        System.out.println(fechaHora.format(sqlFecha_limite));
                                    } else {
                                        System.out.println(fechaHora.format(sqlFecha_limite));
                                        tarea.setTitulo(nuevaTarea.ent_titulo.getText());
                                        tarea.setDescripcion(nuevaTarea.ent_descripcion.getText());
                                        tarea.setEstado("Pendiente");
                                        tarea.setFecha_creacion(sqlFecha_creacion);
                                        tarea.setFecha_limite(sqlFecha_limite);
                                        tarea.setId_usuarioJefe(usuario.getId());
                                        tarea.setImportancia(nuevaTarea.btns_importancia.getSelection().getActionCommand());

                                        sqlTarea.crearTarea(usuario, tarea);
                                        nuevaTarea.dispose();
                                    }
                                } catch (NumberFormatException ex) {
                                    System.err.println("Error: " + ex);
                                }
                            }
                        }
                    }
                });
            }

        }
        if (e.getSource() == principal.btn_mostrrarTodasLasTareas) {
            // Agrega la lógica para mostrar todas las tareas
            
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
            rs = sqlTarea.llenarTabla();
            
            
            try {
                while(rs.next()){
                    Object fila[] = new Object[7];
                    for(int i = 0 ; i<7; i++){
                        fila[i]=rs.getObject(i+1);
                    }
                    
                    modeloTabla.addRow(fila);
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cont_principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            principal.tabla_contenido.setModel(modeloTabla);
        }
        if (e.getSource() == principal.btn_filPendientes) {
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
            rs = sqlTarea.llenarTablaPendientes();
            
            
            try {
                while(rs.next()){
                    Object fila[] = new Object[7];
                    for(int i = 0 ; i<7; i++){
                        fila[i]=rs.getObject(i+1);
                    }
                    
                    modeloTabla.addRow(fila);
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cont_principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
