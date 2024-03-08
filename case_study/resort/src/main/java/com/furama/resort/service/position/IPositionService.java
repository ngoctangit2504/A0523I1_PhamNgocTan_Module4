package com.furama.resort.service.position;

import com.furama.resort.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> showList();
    Position findById(Long id);
}
