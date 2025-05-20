 package com.mycompany.studentbiodata;
 import java.io.FileInputStream;
 public class SetGetStudentData {
 private String name;
 private String rollNumber;
 private String fatherName; private String motherName;
 private String dateOfBirth;
 private String email;
 private String gender;
 private String branch;
 private double attendancePercentage;
 private String courseDuration;
 private FileInputStream photoPath;
 private double cgpa;
 private String address;
 
public void setPhotoPath(FileInputStream photoPath){
 this.photoPath= photoPath;
 }
 public FileInputStream getPhotoPath(){
 return photoPath;
 }
 public SetGetStudentData(){
 }
 public SetGetStudentData(String name, String rollNumber, String fatherName, String
 motherName, String dateOfBirth,
 String gender, String email, String branch, double attendancePercentage, double
 cgpa,
 String courseDuration, String address) {
 this.name = name; this.rollNumber = rollNumber; this.fatherName = fatherName;
 this.motherName = motherName;
 this.gender = gender;
 this.dateOfBirth = dateOfBirth;
 this.email = email;
 this.branch = branch;
 this.cgpa = cgpa;
 this.address = address;
 }
 public String getName() {
 return name;}
 this.attendancePercentage = attendancePercentage;
 this.courseDuration = courseDuration;
 public void setName(String name) {
 this.name = name;}
 public String getRollNumber() {
 return rollNumber;}
 public void setRollNumber(String rollNumber) {
 this.rollNumber = rollNumber;
 }
 public String getFatherName() {
 return fatherName;}
 
public void setFatherName(String fatherName) {
 this.fatherName = fatherName;}
 public String getMotherName() {
 return motherName;}
 public void setMotherName(String motherName) {
 this.motherName = motherName;
 }
 public String getDateOfBirth() {
 return dateOfBirth;
 }
 public void setDateOfBirth(String dateOfBirth) {
 this.dateOfBirth = dateOfBirth;
 }
 public String getGender() {
 return gender;
 }
 public void setGender(String gender) {
 this.gender = gender;
 }
 public String getEmail() {
 return email;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getBranch() {
 return branch;
 }
 public void setBranch(String branch) {
 this.branch = branch;
 
}
 public double getAttendancePercentage() {
 return attendancePercentage;
 }
 public void setAttendancePercentage(double attendancePercentage) {
 this.attendancePercentage = attendancePercentage;
 }
 public double getCgpa() {
 return cgpa;
 }
 public void setCgpa(double cgpa) {
 this.cgpa = cgpa;
 }
 public String getCourseDuration() {
 return courseDuration;
 }
 public void setCourseDuration(String courseDuration) {
 this.courseDuration = courseDuration;
 }
 public String getAddress() {
 return address;
 }
 public void setAddress(String address) {
 this.address = address;
 }}
 