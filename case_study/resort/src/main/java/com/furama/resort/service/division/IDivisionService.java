package com.furama.resort.service.division;

import com.furama.resort.model.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> showList();
    Division findById(Long id);
}
