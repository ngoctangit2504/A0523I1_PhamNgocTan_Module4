package com.furama.service.employee.impl;

import com.furama.model.employee.Division;
import com.furama.model.employee.EducationDegree;

import java.util.List;

public interface IDivisionService {
    List<Division> showList();
    Division findById(int id);
}
