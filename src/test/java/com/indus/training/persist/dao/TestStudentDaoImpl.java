package com.indus.training.persist.dao;

import com.indus.training.persist.Exceptions.ORMHibernateException;
import com.indus.training.persist.entity.Student;
import com.indus.training.persist.impl.StudentDaoImpl;
import junit.framework.TestCase;

/**
 * Tests methods of the {@link StudentDaoImpl} class.
 */
public class TestStudentDaoImpl extends TestCase {

	private StudentDaoImpl stuDaoImplObj;

	/**
	 * Initializes the {@link StudentDaoImpl} instance.
	 * 
	 * @throws Exception if setup fails
	 */
	@Override
	protected void setUp() throws Exception {
		stuDaoImplObj = new StudentDaoImpl();
	}

	/**
	 * Cleans up after tests.
	 * 
	 * @throws Exception if teardown fails
	 */
	@Override
	protected void tearDown() throws Exception {
		stuDaoImplObj = null;
	}

	/**
	 * Tests {@link StudentDaoImpl#insertStudent(Student)}.
	 */
	public void testInsertStudent() {
		Student student = new Student();
		student.setStudentId(1029);
		student.setFirstName("Navya");
		student.setLastName("Bade");

		try {
			boolean result = stuDaoImplObj.insertStudent(student);
			assertTrue(result);
		} catch (ORMHibernateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests {@link StudentDaoImpl#deleteStudent(int)}.
	 */
	public void testDeleteStudent() {
		try {
			boolean result = stuDaoImplObj.deleteStudent(1029);
			assertTrue(result);
		} catch (ORMHibernateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests {@link StudentDaoImpl#updateStudentFirstName(int, String)}.
	 */
	public void testUpdateStudentFirstName() {
		try {
			boolean result = stuDaoImplObj.updateStudentFirstName(1023, "Dhruthi");
			assertTrue(result);
		} catch (ORMHibernateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests {@link StudentDaoImpl#updateStudentLastName(int, String)}.
	 */
	public void testUpdateStudentLastName() {
		try {
			boolean result = stuDaoImplObj.updateStudentLastName(1023, "Bade");
			assertTrue(result);
		} catch (ORMHibernateException e) {
			e.printStackTrace();
		}
	}

	public void testFetchStudent() {
		// Create and insert a student for testing fetch operation
		Student expectedStudent = new Student();
		expectedStudent.setStudentId(1030);
		expectedStudent.setFirstName("Test");
		expectedStudent.setLastName("Student");

		try {
			stuDaoImplObj.insertStudent(expectedStudent); // Ensure the student is in the database

			Student fetchedStudent = stuDaoImplObj.fetchStudent(1030);
			assertNotNull(fetchedStudent); // Check if the fetched student is not null

			// Use equals method to compare expected and fetched students
			assertTrue(expectedStudent.equals(fetchedStudent));

		} catch (ORMHibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				stuDaoImplObj.deleteStudent(1030); // Clean up
			} catch (ORMHibernateException e) {
				e.printStackTrace();
			}
		}
	}

}
