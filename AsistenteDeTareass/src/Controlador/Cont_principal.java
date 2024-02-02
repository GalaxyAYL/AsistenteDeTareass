package Controlador;

import Modelo.CeldaRenderer;
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;

public class Cont_principal implements ActionListener {

    private static Usuario usuario;
    private static Vista_principal principal;
    private static Tarea tarea = new Tarea();
    private static SQLtarea sqlTarea = new SQLtarea();
    private static DefaultTableModel modeloTabla = new DefaultTableModel();
    private static JComboBox comboBox = new JComboBox();
    private static ResultSet rs;
    
    public static Vista_nuevaTarea nuevaTarea = null;
    
    

    public Cont_principal(Vista_principal principal, Usuario usuario) {
        this.principal = principal;
        this.usuario = usuario;
        principal.jlabel_nombre.setText(sqlTarea.cargarDatos(usuario));
        principal.btn_crearTarea.addActionListener(this);
        principal.btn_mostrrarTodasLasTareas.addActionListener(this);

        //FILTRAR CHECK
        principal.chk_alto.addActionListener(this);
        principal.chk_leve.addActionListener(this);
        principal.chk_normal.addActionListener(this);
        principal.chk_pendiente.addActionListener(this);
        principal.chk_realizado.addActionListener(this);
        principal.btn_buscarFecha.addActionListener(this);
        principal.btn_salir.addActionListener(this);
        principal.btn_limpiarFiltros.addActionListener(this);
        comboBox.addActionListener(this);
        
        
//        modeloTabla
        modeloTabla.addColumn("Titulo");
        modeloTabla.addColumn("Fecha limite");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Importancia");
        
        comboBox.addItem("Pendiente");
        comboBox.addItem("Realizado");
        modeloTabla.addColumn("Estado");
        
        principal.tabla_contenido.setModel(modeloTabla);
        principal.tabla_contenido.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboBox));
        principal.tabla_contenido.setDefaultRenderer(Object.class, new CeldaRenderer(4));

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
                                        
                                        if(sqlTarea.crearTarea(usuario, tarea)){
                                            nuevaTarea.dispose();
                                        }else{
                                            System.out.println("Datos no validos");
                                        }
                                        
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
            Tarea tarea1 = new Tarea();
            rs = sqlTarea.buscarSupremo(tarea1, usuario);

            try {
                while (rs.next()) {
                    Object fila[] = new Object[6];
                    for (int i = 0; i < 6; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Cont_principal.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        }

        if (e.getSource() == principal.btn_buscarFecha) {
            limpiarTabla();
            try {
                java.sql.Date sqlFecha_creacion = new java.sql.Date(principal.dateChosser_Inicio.getDate().getTime());
                java.sql.Date sqlFecha_limite = new java.sql.Date(principal.dateChosser_fin.getDate().getTime());

                tarea.setFecha_creacion(sqlFecha_creacion);
                System.out.println("fechaCreacion - buscarFecha");
                tarea.setFecha_limite(sqlFecha_limite);
                System.out.println("fechaFin - buscarFecha");
                rs = sqlTarea.buscarSupremo(tarea, usuario);
            } catch (Exception ef) {
                JOptionPane.showMessageDialog(null, "Campos vacios");
            }
            
            try {
                while (rs.next()) {
                    Object fila[] = new Object[6];
                    for (int i = 0; i < 6; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }

        //BOON PARA SALIR
        if (e.getSource() == principal.btn_salir) {
            Cont_inicioSesion.panelPrincipal = null;
            principal.dispose();
            new Vista.Vista_inicioSesion().setVisible(true);

        }

        //FILTRADO SUPREMO
        if (e.getSource() == principal.chk_alto || e.getSource() == principal.chk_leve || e.getSource() == principal.chk_normal || e.getSource() == principal.chk_pendiente || e.getSource() == principal.chk_realizado || e.getSource() == principal.btn_buscarFecha) {
            limpiarTabla();
            tarea = new Tarea();  // Crear una nueva instancia de Tarea

            // APARTADO DE FECHAS
            tarea.setImportancia(principal.chk_alto.isSelected() ? "alta" : null);
            tarea.setImportancia1(principal.chk_normal.isSelected() ? "media" : null);
            tarea.setImportancia2(principal.chk_leve.isSelected() ? "baja" : null);
            tarea.setEstado(principal.chk_pendiente.isSelected() ? "Pendiente" : null);
            tarea.setEstado2(principal.chk_realizado.isSelected() ? "Realizado" : null);

            tarea.setFecha_creacion(principal.dateChosser_Inicio.getDate() != null ? new java.sql.Date(principal.dateChosser_Inicio.getDate().getTime()) : null);
            tarea.setFecha_limite(principal.dateChosser_fin.getDate() != null ? new java.sql.Date(principal.dateChosser_fin.getDate().getTime()) : null);

            rs = sqlTarea.buscarSupremo(tarea, usuario);

            try {
                while (rs.next()) {
                    Object fila[] = new Object[6];
                    for (int i = 0; i < 6; i++) {
                        fila[i] = rs.getObject(i + 1);
                    }

                    modeloTabla.addRow(fila);
                }
            } catch (SQLException ex) {
                System.err.println("Error: " + ex);
            }
        }

        if (e.getSource() == principal.btn_limpiarFiltros) {
            limpiarTabla();
            limpiarFiltros();
        }

        if (e.getSource()== comboBox) {
            
        }
        
    }

    public void limpiarTabla() {
        for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }

    public void limpiarFiltros() {
        principal.chk_alto.setSelected(false);
        principal.chk_normal.setSelected(false);
        principal.chk_leve.setSelected(false);
        principal.chk_pendiente.setSelected(false);
        principal.chk_realizado.setSelected(false);
        principal.dateChosser_Inicio.setDate(null);
        principal.dateChosser_fin.setDate(null);
    }
}
