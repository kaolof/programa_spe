package Interfaz;

public class Bienvenidos extends javax.swing.JFrame {

    public Bienvenidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbRegistrarme = new javax.swing.JButton();
        jbAcercaDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRegistrarme.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbRegistrarme.setText("Registrarme");
        jbRegistrarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarmeActionPerformed(evt);
            }
        });
        getContentPane().add(jbRegistrarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 170, -1));

        jbAcercaDe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jbAcercaDe.setText("Acerca de");
        jbAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcercaDeActionPerformed(evt);
            }
        });
        getContentPane().add(jbAcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRegistrarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarmeActionPerformed
       DatosParticipante a = new DatosParticipante();
       a.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jbRegistrarmeActionPerformed

    private void jbAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcercaDeActionPerformed
       AcercaDe a = new AcercaDe();
       a.setVisible(true);
       this.dispose();                  
    }//GEN-LAST:event_jbAcercaDeActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAcercaDe;
    private javax.swing.JButton jbRegistrarme;
    // End of variables declaration//GEN-END:variables
}
