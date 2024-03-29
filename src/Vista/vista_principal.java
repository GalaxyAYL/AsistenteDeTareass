
package Vista;


import Modelo.Usuario;

public class Vista_principal extends javax.swing.JFrame {


    
    public Vista_principal(Usuario usuario) {
        initComponents();//INICIAR EL DISENO
        this.setLocationRelativeTo(null);//CENTRAR PESTANA
        this.setTitle("Principal");//TITULO DE VENTANA
        
        new Controlador.Cont_principal(this, usuario);// ESTANCIA DEL CONTROLADOR, QUE CONTROLA ESTA PESTANA
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelRectTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelRectTranslucidoComplete();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlabel_nombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelRectTranslucidoComplete2 = new org.edisoncor.gui.panel.PanelRectTranslucidoComplete();
        btn_mostrrarTodasLasTareas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_filPendientes = new javax.swing.JButton();
        chk_pendiente = new javax.swing.JCheckBox();
        chk_realizado = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        chk_leve = new javax.swing.JCheckBox();
        chk_normal = new javax.swing.JCheckBox();
        chk_alto = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        dateChosser_Inicio = new com.toedter.calendar.JDateChooser();
        dateChosser_fin = new com.toedter.calendar.JDateChooser();
        btn_buscarFecha = new javax.swing.JButton();
        btn_limpiarFiltros = new javax.swing.JButton();
        panelRectTranslucidoComplete3 = new org.edisoncor.gui.panel.PanelRectTranslucidoComplete();
        btn_crearTarea = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_contenido = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        btn_salir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N

        panelRectTranslucidoComplete1.setColorDeBorde(new java.awt.Color(242, 212, 155));
        panelRectTranslucidoComplete1.setColorDeSegundoBorde(new java.awt.Color(242, 149, 94));
        panelRectTranslucidoComplete1.setColorPrimario(new java.awt.Color(242, 169, 153));
        panelRectTranslucidoComplete1.setColorSecundario(new java.awt.Color(89, 35, 30));

        jLabel1.setFont(new java.awt.Font("SimSun", 3, 36)); // NOI18N
        jLabel1.setText("ASISTENTE DE TAREAS");

        jLabel2.setFont(new java.awt.Font("SimSun", 3, 18)); // NOI18N
        jLabel2.setText("Bienvenido");

        jlabel_nombre.setFont(new java.awt.Font("SimSun", 2, 18)); // NOI18N
        jlabel_nombre.setText(".....");

        jLabel6.setFont(new java.awt.Font("SimSun", 2, 24)); // NOI18N
        jLabel6.setText("NUNCA DUDES DE TI ");

        jLabel7.setFont(new java.awt.Font("SimSun", 2, 24)); // NOI18N
        jLabel7.setText("SIEMPRE SERAS MEJOR QUE TODOS");

        javax.swing.GroupLayout panelRectTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelRectTranslucidoComplete1);
        panelRectTranslucidoComplete1.setLayout(panelRectTranslucidoComplete1Layout);
        panelRectTranslucidoComplete1Layout.setHorizontalGroup(
            panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addComponent(jlabel_nombre)
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel6))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRectTranslucidoComplete1Layout.setVerticalGroup(
            panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jlabel_nombre))
                                .addGap(26, 26, 26)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelRectTranslucidoComplete2.setColorDeBorde(new java.awt.Color(89, 35, 30));
        panelRectTranslucidoComplete2.setColorDeSegundoBorde(new java.awt.Color(242, 149, 94));
        panelRectTranslucidoComplete2.setColorPrimario(new java.awt.Color(242, 149, 94));
        panelRectTranslucidoComplete2.setColorSecundario(new java.awt.Color(89, 35, 30));

        btn_mostrrarTodasLasTareas.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_mostrrarTodasLasTareas.setText("MOSTRAR TODO");
        btn_mostrrarTodasLasTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrrarTodasLasTareasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 3, 14)); // NOI18N
        jLabel3.setText("FILTROS");

        btn_filPendientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_filPendientes.setText("Pendientes");

        chk_pendiente.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        chk_pendiente.setText("Pendiente");

        chk_realizado.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        chk_realizado.setText("Realizado");
        chk_realizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_realizadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Importancia");

        chk_leve.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        chk_leve.setText("baja");
        chk_leve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_leveActionPerformed(evt);
            }
        });

        chk_normal.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        chk_normal.setText("media");

        chk_alto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        chk_alto.setText("alta");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setText("Fecha: ");

        btn_buscarFecha.setText("buscarFecha");

        btn_limpiarFiltros.setText("Limpiar filtros");

        javax.swing.GroupLayout panelRectTranslucidoComplete2Layout = new javax.swing.GroupLayout(panelRectTranslucidoComplete2);
        panelRectTranslucidoComplete2.setLayout(panelRectTranslucidoComplete2Layout);
        panelRectTranslucidoComplete2Layout.setHorizontalGroup(
            panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                        .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(chk_realizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btn_filPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(chk_pendiente)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                        .addComponent(chk_leve, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chk_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(chk_alto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_mostrrarTodasLasTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(dateChosser_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateChosser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))))
                .addContainerGap())
            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_buscarFecha)
                    .addComponent(btn_limpiarFiltros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRectTranslucidoComplete2Layout.setVerticalGroup(
            panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btn_mostrrarTodasLasTareas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btn_filPendientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_realizado)
                    .addComponent(chk_pendiente))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_leve)
                    .addComponent(chk_normal)
                    .addComponent(chk_alto))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(25, 25, 25)
                .addGroup(panelRectTranslucidoComplete2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChosser_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChosser_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_buscarFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_limpiarFiltros)
                .addGap(59, 59, 59))
        );

        panelRectTranslucidoComplete3.setColorDeBorde(new java.awt.Color(242, 212, 155));
        panelRectTranslucidoComplete3.setColorDeSegundoBorde(new java.awt.Color(242, 149, 94));
        panelRectTranslucidoComplete3.setColorPrimario(new java.awt.Color(242, 169, 153));
        panelRectTranslucidoComplete3.setColorSecundario(new java.awt.Color(89, 35, 30));

        btn_crearTarea.setBackground(new java.awt.Color(89, 59, 14));
        btn_crearTarea.setForeground(new java.awt.Color(255, 255, 255));
        btn_crearTarea.setText("Crear Tarea");

        tabla_contenido.setBackground(new java.awt.Color(242, 169, 153));
        tabla_contenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Fecha Creacion", "Fecha Limite", "Descripcion", "Importancia", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla_contenido);

        javax.swing.GroupLayout panelRectTranslucidoComplete3Layout = new javax.swing.GroupLayout(panelRectTranslucidoComplete3);
        panelRectTranslucidoComplete3.setLayout(panelRectTranslucidoComplete3Layout);
        panelRectTranslucidoComplete3Layout.setHorizontalGroup(
            panelRectTranslucidoComplete3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_crearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelRectTranslucidoComplete3Layout.setVerticalGroup(
            panelRectTranslucidoComplete3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete3Layout.createSequentialGroup()
                .addGroup(panelRectTranslucidoComplete3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucidoComplete3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucidoComplete3Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(btn_crearTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRectTranslucidoComplete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(panelRectTranslucidoComplete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(panelRectTranslucidoComplete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(panelRectTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRectTranslucidoComplete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRectTranslucidoComplete3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        btn_salir.setText("Salir");
        jMenuBar1.add(btn_salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Controlador.Cont_inicioSesion.panelPrincipal =null;

    }//GEN-LAST:event_formWindowClosing

    private void btn_mostrrarTodasLasTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrrarTodasLasTareasActionPerformed
        
    }//GEN-LAST:event_btn_mostrrarTodasLasTareasActionPerformed

    private void chk_leveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_leveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_leveActionPerformed

    private void chk_realizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_realizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_realizadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_buscarFecha;
    public javax.swing.JButton btn_crearTarea;
    public javax.swing.JButton btn_filPendientes;
    public javax.swing.JButton btn_limpiarFiltros;
    public javax.swing.JButton btn_mostrrarTodasLasTareas;
    public javax.swing.JMenu btn_salir;
    public javax.swing.JCheckBox chk_alto;
    public javax.swing.JCheckBox chk_leve;
    public javax.swing.JCheckBox chk_normal;
    public javax.swing.JCheckBox chk_pendiente;
    public javax.swing.JCheckBox chk_realizado;
    public com.toedter.calendar.JDateChooser dateChosser_Inicio;
    public com.toedter.calendar.JDateChooser dateChosser_fin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel jlabel_nombre;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelRectTranslucidoComplete panelRectTranslucidoComplete1;
    private org.edisoncor.gui.panel.PanelRectTranslucidoComplete panelRectTranslucidoComplete2;
    private org.edisoncor.gui.panel.PanelRectTranslucidoComplete panelRectTranslucidoComplete3;
    public javax.swing.JTable tabla_contenido;
    // End of variables declaration//GEN-END:variables
}
