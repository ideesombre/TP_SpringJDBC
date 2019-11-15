package fr.estelle.spring.jdbc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.estelle.spring.jdbc.dao.EmployeeRepository;
import fr.estelle.spring.jdbc.exception.EmployeeNotValidException;
import fr.estelle.spring.jdbc.model.Employee;


@Service
public class EmployeeService{

	@Autowired
	private EmployeeRepository eJdbcRep;

	@Transactional 
	public void save(Employee employee) {
		eJdbcRep.save(employee);
	}
	
	@Transactional
	public List<Employee> findAll(){
		return eJdbcRep.findAll();
	}

	@Transactional
	public List<Employee> findBySsn(String ssn){
		return eJdbcRep.findBySsn(ssn);
	}

	@Transactional
	public void update(Long id, BigDecimal salary) {
		eJdbcRep.update(id, salary);		
	}

//	@Transactional (rollbackFor = EmptyResultDataAccessException.class)
//	public void updateList(List<Employee> employees) throws EmptyResultDataAccessException {
//		eJdbcRep.updateList(employees);
//		
//	}

	@Transactional (rollbackFor = EmployeeNotValidException.class)
	public void updateList(List<Employee> employees) throws EmployeeNotValidException{
		eJdbcRep.updateList(employees);
		
	}

	
}
