package Controlador;

import Modelo.CifrarPasswd;
import Modelo.SQLusuario;
import Modelo.Usuario;
import Vista.Vista_inicioSesion;
import Vista.Vista_principal;
import Vista.Vista_registrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cont_inicioSesion implements ActionListener {
    
    public static Vista_registrar registrar;
    public static Vista_principal panelPrincipal;
    
    private Vista_inicioSesion iniciarSesion;
    
    public Cont_inicioSesion(Vista_inicioSesion iniciarSesion) {
        this.iniciarSesion = iniciarSesion;
        iniciarSesion.btn_iniciarSesion.addActionListener(this);
        iniciarSesion.btn_registrarse.addActionListener(this);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciarSesion.btn_iniciarSesion) {
            Usuario usuario = new Usuario();
            SQLusuario sqlUusuario = new SQLusuario();
            
            Date fecha = new Date();
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String passwd = new String(iniciarSesion.ent_passwd.getPassword());
            if (iniciarSesion.ent_usuario.getText().equals("") || iniciarSesion.ent_passwd.getPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "Entradas vaicas");
                JOptionPane.showMessageDialog(null, "Algo paso :( --2");
            } else {
                String passwdIncrypted = CifrarPasswd.sha256(passwd);
                usuario.setNombreUsuario(iniciarSesion.ent_usuario.getText());
                usuario.setPasswd(passwdIncrypted);
                usuario.setUltimaSesion(fechaHora.format(fecha));
                if (sqlUusuario.iniciarSesion(usuario)) {
                    
                    if (panelPrincipal == null) {
                        panelPrincipal = new Vista_principal();
                        panelPrincipal.setVisible(true);
                        iniciarSesion.dispose();
                    }
                    
                    JOptionPane.showMessageDialog(null, "Login correcto");
                } else {
                    iniciarSesion.jlabel_conclusion.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Algo paso :( ");
                }
            }
        }
        if (e.getSource() == iniciarSesion.btn_registrarse) {
            if (registrar == null) {
                registrar = new Vista_registrar();
                registrar.setVisible(true);
            }
        }
    }
    
}
