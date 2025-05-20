 package com.mycompany.studentbiodata;
 import java.awt.Dimension;
 import java.awt.Image;
 import java.io.*;
 import java.sql.*;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Enumeration;
 import javax.swing.*;
 public class UpdateStudentPanel extends javax.swing.JPanel {
 SetGetStudentData setGetStudentData=null;
 public UpdateStudentPanel() {
 SetGetStudentData setGetStudentData = new SetGetStudentData();
 initComponents();
 }
 boolean changePhotoStatus = false;
 private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {
 setGetStudentData.setName(studentNameField1.getText());
 setGetStudentData.setRollNumber(rollNumberField1.getText());
 setGetStudentData.setFatherName(fatherNameField1.getText());
 setGetStudentData.setMotherName(motherNameField1.getText());
 setGetStudentData.setDateOfBirth(dateOfBirthField1.getText());
 
setGetStudentData.setEmail(emailIdField1.getText());
 setGetStudentData.setBranch(branchField1.getText());
 if(attendaceField1.getText().isEmpty()){
 setGetStudentData.setAttendancePercentage(0.0);
 }else{
 setGetStudentData.setAttendancePercentage(Double.parseDouble(attendaceField1.getText()))
 ;
 }
 if(gpaField1.getText().isEmpty()){
 setGetStudentData.setCgpa(0.0);
 }else{
 setGetStudentData.setCgpa(Double.parseDouble(gpaField1.getText()));
 }
 setGetStudentData.setAddress(addressField1.getText());
 setGetStudentData.setCourseDuration((String) courseDurationField1.getSelectedItem());
 Enumeration<AbstractButton> buttons = gender.getElements();
 while (buttons.hasMoreElements()) {
 AbstractButton button = buttons.nextElement();
 if (button.isSelected()) {
 setGetStudentData.setGender(button.getText());
 break;
 }}
 ProcessData processData = new ProcessData();
 if(changePhotoStatus){
 if (processData.nullCheck(setGetStudentData)) {
 String query = "UPDATE STUDENTBIODATA SET NAME = ?,
 FATHERNAME = ?, MOTHERNAME = ?, DATEOFBIRTH = ?, GENDER = ?, EMAIL
 = ?, BRANCH = ?, ATTENDANCEPERCENTAGE = ?, CGPA = ?, COURSEDURATION
 = ?, ADDRESS =?, PHOTO=?,WHEREROLLNUMBER=?";
 processData.setPreparedStatement(query);
 boolean status = processData.addStudent(setGetStudentData);
 if (status) {
 
JOptionPane.showMessageDialog(null, "Data successfully saved.");
 } else {
 JOptionPane.showMessageDialog(null, "Data not saved");
 } }
 else {
 JOptionPane.showMessageDialog(null, "Enter all Fields to Save");
 }}
 else{
 if (setGetStudentData.getName() != null&& setGetStudentData.getRollNumber() !=
 null
 &&
 setGetStudentData.getFatherName()
 !=
 null
 &&
 setGetStudentData.getMotherName() != null && setGetStudentData.getDateOfBirth() != null
 && setGetStudentData.getGender() != null && setGetStudentData.getEmail() != null&&
 setGetStudentData.getBranch() != null && setGetStudentData.getAttendancePercentage() !=
 0 &&setGetStudentData.getCgpa() != 0 && setGetStudentData.getCourseDuration() != null
 &&setGetStudentData.getAddress() != null) {
 try {
 Connection con = GetConnection.createConnection();
 String query = "UPDATE STUDENTBIODATA SET NAME = ?,
 FATHERNAME = ?, MOTHERNAME = ?, DATEOFBIRTH = ?, GENDER = ?, EMAIL
 = ?, BRANCH = ?, ATTENDANCEPERCENTAGE = ?, CGPA = ?, COURSEDURATION
 = ?, ADDRESS =?,WHEREROLLNUMBER=?";
 PreparedStatement preparedStatement = con.prepareStatement(query);
 preparedStatement.setString(1, setGetStudentData.getName());
 preparedStatement.setString(12, setGetStudentData.getRollNumber());
 preparedStatement.setString(2, setGetStudentData.getFatherName());
 preparedStatement.setString(3, setGetStudentData.getMotherName());
 preparedStatement.setString(4, setGetStudentData.getDateOfBirth());
 preparedStatement.setString(5, setGetStudentData.getGender());
 preparedStatement.setString(6, setGetStudentData.getEmail());
 preparedStatement.setString(7, setGetStudentData.getBranch());
 preparedStatement.setDouble(8, setGetStudentData.getAttendancePercentage());
 preparedStatement.setDouble(9, setGetStudentData.getCgpa());
 preparedStatement.setString(10, setGetStudentData.getCourseDuration());
 preparedStatement.setString(11, setGetStudentData.getAddress());
 int x = preparedStatement.executeUpdate();
 
if (x == 1) {
 JOptionPane.showMessageDialog(null, "Data successfully saved.");
 } else {
 throw new SQLException("Error something went wrong!!!");
 } } catch (Exception s) {
 JOptionPane.showMessageDialog(null, "Unexcepted-Error");
 adminPanelRef.dispose();
 s.printStackTrace();
 } }
 else {
 JOptionPane.showMessageDialog(null, "Enter all Fields to Save");
 }}}
 private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {
 adminPanelRef.adminHomePanel.remove(this);
 adminPanelRef.adminHomePanel.add(adminPanelRef.homePanel);
 adminPanelRef.adminHomePanel.repaint();
 adminPanelRef.adminHomePanel.revalidate();
 }
 AdminPanel adminPanelRef=null;
 public void AdminPanelReference(AdminPanel adminPanelRef){
 this.adminPanelRef = adminPanelRef;
 }
 private void checkUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {
 setGetStudentData = new SetGetStudentData();
 try {
 String rollNumber = updateRollNumberField.getText();
 Connection con = GetConnection.createConnection();
 String query = "Select * from studentbiodata where rollNumber = ?";
 PreparedStatement statement = con.prepareStatement(query);
 statement.setString(1, rollNumber);
 
ResultSet rs = statement.executeQuery();
 if (rs.next() != false) {
 System.out.println(rs);
 Object[] obj = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
 rs.getDate(5),
 rs.getString(6),
 rs.getString(7),
 rs.getDouble(10), rs.getString(11), rs.getString(12)};
 setGetStudentData.setName((String) obj[0]);
 rs.getString(8),
 setGetStudentData.setRollNumber((String) obj[1]);
 setGetStudentData.setFatherName((String) obj[2]);
 setGetStudentData.setMotherName((String) obj[3]);
 Date date = (Date) obj[4];
 String pattern = "dd-MM-yyyy";
 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
 setGetStudentData.setDateOfBirth(sdf.format(date));
 setGetStudentData.setEmail((String) obj[6]);
 setGetStudentData.setBranch((String) obj[7]);
 setGetStudentData.setAttendancePercentage((double) obj[8]);
 setGetStudentData.setCgpa((double) obj[9]);
 setGetStudentData.setAddress((String) obj[11]);
 setGetStudentData.setCourseDuration((String) obj[10]);
 switch ((String)obj[5]) {
 rs.getDouble(9),
 case "Male": male1.setSelected(true); setGetStudentData.setGender("Male");
 break;
 case "Female": female1.setSelected(true);setGetStudentData.setGender("Male");
 break;
 case "others": others1.setSelected(true); setGetStudentData.setGender("Male");
 break;
 }
 Blob blob = rs.getBlob("photo");
 byte[] imageData = blob.getBytes(1, (int) blob.length());
 ImageIcon imageIcon = new ImageIcon(imageData);
 
Image image = imageIcon.getImage();
 Image
 resizedImage
 Image.SCALE_SMOOTH);
 =
 image.getScaledInstance(300,
 photoStudent.setIcon(new ImageIcon(resizedImage));
 photoStudent.setPreferredSize(new
 300,
 Dimension(imageIcon.getIconWidth(),
 imageIcon.getIconHeight()));
 studentNameField1.setText(setGetStudentData.getName());
 rollNumberField1.setText(setGetStudentData.getRollNumber());
 fatherNameField1.setText(setGetStudentData.getFatherName());
 motherNameField1.setText(setGetStudentData.getMotherName());
 dateOfBirthField1.setText(setGetStudentData.getDateOfBirth());
 emailIdField1.setText(setGetStudentData.getEmail());
 branchField1.setText(setGetStudentData.getBranch());
 attendaceField1.setText(String.valueOf(setGetStudentData.getAttendancePercentage()));
 gpaField1.setText(String.valueOf(setGetStudentData.getCgpa()));
 courseDurationField1.setSelectedItem(setGetStudentData.getCourseDuration());
 addressField1.setText(setGetStudentData.getAddress());
 }
 else{
 JOptionPane.showMessageDialog(null, "Roll Number does not exist");
 updateRollNumberField.setText(null);
 }
 } catch (SQLException e) {
 e.printStackTrace();}}
 private void changePhotoBtnActionPerformed(java.awt.event.ActionEvent evt) {
 JFileChooser fileChooser = new JFileChooser();
 int returnValue = fileChooser.showOpenDialog(null);
 ArrayList<String> ALLOWED_EXTENSIONS = new ArrayList<String>();
 ALLOWED_EXTENSIONS.add(".jpg"); ALLOWED_EXTENSIONS.add(".jpeg");
 ALLOWED_EXTENSIONS.add(".png"); ALLOWED_EXTENSIONS.add(".gif");
 
if (returnValue == JFileChooser.APPROVE_OPTION) {
 File selectedFile = fileChooser.getSelectedFile();
 ProcessData pd = new ProcessData();
 String extension = pd.getFileExtension(selectedFile.getAbsolutePath());
 try{
 if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
 throw new IllegalArgumentException("Photo Format Error");
 }
 else{
 try {
 ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
 Image image = imageIcon.getImage();
 Image
 resizedImage
 Image.SCALE_SMOOTH);
 =
 image.getScaledInstance(300,
 photoStudent.setIcon(new ImageIcon(resizedImage));
 changePhotoBtn.setText(selectedFile.getPath());
 uploadPhotoToDatabase(selectedFile);
 changePhotoStatus = true;
 } catch (SQLException ex) {
 300,
 JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error",
 JOptionPane.ERROR_MESSAGE);
 }
 catch(IOException ioe){
 }
 }}catch(IllegalArgumentException iae){
 changePhotoBtn.setText("Change Photo");
 setGetStudentData.setPhotoPath(null);
 JOptionPane.showMessageDialog(null, "Error:
 JOptionPane.ERROR_MESSAGE);
 }}}
 " + iae.getMessage(), "Error",
 private void uploadPhotoToDatabase(File selectedFile) throws SQLException, IOException
 {
 
try {
 FileInputStream studentPhotoFile = new FileInputStream(selectedFile);
 setGetStudentData.setPhotoPath(studentPhotoFile);
 } catch (IOException ex) {
 ex.printStackTrace(); }
 }
 private javax.swing.JTextArea addressField1;
 attendaceField1;
 private
 private javax.swing.JButton backBtn1;
 javax.swing.JTextField branchField1;
 javax.swing.JTextField
 private
 private javax.swing.JButton changePhotoBtn;
 private javax.swing.JButton checkUpdateBtn;
 private
 javax.swing.JComboBox<String> courseDurationField1; private
 dateOfBirthField1;
 private javax.swing.JLabel dobLabel;
 javax.swing.JTextField emailIdField1;
 fatherNameField1;
 private
 private javax.swing.JLabel fatherNameLabel;
 javax.swing.JTextField
 private
 javax.swing.JTextField
 private
 javax.swing.JRadioButton female1; private javax.swing.ButtonGroup gender;
 javax.swing.JTextField gpaField1; private
 private javax.swing.JRadioButton male1;
 javax.swing.JScrollPane
 private
 private
 jScrollPane3;
 javax.swing.JTextField
 motherNameField1; private javax.swing.JLabel motherNameLabel;
 private
 javax.swing.JRadioButton others1; private javax.swing.JLabel photoLabel;
 javax.swing.JLabel photoStudent;
 private
 private javax.swing.JLabel rollNumLabel; private
 javax.swing.JTextField rollNumberField1; private javax.swing.JLabel rollNumberLabel;
 private javax.swing.JTextField studentNameField1; private
 javax.swing.JLabel
 studentNameLabel; private javax.swing.JButton updateBtn;
 javax.swing.JTextField updateRollNumberField;
 private
 private
 javax.swing.JScrollPane
 updateStudentPane; private javax.swing.JPanel updateStudentPanel1;
 }
 