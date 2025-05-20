 AddStudentPanel.java
 package com.mycompany.studentbiodata;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.Enumeration;
 import javax.swing*;
 public class AddStudentPanel extends javax.swing.JPanel {
 public AddStudentPanel() {
 setGetStudentData = new SetGetStudentData();
 initComponents();
 }
 
private void rollNumberFieldFocusLost(java.awt.event.FocusEvent evt) {
 String rollNumber = rollNumberField.getText();
 if (rollNumberCheck(rollNumber)) {
 JOptionPane.showMessageDialog(null,
 rollNumberField.setText("");
 }
 }
 "Roll
 public boolean rollNumberCheck(String rollNumber){
 try {
 number
 Connection con = GetConnection.createConnection();
 already
 String query = "Select * from studentBioData where rollnumber = ?";
 PreparedStatement statement = con.prepareStatement(query);
 statement.setString(1, rollNumberField.getText());
 ResultSet rs = statement.executeQuery();
 return rs.next();
 } catch (SQLException ex) {
 String errorMessage = ex.getMessage();
 exists!");
 JOptionPane.showMessageDialog(null, "An error occurred: " + errorMessage, "Error",
 JOptionPane.ERROR_MESSAGE);}
 return false;}
 private void photoSelectActionPerformed(java.awt.event.ActionEvent evt) {
 JFileChooser fileChooser = new JFileChooser();
 File selectedFile =null;
 int returnValue = fileChooser.showOpenDialog(null);
 ArrayList<String> ALLOWED_EXTENSIONS = new ArrayList<String>();
 ALLOWED_EXTENSIONS.add(".jpg"); ALLOWED_EXTENSIONS.add(".jpeg");
 ALLOWED_EXTENSIONS.add(".png"); ALLOWED_EXTENSIONS.add(".gif");
 if (returnValue == JFileChooser.APPROVE_OPTION) {
 selectedFile = fileChooser.getSelectedFile();
 ProcessData pd = new ProcessData();
 String extension = pd.getFileExtension(selectedFile.getAbsolutePath());
 
try{
 if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
 throw new IllegalArgumentException("Photo Format Error");
 }
 else{
 try {
 photoSelect.setText(selectedFile.getPath());
 uploadPhotoToDatabase(selectedFile);
 } catch (SQLException | IOException ex) {
 String errorMessage = ex.getMessage();
 JOptionPane.showMessageDialog(null, "An error occurred: " + errorMessage, "Error",
 JOptionPane.ERROR_MESSAGE);
 }
 }}catch(IllegalArgumentException iae){
 selectedFile=null;
 setGetStudentData.setPhotoPath(null);
 photoSelect.setText("select Photo");
 JOptionPane.showMessageDialog(null, "Error:
 JOptionPane.ERROR_MESSAGE);
 }}}
 SetGetStudentData setGetStudentData=null;
 " + iae.getMessage(), "Error",
 private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {
 setGetStudentData.setName(studentNameField.getText());
 setGetStudentData.setRollNumber(rollNumberField.getText());
 setGetStudentData.setFatherName(fatherNameField.getText());
 setGetStudentData.setMotherName(motherNameField.getText());
 setGetStudentData.setDateOfBirth(dateOfBirthField.getText());
 setGetStudentData.setEmail(emailIdField.getText());
 setGetStudentData.setBranch(branchField.getText());
 if(attendaceField.getText().isEmpty()){
 setGetStudentData.setAttendancePercentage(0.0);
 
}
 else{
 setGetStudentData.setAttendancePercentage(Double.parseDouble(attendaceField.getText()));
 }
 if(gpaField.getText().isEmpty()){
 else{
 setGetStudentData.setCgpa(0.0); }
 setGetStudentData.setCgpa(Double.parseDouble(gpaField.getText()));
 }setGetStudentData.setAddress(addressField.getText());
 setGetStudentData.setCourseDuration((String) courseDurationField.getSelectedItem());
 Enumeration<AbstractButton> buttons = gender.getElements();
 while (buttons.hasMoreElements()) {
 AbstractButton button = buttons.nextElement();
 if (button.isSelected()) { setGetStudentData.setGender(button.getText()); break;
 } }
 String query = "INSERT INTO STUDENTBIODATA (NAME, FATHERNAME,
 MOTHERNAME,
 DATEOFBIRTH,
 ATTENDANCEPERCENTAGE,
 CGPA,
 GENDER,
 EMAIL,
 COURSEDURATION,
 PHOTO,ROLLNUMBER)"
 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
 ProcessData processData = new ProcessData(query);
 if (processData.nullCheck(setGetStudentData)) {
 boolean status = processData.addStudent(setGetStudentData);
 if (status) {
 JOptionPane.showMessageDialog(null, "Data successfully saved.");
 } else {
 BRANCH,
 ADDRESS,
 JOptionPane.showMessageDialog(null, "Failed to save data ...Try again");
 }}
 else {
 JOptionPane.showMessageDialog(null, "Enter all Fields to Save");
 }}
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
 private void emailIdFieldFocusLost(java.awt.event.FocusEvent evt) {
 EmailVerifier ev = new EmailVerifier(emailIdField.getText());
 if(ev.verifyEmail()){
 }else{
 JOptionPane.showMessageDialog(null, "Email Format is not Correct");
 emailIdField.setText(null);}}
 private void uploadPhotoToDatabase(File selectedFile) throws SQLException, IOException
 {
 try {
 FileInputStream studentPhotoFile = new FileInputStream(selectedFile);
 setGetStudentData.setPhotoPath(studentPhotoFile);
 } catch (Exception ex) {
 String errorMessage = ex.getMessage();
 JOptionPane.showMessageDialog(null, "An error occurred: " + errorMessage, "Error",
 JOptionPane.ERROR_MESSAGE);
 }
 }
 private javax.swing.JTextArea addressField; private javax.swing.JTextField attendaceField;
 private javax.swing.JButton backBtn; private javax.swing.JTextField branchField; private
 javax.swing.JComboBox<String> courseDurationField; private javax.swing.JTextField
 dateOfBirthField;
 private
 javax.swing.JTextField
 emailIdField;
 private
 javax.swing.JTextField fatherNameField; private javax.swing.JRadioButton female; private
 javax.swing.ButtonGroup gender; private javax.swing.JTextField gpaField; private
 javax.swing.JLabel jLabel1; private javax.swing.JLabel jLabel10; private javax.swing.JLabel
 jLabel11; private javax.swing.JLabel jLabel12; private javax.swing.JLabel jLabel13; private
 javax.swing.JLabel jLabel15; private javax.swing.JLabel jLabel2; private javax.swing.JLabel
 jLabel3; private javax.swing.JLabel jLabel4; private javax.swing.JLabel jLabel6; private
 
javax.swing.JLabel jLabel7; private javax.swing.JLabel jLabel8; private javax.swing.JLabel
 jLabel9; private javax.swing.JScrollPane jScrollPane2; private javax.swing.JRadioButton
 male; private javax.swing.JTextField motherNameField; private javax.swing.JRadioButton
 others;
 private
 rollNumberField;
 javax.swing.JButton
 private
 photoSelect;
 javax.swing.JTextField
 javax.swing.JButton submitBtn;
 }
 