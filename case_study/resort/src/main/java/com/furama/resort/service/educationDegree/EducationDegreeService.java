package com.furama.resort.service.educationDegree;

import com.furama.resort.model.EducationDegree;
import com.furama.resort.repository.educationDegree.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeService implements IEducationDegreeService{
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Override
    public List<EducationDegree> showList() {
        return iEducationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return iEducationDegreeRepository.findById(id).orElse(null);
    }
}
