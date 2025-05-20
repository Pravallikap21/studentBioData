 package com.mycompany.studentbiodata;
 import javax.swing.JOptionPane;
 public class LoginWindow extends javax.swing.JFrame {
 public LoginWindow() {
 initComponents();
 }
 private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
 String userName = userNameField.getText();
 String password = passwordField.getText();
 String query = "select * from admindata where username =? and password = ? ";
 ProcessData processData = new ProcessData(query);
 if(userName.isEmpty() | password.isEmpty()){
 System.out.println(userName + "Hello" +password);
 statusMessage.setVisible(true);
 if(userName.isEmpty() && password.isEmpty())
 statusMessage.setText("Please enter userName and Password");
 else if(password.isEmpty())
 statusMessage.setText("Please Enter password");
 else
 statusMessage.setText("Please enter username");
 }
 else if(processData.verifyAdminDetails(userName, password)){
 this.dispose();
 JOptionPane.showMessageDialog(null, "Login Successful");
 new AdminPanel().setVisible(true);
 }
 else{
 
statusMessage.setText("No admin Details Found...Check your credentials");
 } }
 public static void main(String args[]) {
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new LoginWindow().setVisible(true);
 } });
 }
 private javax.swing.JLabel adminLabel;
 private javax.swing.JButton loginBtn;
 private javax.swing.JPasswordField passwordField;
 private javax.swing.JLabel passwordLabel;
 private javax.swing.JLabel statusMessage;
 private javax.swing.JTextField userNameField;
 private javax.swing.JLabel userNameLabel;
 }
 