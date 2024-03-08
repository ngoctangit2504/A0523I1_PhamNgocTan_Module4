package com.furama.resort.service.employee;

import com.furama.resort.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    //     List<Employee> showList();
    Page<Employee> findAll(Pageable pageable);

    void addNewEmployee(Employee employee);

    void delete(Long id);

    Employee findOne(Long id);
}
