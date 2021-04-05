package application;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
private String name;
private String qualification;
private String gender;
private LocalDate dob;
public Person(String name, String qualification, String gender, LocalDate dob) {
	super();
	this.name = name;
	this.qualification = qualification;
	this.gender = gender;
	this.dob = dob;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}



}
