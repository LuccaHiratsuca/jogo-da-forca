package com.example.demo.Employee.EmployeeRepository;
import java.util.List;
import com.example.demo.Employee.EmployeeModel.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();

	Employee save(Employee e);
    
}
