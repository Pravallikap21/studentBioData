 package com.mycompany.studentbiodata;
 import java.awt.Dimension;
 import java.awt.Image;
 import java.sql.*;
 
import javax.swing.*;
 public class ProcessData {
 private Connection con = null;
 private PreparedStatement preparedStatement = null;
 ProcessData(){
 con = GetConnection.createConnection();
 }
 public ProcessData(String query) {
 try {
 con = GetConnection.createConnection();
 preparedStatement = con.prepareStatement(query);
 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, ex.getMessage());} }
 public void setPreparedStatement(String query){
 try {
 preparedStatement = con.prepareStatement(query);
 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, ex.getMessage());
 } }
 public boolean removeStudent(String rollNumber) {
 try {
 preparedStatement.setString(1, rollNumber);
 int x = preparedStatement.executeUpdate();
 if (x == 0) {
 return false;
 }
 } catch (SQLException sqlException) {
 JOptionPane.showMessageDialog(null, sqlException.getMessage());
 }
 return true;
 
}
 public boolean verifyAdminDetails(String userName, String password) {
 try {
 preparedStatement.setString(1, userName);
 preparedStatement.setString(2, password);
 ResultSet s = preparedStatement.executeQuery();
 if (s.next()) {
 return true;
 }
 } catch (SQLException e) {
 JOptionPane.showMessageDialog(null, e.getMessage());
 }
 return false;
 }
 public boolean addStudent(SetGetStudentData setGetStudentData) {
 try {
 preparedStatement.setString(1, setGetStudentData.getName());
 preparedStatement.setString(13, setGetStudentData.getRollNumber());
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
 preparedStatement.setBlob(12, setGetStudentData.getPhotoPath());
 System.out.println(setGetStudentData.getPhotoPath());

int x = preparedStatement.executeUpdate();
 if (x == 0) {
 return false;
 }
 } catch (Exception s) {
 String errorMessage = s.getMessage();
 if (errorMessage.contains("date") | errorMessage.contains("format")) {
 JOptionPane.showMessageDialog(null, "Date formatting error occurred: " +
 errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
 } else {
 JOptionPane.showMessageDialog(null, "An error occurred: " + errorMessage,
 "Error", JOptionPane.ERROR_MESSAGE);
 }
 return false;
 }
 return true;
 }
 public String getFileExtension(String fileName) {
 int lastDotIndex = fileName.lastIndexOf('.');
 if (lastDotIndex ==-1) {
 return "";
 }
 return fileName.substring(lastDotIndex);
 }
 public boolean nullCheck(SetGetStudentData setGetStudentData){
 if(setGetStudentData.getName() != null && setGetStudentData.getRollNumber() != null
 &&
 setGetStudentData.getFatherName()
 !=
 null
 &&
 setGetStudentData.getMotherName() != null && setGetStudentData.getDateOfBirth() != null
 && setGetStudentData.getGender() != null && setGetStudentData.getEmail() != null &&
 setGetStudentData.getBranch()
 !=
 null
 &&
 setGetStudentData.getAttendancePercentage() !=0 && setGetStudentData.getCgpa() != 0
 && setGetStudentData.getCourseDuration() != null && setGetStudentData.getAddress() !=
 null && setGetStudentData.getPhotoPath() != null){
 return true;
 }
 
else
 return false;
 }
 