package fr.estelle.spring.jdbc.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import fr.estelle.spring.jdbc.exception.EmployeeNotValidException;
import fr.estelle.spring.jdbc.model.Employee;

public interface EmployeeRepository {

	void save(Employee employee);
	
	List<Employee> findAll();
	
	List<Employee> findBySsn(String ssn);
	
	void update(Long id, BigDecimal salary);
	
	void updateList(List<Employee> employees) throws EmployeeNotValidException;

	Employee findById(Long id);
	
	
}
