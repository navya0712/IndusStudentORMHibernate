package com.indus.training.persist.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a student entity in the database. # Field Type Null Key Default
 * Extra student_id int NO PRI first_name varchar(25) NO last_name varchar(25)
 * NO
 * 
 */
public class Student implements Serializable {
	private int studentId;

	private String firstName;
	private String lastName;

	/**
	 * Default constructor. Creates an empty Student object.
	 */
	public Student() {
	}

	/**
	 * Gets the student ID.
	 * 
	 * @return the unique student ID
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * Sets the student ID.
	 * 
	 * @param studentId the unique ID to assign to the student
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * Gets the first name of the student.
	 * 
	 * @return the student's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the student.
	 * 
	 * @param firstName the student's first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the student.
	 * 
	 * @return the student's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the student.
	 * 
	 * @param lastName the student's last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& studentId == other.studentId;
	}

}
