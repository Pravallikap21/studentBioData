 package com.mycompany.studentbiodata;
 import java.awt.CardLayout;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;
 public class RemoveStudentPanel extends javax.swing.JPanel {
 public RemoveStudentPanel() {
 initComponents();
 }
 private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {
 String query = "delete from studentBiodata where ROLLNUMBER = ?";
 ProcessData processData = new ProcessData(query);
 boolean status = processData.removeStudent( rollNumberToRemoveField.getText());
 if (status) {
 removeStatus.setText(rollNumberToRemoveField.getText()
 Successfully");
 } else {
 removeStatus.setText("No such roll number found..");} }
 + " removed
 private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {
 adminPanelRef.adminHomePanel.remove(this);
 adminPanelRef.adminHomePanel.add(adminPanelRef.homePanel);
 adminPanelRef.adminHomePanel.repaint();
 adminPanelRef.adminHomePanel.revalidate();
 }
 AdminPanel adminPanelRef=null;
 
public void AdminPanelReference(AdminPanel adminPanelRef){
 this.adminPanelRef = adminPanelRef;
 }
 private javax.swing.JButton backBtn;
 private javax.swing.JButton removeBtn; private javax.swing.JLabel removeStatus;
 private javax.swing.JPanel removeStudentPanel; private javax.swing.JLabel rollNumber;
 private javax.swing.JTextField rollNumberToRemoveField;
 }
 