package com.furama.service.employee;

import com.furama.model.employee.EducationDegree;
import com.furama.repository.employee.IEducationDegreeRepository;
import com.furama.service.employee.impl.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> showList() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(int id) {
        return iEducationDegreeRepository.findById(id).orElse(null);
    }
}