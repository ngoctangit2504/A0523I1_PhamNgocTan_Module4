package com.furama.service.employee;

import com.furama.model.employee.Division;
import com.furama.repository.employee.IDivisionRepository;
import com.furama.service.employee.impl.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> showList() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Division findById(int id) {
        return iDivisionRepository.findById(id).orElse(null);
    }
}
