package com.example.demo.Transaction;
import com.example.demo.Employee.EmployeeRepository.EmployeeRepository;

import java.util.function.Function;

@FunctionalInterface
public interface TransactionCode<T> extends Function<EmployeeRepository, T> {

}
