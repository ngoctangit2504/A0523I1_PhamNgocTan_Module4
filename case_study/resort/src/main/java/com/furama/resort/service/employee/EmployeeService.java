package com.furama.resort.service.employee;

import com.furama.resort.model.Employee;
import com.furama.resort.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


//    @Override
//    public List<Employee> showList() {
//        return iEmployeeRepository.findAll();
//    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void addNewEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Employee findOne(Long id) {
        return iEmployeeRepository.findById(id).get();
    }
}