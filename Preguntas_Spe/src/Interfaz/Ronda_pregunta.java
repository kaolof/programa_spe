
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import preguntas_spe.TextToSpeech;

public class Ronda_pregunta extends javax.swing.JFrame {

    private String[] preguntas={"the percentage of void space within rock that can contain fluids is known as what?","the pumping of acid into the wellbore to remove near-well formation damage and other substances"};
    private int minuto=10, segundos=5, segundos15=15, contPreguntas=0;
    TextToSpeech tts ;
    private Timer time, t;
        
    
    public Ronda_pregunta() {
        initComponents();
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false);
    }
    
    // 
   /* public void Partida(){
        tts = new TextToSpeech();
        int num=0;
        
        while(num<2){ 
            tts.speak(preguntas[num], 2.0f, false, true);
            num++;
        }        
        
    }*/
    
    public void Partida(){
        tts = new TextToSpeech();
        if (contPreguntas < preguntas.length) {
            if(tts.speak(preguntas[contPreguntas], 1.0f, false, true) == 1) {
                 
                time = new Timer(1000, new ActionListener() {         

                @Override
                public void actionPerformed(ActionEvent e) {   
                    lPrueba.setText("Tiene " +segundos+ " segundos para presionar el botón responder");
                    segundos--;                  
                    // Si pasan los 5s y no se presiona responder se reinicia el timer y se pasa a la siguiente pregunta  
                    if (segundos == 0) {
                        contPreguntas++;
                        time.stop();
                        segundos = 5;
                        Partida(); 
                    } //Agregar que si se presiona responder el temporizador se detenga
                }

            }); 
                time.start();
            } else { 
            JOptionPane.showMessageDialog(null, "¡Hubo un error al cargar las preguntas!");
        }

        } else { 
            JOptionPane.showMessageDialog(null, "¡La ronda ha terminado!");
        }
   
    }
    
    public void temporizador15 () {
        t = new Timer(1000, new ActionListener() {     //Timer de los 15s para responder    
        @Override
        public void actionPerformed(ActionEvent e) {   
            lRespuesta.setText("Tiene: " + segundos15 +" segundos para responder");
            segundos15--;            
            if (segundos15 == 0) { 
                lRespuesta.setText("Tiene: 0 segundos para responder");
                bResponder.setEnabled(false);
                t.stop();          
                segundos15 = 15; 
                contPreguntas++;
                Partida();
            }
        }


    });   
               
        t.start();
        
    }
            
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taRespuesta = new javax.swing.JTextArea();
        bResponder = new javax.swing.JButton();
        bRegistrarPregunta = new javax.swing.JButton();
        bStart = new javax.swing.JButton();
        lPrueba = new javax.swing.JLabel();
        lRespuesta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taRespuesta.setColumns(20);
        taRespuesta.setRows(5);
        jScrollPane1.setViewportView(taRespuesta);

        bResponder.setText("RESPONDER");
        bResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bResponderActionPerformed(evt);
            }
        });

        bRegistrarPregunta.setText("REGISTRAR PREGUNTA");
        bRegistrarPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarPreguntaActionPerformed(evt);
            }
        });

        bStart.setText("START");
        bStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStartActionPerformed(evt);
            }
        });

        lPrueba.setText("Tiene 5 segundos para presionar el botón responder");

        lRespuesta.setText("Tiene 15 segundos para responder");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(bRegistrarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bStart)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lRespuesta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lPrueba, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(bStart)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lRespuesta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(bRegistrarPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Funciones para habilitar y desahabilitar la caja de texto
    //y el botón registrar pregunta en cada partida 
    public void deshabilitar() { 
        bRegistrarPregunta.setEnabled(false);
        taRespuesta.setEnabled(false);       
    }
    
    public void habilitar() { 
        bRegistrarPregunta.setEnabled(true);
        taRespuesta.setEnabled(true);       
    }

    
    private void bResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bResponderActionPerformed
        habilitar();
        bResponder.setEnabled(false);
        //Interrumpir el temporizador time cuando presiono responder
        t = new Timer(1000, new ActionListener() {     //Timer de los 15s para responder    
        @Override
        public void actionPerformed(ActionEvent e) {   
            lRespuesta.setText("Tiene " + segundos15 +" segundos para responder");
            segundos15--;            
            if (segundos15 == 0) {  
                lRespuesta.setText("Tiene: 0 segundos para responder");
                bResponder.setEnabled(false);
                t.stop();           
                segundos15 = 15;    //Colocar que pasa si lo presionan antes de los quince segundos
                contPreguntas++;
                Partida();
            } 
        }


    });   
               
        t.start();
    }//GEN-LAST:event_bResponderActionPerformed

    private void bRegistrarPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarPreguntaActionPerformed
       deshabilitar();
       bResponder.setEnabled(false);
       
    }//GEN-LAST:event_bRegistrarPreguntaActionPerformed

    private void bStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStartActionPerformed
       Partida();      
       bStart.setEnabled(false);
    }//GEN-LAST:event_bStartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegistrarPregunta;
    private javax.swing.JButton bResponder;
    private javax.swing.JButton bStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lPrueba;
    private javax.swing.JLabel lRespuesta;
    private javax.swing.JTextArea taRespuesta;
    // End of variables declaration//GEN-END:variables
}
