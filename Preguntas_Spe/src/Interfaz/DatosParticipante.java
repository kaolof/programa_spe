package Interfaz;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import archivos.ManejoArchivos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import preguntas_spe.Participante;

public class DatosParticipante extends javax.swing.JFrame {
    
    private Participante p;
    String ruta_archivo;
    ArrayList <String> preguntas;

    public DatosParticipante() {
        initComponents();      
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbComenzar = new javax.swing.JButton();
        lNombre = new javax.swing.JLabel();
        lApellido = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellido = new javax.swing.JTextField();
        Cargar_preguntas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbComenzar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbComenzar.setText("Comenzar ronda");
        jbComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComenzarActionPerformed(evt);
            }
        });
        getContentPane().add(jbComenzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 190, -1));

        lNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setText("Nombre:");
        getContentPane().add(lNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 20));

        lApellido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lApellido.setForeground(new java.awt.Color(255, 255, 255));
        lApellido.setText("Apellido:");
        getContentPane().add(lApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 100, 20));
        getContentPane().add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 290, 20));
        getContentPane().add(tfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 290, 20));

        Cargar_preguntas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Cargar_preguntas.setText("Cargar preguntas");
        Cargar_preguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_preguntasActionPerformed(evt);
            }
        });
        getContentPane().add(Cargar_preguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/datos_participante.PNG"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComenzarActionPerformed
        String nombre = "", apellido = "";
        validar(tfNombre);
        nombre = tfNombre.getText();
        validar(tfApellido);
        apellido = tfApellido.getText();
        p = new Participante(nombre,apellido);
        
        Ronda_pregunta a = new Ronda_pregunta(preguntas, p);
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbComenzarActionPerformed
    
//Añadir validacion de que no puede iniciar sin cargar las preguntas 
    private void Cargar_preguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_preguntasActionPerformed
        JFileChooser jf= new JFileChooser();
        jf.showOpenDialog(this);
        File archivo= jf.getSelectedFile();
        if(archivo != null){
            ruta_archivo=archivo.getAbsolutePath();
        }
        try {
            preguntas = ManejoArchivos.leerArchivo(ruta_archivo); 
                  
        } catch (IOException ex) {
            Logger.getLogger(DatosParticipante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_Cargar_preguntasActionPerformed

    private void validar(JTextField tf) {
        if (tf.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "El campo no puede esta vacío");  
        }             
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar_preguntas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbComenzar;
    private javax.swing.JLabel lApellido;
    private javax.swing.JLabel lNombre;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
