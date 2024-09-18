package com.indus.training.persist.dao;

import com.indus.training.persist.Exceptions.ORMHibernateException;
import com.indus.training.persist.entity.Student;

/**
 * Interface for managing Student data access operations. Provides methods to
 * insert, fetch, delete, and update student records.
 */
public interface IStudentDao {

	/**
	 * Inserts a student object into the database.
	 * 
	 * @param stuObj the Student object to insert
	 * @return true if the student was inserted successfully, false otherwise
	 * @throws ORMHibernateException if an error occurs during the insertion process
	 */
	public boolean insertStudent(Student stuObj) throws ORMHibernateException;

	/**
	 * Fetches a student record from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to fetch
	 * @return the Student object corresponding to the given student ID, or null if
	 *         not found
	 * @throws ORMHibernateException if an error occurs during the fetch operation
	 */
	public Student fetchStudent(int studentId) throws ORMHibernateException;

	/**
	 * Deletes a student record from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to delete
	 * @return true if the student was deleted successfully, false otherwise
	 * @throws ORMHibernateException if an error occurs during the deletion process
	 */
	public boolean deleteStudent(int studentId) throws ORMHibernateException;

	/**
	 * Updates the first name of a student in the database.
	 * 
	 * @param studentId    the ID of the student whose first name is to be updated
	 * @param updFirstName the new first name to be set
	 * @return true if the student's first name was updated successfully, false
	 *         otherwise
	 * @throws ORMHibernateException if an error occurs during the update process
	 */
	boolean updateStudentFirstName(int studentId, String updFirstName) throws ORMHibernateException;

	/**
	 * Updates the last name of a student in the database.
	 * 
	 * @param studentId   the ID of the student whose last name is to be updated
	 * @param updLastName the new last name to be set
	 * @return true if the student's last name was updated successfully, false
	 *         otherwise
	 * @throws ORMHibernateException if an error occurs during the update process
	 */
	boolean updateStudentLastName(int studentId, String updLastName) throws ORMHibernateException;

}
