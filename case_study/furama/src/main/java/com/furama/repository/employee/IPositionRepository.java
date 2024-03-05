package com.furama.repository.employee;

import com.furama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
