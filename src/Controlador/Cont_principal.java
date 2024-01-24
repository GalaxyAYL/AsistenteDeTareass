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
    private static Tarea tarea = new Tarea();

    private Vista_principal principal;
    private SQLtarea sqlTarea = new SQLtarea();
    public static Vista_nuevaTarea nuevaTarea = null;
    DefaultTableModel modeloTabla = new DefaultTableModel();
    ResultSet rs;

    public Cont_principal(Vista_principal principal, Usuario usuario) {
        this.principal = principal;
        this.usuario = usuario;
        principal.jlabel_nombre.setText(sqlTarea.cargarDatos(usuario));
        principal.btn_crearTarea.addActionListener(this);
        principal.btn_mostrrarTodasLasTareas.addActionListener(this);

        //FILTRAR BOTONES
        principal.btn_filPendientes.addActionListener(this);
        principal.btn_buscarXfecha.addActionListener(this);
        //FILTRAR CHECK
        principal.chk_alto.addActionListener(this);
        principal.chk_leve.addActionListener(this);
        principal.chk_normal.addActionListener(this);
        principal.chk_pendiente.addActionListener(this);
        principal.chk_realizado.addActionListener(this);
        principal.da

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
            limpiarTabla();
            rs = sqlTarea.llenarTabla(usuario);

            try {
                while (rs.next()) {
                    Object fila[] = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i + 1);
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
            rs = sqlTarea.llenarTablaPendientes(usuario);
            try {
                while (rs.next()) {
                    Object fila[] = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Cont_principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == principal.btn_buscarXfecha) {
            limpiarTabla();
            
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date fechaActual = new java.util.Date();
            java.sql.Date sqlFecha_creacion = new java.sql.Date(principal.dateChosser_Inicio.getDate().getTime());
            java.sql.Date sqlFecha_limite = new java.sql.Date(principal.dateChosser_fin.getDate().getTime());

            tarea.setFecha_creacion(sqlFecha_creacion);
            System.out.println("fechaCreacion - buscarFecha");
            tarea.setFecha_limite(sqlFecha_limite);
            System.out.println("fechaFin - buscarFecha");
            rs = sqlTarea.llenarTablaFechas(tarea, usuario);
            try {
                while (rs.next()) {
                    Object fila[] = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }

        //FILTRADO SUPREMO
        if (e.getSource() == principal.chk_alto || e.getSource() == principal.chk_leve || e.getSource() == principal.chk_normal || e.getSource() == principal.chk_pendiente || e.getSource() == principal.chk_realizado ||principal.dateChosser_Inicio.) {
            
            limpiarTabla();
            
            //APARTADO DE FECHAS
            if(principal.chk_alto.isSelected()){
                tarea.setImportancia(principal.chk_alto.getActionCommand());
            }
            if(principal.chk_leve.isSelected()){
                tarea.setImportancia(principal.chk_leve.getActionCommand());
            }
            if(principal.chk_normal.isSelected()){
                tarea.setImportancia(principal.chk_normal.getActionCommand());
            }
            if(principal.chk_pendiente.isSelected()){
                tarea.setEstado(principal.chk_pendiente.getActionCommand());
            }
            if(principal.chk_realizado.isSelected()){
                tarea.setEstado(principal.chk_realizado.getActionCommand());
            }
            
            rs = sqlTarea.buscarSupremo(tarea, usuario);
         
            try {
                while (rs.next()) {
                    Object fila[] = new Object[7];
                    for (int i = 0; i < 7; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }
        
    }
    public void limpiarTabla(){
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                modeloTabla.removeRow(i);
            }
    }
}
