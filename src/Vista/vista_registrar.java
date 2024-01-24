package Vista;

import Controlador.Cont_registrar;



public class Vista_registrar extends javax.swing.JFrame {

    public Vista_registrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registrarse");
        Controlador.Cont_registrar controlador = new Cont_registrar(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinFieldBeanInfo1 = new com.toedter.components.JSpinFieldBeanInfo();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ent_usuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ent_correo1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ent_passwdConf = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        ent_passwd1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        ent_nick = new javax.swing.JTextField();
        btn_registrar = new org.edisoncor.gui.button.ButtonNice();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N

        panelRectTranslucido1.setColorDeBorde(new java.awt.Color(242, 212, 155));
        panelRectTranslucido1.setColorDeSegundoBorde(new java.awt.Color(242, 149, 94));
        panelRectTranslucido1.setColorPrimario(new java.awt.Color(242, 169, 153));
        panelRectTranslucido1.setColorSecundario(new java.awt.Color(89, 35, 30));

        jLabel11.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        jLabel11.setText("Crea una Cuenta");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("INICIO DE SESION");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Usuario");
        jLabel6.setOpaque(true);
        jLabel6.setRequestFocusEnabled(false);

        ent_usuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ent_usuario.setBorder(null);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Correo");
        jLabel13.setOpaque(true);

        ent_correo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ent_correo1.setBorder(null);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Contraseña");
        jLabel9.setOpaque(true);

        ent_passwdConf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ent_passwdConf.setBorder(null);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Confirmar Contraseña");
        jLabel7.setOpaque(true);

        ent_passwd1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ent_passwd1.setBorder(null);
        ent_passwd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ent_passwd1ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nick");
        jLabel12.setOpaque(true);

        ent_nick.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ent_nick.setBorder(null);

        btn_registrar.setBackground(new java.awt.Color(255, 255, 204));
        btn_registrar.setText("Iniciar Sesion");
        btn_registrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ent_correo1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ent_passwdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRectTranslucido1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)))
                        .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ent_nick, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(ent_passwd1)))
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel11))
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel8)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ent_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ent_correo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ent_passwdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ent_passwd1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ent_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Controlador.Cont_inicioSesion.registrar =null;
    }//GEN-LAST:event_formWindowClosing

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
//        Usuario usuario = new Usuario();
//        SQLusuario sqlUsuario = new SQLusuario();
//
//        String passwd = new String(ent_passwdConf.getPassword());
//        String passwdConf = new String(ent_passwdConf.getPassword());
//        //validaciones
//
//        //VALIDACIOON DE CAMPOS
//        if (ent_usuario.getText().equals("") || passwd.equals("") || passwdConf.equals("")|| ent_Celular.getText().equals("") || ent_Celular.getText().equals(""))
//        {
//            JOptionPane.showMessageDialog(null, "Algunos campos estan vacios, revisalos");
//        } else
//        {
//            //VALIDACIOON CONTRASE;AS IGUALES
//            if (passwd.equals(passwdConf))
//            {
//                if (sqlUsuario.verificarUsuario(ent_usuario.getText()) == 0)
//                {
//
//                    if (sqlUsuario.comprobarEmail(ent_Celular.getText()))
//                    {
//
//                        String nuevaPasswd = CifrarPasswd.sha256(passwd);
//                        
//                        
//                        usuario.setNombreUsuario(ent_usuario.getText());
//                        usuario.setPasswd(nuevaPasswd);
//                        usuario.setNick(ent_nick.getText());
//                        usuario.setCorreo(ent_Celular.getText());
//                        usuario.setIdTipo_usuario(1);
//
//                        if (sqlUsuario.registrar(usuario)) {
//                            JOptionPane.showMessageDialog(null, "Registrado");
//                            new Vista_principal().setVisible(true);
//                            this.dispose();
//                        } else {
//                            JOptionPane.showMessageDialog(null, "Error en el registro");
//                        }
//                    }
//                    else
//                    {
//                        System.out.println("El correo no es correcto");
//                    }
//                } else
//                {
//                    JOptionPane.showMessageDialog(null, "Ya existe el usuario");
//                }
//
//            } else
//            {
//                JOptionPane.showMessageDialog(null, "Contraseñas diferentes");
//            }
//        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void ent_passwd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ent_passwd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ent_passwd1ActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.edisoncor.gui.button.ButtonNice btn_registrar;
    public javax.swing.JTextField ent_correo1;
    public javax.swing.JTextField ent_nick;
    public javax.swing.JPasswordField ent_passwd1;
    public javax.swing.JPasswordField ent_passwdConf;
    public javax.swing.JTextField ent_usuario;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JSpinFieldBeanInfo jSpinFieldBeanInfo1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    // End of variables declaration//GEN-END:variables
}
