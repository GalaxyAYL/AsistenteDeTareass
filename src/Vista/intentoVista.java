
package Vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class intentoVista {
    static JFrame frame = new JFrame();
    
    public intentoVista (){
        init();
    }
    
//    public static void main(String[] args) {
//        new intentoVista();
//    }
//    
    
    static void init(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        darPropiedades(frame);
    }
    
    
    //ARRAYLIST ARA BOTONES
    static ArrayList <JButton> botones = new ArrayList<>();
    
    static void darPropiedades(JFrame frame){
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        
        
        //JPANEL
        JPanel panel = new JPanel();
        
        
        //BOTONES
        crearBoton("btn_crearTarea","Crear");
        crearBoton("btn_eliminarTarea","Eliminar");
        
        
        //TEXTOS
        JLabel titulo = new JLabel();
        titulo.setText("Asistente de tareas de : ");
        
        //LISTAR COMPONENETES

       
        
//AGREGAR CONPONENTES
        
        panel.add(titulo);
        
        for (JButton boton:botones) {
            panel.add(boton);
        }
        
        
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setComponentZOrder(panel, 0);
        
        
    }
    
    /**
     *
     */
    
    
    //METODO DAR CREAR A BOTONES
    static void crearBoton(String nombreV, String leyenda){
        JButton boton = new JButton();
        boton.setSize(50,120);
        boton.setText(leyenda);
        boton.setName(nombreV);
        boton.setVisible(true);
        
        botones.add(boton);
    }
    
}




