 package com.mycompany.studentbiodata;
 public class AdminPanel extends javax.swing.JFrame {
 public AdminPanel() {
 initComponents();
 }
 private
 javax.swing.JTextField
 studentNameField;
 private
 private void updateStudentDetailsActionPerformed(java.awt.event.ActionEvent evt) {
 UpdateStudentPanel usp = new UpdateStudentPanel();
 usp.setVisible(true);
 usp.AdminPanelReference(this);
 adminHomePanel.removeAll();
 adminHomePanel.repaint();
 }
 adminHomePanel.add(usp);
 adminHomePanel.revalidate();
 private void displayAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {
 DisplayAllStudentPanel dasp = new DisplayAllStudentPanel();
 dasp.setVisible(true);
 dasp.AdminPanelReference(this);
 adminHomePanel.removeAll(); adminHomePanel.add(dasp);
 adminHomePanel.repaint();
 }
 adminHomePanel.revalidate();
 private void checkStudentActionPerformed(java.awt.event.ActionEvent evt) {
 CheckStudentPanel csp = new CheckStudentPanel();
 csp.setVisible(true);
 csp.AdminPanelReference(this);
 adminHomePanel.removeAll();
 adminHomePanel.repaint();
 }
 adminHomePanel.add(csp);
 adminHomePanel.revalidate();
 9
private void removeStudentActionPerformed(java.awt.event.ActionEvent evt) {
 RemoveStudentPanel rsp = new RemoveStudentPanel();
 rsp.setVisible(true);
 rsp.AdminPanelReference(this);
 adminHomePanel.removeAll();
 adminHomePanel.repaint();
 }
 adminHomePanel.add(rsp);
 adminHomePanel.revalidate();
 private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {
 AddStudentPanel asp = new AddStudentPanel();
 asp.setVisible(true);
 asp.AdminPanelReference(this);
 adminHomePanel.removeAll();
 adminHomePanel.add(asp);adminHomePanel.repaint(); adminHomePanel.revalidate();
 }
 public static void main(String args[]) {
 java.awt.EventQueue.invokeLater(new Runnable() {
 public void run() {
 new AdminPanel().setVisible(true);
 }}); }
 private javax.swing.JButton addStudent;
 public javax.swing.JPanel adminHomePanel;
 checkStudent;
 private
 javax.swing.JButton
 private javax.swing.JButton displayAllStudents; public javax.swing.JPanel homePanel;
 private javax.swing.JButton removeStudent;
 updateStudentDetails;
 }
 