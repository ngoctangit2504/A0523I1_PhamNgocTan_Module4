package com.furama.service.employee.impl;

import com.furama.model.employee.EducationDegree;
import com.furama.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> showList();
    Position findById(int id);
}
