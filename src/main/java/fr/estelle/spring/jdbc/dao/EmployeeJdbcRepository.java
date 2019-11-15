package fr.estelle.spring.jdbc.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import fr.estelle.spring.jdbc.model.Employee;

@Repository
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	@Override
	public void save(Employee employee) {
//		String sqlQuery = "INSERT INTO employee (id, firstname, lastname, hiredate, salary, ssn) VALUES (?,?,?,?,?,?)";
//		this.jdbcTemplate.update(sqlQuery, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getHireDate(),
//				employee.getSalary(), employee.getSsn());
		String sqlQuery = "INSERT INTO employee (firstname, lastname, hiredate, salary, ssn) VALUES (?,?,?,?,?)";
		this.jdbcTemplate.update(sqlQuery, employee.getFirstName(), employee.getLastName(), employee.getHireDate(),
				employee.getSalary(), employee.getSsn());

	}

	@Override
	public List<Employee> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM employee ORDER BY id", new EmployeeMapper());

	}

	@Override
	public List<Employee> findBySsn(String ssn) {

		return this.jdbcTemplate.query("SELECT * FROM employee e WHERE e.ssn = ?", new Object[] { ssn },
				new EmployeeMapper());
	}

	public Employee findById(Long id) {

		return this.jdbcTemplate.queryForObject("SELECT * FROM employee e WHERE e.id = ?", new Object[] { id },
				new EmployeeMapper());
	}

	@Override
	public void update(Long id, BigDecimal salary) {
		this.jdbcTemplate.update("UPDATE employee SET salary = ? WHERE id = ?", salary, id);

	}

//	@Override
//	public void updateList(List<Employee> employees) throws EmptyResultDataAccessException {
//		for (Employee e : employees) {
//			if (this.jdbcTemplate.queryForObject("SELECT salary FROM employee e WHERE e.id = ?", new Object[] { e.getId() },
//					BigDecimal.class) == null) {
//				throw new EmptyResultDataAccessException("One of the employee does not exist", 1);
//			} else {
//				update(e.getId(), BigDecimal.valueOf(4200));
//			}
//
//		}
//	}

	@Override
	public void updateList(List<Employee> employees) {
		employees.forEach(e -> update(e.getId(), BigDecimal.valueOf(4200)));

	}

}
