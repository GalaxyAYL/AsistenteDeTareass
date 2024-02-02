
package Vista;


public class Vista_nuevaTarea extends javax.swing.JFrame {

    private Controlador.Cont_principal controlador;
    
    public Vista_nuevaTarea(Controlador.Cont_principal controlador) {
        this.controlador=controlador;
        initComponents();
        jRadio_alta.setActionCommand("alta");
        jRadio_media.setActionCommand("media");
        jRadio_baja.setActionCommand("baja");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btns_importancia = new javax.swing.ButtonGroup();
        panelRectTranslucidoComplete1 = new org.edisoncor.gui.panel.PanelRectTranslucidoComplete();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ent_titulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ent_limite = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        ent_descripcion = new javax.swing.JTextArea();
        jRadio_media = new javax.swing.JRadioButton();
        jRadio_baja = new javax.swing.JRadioButton();
        jRadio_alta = new javax.swing.JRadioButton();
        btn_crear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelRectTranslucidoComplete1.setColorDeBorde(new java.awt.Color(242, 212, 155));
        panelRectTranslucidoComplete1.setColorDeSegundoBorde(new java.awt.Color(242, 149, 94));
        panelRectTranslucidoComplete1.setColorPrimario(new java.awt.Color(242, 169, 153));
        panelRectTranslucidoComplete1.setColorSecundario(new java.awt.Color(89, 35, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 3, 18)); // NOI18N
        jLabel1.setText("NUEVA TAREA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText(".....");

        ent_titulo.setText("Titulo de Tarea");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText("FECHA DESTINO");

        ent_descripcion.setColumns(20);
        ent_descripcion.setRows(5);
        ent_descripcion.setText("Descripción");
        jScrollPane1.setViewportView(ent_descripcion);

        btns_importancia.add(jRadio_media);
        jRadio_media.setText("Media");

        btns_importancia.add(jRadio_baja);
        jRadio_baja.setText("Bajo");

        btns_importancia.add(jRadio_alta);
        jRadio_alta.setText("Alta");

        btn_crear.setText("CREAR");

        javax.swing.GroupLayout panelRectTranslucidoComplete1Layout = new javax.swing.GroupLayout(panelRectTranslucidoComplete1);
        panelRectTranslucidoComplete1.setLayout(panelRectTranslucidoComplete1Layout);
        panelRectTranslucidoComplete1Layout.setHorizontalGroup(
            panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ent_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(ent_limite, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jRadio_alta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadio_baja, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadio_media, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelRectTranslucidoComplete1Layout.setVerticalGroup(
            panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucidoComplete1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ent_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(ent_limite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucidoComplete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadio_alta)
                    .addComponent(jRadio_baja)
                    .addComponent(jRadio_media))
                .addGap(28, 28, 28)
                .addComponent(btn_crear)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRectTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRectTranslucidoComplete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Controlador.Cont_principal.nuevaTarea =null;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_crear;
    public javax.swing.ButtonGroup btns_importancia;
    public javax.swing.JTextArea ent_descripcion;
    public com.toedter.calendar.JDateChooser ent_limite;
    public javax.swing.JTextField ent_titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JRadioButton jRadio_alta;
    public javax.swing.JRadioButton jRadio_baja;
    public javax.swing.JRadioButton jRadio_media;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelRectTranslucidoComplete panelRectTranslucidoComplete1;
    // End of variables declaration//GEN-END:variables
}
