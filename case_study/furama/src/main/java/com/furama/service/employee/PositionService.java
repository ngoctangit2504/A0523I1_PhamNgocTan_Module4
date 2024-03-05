package com.furama.service.employee;

import com.furama.model.employee.Position;
import com.furama.repository.employee.IPositionRepository;
import com.furama.service.employee.impl.IPositionService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {

    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> showList() {
        return iPositionRepository.findAll();
    }

    @Override
    public Position findById(int id) {
        return iPositionRepository.findById(id).orElse(null);
    }
}
