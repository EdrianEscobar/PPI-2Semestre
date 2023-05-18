package vista;

import javax.swing.JOptionPane;
import datos.LoginDAO;
import java.awt.event.KeyEvent;
import modelo.Loginn;


public class RegistroUsuarios extends javax.swing.JFrame {

    Loginn login = new Loginn();
    LoginDAO loginDAO = new LoginDAO();

    
    public RegistroUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Se encarga de validar y registrar el usuario y redirigirlo al login principal.
     */
    public void validar() {
        String correo = txtCorreoUsuario.getText();
        String password = String.valueOf(txtPasswordUsuario.getPassword());
        String nombre = txtNombreUsuario.getText();
        String rol = cmbRolUsuario.getSelectedItem().toString();

        if (!"".equals(correo) || !"".equals(password) || !"".equals(nombre)) {
            login.setNombre(nombre);
            login.setCorreo(correo);
            login.setRol(rol);
            login.setPassword(password);

            loginDAO.registrarUsuario(login);

            Login loginApp = new Login();
            loginApp.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "¡Debes ingresar datos!", "Registro inválido", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        labelCorreoElectronicoUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        labelPasswordUsuario = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        labelNombreUsuario = new javax.swing.JLabel();
        txtCorreoUsuario = new javax.swing.JTextField();
        labelRlUsuario = new javax.swing.JLabel();
        cmbRolUsuario = new javax.swing.JComboBox<>();
        labelLogo = new javax.swing.JLabel();
        txtPasswordUsuario = new javax.swing.JPasswordField();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(255, 255, 255));

        panelLogin.setBackground(new java.awt.Color(208, 223, 226));
        panelLogin.setPreferredSize(new java.awt.Dimension(650, 472));

        labelCorreoElectronicoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCorreoElectronicoUsuario.setForeground(new java.awt.Color(0, 51, 255));
        labelCorreoElectronicoUsuario.setText("Correo Electrónico");

        txtNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        labelPasswordUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPasswordUsuario.setForeground(new java.awt.Color(0, 51, 255));
        labelPasswordUsuario.setText("Password");

        btnRegistrarse.setBackground(new java.awt.Color(0, 51, 255));
        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        labelNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNombreUsuario.setForeground(new java.awt.Color(0, 51, 255));
        labelNombreUsuario.setText("Nombre");

        txtCorreoUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCorreoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoUsuarioActionPerformed(evt);
            }
        });

        labelRlUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelRlUsuario.setForeground(new java.awt.Color(0, 51, 255));
        labelRlUsuario.setText("Rol");

        cmbRolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Asistente" }));
        cmbRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolUsuarioActionPerformed(evt);
            }
        });

        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesGoHome/V1.png"))); // NOI18N

        txtPasswordUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPasswordUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordUsuarioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPasswordUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(labelRlUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLoginLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(labelCorreoElectronicoUsuario))
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLogo)
                            .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(labelPasswordUsuario))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(labelNombreUsuario)))
                        .addContainerGap(91, Short.MAX_VALUE))))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(labelCorreoElectronicoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPasswordUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPasswordUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRlUsuario)
                    .addComponent(cmbRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));
        getContentPane().add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 210, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        this.validar();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void cmbRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRolUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRolUsuarioActionPerformed

    private void txtPasswordUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordUsuarioKeyTyped
        int key = evt.getKeyChar();
        
        boolean numeros = key >=48 && key <= 57;
        if (!numeros)
        {   evt.consume();
        }
               
        
            // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordUsuarioKeyTyped

    private void txtCorreoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoUsuarioActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();
        
        boolean mayusc = key >= 65 && key <=90;
        boolean minusc = key >= 97 && key <=122;
        boolean espacio = key == 32;
        
        if(!(minusc || mayusc || espacio))
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped
      
        
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroUsuarios().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JComboBox<String> cmbRolUsuario;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JLabel labelCorreoElectronicoUsuario;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelNombreUsuario;
    private javax.swing.JLabel labelPasswordUsuario;
    private javax.swing.JLabel labelRlUsuario;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JPasswordField txtPasswordUsuario;
    // End of variables declaration//GEN-END:variables
}
