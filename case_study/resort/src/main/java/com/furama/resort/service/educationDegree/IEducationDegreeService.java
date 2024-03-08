package com.furama.resort.service.educationDegree;

import com.furama.resort.model.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> showList();
    EducationDegree findById(Long id);
}
