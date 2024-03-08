package com.furama.resort.service.position;

import com.furama.resort.model.Position;
import com.furama.resort.repository.position.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> showList() {
        return iPositionRepository.findAll();
    }

    @Override
    public Position findById(Long id) {
        return iPositionRepository.findById(id).orElse(null);
    }
}
