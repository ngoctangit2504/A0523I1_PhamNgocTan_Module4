package com.furama.demolast.service.gender;

import com.furama.demolast.model.Gender;
import com.furama.demolast.repository.gender.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class GenderService implements IGenderService{
    @Autowired
    private IGenderRepository iGenderRepository;
    @Override
    public List<Gender> showList() {
        return iGenderRepository.findAll();
    }

    @Override
    public Gender findById(Long id) {
        return iGenderRepository.findById(id).orElse(null);
    }
}
