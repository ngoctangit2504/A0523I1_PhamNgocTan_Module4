package com.furama.service.employee;

import com.furama.model.employee.Employee;
import com.furama.service.employee.impl.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void addNewEmployee(Employee employee) {

    }
}
