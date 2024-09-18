package com.indus.training.persist.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indus.training.persist.Exceptions.ORMHibernateException;
import com.indus.training.persist.dao.IStudentDao;
import com.indus.training.persist.entity.Student;
import com.indus.training.persist.util.HibernateUtil;

/**
 * Implementation of the IStudentDao interface for managing Student data access
 * operations. Provides methods to insert, fetch, delete, and update student
 * records using Hibernate.
 */
public class StudentDaoImpl implements IStudentDao {

	private static final Logger loggerObj = LoggerFactory.getLogger(StudentDaoImpl.class);

	/**
	 * Inserts a student object into the database.
	 * 
	 * @param stuObj the Student object to insert
	 * @return true if the student was inserted successfully, false otherwise
	 * @throws ORMHibernateException if an error occurs during the insertion process
	 */
	@Override
	public boolean insertStudent(Student stuObj) throws ORMHibernateException {
		Session session = null;
		boolean isInserted = false;
		if (stuObj == null) {
			loggerObj.warn("Student object cannot be null for insertion");
			throw new ORMHibernateException("Cannot insert null student object.");
		}

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Student existingStudent = (Student) session.get(Student.class, stuObj.getStudentId());
			if (existingStudent != null) {
				loggerObj.warn("Student with ID {} already exists. Insertion aborted.", stuObj.getStudentId());
				session.getTransaction().rollback();
				return false;
			}
			session.save(stuObj);
			session.getTransaction().commit();
			isInserted = true;
			loggerObj.info("Student inserted successfully with ID {}", stuObj.getStudentId());

		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			loggerObj.error("An exception occurred while saving the student object: {}", e);
			throw new ORMHibernateException("An exception occurred while saving the student object");
		} finally {
			if (session != null) {
				session.close(); // Ensure session is always closed
			}
		}

		return isInserted;
	}

	/**
	 * Fetches a student record from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to fetch
	 * @return the Student object corresponding to the given student ID, or null if
	 *         not found
	 * @throws ORMHibernateException if an error occurs during the fetch operation
	 */
	@Override
	public Student fetchStudent(int studentId) throws ORMHibernateException {
		Student stuObj = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			stuObj = (Student) session.get(Student.class, studentId);
			session.getTransaction().commit();
			if (stuObj != null) {
				loggerObj.info("Fetched Student Details Successfully with ID {}", studentId);
			} else {
				loggerObj.warn("Student with {}  does not exist", studentId);
			}

		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			loggerObj.error("An error occurred while fetching the Student details with ID {}: {}", studentId,
					e.getMessage());
			throw new ORMHibernateException("An exception occurred while recalling the student object");
		}
		return stuObj;
	}

	/**
	 * Deletes a student record from the database based on the student ID.
	 * 
	 * @param studentId the ID of the student to delete
	 * @return true if the student was deleted successfully, false otherwise
	 * @throws ORMHibernateException if an error occurs during the deletion process
	 */
	@Override
	public boolean deleteStudent(int studentId) throws ORMHibernateException {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Student stuObj = (Student) session.get(Student.class, studentId);
			if (stuObj != null) {
				session.delete(stuObj);
				session.getTransaction().commit();
				isDeleted = true;
				loggerObj.info("Student with ID {} deleted Successfully", studentId);

			} else {
				loggerObj.warn("Student with ID {} does not exist, unable to delete.", studentId);
			}
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			loggerObj.error("An error occurred while deleting the Student details with ID {}: {}", studentId,
					e.getMessage());
			throw new ORMHibernateException("An exception occurred while deleting the student object");
		}
		return isDeleted;
	}

	/**
	 * Updates the first name of a student in the database.
	 * 
	 * @param studentId    the ID of the student whose first name is to be updated
	 * @param updFirstName the new first name to be set
	 * @return true if the student's first name was updated successfully, false
	 *         otherwise
	 * @throws ORMHibernateException if an error occurs during the update process
	 */
	@Override
	public boolean updateStudentFirstName(int studentId, String updFirstName) throws ORMHibernateException {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Student stuObj = (Student) session.get(Student.class, studentId);
			if (stuObj != null) {
				stuObj.setFirstName(updFirstName);
				session.update(stuObj);
				session.getTransaction().commit();
				isUpdated = true;
				loggerObj.info("Student firstName with ID {} Updated Successfully", studentId);

			} else {
				loggerObj.warn("Student with ID {} does not exist, unable to Update firstName.", studentId);

			}
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			loggerObj.error("An error occurred while updating the Student firstName with ID {}: {}", studentId,
					e.getMessage());
			throw new ORMHibernateException("An exception occurred while updating the student object");
		}

		return isUpdated;
	}

	/**
	 * Updates the last name of a student in the database.
	 * 
	 * @param studentId   the ID of the student whose last name is to be updated
	 * @param updLastName the new last name to be set
	 * @return true if the student's last name was updated successfully, false
	 *         otherwise
	 * @throws ORMHibernateException if an error occurs during the update process
	 */
	@Override
	public boolean updateStudentLastName(int studentId, String updLastName) throws ORMHibernateException {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Student stuObj = (Student) session.get(Student.class, studentId);
			if (stuObj != null) {
				stuObj.setLastName(updLastName);
				session.update(stuObj);
				session.getTransaction().commit();
				isUpdated = true;
				loggerObj.info("Student lastName with ID {} Updated Successfully", studentId);

			} else {
				loggerObj.warn("Student with ID {} does not exist, unable to Update lastName.", studentId);

			}
		} catch (HibernateException e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			loggerObj.error("An error occurred while updating the Student lastName with ID {}: {}", studentId,
					e.getMessage());
			throw new ORMHibernateException("An exception occurred while updating the student object");
		}

		return isUpdated;
	}

}
