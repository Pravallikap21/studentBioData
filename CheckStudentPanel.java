 package com.mycompany.studentbiodata;
 import java.awt.Dimension;
 import java.awt.Image;
 import java.sql.*;
 import java.util.logging.Level;
 private
 javax.swing.JButton
 
import java.util.logging.Logger;
 import javax.swing.*;
 public class CheckStudentPanel extends javax.swing.JPanel {
 public CheckStudentPanel() {
 initComponents();
 }
 private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {
 studentPhoto.setText("");
 studentPhoto.setIcon(null);
 try {
 Connection con = GetConnection.createConnection();
 String query = "SELECT * FROM studentBiodata WHERE ROLLNUMBER = ?";
 PreparedStatement statement = con.prepareStatement(query);
 statement.setString(1, rollNumberCheckField.getText());
 ResultSet rs;
 rs = statement.executeQuery();
 DefaultTableModel tModel = (DefaultTableModel) studentData.getModel();
 Object[] values = {"Name", "Roll Number", "Father Name", "Mother Name", "Date
 Of Birth", "Gender", "Email", "Branch", "Attendance(%)", "CGPA", "Course Duration",
 "Address"};
 for (int i = 0; i < values.length; i++) { tModel.setValueAt(values[i], i, 0);}
 for (int i = 0; i < 12; i++) {tModel.setValueAt(null, i, 1);}
 if (rs.next() != false) {
 Blob blob = rs.getBlob("photo");
 byte[] imageData = blob.getBytes(1, (int) blob.length());
 ImageIcon imageIcon = new ImageIcon(imageData);
 Image image = imageIcon.getImage();
 Image
 resizedImage
 Image.SCALE_SMOOTH);
 =
 image.getScaledInstance(300,
 300,
 studentPhoto.setIcon(new ImageIcon(resizedImage));
 studentData.setPreferredSize(new
 imageIcon.getIconHeight()));
 Dimension(imageIcon.getIconWidth(),
 
Object[] obj = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
 rs.getDate(5),
 rs.getString(6),
 rs.getString(7),
 rs.getDouble(10), rs.getString(11), rs.getString(12)};
 rs.getString(8),
 rs.getDouble(9),
 for (int i = 0; i < obj.length; i++) { tModel.setValueAt(obj[i], i, 1);}
 } else {
 studentPhoto.setText("Student Not Found");
 studentPhoto.setSize(12, 12);
 }} catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, ex.getMessage());
 } }
 private void checkBackBtnActionPerformed(java.awt.event.ActionEvent evt) {
 adminPanelRef.adminHomePanel.remove(this);adminPanelRef.adminHomePanel.add(admin
 PanelRef.homePanel);
 adminPanelRef.adminHomePanel.repaint();adminPanelRef.adminHomePanel.revalidate();
 }
 AdminPanel adminPanelRef=null;
 public void AdminPanelReference(AdminPanel adminPanelRef){
 this.adminPanelRef = adminPanelRef;
 }
 private javax.swing.JButton checkBackBtn; private javax.swing.JButton checkBtn;
 private javax.swing.JScrollPane jScrollPane1;
 rollNumberCheckField;
 private javax.swing.JTextField
 private javax.swing.JLabel rollNumberLabel; private javax.swing.JTable studentData;
 private javax.swing.JLabel studentPhoto;
 }
 