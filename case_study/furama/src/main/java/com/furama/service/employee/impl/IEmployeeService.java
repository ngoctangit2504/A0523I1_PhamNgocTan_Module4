package com.furama.service.employee.impl;

import com.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    //    List<Student> showList();
    Page<Employee> findAll(Pageable pageable);

    void addNewEmployee(Employee employee);
}
