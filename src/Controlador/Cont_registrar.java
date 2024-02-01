
//THIS LISTO


package Controlador;

import Modelo.CifrarPasswd;
import Modelo.SQLusuario;
import Modelo.Usuario;
import Vista.Vista_registrar;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Cont_registrar implements ActionListener{
    
    private Vista_registrar registrar;
    

    public Cont_registrar(Vista_registrar registrar) {
        this.registrar = registrar;
        registrar.btn_registrar.addActionListener(this);
    }

    public void iniciar(){
        registrar.setTitle("Registrar");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registrar.btn_registrar)
        {
            Usuario usuario = new Usuario();
            SQLusuario sqlUsuario = new SQLusuario();

            String passwd = new String(registrar.ent_passwdConf.getPassword());
            String passwdConf = new String(registrar.ent_passwdConf.getPassword());
            //validaciones

            //VALIDACIOON DE CAMPOS
            if (registrar.ent_usuario.getText().equals("") || passwd.equals("") || passwdConf.equals("")||  registrar.ent_nick.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Algunos campos estan vacios, revisalos");
            } else
            {
                //VALIDACIOON CONTRASE;AS IGUALES
                if (passwd.equals(passwdConf))
                {
                    if (sqlUsuario.verificarUsuario(registrar.ent_usuario.getText()) == 0)
                    {

                        if (sqlUsuario.comprobarEmail(registrar.ent_correo1.getText()))
                        {

                            String nuevaPasswd = CifrarPasswd.sha256(passwd);


                            usuario.setNombreUsuario(registrar.ent_usuario.getText());
                            usuario.setPasswd(nuevaPasswd);
                            usuario.setNick(registrar.ent_nick.getText());
                            usuario.setCorreo(registrar.ent_correo1.getText());
                            usuario.setIdTipo_usuario(1);

                            if (sqlUsuario.registrar(usuario)) {
                                JOptionPane.showMessageDialog(null, "Registrado");
                                new Vista.Vista_inicioSesion().setVisible(true);
                                registrar.dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error en el registro");
                                
                            }
                        }
                        else
                        {
                            System.out.println("El correo no es correcto");
                        }
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Ya existe el usuario");
                    }

                } else
                {
                    JOptionPane.showMessageDialog(null, "Contraseñas diferentes");
                }
            }
        }
    }
    
    
    
}
