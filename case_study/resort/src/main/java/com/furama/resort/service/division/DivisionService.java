package com.furama.resort.service.division;

import com.furama.resort.model.Division;
import com.furama.resort.repository.division.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService{
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> showList() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Division findById(Long id) {
        return iDivisionRepository.findById(id).orElse(null);
    }
}
