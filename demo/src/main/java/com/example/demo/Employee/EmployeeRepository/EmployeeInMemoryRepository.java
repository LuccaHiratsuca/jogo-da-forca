package com.example.demo.Employee.EmployeeRepository;
import com.example.demo.Employee.EmployeeModel.Employee;
import  java.util.List;
import java.util.ListIterator;

public class EmployeeInMemoryRepository {
    private List<Employee> employees;

    public EmployeeInMemoryRepository(List<Employee> employees){
        this.employees = employees;
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Employee save(Employee employee) {
		ListIterator<Employee> listIterator = employees.listIterator();
		while (listIterator.hasNext()) {
			if (listIterator.next().getId().equals(employee.getId())) {
				listIterator.set(employee);
				return employee;
			}
		}
		employees.add(employee);
		return employee;

    }


}
