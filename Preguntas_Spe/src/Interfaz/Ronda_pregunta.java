
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import preguntas_spe.TextToSpeech;
import com.sun.glass.events.KeyEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import preguntas_spe.Participante;
import preguntas_spe.Respuesta;
<<<<<<< HEAD
import javax.swing.SwingWorker;
=======
import java.lang.Thread;
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb

public class Ronda_pregunta extends javax.swing.JFrame {

    private Participante p;
    private ArrayList<String> preguntas;
    private int minutos_partida=10, segundos5=5, segundos15=15, contPreguntas=0,segundos_partida=0;
    TextToSpeech tts;
<<<<<<< HEAD
    private Timer t5, t15;
    long TInicio, TFin, espera;
    float tiempo;
    private boolean estado;
  
=======
    private Timer t5, t15,t_partida;
    private ManejoArchivos registro;
    //private Respuestas respuestas;
    long TInicio, TFin;
    float cal_tiempo;
    String tiempo;//variable que se carga con la respuesta
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
        
    
    public Ronda_pregunta(ArrayList<String> a, Participante p) {
        initComponents();
<<<<<<< HEAD
        //this.getRootPane().setDefaultButton(bResponder);
        espera = 5000;
=======
        tts = new TextToSpeech();
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false);      
        tts = new TextToSpeech();
        t5 = new Timer(1000,acciones);
        t15 = new Timer(1000, acciones15);    
        t_partida=new Timer(1000,acciones10min);
        preguntas = a;
        this.p = p;
  
    }
    
    
<<<<<<< HEAD
    public void Partida() {
        if (contPreguntas < preguntas.size()) {
            final SwingWorker worker = new SwingWorker() {
=======
    public void Partida(){
        TInicio = System.currentTimeMillis();
        cont_pregunta.setText(""+(contPreguntas+1));//actuliza la etiqueta que cuenta las preguntas
        if (contPreguntas < preguntas.size()) {
          if(tts.speak(preguntas.get(contPreguntas), 1.0f, false, false) == 1) {
                //verificar si todo ok 
            } else {                 
                JOptionPane.showMessageDialog(null, "¡Hubo un error al cargar la preguntas!");
            }
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb

            @Override  //METODO PARA QUE SE EJECUTE EN SEGUNDO PLANO Y NO BLOQUEE LA INTERFAZ
            protected Object doInBackground() throws Exception {            
                tts.speak(preguntas.get(contPreguntas), 1.0f, false, true); 
                while (tts.getTts().isAlive()) {
                    estado = false;
                     
                } 
                //SI AL FINAL ES FALSO SIGNIFICA QUE NO SE PRESIONO RESPONDER
                if (estado == false) {
                    t5.start();
                } /* else { // SI AL FINAL ES VERDADERO SIGNIFICA QUE SÍ SE PRESIONÓ RESPONDER
                    
                } */
                
                return null;
            }
        };
        worker.execute();
           
                        
                     
        } else {
            int op = JOptionPane.showConfirmDialog(null, "¡La ronda ha terminado!"); //CAMBIARLO A SHOWOPTION
            if (op == 0) {
                guardarRespuestaFrame(p);
            }
        }
<<<<<<< HEAD
=======
        
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
    }
    

   
    
    //TEMPORIZADOR DE LOS 5 SEGUNDOS 
    @SuppressWarnings("Unchecked")

    public ActionListener acciones=new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) {       
            segundos5--;
            lPrueba5.setText("Tiene " + segundos5 +" segundos para presionar el botón responder");
            if(segundos5==0){
                lPrueba5.setText("Tiene 0 segundos para presionar el botón responder");
                t5.stop();
                contPreguntas++;
                segundos5 = 5;
                Partida();
            }
         }
    };
    
    //TEMPORIZADOR 15 SEGUNDOS
    @SuppressWarnings("Unchecked")

    public ActionListener acciones15 =new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) { 
            segundos15--;
            lPrueba5.setText("Tiene " + segundos15 +" segundos para responder");            
            if (segundos15 == 0) {  
                lPrueba15.setText("Tiene 0 segundos para responder");
                bResponder.setEnabled(false);
                t15.stop();           
                segundos15 = 15;
                contPreguntas++;
                Partida();
            } 
        }
<<<<<<< HEAD
   };      
=======
   };  
   
       //TEMPORIZADOR 10 minutos
    @SuppressWarnings("Unchecked")

    public ActionListener acciones10min =new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent ae) { 
            
               if(segundos_partida==0){
                  minutos_partida--;
                  segundos_partida=60;
               }
               
               segundos_partida--;
               ActualizarJLabel();
               if(segundos_partida==0 & minutos_partida==0){
                   t_partida.stop();
                   tts.stopSpeaking();
                   JOptionPane.showMessageDialog(null, "¡El tiempo ha terminado!");
                   guardarRespuestaFrame(p);
               }
            }

   };
    //actualiza el label del temporizador de toda la partida
    public void ActualizarJLabel(){
        String tiempo= "0"+minutos_partida+":"+(segundos_partida<=9?"0":"")+segundos_partida;
        Tiempo_partida.setText(tiempo);
            
     }
    
  
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
               
    
   public void guardarRespuestaFrame(Participante p) {        
        Guardar_respuestas a = new Guardar_respuestas(p);
        a.setVisible(true);
        this.dispose();       
   }    
    


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taRespuesta = new javax.swing.JTextArea();
        Tiempo_partida = new javax.swing.JLabel();
        cont_pregunta = new javax.swing.JLabel();
        bResponder = new javax.swing.JButton();
        bRegistrarPregunta = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        lPrueba5 = new javax.swing.JLabel();
        lPrueba15 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taRespuesta.setColumns(20);
        taRespuesta.setRows(5);
        jScrollPane1.setViewportView(taRespuesta);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 486, 149));

        Tiempo_partida.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Tiempo_partida.setForeground(new java.awt.Color(255, 255, 255));
        Tiempo_partida.setText("10:00");
        getContentPane().add(Tiempo_partida, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 32, 70, 30));

        cont_pregunta.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        cont_pregunta.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(cont_pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 50, 40));

        bResponder.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bResponder.setText("RESPONDER");
        bResponder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bResponderMouseClicked(evt);
            }
        });
        bResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResponderActionPerformed(evt);
            }
        });
        bResponder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bResponderKeyPressed(evt);
            }
        });
        getContentPane().add(bResponder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 150, 40));

        bRegistrarPregunta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bRegistrarPregunta.setText("REGISTRAR PREGUNTA");
        bRegistrarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarPreguntaActionPerformed(evt);
            }
        });
        bRegistrarPregunta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bRegistrarPreguntaKeyPressed(evt);
            }
        });
        getContentPane().add(bRegistrarPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 270, 40));

        bStart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bStart.setText("START");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });
        getContentPane().add(bStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        lPrueba5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lPrueba5.setForeground(new java.awt.Color(255, 255, 255));
        lPrueba5.setText("Tiene 5 segundos para presionar el botón responder");
        getContentPane().add(lPrueba5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 510, 18));

        lPrueba15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lPrueba15.setForeground(new java.awt.Color(255, 255, 255));
        lPrueba15.setText("Tiene 15 segundos para responder");
        getContentPane().add(lPrueba15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 500, -1));

        fondo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ronda_pregunta.PNG"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Funciones para habilitar y desahabilitar la caja de texto y registrar respuesta
    public void deshabilitar() { 
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false); 
        bResponder.setEnabled(true);
    }
    
    public void habilitar() { 
        bRegistrarPregunta.setEnabled(true);
        taRespuesta.setEnabled(true);
    }

<<<<<<< HEAD
    /**/
=======
    
    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed
        habilitar();
        //calcular tiempo que se tardo en presionar RESPONDER
        TFin=System.currentTimeMillis();
        long resta= TFin-TInicio;
        float  calcular_tiempo= (float)resta/1000;
        tiempo=String.format("%.3f", calcular_tiempo);
        //parar timer 5seg
        t5.stop();
        tts.stopSpeaking();
        lPrueba5.setText("Tiene 0 segundos para presionar el botón responder");
        segundos5 = 5;
        t15.start();        
    }//GEN-LAST:event_bResponderActionPerformed

>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
    private void bRegistrarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaActionPerformed
       Respuesta respuesta;
       String s = taRespuesta.getText(); //VALIDAR SI ESTA VACÍO
       int tiempoRespuesta = 0;
       respuesta = new Respuesta(s,tiempoRespuesta);
       p.getRespuestasP().agregarRespuesta(respuesta);
       taRespuesta.setText(" ");
       deshabilitar();
       t15.stop();
       segundos15 = 15;
       contPreguntas++;
       Partida();
       estado = false; //VUELVE A SU ESTADO ORIGINAL
 
    }//GEN-LAST:event_bRegistrarPreguntaActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
       Partida();      
<<<<<<< HEAD
       bStart.setEnabled(false);       

=======
       bStart.setEnabled(false);
       t_partida.start();
>>>>>>> 629bf66e5be151e30225789843b1ac589557d7eb
    }//GEN-LAST:event_bStartActionPerformed

    private void bRegistrarPreguntaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaKeyPressed
       
       
    }//GEN-LAST:event_bRegistrarPreguntaKeyPressed

    private void bResponderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bResponderKeyPressed
        /*String ch = String.valueOf(evt.getKeyChar());
        if (ch.equals(1)) {
             habilitar();
            //bResponder.setEnabled(false); //Ponerlo en habilitar 
            t5.stop();
            segundos = 5;
            ActualizarJLabel(0, lPrueba5);
            t15.start();
        }  */ 
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            //tts.getTts().cancel();
            tts.stopSpeaking();
            habilitar();
            t5.stop();
            lPrueba5.setText("Tiene 0 segundos para presionar el botón responder");
            segundos5 = 5;
            t15.start();
    }//GEN-LAST:event_bResponderKeyPressed

    private void bResponderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bResponderMouseClicked
       
    }//GEN-LAST:event_bResponderMouseClicked

    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed

        habilitar();
        bResponder.setEnabled(false);
        t5.stop();
        tts.stopSpeaking();
        segundos = 5;
        ActualizarJLabel(0, lPrueba5);
        t15.start();
        estado = true;          

       
    }//GEN-LAST:event_bResponderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tiempo_partida;
    private javax.swing.JButton bRegistrarPregunta;
    private javax.swing.JButton bResponder;
    private javax.swing.JButton bStart;
    private javax.swing.JLabel cont_pregunta;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lPrueba15;
    private javax.swing.JLabel lPrueba5;
    private javax.swing.JTextArea taRespuesta;
    // End of variables declaration//GEN-END:variables
}
