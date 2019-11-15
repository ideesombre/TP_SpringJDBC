package fr.estelle.spring.jdbc;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import fr.estelle.spring.jdbc.dao.EmployeeJdbcRepository;
import fr.estelle.spring.jdbc.exception.EmployeeNotValidException;
import fr.estelle.spring.jdbc.model.Employee;
import fr.estelle.spring.jdbc.service.EmployeeService;

@Configuration
@ComponentScan
public class App {

	public static void main(String[] args) throws EmployeeNotValidException {
		System.out.println("Start created");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

		EmployeeService employeeService = context.getBean(EmployeeService.class);

		System.out.println("\nsave several employees");
		employeeService.save(new Employee(1L, "Jonathan", "Ruggiero", LocalDate.of(2012, 11, 14),
				BigDecimal.valueOf(32300L), "212184892389823"));
		employeeService.save(new Employee(2L, "Alexis", "Puskarczyk", LocalDate.of(2014, 5, 10),
				BigDecimal.valueOf(37000L), "178628378273827"));
		employeeService.save(new Employee(3L, "Laurent", "Jouanno", LocalDate.of(1995, 9, 06),
				BigDecimal.valueOf(60000L), "287392783928739"));
		employeeService.save(new Employee(4L, "Balthazar", "Feron", LocalDate.of(2018, 02, 01),
				BigDecimal.valueOf(32300L), "283729379827382"));
		employeeService.save(new Employee(5L, "Salim", "Tazi", LocalDate.of(2018, 03, 04), BigDecimal.valueOf(100000L),
				"749873987928732"));
//		
//		employeeService.save(new Employee("Jonathan", "Ruggiero", LocalDate.of(2012, 11, 14), BigDecimal.valueOf(32300L), "212184892389823"));
//		employeeService.save(new Employee("Alexis", "Puskarczyk", LocalDate.of(2014, 5, 10), BigDecimal.valueOf(37000L), "178628378273827"));
//		employeeService.save(new Employee("Laurent", "Jouanno", LocalDate.of(1995, 9, 06), BigDecimal.valueOf(60000L), "287392783928739"));
//		employeeService.save(new Employee("Balthazar", "Feron", LocalDate.of(2018, 02, 01), BigDecimal.valueOf(32300L), "283729379827382"));
//		employeeService.save(new Employee("Salim", "Tazi", LocalDate.of(2018, 03, 04), BigDecimal.valueOf(100000L), "749873987928732"));

		System.out.println("\nFind all");
		List<Employee> findAll = employeeService.findAll();
		findAll.forEach(System.out::println);

		System.out.println("\nFind by ssn4\n" + employeeService.findBySsn("ssn4").toString());

		System.out.println("\nUpdate Salary");
		employeeService.update(2L, BigDecimal.valueOf(10000L));

		System.out.println("\nFind all");
		findAll = employeeService.findAll();
		findAll.forEach(System.out::println);

		System.out.println();

		findAll.add(new Employee(1000L, "Salim", "Tazi", LocalDate.of(2018, 03, 04), BigDecimal.valueOf(100000L),
				"749873987928732"));

//		try {
//			employeeService.updateList(findAll);
//		} catch (EmptyResultDataAccessException e) {
//			System.out.println("exception after updateList");;
//		}

		employeeService.updateList(findAll);
		System.out.println("\nFind all");
		findAll = employeeService.findAll();
		findAll.forEach(System.out::println);

		System.out.println();
	}

}
