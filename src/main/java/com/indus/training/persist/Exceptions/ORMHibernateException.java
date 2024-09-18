package com.indus.training.persist.Exceptions;

/**
 *  * Custom exception class for handling Hibernate-related ORM (Object-Relational Mapping) errors.
 */
public class ORMHibernateException extends Exception {
	/**
     * Constructs a new ORMHibernateException with the specified error message.
     * 
     * @param msg the detail message explaining the reason for the exception
     */
	public ORMHibernateException(String msg) {
		super(msg);
	}

}
