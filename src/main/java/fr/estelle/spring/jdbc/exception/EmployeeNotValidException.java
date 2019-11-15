package fr.estelle.spring.jdbc.exception;

public class EmployeeNotValidException extends Exception{

	public EmployeeNotValidException(Long id) {
		System.out.println("there is no employee with id "+id);
	}
}
