 package com.mycompany.studentbiodata;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;

import java.sql.SQLException;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import javax.swing.table.DefaultTableModel;
 public class DisplayAllStudentPanel extends javax.swing.JPanel {
 public DisplayAllStudentPanel() {
 initComponents();
 try {
 Connection con = GetConnection.createConnection();
 String query = "select * from studentBiodata";
 PreparedStatement statement = con.prepareStatement(query);
 ResultSet rs;
 rs = statement.executeQuery();
 DefaultTableModel model = (DefaultTableModel) studentDataTable.getModel();
 int i = 1;
 while (rs.next()) {
 Object[] obj = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
 rs.getDate(5),
 rs.getString(6),
 rs.getString(7),
 rs.getDouble(10), rs.getString(11), rs.getString(12)};
 model.addRow(obj);
 }
 } catch (SQLException ex) {
 rs.getString(8),
 rs.getDouble(9),
 Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);}}
 private void displayAllBackBtnActionPerformed(java.awt.event.ActionEvent evt) {
 adminPanelRef.adminHomePanel.remove(this);
 adminPanelRef.adminHomePanel.add(adminPanelRef.homePanel);
 adminPanelRef.adminHomePanel.repaint();
 adminPanelRef.adminHomePanel.revalidate();
 }
 AdminPanel adminPanelRef=null;
 public void AdminPanelReference(AdminPanel adminPanelRef){
 this.adminPanelRef = adminPanelRef;
 
}
 private javax.swing.JButton displayAllBackBtn;
 private javax.swing.JScrollPane displayAllStudentScroll;
 private javax.swing.JTable studentDataTable;
 }
 RemoveStudentPanel.java
 package com.mycompany.studentbi