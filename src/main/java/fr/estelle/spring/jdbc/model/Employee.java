package fr.estelle.spring.jdbc.model;

import java.math.BigDecimal;
import java.time.LocalDate;



public class Employee {
	


	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate hireDate;
	private BigDecimal salary;
	private String ssn;
	
	public Employee(){
		
	}
	
	public Employee(String firstName, String lastName, LocalDate hireDate, BigDecimal salary, String ssn ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.salary = salary;
		this.ssn = ssn;
		
	}
	
	public Employee(Long id, String firstName, String lastName, LocalDate hireDate, BigDecimal salary, String ssn ) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.salary = salary;
		this.ssn = ssn;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate localDate) {
		this.hireDate = localDate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+", hireDate=" + hireDate +  ", salary=" + salary + ", ssn=" + ssn + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

}
