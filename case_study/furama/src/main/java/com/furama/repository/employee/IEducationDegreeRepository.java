package com.furama.repository.employee;

import com.furama.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
