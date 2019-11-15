package fr.estelle.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import org.springframework.jdbc.core.RowMapper;

import fr.estelle.spring.jdbc.model.Employee;

public final class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getLong("id"));
		employee.setFirstName(rs.getString("firstname"));
		employee.setLastName(rs.getString("lastname"));
		Date hireDate = rs.getDate("hiredate");
		if (hireDate != null ) {
			LocalDate hireLocalDate = hireDate.toLocalDate();
			employee.setHireDate(hireLocalDate);
		}
		employee.setSalary(rs.getBigDecimal("salary"));
		employee.setSsn(rs.getString("ssn"));
		return employee;
	}

}
