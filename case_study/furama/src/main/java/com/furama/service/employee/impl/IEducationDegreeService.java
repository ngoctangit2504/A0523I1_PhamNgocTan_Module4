package com.furama.service.employee.impl;

import com.furama.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> showList();
    EducationDegree findById(int id);
}
