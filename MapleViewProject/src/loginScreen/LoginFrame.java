/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginScreen;

import SignupScreen.SignupFrame;

/**
 *
 * @author usman
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    private static final String EMAIL_PATTERN = 
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        signUpNowLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        forgotPassword = new javax.swing.JLabel();
        orLabel = new javax.swing.JLabel();
        leftPane = new javax.swing.JPanel();
        logoImage = new javax.swing.JLabel();
        mapleLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginCredLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MapleView");
        setBackground(new java.awt.Color(255, 51, 102));
        setBounds(new java.awt.Rectangle(500, 300, 500, 300));
        setForeground(java.awt.Color.red);
        setMinimumSize(new java.awt.Dimension(1000, 555));
        getContentPane().setLayout(null);

        loginButton.setBackground(new java.awt.Color(255, 102, 102));
        loginButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-login-50.png"))); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(580, 320, 108, 36);

        signUpButton.setBackground(new java.awt.Color(0, 102, 255));
        signUpButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-user-male-50.png"))); // NOI18N
        signUpButton.setText("Sign Up Now!");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signUpButton);
        signUpButton.setBounds(550, 430, 170, 36);

        signUpNowLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        signUpNowLabel.setText("Don't Have an Account?");
        getContentPane().add(signUpNowLabel);
        signUpNowLabel.setBounds(560, 410, 159, 16);

        emailLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        emailLabel.setText("Email");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(460, 170, 32, 16);

        passLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        passLabel.setText("Password");
        getContentPane().add(passLabel);
        passLabel.setBounds(460, 240, 56, 16);

        emailField.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailField);
        emailField.setBounds(460, 190, 353, 30);

        passwordField.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 12)); // NOI18N
        getContentPane().add(passwordField);
        passwordField.setBounds(460, 260, 350, 30);

        forgotPassword.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        forgotPassword.setText("Forgot Password?");
        getContentPane().add(forgotPassword);
        forgotPassword.setBounds(580, 370, 101, 16);

        orLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        orLabel.setText("OR");
        getContentPane().add(orLabel);
        orLabel.setBounds(620, 390, 18, 16);

        leftPane.setBackground(new java.awt.Color(0, 153, 255));
        leftPane.setLayout(null);

        logoImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo-removebg-preview-(1).png"))); // NOI18N
        leftPane.add(logoImage);
        logoImage.setBounds(80, 20, 150, 110);

        mapleLabel1.setFont(new java.awt.Font("Montserrat Black", 0, 18)); // NOI18N
        mapleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        mapleLabel1.setText("MapleView by MapleTech");
        leftPane.add(mapleLabel1);
        mapleLabel1.setBounds(50, 120, 274, 50);

        jLabel1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-gmail-logo-50.png"))); // NOI18N
        jLabel1.setText("Contact Support");
        leftPane.add(jLabel1);
        jLabel1.setBounds(70, 490, 160, 16);

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("<html>An image editor with a place to edit & share art with your loved onlines!</html>");
        leftPane.add(jLabel2);
        jLabel2.setBounds(10, 220, 320, 100);

        getContentPane().add(leftPane);
        leftPane.setBounds(0, 0, 310, 520);

        loginCredLabel.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 24)); // NOI18N
        loginCredLabel.setText("Login Using Your Credentials");
        getContentPane().add(loginCredLabel);
        loginCredLabel.setBounds(450, 90, 400, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        setVisible(false);
        SignupFrame s1=new SignupFrame();
        s1.setVisible(true);
       // TODO add your handling code here:
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel forgotPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel leftPane;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginCredLabel;
    private javax.swing.JLabel logoImage;
    private javax.swing.JLabel mapleLabel1;
    private javax.swing.JLabel orLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUpNowLabel;
    // End of variables declaration//GEN-END:variables
}
