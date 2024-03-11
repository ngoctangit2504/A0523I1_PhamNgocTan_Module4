package com.furama.demolast.service.gender;

import com.furama.demolast.model.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> showList();
    Gender findById(Long id);
}
