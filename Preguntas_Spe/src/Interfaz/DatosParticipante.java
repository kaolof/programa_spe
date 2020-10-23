package Interfaz;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import preguntas_spe.Participante;

public class DatosParticipante extends javax.swing.JFrame {
    
    private Participante p;
    String Ruta_archivo;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbComenzar.setText("Comenzar ronda");
        jbComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComenzarActionPerformed(evt);
            }
        });

        lNombre.setText("Nombre:");

        lApellido.setText("Apellido:");

        Cargar_preguntas.setText("Cargar preguntas");
        Cargar_preguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cargar_preguntasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jbComenzar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lApellido)
                                .addGap(18, 18, 18)
                                .addComponent(tfApellido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lNombre)
                                .addGap(18, 18, 18)
                                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Cargar_preguntas)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lApellido)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(Cargar_preguntas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jbComenzar)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComenzarActionPerformed
        String nombre, apellido;
        validar(tfNombre);
        nombre = tfNombre.getText();
        validar(tfApellido);
        apellido = tfApellido.getText();
            
        
        Ronda_pregunta a = new Ronda_pregunta();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbComenzarActionPerformed

    private void Cargar_preguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cargar_preguntasActionPerformed
        JFileChooser jf= new JFileChooser();
        jf.showOpenDialog(this);
        File archivo= jf.getSelectedFile();
        if(archivo != null){
            Ruta_archivo=archivo.getAbsolutePath();
        }
        
    }//GEN-LAST:event_Cargar_preguntasActionPerformed

    private void validar(JTextField tf) {
        if (tf.getText().isEmpty()) {
           JOptionPane.showMessageDialog(null, "El campo no puede esta vacío");
        }              
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar_preguntas;
    private javax.swing.JButton jbComenzar;
    private javax.swing.JLabel lApellido;
    private javax.swing.JLabel lNombre;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
