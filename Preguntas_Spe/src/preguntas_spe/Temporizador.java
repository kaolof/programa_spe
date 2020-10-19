
package preguntas_spe;

import java.util.Timer;

/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

public class Temporizador extends javax.swing.JFrame {
    JLabel EtiquetaTiempo;
    JButton BStart,BPause,BStop;
    
    public Temporizador(){
       initComponents(); 
       setLocationRelativeTo(null);
       t=new Timer(1000,acciones);
       
       EtiquetaTiempo=new JLabel();
       
       add(EtiquetaTiempo);
    }
    
    @SuppressWarnings("Unchecked")
       private Timer t;
       private int m,s;

       
       private ActionListener acciones=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              while(s>0){
                if(s==0){
                   m--;
                }
                s=59;
                s--;
                ActualizarJLabel();
            }
            }
       };
       
       private void ActualizarJLabel(){
            String tiempo= "0"+m+":"+(s<=9?"0":"")+s;
            EtiquetaTiempo.setText(tiempo);
            
       }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}*/


public class Temporizador {
    
    private int minutos, segundos;
    private String tiempo;
    private Timer t;
    //private BStart,BPause,BStop;
    
    public Temporizador(){ 
       t = new Timer();
       minutos = 0;
       segundos = 0;
       tiempo = "";
    }
    
    private void reiniciarTiempo() { 
        
    }
    
    private void detenerTiempo() { 
        
    }
     
    private void iniciarTiempo() {   
        
    }
    
    
     private String getTiempo() { 
        return tiempo;       
    }
    
    
    
    
    /*
    public void actionPerformed(ActionEvent ae) {
        while(s>0){
          if(s==0){
             m--;
          }
          s=59;
          s--;
          ActualizarJLabel();
      }
   }
 

 private void ActualizarJLabel(){
      String tiempo= "0"+m+":"+(s<=9?"0":"")+s;
      EtiquetaTiempo.setText(tiempo);

 } */

 }
